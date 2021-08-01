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
import com.internal.ServicioWebREST.Service.SolicitudService;

@Controller
@RequestMapping("/Solicitudes")
public class SolicitudController {
	
	@Autowired
	private SolicitudService solicitudService;

	@GetMapping( path = "/{id}")
    public @ResponseBody ResponseEntity<List<Solicitud>> getSolicitudes(@PathVariable("id") String id) {
        List<Solicitud> ret = this.solicitudService.GetSolicitud(id);
		return ResponseEntity.status(HttpStatus.OK).body(ret);
    }	
	
	@PostMapping( path = "/")
    public @ResponseBody ResponseEntity<Solicitud> setSolicitud(@RequestBody Solicitud sol) {
		Solicitud ret = this.solicitudService.SetSolicitud(sol);
		return ResponseEntity.status(HttpStatus.OK).body(ret);
    }	
	
}
