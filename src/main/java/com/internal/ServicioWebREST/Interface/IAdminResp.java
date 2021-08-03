package com.internal.ServicioWebREST.Interface;


import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.internal.ServicioWebREST.Models.AdminResp;


public interface IAdminResp extends MongoRepository<AdminResp, String> {
	  
	  @Query("{ 'no_radicado' :  :#{#no_radicado} }")
	  public Optional<AdminResp> findOneByNo_Radicado(@Param("no_radicado") String no_radicado);
}
