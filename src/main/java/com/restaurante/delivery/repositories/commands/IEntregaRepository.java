package com.restaurante.delivery.repositories.commands;

import java.util.List;

import com.restaurante.delivery.models.EntregaDO;

public interface IEntregaRepository {

	List<EntregaDO> listarEntregas();

	EntregaDO listarEntrega(Integer id);

	EntregaDO verificarEntregaExistente(Integer id);

	EntregaDO salvar(EntregaDO entregaDO);

	void deletar(Integer id);

}
