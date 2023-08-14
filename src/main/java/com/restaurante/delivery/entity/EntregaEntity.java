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
@Table(name="entrega")
public class EntregaEntity {
	
	@Id
	@GeneratedValue(generator = "Inc_Entrega", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "Inc_Entrega", sequenceName = "So.Inc_Entrega", allocationSize = 1)
	private Integer id;
	
	@Column(name="data_entrega")
	private Date dataEntrega;
	
	@Column(name="status")
	private String status;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_pedido", nullable = false)
	private PedidoEntity pedido;

}
