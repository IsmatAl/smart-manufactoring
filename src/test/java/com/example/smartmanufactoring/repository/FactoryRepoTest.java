package com.example.smartmanufactoring.repository;

import com.example.smartmanufactoring.persistence.repo.FactoryRepo;
import com.example.smartmanufactoring.persistence.repo.FactorySpecs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FactoryRepoTest {

    @Autowired
    private FactoryRepo repository;




    @Test
    public void should_find_in_city_with_status() {

        var factories = repository.findAll(Specification
                .where(FactorySpecs.hasCity("Tallinn"))
                .and(FactorySpecs.hasStatus("OPERATIVE"))
        );

        assertThat(factories).hasSize(1);
    }

    @Test
    public void should_find_in_with_status() {

        var factories = repository.findAll(Specification
                .where(FactorySpecs.hasCountry("Estonia"))
                .and(FactorySpecs.hasStatus("OPERATIVE")));

        assertThat(factories).hasSize(1);
    }
}
