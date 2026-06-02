package garden_management_api.weather;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import garden_management_api.weather.dto.WeatherResponseDTO;
import garden_management_api.entity.WeatherRecord;
import garden_management_api.repository.WeatherRecordRepository;

import java.time.LocalDateTime;


@Service
public class WeatherService {

    private static final Logger logger = LoggerFactory.getLogger(WeatherService.class);
	
	private final WeatherRecordRepository weatherRecordRepository;
	private final String weatherApiUrl;
	private final Double latitude;
	private final Double longitude;
	private final String currentWeatherFields;
	
	public WeatherService(
	        WeatherRecordRepository weatherRecordRepository,
	        @Value("${weather.api.url}") String weatherApiUrl,
	        @Value("${weather.api.latitude}") Double latitude,
	        @Value("${weather.api.longitude}") Double longitude,
	        @Value("${weather.api.current-fields}") String currentWeatherFields) {

	    this.weatherRecordRepository = weatherRecordRepository;
	    this.weatherApiUrl = weatherApiUrl;
	    this.latitude = latitude;
	    this.longitude = longitude;
	    this.currentWeatherFields = currentWeatherFields;
	}
	
	public WeatherResponseDTO getWeather() {

	    String url = weatherApiUrl
	            + "?latitude=" + latitude
	            + "&longitude=" + longitude
	            + "&current=" + currentWeatherFields;

	    RestTemplate restTemplate = new RestTemplate();

	    WeatherResponseDTO response =
	            restTemplate.getForObject(url, WeatherResponseDTO.class);

	    logger.info(
	            "Weather data collected: temperature={} latitude={} longitude={}",
	            response.getCurrent().getTemperature_2m(),
	            latitude,
	            longitude
	    );

	    WeatherRecord record = new WeatherRecord();

	    record.setTemperature(
	            response.getCurrent().getTemperature_2m());

	    record.setLatitude(latitude);

	    record.setLongitude(longitude);

	    record.setCreatedAt(LocalDateTime.now());

	    WeatherRecord savedRecord = weatherRecordRepository.save(record);

	    logger.info("Weather record saved with id={}", savedRecord.getId());

	    return response;
	}
}

