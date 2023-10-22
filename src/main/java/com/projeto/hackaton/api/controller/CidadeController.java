package com.projeto.hackaton.api.controller;

import com.projeto.hackaton.api.models.CidadeModel;
import com.projeto.hackaton.api.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cidades")
@CrossOrigin(origins = "*")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping(value = "/nome")
    public List<CidadeModel> enviar() {
        return cidadeService.getCidadesNomeEId();
    }

}
