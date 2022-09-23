package br.com.alura.data.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.alura.comex.data.orm.Cliente;
import br.com.alura.comex.data.repository.ClienteRepository;

@Service
public class ClienteService {

	private final ClienteRepository clienteRepository;
	
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	
	
	
	
	
	
	
}
