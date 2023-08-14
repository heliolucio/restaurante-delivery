package com.restaurante.delivery.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "pedido")
public class PedidoEntity {

	@Id
	@GeneratedValue(generator = "Inc_Pedido", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "Inc_Pedido", sequenceName = "So.Inc_Pedido", allocationSize = 1)
	private Integer id;
	
	@Column(name="descricao_pedido")
	private String descricaoPedido;
	
	@Column(name="data_pedido")
	private Date dataPedido;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_cliente", nullable = false)
	private ClienteEntity cliente;

}
