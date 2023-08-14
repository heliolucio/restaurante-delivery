package com.restaurante.delivery.commands.repositories.interfaces;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurante.delivery.entity.ClienteEntity;

@Repository
public interface ClienteJpaRepository extends JpaRepository<ClienteEntity, BigInteger> {

	Optional<ClienteEntity> findById(Integer id);

	void deleteById(Integer id);


}
