package com.projeto.hackaton.api.controller;

import com.projeto.hackaton.api.models.EventoModel;
import com.projeto.hackaton.api.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
@CrossOrigin(origins = "*")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public List<EventoModel> getEventos() {
        return eventoService.getEventos();
    }

    @GetMapping("/cidade/{id}")
    public List<EventoModel> getEventosPorCidade(@PathVariable(name = "id", required = true) Integer cidadeId) {
        return eventoService.getEventosPorCidade(cidadeId);
    }


}
