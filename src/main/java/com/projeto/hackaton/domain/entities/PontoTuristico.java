package com.projeto.hackaton.domain.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity(name = "pontos_turistico")
public class PontoTuristico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidadeId;
    @OneToOne
    @JoinColumn(name = "tipo_ponto_turistico_id")
    private TipoPontoTuristico tiposPontosTuristicosId;
    @Column(name = "cordenada_x")
    private BigDecimal coordenadaX;
    @Column(name = "cordenada_y")
    private BigDecimal coordenadaY;
    @Column(name = "imagem_url")
    private String imagemUrl;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PontoTuristico that = (PontoTuristico) o;
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

    public Cidade getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(Cidade cidadeId) {
        this.cidadeId = cidadeId;
    }

    public TipoPontoTuristico getTiposPontosTuristicosId() {
        return tiposPontosTuristicosId;
    }

    public void setTiposPontosTuristicosId(TipoPontoTuristico tiposPontosTuristicosId) {
        this.tiposPontosTuristicosId = tiposPontosTuristicosId;
    }

    public BigDecimal getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(BigDecimal coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public BigDecimal getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(BigDecimal coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }
}
