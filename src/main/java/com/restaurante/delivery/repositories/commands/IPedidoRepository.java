package com.restaurante.delivery.repositories.commands;

import java.util.List;

import com.restaurante.delivery.models.PedidoDO;

public interface IPedidoRepository {

	List<PedidoDO> listarPedidos();

	PedidoDO listarPedido(Integer id);

	PedidoDO verificarPedidoExistente(Integer id);

	PedidoDO salvar(PedidoDO pedidoDO);

	void deletar(Integer id);

}
