package com.example.smartmanufactoring.dto;

import com.example.smartmanufactoring.CustomValidator.ValueOfEnum;
import com.example.smartmanufactoring.persistence.entity.FactoryStatus;
import com.example.smartmanufactoring.persistence.entity.Location;
import com.example.smartmanufactoring.service.OnUpdate;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class FactoryDTO {

    @NotNull(groups = OnUpdate.class, message = "Factory id is missing")
    private Long id;

    @NotEmpty(message = "name missing")
    private String name;

    @NotEmpty(message = "description missing")
    private String description;

    @NotNull(message = "latitude missing")
    private double latitude;

    @NotNull(message = "longitude missing")
    private double longitude;

    @ValueOfEnum(enumClass = FactoryStatus.class, message = "status missing")
    private String status;

    @NotNull(message = "Location id missing")
    private Long locationId;
}


