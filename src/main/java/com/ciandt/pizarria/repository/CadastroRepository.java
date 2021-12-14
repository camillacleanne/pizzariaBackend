package com.ciandt.pizarria.repository;

import java.util.List;
import java.util.Optional;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ciandt.pizarria.model.Cadastro;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Long> {

	Page<Cadastro> findByNome(String cadastroNome, Pageable pageable);
	
	Page<Cadastro> findById(Long cadastroId, Pageable pageable);
	
	public List<Cadastro> findAllByNomeContainingIgnoreCase(String nome);
	
	public Optional<Cadastro> findByNome(String nome);
}
