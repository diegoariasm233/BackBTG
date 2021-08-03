package com.internal.ServicioWebREST.Until;
import org.apache.commons.lang3.StringUtils;
public class Utils {
	
	public static final String TYPE_RQ_QUEJA = "QUEJA";
	public static final String TYPE_RQ_RECLAMO = "RECLAMO";
	public static final String TYPE_RQ_PETICION = "PETICION";
	
	public static final String ESTADO_APROBADO = "APROBADO";
	public static final String ESTADO_CERRADO = "CERRADO";
	
	public static final String NO_SATIFACCION = "NO_SATIFACCION";
	public static final String SATIFACCION = "SATIFACCION";
	
	public static final String CALIFICADO = "1";
	public static final String NO_CALIFICADO = "0";
	
	
	public static final Boolean validateNotBlank(String... strings) {
		for(String string : strings) {
			if(StringUtils.isBlank(string)) {
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}
	
}