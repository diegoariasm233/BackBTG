package com.internal.ServicioWebREST.Models;

import org.springframework.data.annotation.Id;

public class Solicitud {

	@Id
	public String no_radicado;
	public String text;
	public String date;
	public String satifaccion;
	public String identificacion;
	public String tipo_solicitud;
	
	public Solicitud () {}

	public Solicitud(String no_radicado, String text, String date, String satifaccion, String identificacion,
			String tipo_solicitud) {
		super();
		this.no_radicado = no_radicado;
		this.text = text;
		this.date = date;
		this.satifaccion = satifaccion;
		this.identificacion = identificacion;
		this.tipo_solicitud = tipo_solicitud;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSatifaccion() {
		return satifaccion;
	}

	public void setSatifaccion(String satifaccion) {
		this.satifaccion = satifaccion;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getTipo_solicitud() {
		return tipo_solicitud;
	}

	public void setTipo_solicitud(String tipo_solicitud) {
		this.tipo_solicitud = tipo_solicitud;
	}

}