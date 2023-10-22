package com.projeto.hackaton.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.projeto.hackaton.domain.entities.Cidade;
import com.projeto.hackaton.domain.entities.PontoTuristico;

import java.math.BigDecimal;

public class CoordenadaModel {
    @JsonProperty("lat")
    private BigDecimal coordenadaX;
    @JsonProperty("lon")
    private BigDecimal coordenadaY;

    public CoordenadaModel(PontoTuristico pontoTuristico) {
        this.coordenadaX = pontoTuristico.getCoordenadaX();
        this.coordenadaY = pontoTuristico.getCoordenadaY();
    }

    public CoordenadaModel(Cidade cidade) {
        this.coordenadaX = cidade.getLatitude();
        this.coordenadaY = cidade.getLongitude();
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
}
