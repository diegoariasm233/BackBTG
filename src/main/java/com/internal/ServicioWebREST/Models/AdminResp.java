package com.internal.ServicioWebREST.Models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

public class AdminResp {
	
	@Id
	public String idresponseadmin;
	public String no_radicado;
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonProperty("date")
	public LocalDateTime date;
	public String text;
	public String satifaccion;
	public String calificacion;
	
	public AdminResp() { }
	
	public AdminResp(String idresponseadmin, String no_radicado, LocalDateTime date, String text, String satifaccion, String calificacion) {
		super();
		this.idresponseadmin = idresponseadmin;
		this.no_radicado = no_radicado;
		this.date = date;
		this.text = text;
		this.satifaccion = satifaccion;
	}
	public String getId_response_admin() {
		return idresponseadmin;
	}
	public void setId_response_admin(String idresponseadmin) {
		this.idresponseadmin = idresponseadmin;
	}
	public String getNo_radicado() {
		return no_radicado;
	}
	public void setNo_radicado(String no_radicado) {
		this.no_radicado = no_radicado;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getSatifaccion() {
		return satifaccion;
	}
	public void setSatifaccion(String satifaccion) {
		this.satifaccion = satifaccion;
	}

	public String getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}
}
