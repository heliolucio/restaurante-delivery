package com.restaurante.delivery.services;

import org.hibernate.QueryException;
import org.springframework.beans.factory.annotation.Autowired;

import com.restaurante.delivery.commands.repositories.ClienteRepository;
import com.restaurante.delivery.models.ClienteDO;

public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public ClienteDO cadastrarCliente(ClienteDO clienteDO) throws Exception {

		if (clienteDO.getId() != null) {
			ClienteDO cliente = clienteRepository.verificarClienteExistente(clienteDO.getId());
			if (cliente != null) {
				throw new QueryException("Cliente já cadastrado.");
			}
		}

		return clienteRepository.salvar(clienteDO);
	}

	public ClienteDO editarCliente(ClienteDO clienteDO) throws Exception {

		if (clienteDO.getId() == null) {
			throw new Exception("O Campo id é obrigatório.");
		}

		return clienteRepository.salvar(clienteDO);
	}

	public void deletarCliente(Integer id) {
		ClienteDO cliente = clienteRepository.verificarClienteExistente(id);
		
		if (cliente == null) {
			throw new QueryException("Cliente não encontrado.");
		}
		
		clienteRepository.deletar(id);
	}

}
