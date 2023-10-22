package com.projeto.hackaton.domain.repositories;

import com.projeto.hackaton.domain.entities.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM cidades ORDER BY nome")
    List<Cidade> procurarNomeTodasCidades();

}
