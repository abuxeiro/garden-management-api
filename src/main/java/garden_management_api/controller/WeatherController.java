package garden_management_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import garden_management_api.weather.WeatherService;
import garden_management_api.weather.dto.WeatherResponseDTO;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public WeatherResponseDTO getWeather() {
        return weatherService.getWeather();
    }
}
