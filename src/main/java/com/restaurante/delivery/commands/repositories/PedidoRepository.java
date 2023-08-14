package com.restaurante.delivery.commands.repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.delivery.commands.converter.PedidoConverter;
import com.restaurante.delivery.commands.repositories.interfaces.PedidoJpaRepository;
import com.restaurante.delivery.entity.PedidoEntity;
import com.restaurante.delivery.models.PedidoDO;
import com.restaurante.delivery.repositories.commands.IPedidoRepository;

@Service
public class PedidoRepository implements IPedidoRepository {

	@Autowired
	private PedidoJpaRepository pedidoJpaRepository;

	@Override
	public List<PedidoDO> listarPedidos() {
		List<PedidoEntity> list;
		list = this.pedidoJpaRepository.findAll();

		return list.stream().map(PedidoConverter::toDO).toList();
	}

	@Override
	public PedidoDO listarPedido(Integer id) {
		Optional<PedidoEntity> pedido;

		pedido = this.pedidoJpaRepository.findById(id);

		return pedido.map(PedidoConverter::toDO).orElseGet(() -> null);
	}

	@Override
	public PedidoDO verificarPedidoExistente(Integer id) {
		Optional<PedidoEntity> pedido;
		pedido = this.pedidoJpaRepository.findById(id);

		return pedido.map(PedidoConverter::toDO).orElseGet(() -> null);
	}

	@Override
	public PedidoDO salvar(PedidoDO pedidoDO) {
		return PedidoConverter.toDO(pedidoJpaRepository.saveAndFlush(PedidoConverter.toEntity(pedidoDO)));
	}

	@Override
	@Transactional 
	public void deletar(Integer id) {
		pedidoJpaRepository.deleteById(id);
	}

}
