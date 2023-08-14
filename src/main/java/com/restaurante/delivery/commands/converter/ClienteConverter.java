package com.restaurante.delivery.commands.converter;

import com.restaurante.delivery.entity.ClienteEntity;
import com.restaurante.delivery.models.ClienteDO;

public class ClienteConverter {
	
	public static ClienteDO toDO(ClienteEntity entity) {
		
		ClienteDO cliente = new ClienteDO();
		
		cliente.setId(entity.getId());
		cliente.setNome(entity.getNome());
		cliente.setEndereco(entity.getEndereco());
		cliente.setTelefone(entity.getTelefone());
		
		return cliente;
	}

	public static ClienteEntity toEntity(ClienteDO clienteDO) {
		ClienteEntity entity = new ClienteEntity();
		
		entity.setId(clienteDO.getId());
		entity.setNome(clienteDO.getNome());
		entity.setEndereco(clienteDO.getEndereco());
		entity.setTelefone(clienteDO.getTelefone());
		
		return entity;
	}

}
