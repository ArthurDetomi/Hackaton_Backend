package com.projeto.hackaton.domain.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "cidades_visitadas")
public class CidadeVisitadas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuarioId;
    @ManyToOne
    @JoinColumn(name = "id_cidade")
    private Cidade cidadeId;

    public CidadeVisitadas() {

    }

    public CidadeVisitadas(Usuario usuarioLogado, Cidade cidade) {
        this.usuarioId = usuarioLogado;
        this.cidadeId = cidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CidadeVisitadas that = (CidadeVisitadas) o;
        return Objects.equals(usuarioId, that.usuarioId) && Objects.equals(cidadeId, that.cidadeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioId, cidadeId);
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Cidade getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(Cidade cidadeId) {
        this.cidadeId = cidadeId;
    }
}
