package br.com.alura.comex.controller;

import java.net.URI;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.alura.comex.data.modelo.Cliente;
import br.com.alura.comex.data.modelo.Endereco;
import br.com.alura.comex.data.repository.ClienteRepository;
import br.com.alura.comex.dto.ClienteDto;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles(value = {"dev", "test"})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClienteControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ClienteRepository clienteRepositorio;
	
	@Test 
	@Order(1)
	void cadastraTresClientesERetorna200() throws Exception {
		URI uri = new URI("/api/clientes");
		
		Cliente cliente = new Cliente();
		cliente.setNome("teste1");
		cliente.setCpf("22222222222");
		cliente.setEmail("rere@teste.com");
		Endereco endereco = new Endereco();
		endereco.setRua("Rua teste");
		endereco.setNumero("121");
		endereco.setBairro("bairro teste");
		endereco.setCidade("Sao Paulo");
		endereco.setEstado("Sao Paulo");
		cliente.setEndereco(endereco);
		this.clienteRepositorio.save(cliente);
		
		Cliente cliente2 = new Cliente();
		cliente2.setNome("teste1");
		cliente2.setCpf("22222222222");
		cliente2.setEmail("rere@teste.com");
		Endereco endereco2 = new Endereco();
		endereco2.setRua("Rua teste");
		endereco2.setNumero("121");
		endereco2.setBairro("bairro teste");
		endereco2.setCidade("Sao Paulo");
		endereco2.setEstado("Sao Paulo");
		cliente2.setEndereco(endereco2);
		this.clienteRepositorio.save(cliente2);
		
		String json = "{\r\n"
				+ "    \"nome\": \"teste1\",\r\n"
				+ "    \"cpf\": \"66444555441\",\r\n"
				+ "    \"email\": \"lolo@brq.com\",\r\n"
				+ "    \"telefone\": \"12341234\",\r\n"
				+ "    \"rua\": \"rua 3 teste\",\r\n"
				+ "    \"numero\": \"333\",\r\n"
				+ "    \"complemento\": \"complemento teste\",\r\n"
				+ "    \"bairro\": \"bairro teste\",\r\n"
				+ "    \"cidade\": \"Cidade 3\",\r\n"
				+ "    \"estado\": \"PR\",\r\n"
				+ "    \"profissão\": \"desenvolvedor\"\r\n"
				+ "}";
		
		
			mockMvc.perform(MockMvcRequestBuilders
					.post(uri)
					.content(json)
					.contentType(MediaType.APPLICATION_JSON))
						.andExpect(MockMvcResultMatchers.status().is(200));
		
		
		
		
	}
	
	@Test
	@Order(2)
	public void DeveriaRetornarListaDeClientesERetornar200() throws Exception {
		URI uri = new URI("/api/clientes");
		
		MvcResult resultado = mockMvc.perform(MockMvcRequestBuilders
										.get(uri))
											.andExpect(MockMvcResultMatchers
															.status()
															.isOk())
																.andReturn();
		ObjectMapper mapper = new ObjectMapper();
		
		List<ClienteDto> actual = mapper.readValue(resultado.getResponse().getContentAsString(), new TypeReference<List<ClienteDto>>() {});
		Assertions.assertEquals(3, actual.size());
		
	}

}
