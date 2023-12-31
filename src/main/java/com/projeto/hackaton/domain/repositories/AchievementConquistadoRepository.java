package com.projeto.hackaton.domain.repositories;

import com.projeto.hackaton.domain.entities.Achievement;
import com.projeto.hackaton.domain.entities.AchievementConquistado;
import com.projeto.hackaton.domain.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AchievementConquistadoRepository extends JpaRepository<AchievementConquistado, Integer> {
    List<AchievementConquistado> findAllByUsuarioId(Usuario usuario);

    Optional<AchievementConquistado> findByUsuarioIdAndAchievementId(Usuario usuario, Achievement achievement);
}
