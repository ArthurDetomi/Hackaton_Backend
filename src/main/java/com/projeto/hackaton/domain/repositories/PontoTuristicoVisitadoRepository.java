package com.projeto.hackaton.domain.repositories;

import com.projeto.hackaton.domain.entities.PontoTuristicoVisitado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PontoTuristicoVisitadoRepository extends JpaRepository<PontoTuristicoVisitado, Integer> {
}
