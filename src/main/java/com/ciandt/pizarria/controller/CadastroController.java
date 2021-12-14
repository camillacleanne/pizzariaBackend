package com.ciandt.pizarria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ciandt.pizarria.model.Cadastro;
import com.ciandt.pizarria.repository.CadastroRepository;

@RestController
@RequestMapping("/cadastrar")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class CadastroController {

	@Autowired
	private CadastroRepository repository;

	@GetMapping
	public ResponseEntity<List<Cadastro>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/listagem")
	public Page<Cadastro> getAllcadastro(Pageable pageable) {

		return repository.findAll(pageable);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cadastro> getById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Cadastro>> getByTitle(@PathVariable String nome) {
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}

	@PostMapping
	public ResponseEntity<Cadastro> post(@RequestBody Cadastro cadastro) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(cadastro));
	}

	@PutMapping
	public ResponseEntity<Cadastro> put(@RequestBody Cadastro cadastro) {
		return repository.findById(cadastro.getId())
				.map(resp -> ResponseEntity.status(HttpStatus.CREATED).body(repository.save(cadastro)))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		Optional<Cadastro> post = repository.findById(id);

		if (post.isEmpty())
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

		repository.deleteById(id);
	}
}