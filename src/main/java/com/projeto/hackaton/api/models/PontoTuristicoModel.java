package com.projeto.hackaton.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.projeto.hackaton.domain.entities.PontoTuristico;

import java.util.Date;

public class PontoTuristicoModel {

    private Integer id;
    private String city;
    private String name;
    @JsonProperty("coords")
    private CoordenadaModel coordenadaModel;
    @JsonProperty("imageUrl")
    private String image;
    private String type;

    public PontoTuristicoModel(PontoTuristico pontoTuristico) {
        this.id = pontoTuristico.getId();
        this.city = pontoTuristico.getCidadeId().getNome();
        this.name = pontoTuristico.getNome();
        this.image = pontoTuristico.getImagemUrl();
        this.coordenadaModel = new CoordenadaModel(pontoTuristico);
        this.type = pontoTuristico.getTiposPontosTuristicosId().getNome();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CoordenadaModel getCoordenadaModel() {
        return coordenadaModel;
    }

    public void setCoordenadaModel(CoordenadaModel coordenadaModel) {
        this.coordenadaModel = coordenadaModel;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
