package com.example.smartmanufactoring.rest;


import com.example.smartmanufactoring.CustomValidator.ValueOfEnum;
import com.example.smartmanufactoring.dto.FactoryDTO;
import com.example.smartmanufactoring.dto.FactoryMapper;
import com.example.smartmanufactoring.dto.LocationDTO;
import com.example.smartmanufactoring.dto.LocationMapper;
import com.example.smartmanufactoring.persistence.entity.FactoryStatus;
import com.example.smartmanufactoring.persistence.entity.LocationStatus;
import com.example.smartmanufactoring.service.FactoryService;
import com.example.smartmanufactoring.service.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/smart-manufacturing/")
public class SmartManufacturingController {


    private final FactoryService factoryService;
    private final LocationService locationService;
    private final FactoryMapper factoryMapper;
    private final LocationMapper locationMapper;


    @PostMapping("/factories/")
    public ResponseEntity<?> createFactory(@Valid @RequestBody FactoryDTO factoryDTO) {
        factoryService.createFactory(factoryMapper.fromDto(factoryDTO), factoryDTO.getLocationId());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/factories/{factoryId}")
    public ResponseEntity<?> updateFactory(@Valid @RequestBody FactoryDTO factoryDTO,
                                           @PathVariable Long factoryId) {
        factoryService.updateFactory(factoryId, factoryDTO);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/factories/{factoryId}")
    public ResponseEntity<?> changeFactoryStatus(@ValueOfEnum(enumClass = FactoryStatus.class, message = "Factory status missing or not correct") FactoryStatus status,
                                                 @PathVariable Long factoryId) {
        factoryService.changeFactoryStatus(factoryId, status);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/factories/")
    public ResponseEntity<List<FactoryDTO>> getFactoriesBy(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String country,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String street,
            @RequestParam(required = false) String zipCode,
            @RequestParam(required = false) String status
    ) {
        List<FactoryDTO> productDtoList = factoryService.getFactoriesBy(name, country, city, street, zipCode, status)
                .stream().map(factoryMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(productDtoList);
    }


    @PostMapping("/locations/")
    public ResponseEntity<?> createLocation(@Valid @RequestBody LocationDTO locationDTO) {
        locationService.createLocation(locationMapper.fromDto(locationDTO));
        return ResponseEntity.ok().build();
    }

    @PutMapping("/locations/{locationId}")
    public ResponseEntity<?> updateLocation(@Valid @RequestBody LocationDTO locationDTO,
                                            @PathVariable Long locationId) {
        locationService.updateLocation(locationId, locationDTO);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/locations/{locationId}")
    public ResponseEntity<?> changeLocationStatus(@ValueOfEnum(enumClass = LocationStatus.class, message = "Location status missing or not correct") LocationStatus status,
                                                  @PathVariable Long locationId) {
        locationService.changeLocationStatus(locationId, status);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/locations/")
    public ResponseEntity<List<LocationDTO>> getLocationsBy(
            @RequestParam(required = false) String country,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String street,
            @RequestParam(required = false) String zipCode
    ) {
        List<LocationDTO> locationDTOList = locationService.getLocationsBy(country, city, street, zipCode)
                .stream().map(locationMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(locationDTOList);
    }


}
