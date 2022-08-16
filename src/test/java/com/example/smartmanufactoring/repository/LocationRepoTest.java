package com.example.smartmanufactoring.repository;

import com.example.smartmanufactoring.persistence.repo.LocationRepo;
import com.example.smartmanufactoring.persistence.repo.LocationSpecs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LocationRepoTest {

    @Autowired
    private LocationRepo repository;

    @Test
    public void should_find_in_city() {

        var locations = repository.findAll(Specification
                .where(LocationSpecs.hasCountry("Germany"))
                .and(LocationSpecs.hasCity("Berlin")));

        assertThat(locations).hasSize(1);
    }
}
