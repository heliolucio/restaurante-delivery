package com.restaurante.delivery.commands.repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.delivery.commands.converter.EntregaConverter;
import com.restaurante.delivery.commands.repositories.interfaces.EntregaJpaRepository;
import com.restaurante.delivery.entity.EntregaEntity;
import com.restaurante.delivery.models.EntregaDO;
import com.restaurante.delivery.repositories.commands.IEntregaRepository;

@Service
public class EntregaRepository implements IEntregaRepository {
	
	@Autowired
	private EntregaJpaRepository entregaJpaRepository;

	@Override
	public List<EntregaDO> listarEntregas() {
		List<EntregaEntity> list;
		list = this.entregaJpaRepository.findAll();
		return list.stream().map(EntregaConverter::toDO).toList();
	}

	@Override
	public EntregaDO listarEntrega(Integer id) {
		Optional<EntregaEntity> entrega;
		entrega = this.entregaJpaRepository.findById(id);
		
		return entrega.map(EntregaConverter::toDO).orElseGet(() -> null);
	}

	@Override
	public EntregaDO verificarEntregaExistente(Integer id) {
		
		Optional<EntregaEntity> entrega;
		entrega = this.entregaJpaRepository.findById(id);
		
		return entrega.map(EntregaConverter::toDO).orElseGet(() -> null);
	}

	@Override
	public EntregaDO salvar(EntregaDO entregaDO) {
		return EntregaConverter.toDO(entregaJpaRepository.saveAndFlush(EntregaConverter.toEntity(entregaDO)));
	}

	@Override
	@Transactional 
	public void deletar(Integer id) {
		entregaJpaRepository.deleteById(id);		
	}

}
