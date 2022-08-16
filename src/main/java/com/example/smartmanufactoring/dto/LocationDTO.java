package com.example.smartmanufactoring.dto;

import com.example.smartmanufactoring.CustomValidator.ValueOfEnum;
import com.example.smartmanufactoring.persistence.entity.LocationStatus;
import com.example.smartmanufactoring.service.OnUpdate;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
public class LocationDTO {

    @NotNull(groups = OnUpdate.class, message = "Location id is missing")
    private Long id;

    @NotEmpty(message = "country name missing")
    private String country;

    @NotEmpty(message = "city name missing")
    private String city;

    @NotEmpty(message = "Street name missing")
    private String street;

    @ValueOfEnum(enumClass = LocationStatus.class, message = "status missing")
    private String status;

    private String zipCode;
}
