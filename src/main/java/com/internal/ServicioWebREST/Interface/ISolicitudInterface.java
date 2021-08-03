package com.internal.ServicioWebREST.Interface;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.internal.ServicioWebREST.Models.Solicitud;

public interface ISolicitudInterface extends MongoRepository<Solicitud, String> {
	  
	  @Query("{ '_id' :  :#{#no_radicado} }")
	  public List<Solicitud> findOneByNo_Radicado(@Param("no_radicado") String no_radicado);
	  
}
