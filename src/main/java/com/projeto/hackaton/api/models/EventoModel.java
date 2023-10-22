package com.projeto.hackaton.api.models;

import com.projeto.hackaton.api.utils.StringUtil;
import com.projeto.hackaton.domain.entities.Evento;

import java.time.LocalDateTime;
import java.util.Date;

public class EventoModel {

    private Integer id;
    private String name;
    private String imageUrl;
    private Date dateStart;
    private Date dateEnd;

    public EventoModel(Evento evento) {
        this.id = evento.getId();
        this.dateStart = evento.getDataInicio();
        this.dateEnd = evento.getDataFim();
        this.name = evento.getNome();
        this.imageUrl = evento.getImagemUrl();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }
}
