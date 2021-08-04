package com.internal.ServicioWebREST.Service;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.internal.ServicioWebREST.Interface.IAdminResp;
import com.internal.ServicioWebREST.Interface.ISolicitudInterface;
import com.internal.ServicioWebREST.Interface.ITicket;
import com.internal.ServicioWebREST.Models.AdminResp;
import com.internal.ServicioWebREST.Models.Solicitud;
import com.internal.ServicioWebREST.Models.Ticket;
import com.internal.ServicioWebREST.Until.Utils;

@Service
public class RQService {

	@Autowired
	ISolicitudInterface iSolicitudInterface;
	@Autowired
	ITicket iTicket;
	@Autowired
	IAdminResp iAdminResp;

	public List<Solicitud> getSolicitudesPorTicket(String Ticket) {
		Solicitud solicitud = new Solicitud();
		solicitud.setTicketId(Ticket);
		Example<Solicitud> querySol = Example.of(solicitud);
		List<Solicitud> solicitudes =  iSolicitudInterface.findAll(querySol);
		for(Solicitud e : solicitudes) {
			Optional<AdminResp> adminResp = iAdminResp.findOneByNo_Radicado(e.getNo_radicado());
			if(adminResp.isPresent()) {
				e.setAdminresp(adminResp.get());
			}
		}
		return solicitudes;
	}

	public List<Ticket> getTicketPorIdentificacion(String identificacion) {
		Ticket tik = new Ticket();
		tik.setIdentificacion(identificacion);
		Example<Ticket> querySol = Example.of(tik);
		return iTicket.findAll(querySol);
	}
	
	public AdminResp setResponsetoSolicitud(AdminResp adminResp) {
		if(adminResp.getNo_radicado() != null) {
			Optional<Solicitud> asoc = iSolicitudInterface.findById(adminResp.getNo_radicado());
			if(asoc.isPresent()) {
				adminResp.setId_response_admin(UUID.randomUUID().toString());
				adminResp.setSatifaccion(Utils.NO_SATIFACCION);
				adminResp.setCalificacion(Utils.NO_CALIFICADO);
				return iAdminResp.insert(adminResp);
			}
		}
		return new AdminResp();
	}
	
	public AdminResp updateAdminRespCalf(AdminResp adminResp) {
		Optional<AdminResp> asoc = iAdminResp.findById(adminResp.getId_response_admin());
		if(asoc.isPresent()) {
			asoc.get().setSatifaccion(adminResp.getSatifaccion());
			asoc.get().setCalificacion(Utils.CALIFICADO);
			return iAdminResp.save(asoc.get());	
		}
		return new AdminResp();
	}

	public Solicitud createSolicitud(Solicitud solicitud) {
		if (solicitud.getTicketId() != null && iTicket.existsById(solicitud.getTicketId())) {
			solicitud.setNo_radicado(UUID.randomUUID().toString());
			if (this.setTypeValidation(solicitud)) {
				return iSolicitudInterface.insert(solicitud);
			}
		}
		return new Solicitud();
	}

	public Ticket createTicket(Ticket tik) {
		tik.setTicket(UUID.randomUUID().toString());
		tik.setEstado(Utils.ESTADO_APROBADO);
		return iTicket.insert(tik);
	}

	private boolean setTypeValidation(Solicitud solicitud) {
		Boolean validation = Boolean.FALSE;
		if (solicitud.getTipo_solicitud() != null) {
			switch (solicitud.getTipo_solicitud()) {
			case "0":
				solicitud.setTipo_solicitud(Utils.TYPE_RQ_PETICION);
				validation = Boolean.TRUE;
				break;
			case "1":
				solicitud.setTipo_solicitud(Utils.TYPE_RQ_QUEJA);
				validation = Boolean.TRUE;
				break;
			case "2":
				if(solicitud.getNo_radicado_assoc() != null) {
					Optional<Solicitud> asoc = iSolicitudInterface.findById(solicitud.getNo_radicado_assoc());
					Optional<AdminResp> adminResp = iAdminResp.findOneByNo_Radicado(solicitud.getNo_radicado_assoc());
					if (adminResp.isPresent() && !adminResp.get().getSatifaccion().equals(Utils.SATIFACCION)
							&& adminResp.get().getCalificacion().equals(Utils.CALIFICADO)) {
						solicitud.setTipo_solicitud(Utils.TYPE_RQ_RECLAMO);
						validation = Boolean.TRUE;
					} else if (asoc.isPresent() && !asoc.get().getTipo_solicitud().equals(Utils.TYPE_RQ_RECLAMO)) {
						long numberOFDays = Duration.between(asoc.get().getDate(), solicitud.getDate() ).toDays();
						if (numberOFDays > 5) {
							solicitud.setTipo_solicitud(Utils.TYPE_RQ_RECLAMO);
							validation = Boolean.TRUE;
						}
					}
				}
				break;
			}
		}
		return validation;
	}

}