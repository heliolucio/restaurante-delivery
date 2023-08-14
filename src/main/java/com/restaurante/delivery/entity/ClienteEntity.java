package com.restaurante.delivery.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Getter
@Setter
@Table(name="clientes")
public class ClienteEntity {
	
	@Id
	@GeneratedValue(generator = "Inc_Clientes", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "Inc_Clientes", sequenceName = "So.Inc_Clientes", allocationSize = 1)
	private Integer id;
	private String nome;
	private String endereco;
	private String telefone;

}
