package com.example.smartmanufactoring.persistence.repo;

import com.example.smartmanufactoring.persistence.entity.*;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;

public class FactorySpecs {
    public static Specification<Factory> hasName(String name) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get(Factory_.name), name);
    }

    public static Specification<Factory> hasStatus(String status) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get(Factory_.status), FactoryStatus.valueOf(status));
    }

    public static Specification<Factory> hasCountry(String name) {
        return (root, query, criteriaBuilder) -> {
            Join<Factory, Location> factoryLocation = root.join("location");
            return criteriaBuilder.equal(factoryLocation.get(Location_.country), name);
        };
    }

    public static Specification<Factory> hasCity(String name) {
        return (root, query, criteriaBuilder) -> {
            Join<Factory, Location> factoryLocation = root.join("location");
            return criteriaBuilder.equal(factoryLocation.get(Location_.city), name);
        };
    }

    public static Specification<Factory> hasStreet(String name) {
        return (root, query, criteriaBuilder) -> {
            Join<Factory, Location> factoryLocation = root.join("location");
            return criteriaBuilder.equal(factoryLocation.get(Location_.street), name);
        };
    }

    public static Specification<Factory> hasZipCode(String name) {
        return (root, query, criteriaBuilder) -> {
            Join<Factory, Location> factoryLocation = root.join("location");
            return criteriaBuilder.equal(factoryLocation.get(Location_.zipCode), name);
        };
    }
}
