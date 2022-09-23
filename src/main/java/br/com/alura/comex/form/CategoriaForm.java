package br.com.alura.comex.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.alura.comex.data.modelo.Categoria;
import br.com.alura.comex.data.modelo.Cliente;

public class CategoriaForm {

	@NotNull
	@NotEmpty
	@Length(min = 5, max = 250)
	private String nome;
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria converter() {
		Categoria categoria = new Categoria();
		categoria.setNome(this.nome);
		
		return categoria;
	}
	
	
}
