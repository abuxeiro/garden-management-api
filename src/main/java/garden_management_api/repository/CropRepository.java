package garden_management_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import garden_management_api.entity.Crop;

public interface CropRepository extends JpaRepository<Crop, Long> {

}