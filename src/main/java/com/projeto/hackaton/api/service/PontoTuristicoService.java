package com.projeto.hackaton.api.service;

import com.projeto.hackaton.api.handler.NotFoundException;
import com.projeto.hackaton.api.handler.UnauthorizedException;
import com.projeto.hackaton.api.models.PontoTuristicoModel;
import com.projeto.hackaton.domain.entities.Cidade;
import com.projeto.hackaton.domain.entities.PontoTuristico;
import com.projeto.hackaton.domain.entities.PontoTuristicoVisitado;
import com.projeto.hackaton.domain.entities.Usuario;
import com.projeto.hackaton.domain.repositories.CidadeRepository;
import com.projeto.hackaton.domain.repositories.PontoTuristicoRepository;
import com.projeto.hackaton.domain.repositories.PontoTuristicoVisitadoRepository;
import com.projeto.hackaton.domain.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PontoTuristicoService {

    @Autowired
    private PontoTuristicoRepository pontoTuristicoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PontoTuristicoVisitadoRepository pontoTuristicoVisitadoRepository;

    public List<PontoTuristicoModel> getAllPontosTuristicos() {
        return pontoTuristicoRepository.findAll().stream().map(PontoTuristicoModel::new).collect(Collectors.toList());
    }

    public List<PontoTuristicoModel> getPontosTuristicosPorCidade(Integer cidadeId) {
        Cidade cidade = cidadeRepository.findById(cidadeId).orElseThrow(NotFoundException::new);
        return pontoTuristicoRepository.findAllByCidadeId(cidade).stream().map(PontoTuristicoModel::new).collect(Collectors.toList());
    }

    public void registrarPontoVisitado(String token, Integer pontoTuristicoId) {
        Usuario usuario = usuarioRepository.findByToken(token).orElseThrow(UnauthorizedException::new);
        PontoTuristico pontoTuristico = pontoTuristicoRepository.findById(pontoTuristicoId)
                .orElseThrow(NotFoundException::new);
        PontoTuristicoVisitado pontoTuristicoVisitado = new PontoTuristicoVisitado(usuario, pontoTuristico);
        pontoTuristicoVisitadoRepository.save(pontoTuristicoVisitado);
    }

}
