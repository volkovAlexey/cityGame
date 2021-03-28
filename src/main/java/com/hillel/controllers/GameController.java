package com.hillel.controllers;

import com.hillel.models.City;
import com.hillel.services.CitiesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/new-game")
public class GameController {

    CitiesService citiesService;

    public GameController(CitiesService citiesService) {
        this.citiesService = citiesService;
    }

    @GetMapping("/new-game")
    public String startGame(Model model) {
        UUID idGame = UUID.randomUUID();
        City randomCity = citiesService.getRandomCity();

        model.addAttribute("idGame", idGame);
        model.addAttribute("randomCity", randomCity);
        return "gamePage";
    }
}
