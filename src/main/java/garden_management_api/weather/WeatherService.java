package garden_management_api.weather;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import garden_management_api.weather.dto.WeatherResponseDTO;

@Service
public class WeatherService {

    public WeatherResponseDTO  getWeather() {

        String url = "https://api.open-meteo.com/v1/forecast"
                + "?latitude=42.59548309609141"
                + "&longitude=-8.953329938730201"
                + "&current=temperature_2m,relative_humidity_2m";

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(url, WeatherResponseDTO.class);
    }
}

