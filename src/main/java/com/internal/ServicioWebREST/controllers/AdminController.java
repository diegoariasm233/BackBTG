package com.internal.ServicioWebREST.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.internal.ServicioWebREST.Models.AdminResp;
import com.internal.ServicioWebREST.Models.Ticket;
import com.internal.ServicioWebREST.Service.RQService;
import com.internal.ServicioWebREST.Service.ValidateRQService;

@Controller
@RequestMapping("/Admin")
public class AdminController {
	
	@Autowired
	private RQService rQService;
	
	@Autowired
	private ValidateRQService validateRQService;
	
	/**
	 * Admin response solicitud
	 * @param id
	 * @param type
	 * @return AdminResp
	 */
	@PostMapping( path = "/")
    public @ResponseBody ResponseEntity<AdminResp> responseSolicitud(@RequestBody AdminResp adminResp) {
		if(!validateRQService.validateResponseSolicitud(adminResp)) {
			AdminResp ret = this.rQService.setResponsetoSolicitud(adminResp);
			return ResponseEntity.status(HttpStatus.OK).body(ret);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
    }	
	@PutMapping( path = "/")
	public @ResponseBody ResponseEntity<AdminResp> updateAdminRespCalf(@RequestBody AdminResp adminResp) {
		if(!validateRQService.validateUpdateTicketCalf(adminResp)) {
			AdminResp ret = this.rQService.updateAdminRespCalf(adminResp);
			return ResponseEntity.status(HttpStatus.OK).body(ret);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	
}
