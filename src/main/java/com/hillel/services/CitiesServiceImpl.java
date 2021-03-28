package com.hillel.services;

import com.hillel.models.City;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class CitiesServiceImpl implements CitiesService {

    JdbcTemplate jdbcTemplate;

    public CitiesServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<City> getCities() {
        return jdbcTemplate.queryForList("SELECT * FROM cities", City.class);
    }

    @Override
    public void addCity(City city) {
        String id = city.getId();
        String name = city.getName();
        String insert = "INSERT INTO cities (id, name) VALUES ('" + id + "', '" + name + "');";
        jdbcTemplate.update(insert);
    }

    @Override
    public City getRandomCity() {
        return jdbcTemplate.queryForObject("SELECT * FROM cities ORDER BY random() LIMIT 1", City.class);
    }

    @Override
    public City getCityByChar(char ch) throws SQLException {
        String regex = ch + "%'";
        City city = jdbcTemplate.queryForObject("SELECT * FROM cities WHERE name LIKE '" + regex, City.class);
        return city;
    }
}