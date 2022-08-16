package com.example.smartmanufactoring.service;

import com.example.smartmanufactoring.dto.FactoryDTO;
import com.example.smartmanufactoring.dto.FactoryMapper;

import static com.example.smartmanufactoring.exception.CustomExceptionMessage.*;

import com.example.smartmanufactoring.persistence.entity.Factory;
import com.example.smartmanufactoring.persistence.entity.FactoryStatus;
import com.example.smartmanufactoring.persistence.entity.Location;
import com.example.smartmanufactoring.persistence.entity.LocationStatus;
import com.example.smartmanufactoring.persistence.repo.FactoryRepo;
import com.example.smartmanufactoring.persistence.repo.FactorySpecs;
import com.example.smartmanufactoring.persistence.repo.LocationRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@Service
@AllArgsConstructor
public class FactoryService {

    private final FactoryRepo factoryRepo;
    private final LocationRepo locationRepo;
    private final FactoryMapper factoryMapper;


    public void createFactory(Factory factory, Long locationId) {
        Location location = locationRepo.findById(locationId)
                .orElseThrow(() -> new EntityNotFoundException(String.format(LOCATION_NOT_FOUND_ERROR_MSG, locationId)));

        if (location.getStatus().equals(LocationStatus.NOT_ACTIVE))
            throw new IllegalStateException(String.format(LOCATION_STATUS_NOT_ACTIVE_MSG, location.getId()));

        factoryRepo.save(factory);
    }

    public Factory getFactory(Long factoryId) {
        return factoryRepo.findById(factoryId)
                .orElseThrow(() -> new EntityNotFoundException(String.format(FACTORY_NOT_FOUND_ERROR_MSG, factoryId)));
    }

    public void updateFactory(Long factoryId, FactoryDTO factoryDTO) {
        Factory factory = getFactory(factoryId);
        factoryMapper.merge(factoryDTO, factory);
        factoryRepo.save(factory);
    }


    public void changeFactoryStatus(long factoryId, FactoryStatus status) {
        Factory factory = getFactory(factoryId);
        factory.setStatus(status);
        factoryRepo.save(factory);
    }


    public List<Factory> getFactoriesBy(String name,
                                        String country,
                                        String city,
                                        String street,
                                        String zipCode,
                                        String status) {
        return factoryRepo.findAll(Specification.where(
                        name == null ? null : FactorySpecs.hasName(name))
                .and(country == null ? null : FactorySpecs.hasCountry(country))
                .and(city == null ? null : FactorySpecs.hasCity(city))
                .and(street == null ? null : FactorySpecs.hasStreet(street))
                .and(zipCode == null ? null : FactorySpecs.hasZipCode(zipCode))
                .and(status == null ? null : FactorySpecs.hasStatus(status))
        );
    }
}
