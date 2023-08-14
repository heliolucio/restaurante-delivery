package com.restaurante.delivery.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.restaurante.delivery.commands.repositories.PedidoRepository;
import com.restaurante.delivery.models.PedidoDO;

public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	public PedidoDO cadastrarPedido(PedidoDO pedidoDO) throws Exception {
		if(pedidoDO.getId() != null) {
			PedidoDO pedido = pedidoRepository.verificarPedidoExistente(pedidoDO.getId());
			if(pedido != null) {
				throw new Exception("Pedido já cadastrado.");
			}
		}
		return pedidoRepository.salvar(pedidoDO);
	}

	public PedidoDO editarPedido(PedidoDO pedidoDO) throws Exception {
		if(pedidoDO.getId() == null) {
			throw new Exception("O campo id é obrigatório.");
		}
		return pedidoRepository.salvar(pedidoDO);
	}

	public void deletarPedido(Integer id) throws Exception {
		PedidoDO pedido = pedidoRepository.verificarPedidoExistente(id);
		
		if(pedido == null) {
			throw new Exception("Pedido não encontrado.");
		}
		
		pedidoRepository.deletar(id);
	}

}
