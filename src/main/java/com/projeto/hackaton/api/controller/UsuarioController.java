package com.projeto.hackaton.api.controller;

import com.projeto.hackaton.api.models.UsuarioModel;
import com.projeto.hackaton.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registrar/visita/cidade/{id}")
    public void registrarVisitaCidade(@RequestHeader("token") String token,
                                      @PathVariable("id") Integer cidadeId) {
        usuarioService.cadastrarVisitaCidade(token, cidadeId);
    }

    @GetMapping("/dados")
    public UsuarioModel getNomeUsuario(@RequestHeader("token") String token) {
        return usuarioService.getNomeUsuario(token);
    }

}
