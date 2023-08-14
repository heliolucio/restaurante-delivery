package com.restaurante.delivery.commands.converter;

import com.restaurante.delivery.entity.EntregaEntity;
import com.restaurante.delivery.entity.PedidoEntity;
import com.restaurante.delivery.models.EntregaDO;

public class EntregaConverter {
	
	public static EntregaDO toDO(EntregaEntity entity) {
		
		EntregaDO entrega = new EntregaDO();
		
		entrega.setId(entity.getId());
		entrega.setIdPedido(entity.getPedido().getId());
		entrega.setDataEntrega(entity.getDataEntrega());
		entrega.setStatus(entity.getStatus());
		
		return entrega;
	}

	public static EntregaEntity toEntity(EntregaDO entregaDO) {
		EntregaEntity entity = new EntregaEntity();
		
		entity.setId(entregaDO.getId());
		
		if(entregaDO.getIdPedido() != null) {
			entity.setPedido(new PedidoEntity());
			entity.getPedido().setId(entregaDO.getIdPedido());
		}
		
		entity.setDataEntrega(entregaDO.getDataEntrega());
		entity.setStatus(entregaDO.getStatus());
		
		return entity;
	}

}
