package com.projeto.hackaton.api.controller;

import com.projeto.hackaton.api.models.AchievementModel;
import com.projeto.hackaton.api.models.RecompensaModel;
import com.projeto.hackaton.api.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conquista")
@CrossOrigin(origins = "*")
public class AchievementController {

    @Autowired
    private AchievementService achievementService;

    @GetMapping("/todos")
    public List<AchievementModel> getAllAchievementes(@RequestHeader(value = "token", required = false) String token) {
        return achievementService.getTodosAchievementes(token);
    }

    @GetMapping(value = "/consumir/{id}")
    public String getConsumido(@RequestParam("token") String token,
                             @PathVariable("id") Integer achievementId) {
        return achievementService.consumirAchievement(achievementId, token);
    }



}
