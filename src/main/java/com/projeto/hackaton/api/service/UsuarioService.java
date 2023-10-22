package com.projeto.hackaton.api.service;

import com.projeto.hackaton.api.handler.NotFoundException;
import com.projeto.hackaton.api.handler.UnauthorizedException;
import com.projeto.hackaton.api.models.UsuarioModel;
import com.projeto.hackaton.domain.entities.Cidade;
import com.projeto.hackaton.domain.entities.CidadeVisitadas;
import com.projeto.hackaton.domain.entities.Usuario;
import com.projeto.hackaton.domain.repositories.CidadeRepository;
import com.projeto.hackaton.domain.repositories.CidadeVisitadaRepository;
import com.projeto.hackaton.domain.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private CidadeVisitadaRepository cidadeVisitadaRepository;

    public ResponseEntity<?> cadastrarVisitaCidade(String token, Integer cidadeId) {
        Usuario usuarioLogado = usuarioRepository.findByToken(token).orElseThrow(UnauthorizedException::new);
        Cidade cidade = cidadeRepository.findById(cidadeId).orElseThrow(NotFoundException::new);
        if (cidadeVisitadaRepository.findByUsuarioIdAndCidadeId(usuarioLogado, cidade).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        CidadeVisitadas cidadeVisitadas = new CidadeVisitadas(usuarioLogado, cidade);
        cidadeVisitadaRepository.save(cidadeVisitadas);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public UsuarioModel getNomeUsuario(String token) {
        Usuario usuarioLogado = usuarioRepository.findByToken(token).orElseThrow(UnauthorizedException::new);
        return new UsuarioModel(usuarioLogado);
    }
}
