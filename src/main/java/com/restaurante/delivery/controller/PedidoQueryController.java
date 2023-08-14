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

import com.restaurante.delivery.commands.repositories.PedidoRepository;
import com.restaurante.delivery.models.PedidoDO;
import com.restaurante.delivery.services.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoQueryController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping
	public ResponseEntity<List<PedidoDO>> listarPedido()throws Exception {
		return new ResponseEntity<>(pedidoRepository.listarPedidos(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PedidoDO> listarPedido(@PathVariable Integer id) throws Exception{
		return new ResponseEntity<>(pedidoRepository.listarPedido(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<PedidoDO> cadastrarPedido(@Valid @RequestBody PedidoDO pedidoDO) throws Exception {
		return new ResponseEntity<>(pedidoService.cadastrarPedido(pedidoDO), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<PedidoDO> editarPedido(@Valid @RequestBody PedidoDO pedidoDO) throws Exception {
		return new ResponseEntity<>(pedidoService.editarPedido(pedidoDO), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<PedidoDO> deletarPedido(@PathVariable Integer id) throws Exception {
		
		pedidoService.deletarPedido(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
