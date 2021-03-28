package com.hillel.controllers;

import com.hillel.models.City;
import com.hillel.services.CitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller
public class CityController {

    @Autowired
    CitiesService citiesService;

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/city")
    public String getCities(@RequestParam(value = "cityName") String cityName, Model model) throws SQLException {
        char lastChar = cityName.charAt(cityName.length() - 1);
        City city = citiesService.getCityByChar(Character.toUpperCase(lastChar));
        model.addAttribute("city", city);
        return "index";
    }
}