package br.com.alura.comex.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.comex.data.modelo.Cliente;
import br.com.alura.comex.data.repository.ClienteRepository;
import br.com.alura.comex.dto.ClienteDto;
import br.com.alura.comex.form.ClienteForm;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepositorio;
	
	@GetMapping
	@Cacheable(value = "listaDeClientes")
	public List<ClienteDto> ListarClientes() {
		List<Cliente> listaClientes = (List<Cliente>) clienteRepositorio.findAll();
		return ClienteDto.converter(listaClientes);
		
	}
	
	@PostMapping
	@CacheEvict(value = "listaDeClientes", allEntries = true)
	public ResponseEntity<ClienteForm> cadastrar(@RequestBody @Valid ClienteForm form){
		Cliente cliente = form.converter();
		this.clienteRepositorio.save(cliente);
		
		return ResponseEntity.ok(form);
	}
	
}
