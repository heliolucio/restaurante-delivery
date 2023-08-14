package com.restaurante.delivery.models;

import java.math.BigInteger;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoDO {

	private Integer id;
	
	@NotNull
	private Integer idCliente;
	
	@Size(max = 50, message = "A descrição do pedido permite até 50 caracteres.")
	@NotBlank(message = "A descrição pedido não pode ser branco.")
	@NotEmpty(message = "A descrição pedido não pode ser vazio.")
	private String descricaoPedido;
	
	private Date dataPedido;
}
