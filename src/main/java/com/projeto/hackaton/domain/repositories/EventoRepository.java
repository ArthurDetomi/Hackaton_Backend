package com.projeto.hackaton.domain.repositories;

import com.projeto.hackaton.api.models.EventoModel;
import com.projeto.hackaton.domain.entities.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {
    @Query(nativeQuery = true, value = "SELECT * from eventos WHERE :dataAtual < date_fim")
    List<Evento> getEventosEmAndamento(@Param("dataAtual") Date dataAtual);
    @Query(nativeQuery = true, value = "SELECT * FROM eventos WHERE cidade_id = :cidadeId order by data_inicio asc")
    List<Evento> getEventosPorCidade(Integer cidadeId);
}
