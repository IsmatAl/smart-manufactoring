package com.example.smartmanufactoring.persistence.repo;

import com.example.smartmanufactoring.persistence.entity.Location;
import com.example.smartmanufactoring.persistence.entity.Location_;
import org.springframework.data.jpa.domain.Specification;

public class LocationSpecs {
    public static Specification<Location> hasCountry (String name) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get(Location_.country), name);
    }

    public static Specification<Location> hasCity (String name) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get(Location_.city), name);
    }

    public static Specification<Location> hasStreet (String name) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get(Location_.street), name);
    }

    public static Specification<Location> hasZipCode (String name) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get(Location_.zipCode), name);
    }
}
