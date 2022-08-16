package com.example.smartmanufactoring.persistence.repo;

import com.example.smartmanufactoring.persistence.entity.Factory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FactoryRepo extends JpaRepository<Factory, Long>, JpaSpecificationExecutor<Factory> {}
