package com.projeto.hackaton.domain.repositories;

import com.projeto.hackaton.domain.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByToken(String token);

    Optional<Usuario> findByNomeUsuario(String nomeUsuario);

    Optional<Usuario> findByEmail(String email);

    Optional<Usuario> findByNomeUsuarioAndSenha(String usuario, String usuario1);
}
