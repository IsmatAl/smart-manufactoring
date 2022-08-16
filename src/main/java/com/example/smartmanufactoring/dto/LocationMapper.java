package com.example.smartmanufactoring.dto;

import com.example.smartmanufactoring.persistence.entity.Location;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface LocationMapper {

    Location fromDto(LocationDTO dto);

    @InheritInverseConfiguration(name = "fromDto")
    LocationDTO toDto(Location entity);

    Location merge(LocationDTO dto, @MappingTarget Location entity);
}
