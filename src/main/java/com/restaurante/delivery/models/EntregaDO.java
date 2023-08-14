package com.restaurante.delivery.models;

import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntregaDO {
	
	private Integer id;
	
	@NotNull
	private Integer idPedido; 
	
	private Date dataEntrega;
	private String status;

}
