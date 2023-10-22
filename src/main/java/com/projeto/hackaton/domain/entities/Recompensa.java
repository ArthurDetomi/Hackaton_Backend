package com.projeto.hackaton.domain.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "recompensas")
public class Recompensa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "descricao")
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "estabelecimento_id")
    private Estabelecimento estabelecimentoId;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recompensa that = (Recompensa) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Estabelecimento getEstabelecimentoId() {
        return estabelecimentoId;
    }

    public void setEstabelecimentoId(Estabelecimento estabelecimentoId) {
        this.estabelecimentoId = estabelecimentoId;
    }
}
