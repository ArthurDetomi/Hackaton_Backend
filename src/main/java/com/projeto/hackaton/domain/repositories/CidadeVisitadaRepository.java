package com.projeto.hackaton.domain.repositories;

import com.projeto.hackaton.domain.entities.CidadeVisitadas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeVisitadaRepository extends JpaRepository<CidadeVisitadas, Integer> {
}
