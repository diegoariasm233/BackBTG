package com.internal.ServicioWebREST.controllers;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.internal.ServicioWebREST.Models.Solicitud;
import com.internal.ServicioWebREST.Service.RQService;
import com.internal.ServicioWebREST.Service.ValidateRQService;

@Controller
@RequestMapping("/Solicitudes")
public class SolicitudController {
	
	@Autowired
	private RQService rQService;
	
	@Autowired
	private ValidateRQService validateRQService;
	
	/**
	 * Got Document from Ticket
	 * @param id
	 * @param type
	 * @return List of Documents
	 */
	@GetMapping( path = "/{Ticketid}/")
    public @ResponseBody ResponseEntity<List<Solicitud>> getSolicitudesPorTicket(@PathVariable("Ticketid") String Ticketid) {
        List<Solicitud> ret = this.rQService.getSolicitudesPorTicket(Ticketid);
		return ResponseEntity.status(HttpStatus.OK).body(ret);
    }	
	
	/**
	 * Set Document at Ticket
	 * @param id
	 * @param type
	 * @return Document
	 */
	@PostMapping( path = "/")
    public @ResponseBody ResponseEntity<Solicitud> createSolicitud(@RequestBody Solicitud solicitud) {
		if(!validateRQService.validateCreateSolicitud(solicitud)) {
			Solicitud ret = this.rQService.createSolicitud(solicitud);
			return ResponseEntity.status(HttpStatus.OK).body(ret);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
    }	
	
	
}
