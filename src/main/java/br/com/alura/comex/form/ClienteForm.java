package br.com.alura.comex.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.alura.comex.data.orm.Cliente;
import br.com.alura.comex.data.orm.Endereco;

public class ClienteForm {

	@NotNull
	@NotEmpty
	@Length(min = 5)
	private String nome;
	
	@NotNull
	@NotEmpty
	@Length(min = 11)
	private String cpf;
	
	@NotNull
	@NotEmpty
	private String email;
	
	@NotNull
	@NotEmpty
	@Length(min = 8)
	private String telefone;
	
	@NotNull
	@NotEmpty
	private String rua;
	
	@NotNull
	@NotEmpty
	private String numero;
	
	private String complemento;
	
	@NotNull
	@NotEmpty
	private String bairro;
	
	@NotNull
	@NotEmpty
	private String cidade;
	
	@NotNull
	@NotEmpty
	private String estado;
	
	@NotNull
	@NotEmpty
	private String profissão;

	
	
	
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getProfissão() {
		return profissão;
	}

	public void setProfissão(String profissão) {
		this.profissão = profissão;
	}

	public Cliente converter() {
		Endereco endereco = new Endereco();
		endereco.setRua(this.rua);
		endereco.setNumero(this.numero);
		endereco.setComplemento(this.complemento);
		endereco.setBairro(this.bairro);
		endereco.setCidade(this.cidade);
		endereco.setEstado(this.estado);
		Cliente cliente = new Cliente();
		cliente.setNome(this.nome);
		cliente.setCpf(this.cpf);
		cliente.setEmail(this.email);
		cliente.setTelefone(this.telefone);
		cliente.setEndereco(endereco);
		cliente.setProfissão(this.profissão);
		
		return cliente;
	}
	
	
}
