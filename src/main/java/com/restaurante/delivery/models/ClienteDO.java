package com.restaurante.delivery.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDO {
	
	private Integer id;

	@Size(max = 30, message = "O campo nome permite até 30 caracteres.")
	@NotBlank(message = "O campo nome não pode ser branco.")
	@NotEmpty(message = "O campo nome não pode ser vazio.")
	private String nome;
	
	@Size(max = 50, message = "O endereço nome permite até 50 caracteres.")
	@NotBlank(message = "O endereço nome não pode ser branco.")
	@NotEmpty(message = "O endereço nome não pode ser vazio.")
	private String endereco;
	
	private String telefone;

}
