package com.internal.ServicioWebREST.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.internal.ServicioWebREST.Interface.ISolicitudInterface;
import com.internal.ServicioWebREST.Models.Solicitud;
@Service

public class SolicitudService {
	 	@Autowired
	 	ISolicitudInterface iSolicitudInterface;

	    public List<Solicitud> GetSolicitud(String Identificador){
	    	System.out.println("Consulting... " + Identificador);
	    	return iSolicitudInterface.findAllByIdentificacion(Identificador);
	    }
	    public Solicitud SetSolicitud(Solicitud sol){
	    	sol.setNo_radicado(UUID.randomUUID().toString()); 
	    	System.out.println("Insert... " + sol.getNo_radicado());
	    	return iSolicitudInterface.insert(sol);
	    }
}