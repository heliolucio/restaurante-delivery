package com.restaurante.delivery.commands.converter;

import com.restaurante.delivery.entity.ClienteEntity;
import com.restaurante.delivery.entity.PedidoEntity;
import com.restaurante.delivery.models.PedidoDO;

public class PedidoConverter {
	
	public static PedidoDO toDO(PedidoEntity entity) {
		PedidoDO pedido = new PedidoDO();
		
		pedido.setId(entity.getId());
		pedido.setIdCliente(entity.getCliente().getId());
		pedido.setDescricaoPedido(entity.getDescricaoPedido());
		pedido.setDataPedido(entity.getDataPedido());
		
		return pedido;
	}

	public static PedidoEntity toEntity(PedidoDO pedidoDO) {
		PedidoEntity entity = new PedidoEntity();
		
		entity.setId(pedidoDO.getId());
		
		if(pedidoDO.getIdCliente() != null) {
			entity.setCliente(new ClienteEntity());
			entity.getCliente().setId(pedidoDO.getIdCliente());
		}
		
		entity.setDescricaoPedido(pedidoDO.getDescricaoPedido());
		entity.setDataPedido(pedidoDO.getDataPedido());
		
		return entity;
	}

}
