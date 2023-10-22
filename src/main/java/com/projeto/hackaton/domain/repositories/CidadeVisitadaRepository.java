package com.projeto.hackaton.domain.repositories;

import com.projeto.hackaton.domain.entities.Cidade;
import com.projeto.hackaton.domain.entities.CidadeVisitadas;
import com.projeto.hackaton.domain.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CidadeVisitadaRepository extends JpaRepository<CidadeVisitadas, Integer> {
    Optional<CidadeVisitadas> findByUsuarioIdAndCidadeId(Usuario usuario, Cidade cidade);
}
