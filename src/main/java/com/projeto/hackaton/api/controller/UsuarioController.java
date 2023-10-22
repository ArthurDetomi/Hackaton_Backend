package com.projeto.hackaton.api.controller;

import com.projeto.hackaton.api.models.Token;
import com.projeto.hackaton.api.models.UsuarioAutenticarModel;
import com.projeto.hackaton.api.models.UsuarioCadastroModel;
import com.projeto.hackaton.api.models.UsuarioModel;
import com.projeto.hackaton.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registrar/visita/cidade/{id}")
    public ResponseEntity<?> registrarVisitaCidade(@RequestHeader("token") String token,
                                                @PathVariable("id") Integer cidadeId) {
        return usuarioService.cadastrarVisitaCidade(token, cidadeId);
    }

    @GetMapping("/dados")
    public UsuarioModel getNomeUsuario(@RequestHeader("token") String token) {
        return usuarioService.getNomeUsuario(token);
    }

    @PostMapping("/cadastro")
    @ResponseStatus(HttpStatus.CREATED)
    public Token cadastrar(@RequestBody UsuarioCadastroModel usuarioCadastroModel) {
        return usuarioService.cadastrarUsuario(usuarioCadastroModel);
    }

    @PostMapping("/autenticar")
    public Token autenticar(@RequestBody UsuarioAutenticarModel usuarioAutenticarModel) {
        return usuarioService.autenticarUsuario(usuarioAutenticarModel);
    }

}
