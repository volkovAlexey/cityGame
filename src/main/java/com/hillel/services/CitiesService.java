package com.hillel.services;

import com.hillel.models.City;

import java.sql.SQLException;
import java.util.List;

public interface CitiesService {
    List<City> getCities() throws SQLException;

    City getCityByChar(char ch) throws SQLException;

    void addCity(City city) throws SQLException;

    City getRandomCity();
}