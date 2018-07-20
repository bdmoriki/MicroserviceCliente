package com.itau.microservicecliente.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itau.microservicecliente.dao.ClienteDao;
import com.itau.microservicecliente.model.Cliente;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteDao clienteDao;
	
	public List<Cliente> listarClientes(Optional<String> segmento) {
		
		 List<Cliente> listaCliente = new ArrayList<Cliente>();
		 Iterable<Cliente> listaIterable = Collections.emptySet();
		 
		 if (segmento.isPresent()) {
			 listaIterable = this.clienteDao.findBySegmento(segmento.get());			 
		 } else {
			 listaIterable = this.clienteDao.findAll();
		 }
		 
		 if(listaIterable != null) {
			 for(Cliente cliente: listaIterable) {
				 listaCliente.add(cliente);
		     }
		 }
		
		return listaCliente;
	}

}
