package br.com.alura.comex.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.comex.data.modelo.Cliente;

public class ClienteDto {
	private Long id;
	private String nome;
	private String cpf;
	private String email;
	private String local;
	private String status;
	
	public ClienteDto(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.cpf = cliente.getCpf();
		this.email = cliente.getEmail();
		this.local = cliente.getEndereco().getCidade() + "/" + cliente.getEndereco().getEstado();
		this.status = cliente.getStatus().toString();
	}
	
	

	public ClienteDto() {
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static List<ClienteDto> converter(List<Cliente> listaClientes) {
		return listaClientes.stream().map(ClienteDto::new).collect(Collectors.toList());
	}
	
}
