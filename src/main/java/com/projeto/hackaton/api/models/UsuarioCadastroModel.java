package com.projeto.hackaton.api.models;

import com.projeto.hackaton.domain.entities.Usuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UsuarioCadastroModel {
    @NotBlank
    @Size(min = 8, max = 128)
    private String usuario;
    @NotBlank
    @Size(min = 8,max = 32)
    private String senha;
    @NotBlank
    @Size(min = 5,max = 320)
    @Email
    private String email;

    public Usuario converter() {
        Usuario usuario = new Usuario();
        usuario.setEmail(this.email);
        usuario.setNomeUsuario(this.usuario);
        usuario.setSenha(this.senha);
        return usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
