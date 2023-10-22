package com.projeto.hackaton.api.service;

import com.projeto.hackaton.api.handler.NotFoundException;
import com.projeto.hackaton.api.models.EventoModel;
import com.projeto.hackaton.domain.entities.Cidade;
import com.projeto.hackaton.domain.repositories.CidadeRepository;
import com.projeto.hackaton.domain.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    public List<EventoModel> getEventos() {
        return eventoRepository.getEventosEmAndamento(new Date()).stream().map(EventoModel::new).collect(Collectors.toList());
    }

    public List<EventoModel> getEventosPorCidade(Integer cidadeId) {
        Cidade cidade = cidadeRepository.findById(cidadeId).orElseThrow(NotFoundException::new);
        return eventoRepository.getEventosPorCidade(cidade.getId()).stream().map(EventoModel::new).collect(Collectors.toList());
    }
}
