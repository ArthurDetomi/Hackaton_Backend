package com.projeto.hackaton.domain.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity(name = "achievements")
public class Achievement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_de_inicio")
    private Date dataInicio;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_de_fim")
    private Date dataFim;
    @Column(name = "nome")
    private String nome;
    @Column(name = "descricao")
    private String descricao;
    @OneToOne
    @JoinColumn(name = "recompensa_id")
    private Recompensa recompensaId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Achievement that = (Achievement) o;
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

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
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

    public Recompensa getRecompensaId() {
        return recompensaId;
    }

    public void setRecompensaId(Recompensa recompensaId) {
        this.recompensaId = recompensaId;
    }
}
