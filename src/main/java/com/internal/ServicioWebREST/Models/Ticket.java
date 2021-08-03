package com.internal.ServicioWebREST.Models;


import org.springframework.data.annotation.Id;

public class Ticket {
	@Id
	public String ticket;
	public String asunto;
	public String estado;
	public String identificacion;
	
	public Ticket() {
		
	}

	public Ticket(String Ticket, String asunto, String estado, String identificacion) {
		super();
		this.ticket = Ticket;
		this.asunto = asunto;
		this.estado = estado;
		this.identificacion = identificacion;
	}
	
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	

	
}
