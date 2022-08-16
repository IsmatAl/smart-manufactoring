package com.example.smartmanufactoring.dto;

import com.example.smartmanufactoring.persistence.entity.Factory;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;


@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface FactoryMapper {


    Factory fromDto(FactoryDTO dto);


    @InheritInverseConfiguration(name = "fromDto")
    FactoryDTO toDto(Factory entity);

    Factory merge(FactoryDTO dto, @MappingTarget Factory entity);
}
