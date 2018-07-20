package com.itau.microservicecliente.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itau.microservicecliente.model.Cliente;
import com.itau.microservicecliente.service.ClienteService;

@RestController
@RequestMapping(
		path = "/api/v1/clientes"
		)
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;

	@RequestMapping(
	method = RequestMethod.GET,
	produces = MediaType.APPLICATION_JSON_VALUE
	)
	@CrossOrigin(origins = "http://localhost:4200") //Tirar
	public List<Cliente> Listar(@RequestParam("segmento") Optional<String> segmento) {
		return this.clienteService.listarClientes(segmento);
	}
}
