package com.projeto.hackaton.domain.repositories;

import com.projeto.hackaton.domain.entities.PontoTuristico;
import com.projeto.hackaton.domain.entities.PontoTuristicoVisitado;
import com.projeto.hackaton.domain.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PontoTuristicoVisitadoRepository extends JpaRepository<PontoTuristicoVisitado, Integer> {
    Optional<PontoTuristicoVisitado> findByUsuarioIdAndPontoTuristicoId(Usuario usuarioId, PontoTuristico pontoTuristico);

}
