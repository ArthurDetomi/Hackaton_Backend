package com.projeto.hackaton.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.projeto.hackaton.domain.entities.Achievement;

import java.util.Date;
import java.util.Objects;

public class AchievementModel {

    private Integer id;
    @JsonProperty("finishDate")
    private Date endDate;
    private String name;
    private String description;
    @JsonProperty("isComplete")
    private boolean completeAchievement;
    @JsonProperty("isConsumed")
    private boolean consumed;

    private RecompensaModel reward;

    public AchievementModel(Achievement achievement) {
        this.id = achievement.getId();
        this.endDate = achievement.getDataFim();
        this.name = achievement.getNome();
        this.description = achievement.getDescricao();
    }

    public AchievementModel(Achievement achievement, boolean conquistado, boolean consumido) {
        this(achievement);
        this.completeAchievement = conquistado;
        this.consumed = consumido;
        this.reward = new RecompensaModel(achievement.getRecompensaId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AchievementModel that = (AchievementModel) o;
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

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleteAchievement() {
        return completeAchievement;
    }

    public void setCompleteAchievement(boolean completeAchievement) {
        this.completeAchievement = completeAchievement;
    }

    public boolean isConsumed() {
        return consumed;
    }

    public void setConsumed(boolean consumed) {
        this.consumed = consumed;
    }

    public RecompensaModel getReward() {
        return reward;
    }

    public void setReward(RecompensaModel reward) {
        this.reward = reward;
    }
}
