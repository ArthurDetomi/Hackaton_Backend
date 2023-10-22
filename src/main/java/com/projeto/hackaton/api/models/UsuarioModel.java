package com.projeto.hackaton.api.models;

import com.projeto.hackaton.domain.entities.Usuario;

public class UsuarioModel {

    private String login;

    public UsuarioModel(Usuario usuario) {
        this.login = usuario.getNomeUsuario();
    }
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
