package com.restaurante.delivery.services;

import org.hibernate.QueryException;
import org.springframework.beans.factory.annotation.Autowired;

import com.restaurante.delivery.commands.repositories.EntregaRepository;
import com.restaurante.delivery.models.EntregaDO;

public class EntregaService {
	
	@Autowired
	private EntregaRepository entregaRepository;

	
	public EntregaDO cadastrarEntrega(EntregaDO entregaDO) throws Exception {
		
		if(entregaDO.getId() != null) {
			EntregaDO entrega = entregaRepository.verificarEntregaExistente(entregaDO.getId());
			if(entrega != null) {
				throw new Exception("Entrega já cadastrada.");
			}
		}
		return entregaRepository.salvar(entregaDO);
	}


	public EntregaDO editarEntrega(EntregaDO entregaDO) throws Exception {
		if(entregaDO.getId() == null) {
			throw new Exception("O campo id é obrigatório.");
		}
		
		return entregaRepository.salvar(entregaDO);
	}


	public void deletarCliente(Integer id) {
		EntregaDO entrega = entregaRepository.verificarEntregaExistente(id);
		
		if(entrega == null) {
			throw new QueryException("Entrega não encontrada.");
		}
		entregaRepository.deletar(id);		
	}

}
