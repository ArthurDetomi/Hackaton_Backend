package com.projeto.hackaton.api.service;

import com.projeto.hackaton.api.handler.UnauthorizedException;
import com.projeto.hackaton.api.models.AchievementModel;
import com.projeto.hackaton.api.models.RecompensaModel;
import com.projeto.hackaton.domain.entities.Achievement;
import com.projeto.hackaton.domain.entities.Recompensa;
import com.projeto.hackaton.domain.entities.Usuario;
import com.projeto.hackaton.domain.repositories.AchievementConquistadoRepository;
import com.projeto.hackaton.domain.repositories.AchievementRepository;
import com.projeto.hackaton.domain.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AchievementService {

    @Autowired
    private AchievementRepository achievementRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AchievementConquistadoRepository achievementConquistadoRepository;

    public List<AchievementModel> getTodosAchievementes(String token) {
        if (token != null && !token.isEmpty()) {
            return getTodosAchievementesCompletadosPorUsuario(token);
        }

        return achievementRepository.findAll().stream().map(AchievementModel::new).collect(Collectors.toList());
    }

    private List<AchievementModel> getTodosAchievementesCompletadosPorUsuario(String token) {
        Usuario usuarioLogado = usuarioRepository.findByToken(token).orElseThrow(UnauthorizedException::new);
        List<Achievement> achievementsConquistados = achievementConquistadoRepository
                .findAllByUsuarioId(usuarioLogado);

        Set<AchievementModel> achievementModelSet = achievementsConquistados.stream().map(
                achievement -> new AchievementModel(achievement, true)
        ).collect(Collectors.toSet());

        List<Achievement> achievementsList = achievementRepository.findAll();

        achievementsList.forEach(
                achievement -> {
                    AchievementModel achievementModel = new AchievementModel(achievement);
                    if (!achievementModelSet.contains(achievementModel)) {
                        achievementModelSet.add(achievementModel);
                    }
                }
        );

        return new ArrayList<>(achievementModelSet);
    }

    public List<RecompensaModel> getAllRecompensasPorUsuario(String token) {
        Usuario usuarioLogado = usuarioRepository.findByToken(token).orElseThrow(UnauthorizedException::new);
        List<Achievement> achievementsConquistados = achievementConquistadoRepository
                .findAllByUsuarioId(usuarioLogado);

        if (achievementsConquistados.isEmpty()) {
            return null;
        }

        List<Recompensa> recompensaList = achievementsConquistados.stream()
                .map(Achievement::getRecompensaId)
                .collect(Collectors.toList());


        return recompensaList.stream().map(RecompensaModel::new).collect(Collectors.toList());
    }
}
