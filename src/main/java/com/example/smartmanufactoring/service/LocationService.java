package com.example.smartmanufactoring.service;

import com.example.smartmanufactoring.dto.LocationDTO;
import com.example.smartmanufactoring.dto.LocationMapper;
import com.example.smartmanufactoring.persistence.entity.Location;
import com.example.smartmanufactoring.persistence.entity.LocationStatus;
import com.example.smartmanufactoring.persistence.repo.LocationRepo;
import com.example.smartmanufactoring.persistence.repo.LocationSpecs;
import static com.example.smartmanufactoring.exception.CustomExceptionMessage.*;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class LocationService {

    private final LocationRepo locationRepo;
    private final LocationMapper locationMapper;

    public void createLocation(Location location) {
        locationRepo.save(location);
    }

    public void updateLocation(Long locationId, LocationDTO locationDTO) {
        Location location = locationRepo.findById(locationId)
                .orElseThrow(() -> new EntityNotFoundException(String.format(LOCATION_NOT_FOUND_ERROR_MSG, locationId)));

        locationMapper.merge(locationDTO, location);
        locationRepo.save(location);
    }

    public void changeLocationStatus(Long locationId, LocationStatus status) {
        Location location = locationRepo.findById(locationId)
                .orElseThrow(() -> new EntityNotFoundException(String.format(LOCATION_NOT_FOUND_ERROR_MSG, locationId)));
        location.setStatus(status);
        locationRepo.save(location);
    }

    public List<Location> getLocationsBy(String country,
                                            String city,
                                            String street,
                                            String zipCode) {
        return locationRepo.findAll(
                Specification.where(country == null ? null : LocationSpecs.hasCountry(country))
                        .and(city == null ? null : LocationSpecs.hasCity(city))
                        .and(street == null ? null : LocationSpecs.hasStreet(street))
                        .and(zipCode == null ? null : LocationSpecs.hasZipCode(zipCode))
        );
    }
}
