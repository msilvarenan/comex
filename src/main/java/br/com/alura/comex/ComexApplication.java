package br.com.alura.comex;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import br.com.alura.comex.data.repository.CategoriaRepository;
import br.com.alura.comex.data.repository.ClienteRepository;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableCaching
@EnableSwagger2
public class ComexApplication implements CommandLineRunner {
	
	private final ClienteRepository clienteRepository;
	private final CategoriaRepository categoriaRepository;
	//teste
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
