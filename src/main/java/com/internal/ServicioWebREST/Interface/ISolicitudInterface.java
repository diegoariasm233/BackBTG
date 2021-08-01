package com.internal.ServicioWebREST.Interface;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.internal.ServicioWebREST.Models.Solicitud;

public interface ISolicitudInterface extends MongoRepository<Solicitud, String> {
	  
	  @Query("{ 'identificacion' :  :#{#identifficacion} }")
	  public List<Solicitud> findAllByIdentificacion(@Param("identifficacion") String identifficacion);
	  
}
