package com.itau.microservicecliente.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.itau.microservicecliente.model.Cliente;

public interface ClienteDao extends MongoRepository<Cliente, Long> {
	
    List<Cliente> findBySegmento(String segmento); 

}
