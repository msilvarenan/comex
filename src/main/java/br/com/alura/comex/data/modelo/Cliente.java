package br.com.alura.comex.data.modelo;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.alura.comex.Status;



@Entity
@Table(name = "clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	private String profissão;
	
	@Embedded
	private Endereco endereco;
	
	@Enumerated(EnumType.STRING)
	private Status status = Status.ATIVO;
	
	/*
	 * @OneToOne private Usuario usuario;
	 */

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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfissão() {
		return profissão;
	}

	public void setProfissão(String profissão) {
		this.profissão = profissão;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Cliente { Id: "+ this.id +"| Nome: " + this.nome +" | E-mail: " + this.email+ " | CPF: "+this.cpf + " | Status: "+ this.status + "| Endereço: " + endereco;
	}
	
}
