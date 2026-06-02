package garden_management_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;

import garden_management_api.dto.CropDTO;
import garden_management_api.service.CropService;

@RestController
public class CropController {

    private final CropService cropService;

    public CropController(CropService cropService) {
        this.cropService = cropService;
    }

    @GetMapping("/crops")
    public List<CropDTO> getAllCrops() {
        return cropService.getAllCrops();
    }
    
    @PostMapping("/crops")
    public CropDTO createCrop(@Valid @RequestBody CropDTO cropDTO) {
        return cropService.createCrop(cropDTO);
    }
}
