package com.projeto.hackaton.api.models;

import com.projeto.hackaton.domain.entities.Recompensa;

public class RecompensaModel {

    private String nome;
    private String descricao;

    public RecompensaModel(Recompensa recompensa) {
        this.nome = recompensa.getNome();
        this.descricao = recompensa.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
