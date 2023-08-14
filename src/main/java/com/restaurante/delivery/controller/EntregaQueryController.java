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

import com.restaurante.delivery.commands.repositories.EntregaRepository;
import com.restaurante.delivery.models.EntregaDO;
import com.restaurante.delivery.services.EntregaService;

@RestController
@RequestMapping("/entrega")
public class EntregaQueryController {
	
	@Autowired
	private EntregaRepository entregaRepository;
	
	@Autowired
	private EntregaService entregService;
	
	@GetMapping
	public ResponseEntity<List<EntregaDO>> listarEntregas() throws Exception {
		return new ResponseEntity<>(entregaRepository.listarEntregas(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EntregaDO> listarEntrega(@PathVariable Integer id) throws Exception {
		return new ResponseEntity<>(entregaRepository.listarEntrega(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<EntregaDO> cadastrarEntrega(@Valid @RequestBody EntregaDO entregaDO) throws Exception {
		return new ResponseEntity<>(entregService.cadastrarEntrega(entregaDO), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<EntregaDO> editarEntrega(@Valid @RequestBody EntregaDO entregaDO) throws Exception {
		return new ResponseEntity<>(entregService.editarEntrega(entregaDO), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<EntregaDO> deletarEntrega(@PathVariable Integer id) throws Exception {
		entregService.deletarCliente(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
