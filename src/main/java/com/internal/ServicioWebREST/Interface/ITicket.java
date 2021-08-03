package com.internal.ServicioWebREST.Interface;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.internal.ServicioWebREST.Models.Ticket;

public interface ITicket extends MongoRepository<Ticket, String> {
	  
	  
}
