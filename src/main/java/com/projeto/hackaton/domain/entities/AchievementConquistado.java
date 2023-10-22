package com.projeto.hackaton.domain.entities;

import jdk.jfr.Timestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
@Entity(name = "achievements_conquistados")
public class AchievementConquistado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_achievement")
    private Achievement achievementId;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuarioId;
    @Column(name = "data_de_expiracao")
    private Date dataExpiracao;
    @Column(name = "consumido")
    private boolean consumido;
    public  AchievementConquistado() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AchievementConquistado that = (AchievementConquistado) o;
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

    public Achievement getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(Achievement achievementId) {
        this.achievementId = achievementId;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Date getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(Date dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

    public boolean isConsumido() {
        return consumido;
    }

    public void setConsumido(boolean consumido) {
        this.consumido = consumido;
    }

}
