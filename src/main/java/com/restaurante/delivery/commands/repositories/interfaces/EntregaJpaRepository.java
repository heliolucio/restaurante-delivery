package com.restaurante.delivery.commands.repositories.interfaces;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurante.delivery.entity.EntregaEntity;

@Repository
public interface EntregaJpaRepository extends JpaRepository<EntregaEntity, BigInteger> {

	void deleteById(Integer id);

	Optional<EntregaEntity> findById(Integer id);

}
