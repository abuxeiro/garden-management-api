package garden_management_api.repository;

import garden_management_api.entity.WeatherRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRecordRepository
        extends JpaRepository<WeatherRecord, Long> {
}