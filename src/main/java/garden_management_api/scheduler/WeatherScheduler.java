package garden_management_api.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import garden_management_api.weather.WeatherService;

@Component
public class WeatherScheduler {

    private static final Logger logger = LoggerFactory.getLogger(WeatherScheduler.class);

    private final WeatherService weatherService;

    public WeatherScheduler(
            WeatherService weatherService) {

        this.weatherService = weatherService;
    }

    @Scheduled(fixedRateString = "${weather.scheduler.fixed-rate-ms}")
    public void collectWeatherData() {

        try {

            logger.info("Collecting weather data...");

            weatherService.getWeather();

            logger.info("Weather data saved successfully");

        } catch (Exception e) {

            logger.error("Failed to collect weather data", e);
        }
    }
}
