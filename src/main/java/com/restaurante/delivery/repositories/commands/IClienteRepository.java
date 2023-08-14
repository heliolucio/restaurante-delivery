package com.restaurante.delivery.repositories.commands;

import java.util.List;

import com.restaurante.delivery.models.ClienteDO;

public interface IClienteRepository {

	List<ClienteDO> listarClientes();
	
	ClienteDO listarCliente(Integer id);
	
	ClienteDO salvar (ClienteDO clienteDO);

	void deletar(Integer id);

	ClienteDO verificarClienteExistente(Integer id);

}
