package br.com.alura.comex;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.comex.data.orm.Categoria;
import br.com.alura.comex.data.orm.Cliente;
import br.com.alura.comex.data.orm.Endereco;
import br.com.alura.comex.data.repository.CategoriaRepository;
import br.com.alura.comex.data.repository.ClienteRepository;

@SpringBootApplication
public class ComexApplication implements CommandLineRunner {
	
	private final ClienteRepository clienteRepository;
	private final CategoriaRepository categoriaRepository;
	
	public ComexApplication(ClienteRepository clienteReporitory, CategoriaRepository categoriaRepository) {
		this.clienteRepository = clienteReporitory;
		this.categoriaRepository = categoriaRepository;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ComexApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			
	}

	

}
