package com.projeto.hackaton.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.projeto.hackaton.domain.entities.Cidade;

public class CidadeModel {

    private Integer id;
    @JsonProperty("name")
    private String text;
    @JsonProperty("coords")
    private CoordenadaModel coordenadaModel;

    public CidadeModel(Cidade cidade) {
        this.id = cidade.getId();
        this.text = cidade.getNome();
        this.coordenadaModel = new CoordenadaModel(cidade);
    }

    public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }
}
