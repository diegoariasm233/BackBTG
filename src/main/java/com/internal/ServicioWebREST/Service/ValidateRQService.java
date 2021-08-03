package com.internal.ServicioWebREST.Service;


import org.springframework.stereotype.Service;
import com.internal.ServicioWebREST.Models.AdminResp;
import com.internal.ServicioWebREST.Models.Solicitud;
import com.internal.ServicioWebREST.Models.Ticket;
import com.internal.ServicioWebREST.Until.Utils;

@Service
public class ValidateRQService {

	public Boolean validateResponseSolicitud(AdminResp adminResp) {
		return Utils.validateNotBlank(adminResp.getDate().toString(), adminResp.getNo_radicado(), adminResp.getText());
	}
	
	public Boolean validateCreateSolicitud(Solicitud solicitud) {
		return Utils.validateNotBlank(solicitud.getDate().toString(), solicitud.getText()
				, solicitud.getTicketId(), solicitud.getTipo_solicitud());
	}
	
	public Boolean validateCreateTicket(Ticket ticket) {
		return Utils.validateNotBlank(ticket.getIdentificacion(), ticket.getAsunto());
	}
	
	public Boolean validateUpdateTicketCalf(AdminResp ticket) {
		return Utils.validateNotBlank(ticket.getId_response_admin(), ticket.getSatifaccion());
	}
	
}
