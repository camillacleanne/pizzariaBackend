package com.ciandt.pizarria.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.ciandt.pizarria.model.Cadastro;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CadastroRepositoryTest {
	
	@Autowired
	private CadastroRepository repository;
	
	@BeforeAll
	void start(){

		repository.save(new Cadastro(0L, "Pizza Margarida", "mussarela, tomates e manjericão", 25.50));
		
		repository.save(new Cadastro(0L, "Pizza 4 estações", "Gorgonzola, mussarela, parmesão e provolone", 32.00));
		
		repository.save(new Cadastro(0L, "Pizza Escachova", "Escarola, anchova, queijo e molho de tomates",  29.90));

		repository.save(new Cadastro(0L, "Pizza dos sonhos ", "Alho frito, queijo e oregano", 27.50));

	}

	@Test
	@DisplayName("Retorna 1 cadastro")
	public void deveRetornarUmCadastro() {

		Optional<Cadastro> cadastro = repository.findByNome("Marguerita");
		assertTrue(cadastro.get().getNome().equals("Pizza Margarida"));
	}

	@Test
	@DisplayName("Retorna 3 cadastros")
	public void deveRetornarTresCadastros() {

		List<Cadastro> listaDeCadastros = repository.findAllByNomeContainingIgnoreCase("Pizza");
		assertEquals(3, listaDeCadastros.size());
		assertTrue(listaDeCadastros.get(0).getNome().equals("Pizza Margarida"));
		assertTrue(listaDeCadastros.get(1).getNome().equals("Pizza 4 estações"));
		assertTrue(listaDeCadastros.get(2).getNome().equals("Pizza dos sonhos"));
		
	}
}
