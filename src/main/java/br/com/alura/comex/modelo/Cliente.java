package br.com.alura.comex.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private long cpf;
	private long telefone;
	private String email;
	private String profissão;
	private String status;
	
	public Cliente(String nome, long cpf, long telefone, String email, String profissão, String status) {
		
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.profissão = profissão;
		this.status = status;
	}
	
	
}
