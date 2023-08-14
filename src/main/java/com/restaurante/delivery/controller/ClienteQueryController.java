package com.restaurante.delivery.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.delivery.commands.repositories.ClienteRepository;
import com.restaurante.delivery.models.ClienteDO;
import com.restaurante.delivery.services.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteQueryController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<List<ClienteDO>> listarCliente() throws Exception {
		return new ResponseEntity<>(clienteRepository.listarClientes(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteDO> listarCliente(@PathVariable Integer id) throws Exception {
		return new ResponseEntity<>(clienteRepository.listarCliente(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ClienteDO> cadastrarCliente(@Valid @RequestBody ClienteDO clienteDO) throws Exception {
		return new ResponseEntity<>(clienteService.cadastrarCliente(clienteDO), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<ClienteDO> editarCliente(@Valid @RequestBody ClienteDO clienteDO) throws Exception {
		return new ResponseEntity<>(clienteService.editarCliente(clienteDO), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ClienteDO> deletarCliente(@PathVariable Integer id) throws Exception {
		clienteService.deletarCliente(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
