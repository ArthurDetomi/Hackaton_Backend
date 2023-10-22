package com.projeto.hackaton.domain.repositories;

import com.projeto.hackaton.domain.entities.Cidade;
import com.projeto.hackaton.domain.entities.PontoTuristico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PontoTuristicoRepository extends JpaRepository<PontoTuristico, Integer> {

    List<PontoTuristico> findAllByCidadeId(Cidade cidade);

}
