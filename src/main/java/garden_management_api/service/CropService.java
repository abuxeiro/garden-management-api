package garden_management_api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import garden_management_api.entity.Crop;
import garden_management_api.repository.CropRepository;
import garden_management_api.dto.CropDTO;

@Service
public class CropService {

    @Autowired
    private CropRepository cropRepository;

    public List<CropDTO> getAllCrops() {

        return cropRepository.findAll()
                .stream()
                .map(crop -> new CropDTO(
                        crop.getId(),
                        crop.getName(),
                        crop.getVariety(),
                        crop.getArea()))
                .collect(Collectors.toList());
    }

    public CropDTO createCrop(CropDTO cropDTO) {

        Crop crop = new Crop();

        crop.setName(cropDTO.getName());
        crop.setVariety(cropDTO.getVariety());
        crop.setArea(cropDTO.getArea());

        Crop savedCrop = cropRepository.save(crop);

        return new CropDTO(
                savedCrop.getId(),
                savedCrop.getName(),
                savedCrop.getVariety(),
                savedCrop.getArea());
    }
}