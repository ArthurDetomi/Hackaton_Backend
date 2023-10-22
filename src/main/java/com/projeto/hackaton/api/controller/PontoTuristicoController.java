package com.projeto.hackaton.api.controller;

import com.projeto.hackaton.api.models.PontoTuristicoModel;
import com.projeto.hackaton.api.service.PontoTuristicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/pontos")
public class PontoTuristicoController {

    @Autowired
    private PontoTuristicoService pontoTuristicoService;

    @GetMapping
    public List<PontoTuristicoModel> getTodosPontosTuristicos() {
        return pontoTuristicoService.getAllPontosTuristicos();
    }

    @GetMapping("/cidade/{id}")
    public List<PontoTuristicoModel> getPontosTuristicosPorCidade(
            @PathVariable("id") Integer cidadeId) {
        return pontoTuristicoService.getPontosTuristicosPorCidade(cidadeId);
    }

    @PostMapping("/registrar/{id}")
   public void registrarPontoTuristicoVisitado(@PathVariable("id") Integer pontoTuristicoId,
            @RequestHeader("token") String token) {
        pontoTuristicoService.registrarPontoVisitado(token, pontoTuristicoId);
   }

}
