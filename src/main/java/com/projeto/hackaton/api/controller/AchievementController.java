package com.projeto.hackaton.api.controller;

import com.projeto.hackaton.api.models.AchievementModel;
import com.projeto.hackaton.api.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conquista")
@CrossOrigin(origins = "*")
public class AchievementController {

    @Autowired
    private AchievementService achievementService;

    @GetMapping("/todos")
    public List<AchievementModel> getAllAchievementes(@RequestHeader("token") String token) {
        return achievementService.getTodosAchievementes(token);
    }




}
