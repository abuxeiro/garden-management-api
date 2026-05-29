package garden_management_api.weather;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import garden_management_api.weather.dto.WeatherResponseDTO;
import garden_management_api.entity.WeatherRecord;
import garden_management_api.repository.WeatherRecordRepository;

import java.time.LocalDateTime;


@Service
public class WeatherService {
	
	private final WeatherRecordRepository weatherRecordRepository;
	
	public WeatherService(
	        WeatherRecordRepository weatherRecordRepository) {

	    this.weatherRecordRepository = weatherRecordRepository;
	}
	
	public WeatherResponseDTO getWeather() {

	    String url = "https://api.open-meteo.com/v1/forecast"
	            + "?latitude=42.59548309609141"
	            + "&longitude=-8.953329938730201"
	            + "&current=temperature_2m,relative_humidity_2m";

	    RestTemplate restTemplate = new RestTemplate();

	    WeatherResponseDTO response =
	            restTemplate.getForObject(url, WeatherResponseDTO.class);
	    
	    System.out.println(response);
	    System.out.println(response.getCurrent());
	    System.out.println(
	            response.getCurrent().getTemperature_2m()
	    );

	    WeatherRecord record = new WeatherRecord();

	    record.setTemperature(
	            response.getCurrent().getTemperature_2m());

	    record.setLatitude(42.59548309609141);

	    record.setLongitude(-8.953329938730201);

	    record.setCreatedAt(LocalDateTime.now());

	    WeatherRecord savedRecord = weatherRecordRepository.save(record);
	    
	    System.out.println(savedRecord.getId());

	    return response;
	}
}

