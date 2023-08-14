package com.restaurante.delivery.commands.repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.delivery.commands.converter.ClienteConverter;
import com.restaurante.delivery.commands.repositories.interfaces.ClienteJpaRepository;
import com.restaurante.delivery.entity.ClienteEntity;
import com.restaurante.delivery.models.ClienteDO;
import com.restaurante.delivery.repositories.commands.IClienteRepository;

@Service
public class ClienteRepository implements IClienteRepository {

	@Autowired
	private ClienteJpaRepository clienteJpaRepository;

	@Override
	public List<ClienteDO> listarClientes() {
		
		List<ClienteEntity> list;
		list = this.clienteJpaRepository.findAll();
		return list.stream().map(ClienteConverter::toDO).toList();
	}

	@Override
	public ClienteDO listarCliente(Integer id) {
		Optional<ClienteEntity> cliente;
		cliente = this.clienteJpaRepository.findById(id);
		return cliente.map(ClienteConverter::toDO).orElseGet(() -> null);
	}

	@Override
	public ClienteDO salvar(ClienteDO clienteDO) {
		return ClienteConverter.toDO(clienteJpaRepository.saveAndFlush(ClienteConverter.toEntity(clienteDO)));
	}

	@Override
	public ClienteDO verificarClienteExistente(Integer id) {
		
		Optional<ClienteEntity> cliente;
		cliente = clienteJpaRepository.findById(id);
		return cliente.map(ClienteConverter::toDO).orElseGet(() -> null);
	}

	@Override
	@Transactional 
	public void deletar(Integer id) {
		clienteJpaRepository.deleteById(id);		
	}

}
