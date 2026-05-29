package garden_management_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import garden_management_api.weather.WeatherService;
import garden_management_api.weather.dto.WeatherResponseDTO;

@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather")
    public WeatherResponseDTO getWeather() {
        return weatherService.getWeather();
    }
}