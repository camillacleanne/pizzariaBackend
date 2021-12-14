package com.ciandt.pizarria.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ciandt.pizarria.model.Cadastro;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CadastroControllerTest {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	@Order(1)
	@DisplayName("Cadastrar uma pizza")
	public void deveCriarUmCadastro() {

		HttpEntity<Cadastro> requisicao = new HttpEntity<Cadastro>(
				new Cadastro(0L, "Pizza Antunes", "Batata inglesa, queijo e alecrim", 27.50));

		ResponseEntity<Cadastro> resposta = testRestTemplate.exchange("/cadastrar", HttpMethod.POST, requisicao,
				Cadastro.class);

		assertEquals(HttpStatus.CREATED, resposta.getStatusCode());
		assertEquals(requisicao.getBody().getNome(), resposta.getBody().getNome());
		assertEquals(requisicao.getBody().getId(), resposta.getBody().getId());
	}
	

}
