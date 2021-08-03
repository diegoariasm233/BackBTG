package com.internal.ServicioWebREST.Models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

public class Solicitud {

	@Id
	public String no_radicado;
	public String text;
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonProperty("date")
	public LocalDateTime date;
	public String tipo_solicitud;
	public String ticketId;
	public String no_radicado_assoc;
	
	@Transient
	public AdminResp adminresp;
	
	public Solicitud() { }
	
	public Solicitud(String no_radicado, String text, LocalDateTime date, String tipo_solicitud, String ticketId, String no_radicado_assoc) {
		super();
		this.no_radicado = no_radicado;
		this.text = text;
		this.date = date;
		this.tipo_solicitud = tipo_solicitud;
		this.ticketId = ticketId;
		this.no_radicado_assoc = no_radicado_assoc;
	}
	public String getNo_radicado() {
		return no_radicado;
	}
	public void setNo_radicado(String no_radicado) {
		this.no_radicado = no_radicado;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public String getTipo_solicitud() {
		return tipo_solicitud;
	}
	public void setTipo_solicitud(String tipo_solicitud) {
		this.tipo_solicitud = tipo_solicitud;
	}
	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public String getNo_radicado_assoc() {
		return no_radicado_assoc;
	}

	public void setNo_radicado_assoc(String no_radicado_assoc) {
		this.no_radicado_assoc = no_radicado_assoc;
	}

	public AdminResp getAdminresp() {
		return adminresp;
	}

	public void setAdminresp(AdminResp adminresp) {
		this.adminresp = adminresp;
	}
	


}