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

import br.com.alura.comex.data.modelo.Categoria;
import br.com.alura.comex.data.repository.CategoriaRepository;
import br.com.alura.comex.dto.CategoriaDto;
import br.com.alura.comex.form.CategoriaForm;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepositorio;
	
	@GetMapping
	public List<CategoriaDto> ListarClientes() {
		List<Categoria> listaCategoria = (List<Categoria>) categoriaRepositorio.listaTodas();
		return CategoriaDto.converter(listaCategoria);
		
	}
	
	@PostMapping
	public ResponseEntity<CategoriaForm> cadastrar(@RequestBody @Valid CategoriaForm form){
		Categoria categoria = form.converter();
		this.categoriaRepositorio.save(categoria);
		
		return ResponseEntity.ok(form);
	}
	
}
