package com.projeto.hackaton.api.service;

import com.projeto.hackaton.api.models.CidadeModel;
import com.projeto.hackaton.domain.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public List<CidadeModel> getCidadesNomeEId() {
        return cidadeRepository.procurarNomeTodasCidades().stream().map(CidadeModel::new).collect(Collectors.toList());
    }

}
