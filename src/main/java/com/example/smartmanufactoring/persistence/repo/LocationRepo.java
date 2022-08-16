package com.example.smartmanufactoring.persistence.repo;

import com.example.smartmanufactoring.persistence.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepo extends JpaRepository<Location, Long>, JpaSpecificationExecutor<Location> {
}
