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

import com.internal.ServicioWebREST.Models.Ticket;
import com.internal.ServicioWebREST.Service.RQService;
import com.internal.ServicioWebREST.Service.ValidateRQService;

@Controller
@RequestMapping("/Ticket")
public class TicketController {
	
	@Autowired
	private RQService rQService;
	
	@Autowired
	private ValidateRQService validateRQService;
	
	
	@PostMapping( path = "/")
    public @ResponseBody ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
		if(!validateRQService.validateCreateTicket(ticket)) {
			Ticket ret = this.rQService.createTicket(ticket);
			return ResponseEntity.status(HttpStatus.OK).body(ret);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
    }	
	

	/**
	 * Get Tickets from IDENTIFICACION
	 * @param id
	 * @param type
	 * @return List of Tickets
	 */
	@GetMapping( path = "/{identificacion}/")
    public @ResponseBody ResponseEntity<List<Ticket>> getTicketPorIdentificacion(@PathVariable("identificacion") String identificacion) {
        List<Ticket> ret = this.rQService.getTicketPorIdentificacion(identificacion);
		return ResponseEntity.status(HttpStatus.OK).body(ret);
    }	
	
	
}
