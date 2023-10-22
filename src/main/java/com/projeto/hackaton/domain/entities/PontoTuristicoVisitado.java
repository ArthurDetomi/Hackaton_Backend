package com.projeto.hackaton.domain.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "pontos_turisticos_visitados")
public class PontoTuristicoVisitado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuarioId;
    @ManyToOne
    @JoinColumn(name = "id_ponto_turistico")
    private PontoTuristico pontoTuristicoId;

    public PontoTuristicoVisitado() {

    }

    public PontoTuristicoVisitado(Usuario usuario, PontoTuristico pontoTuristico) {
        this.pontoTuristicoId = pontoTuristico;
        this.usuarioId = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PontoTuristicoVisitado that = (PontoTuristicoVisitado) o;
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

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public PontoTuristico getPontoTuristicoId() {
        return pontoTuristicoId;
    }

    public void setPontoTuristicoId(PontoTuristico pontoTuristicoId) {
        this.pontoTuristicoId = pontoTuristicoId;
    }
}
