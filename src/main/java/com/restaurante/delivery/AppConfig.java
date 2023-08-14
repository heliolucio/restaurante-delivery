package com.restaurante.delivery;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.restaurante.delivery.services.ClienteService;
import com.restaurante.delivery.services.EntregaService;
import com.restaurante.delivery.services.PedidoService;

@Configuration
public class AppConfig {

	@Bean
	public ClienteService clienteService() {

		return new ClienteService();
	}
	
	@Bean
	public PedidoService pedidoService() {
		return new PedidoService();
	}
	
	@Bean
	public EntregaService entregaService() {
		return new EntregaService();
	}

}
