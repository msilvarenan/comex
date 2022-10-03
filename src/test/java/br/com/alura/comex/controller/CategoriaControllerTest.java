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

import br.com.alura.comex.data.modelo.Categoria;
import br.com.alura.comex.data.repository.CategoriaRepository;
import br.com.alura.comex.dto.CategoriaDto;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles(value = {"dev", "test"})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CategoriaControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private CategoriaRepository categoriaRepositorio;
	
	@Test 
	@Order(1)
	void cadastraUmaNovaCategoriaRetorno200() throws Exception {
			
		
		URI uri = new URI("/api/categoria");
		
		
		
		String json = "{\r\n"
				+ "    \"nome\": \"CategoriaTeste1\"\r\n"
				+ "}";
		
		mockMvc.perform(MockMvcRequestBuilders
					.post(uri)
					.content(json)
					.contentType(MediaType.APPLICATION_JSON))
						.andExpect(MockMvcResultMatchers.status().is(200));
		
	}
	
	@Test
	@Order(2)
	public void DeveriaRetornarListaDeCategoriasERetornar200() throws Exception {
		URI uri = new URI("/api/categoria");
		
		MvcResult resultado = mockMvc.perform(MockMvcRequestBuilders
										.get(uri))
									.andExpect(MockMvcResultMatchers
										.status()
										.isOk())
									.andReturn();
		ObjectMapper mapper = new ObjectMapper();
		
		List<CategoriaDto> actual = mapper.readValue(resultado.getResponse().getContentAsString(), new TypeReference<List<CategoriaDto>>() {});
		Assertions.assertEquals(1, actual.size());
		
	}

}
