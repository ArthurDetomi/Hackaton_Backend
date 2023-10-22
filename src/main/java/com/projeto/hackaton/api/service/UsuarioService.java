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
import org.springframework.stereotype.Component;

@Component
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private CidadeVisitadaRepository cidadeVisitadaRepository;

    public void cadastrarVisitaCidade(String token, Integer cidadeId) {
        Usuario usuarioLogado = usuarioRepository.findByToken(token).orElseThrow(UnauthorizedException::new);
        Cidade cidade = cidadeRepository.findById(cidadeId).orElseThrow(NotFoundException::new);
        CidadeVisitadas cidadeVisitadas = new CidadeVisitadas(usuarioLogado, cidade);
        cidadeVisitadaRepository.save(cidadeVisitadas);
    }

    public UsuarioModel getNomeUsuario(String token) {
        Usuario usuarioLogado = usuarioRepository.findByToken(token).orElseThrow(UnauthorizedException::new);
        return new UsuarioModel(usuarioLogado);
    }
}
