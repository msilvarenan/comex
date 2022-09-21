package br.com.alura.comex.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.comex.data.orm.Cliente;
import br.com.alura.comex.data.repository.ClienteRepository;
import br.com.alura.comex.dto.ClienteDto;
import br.com.alura.comex.form.ClienteForm;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepositorio;
	
	@GetMapping
	public List<ClienteDto> ListarClientes() {
		List<Cliente> listaClientes = (List<Cliente>) clienteRepositorio.findAll();
		return ClienteDto.converter(listaClientes);
		
	}
	
	@PostMapping
	public ResponseEntity<ClienteForm> cadastrar(@RequestBody @Valid ClienteForm form){
		Cliente cliente = form.converter();
		this.clienteRepositorio.save(cliente);
		
		return ResponseEntity.ok(form);
	}
	
}
