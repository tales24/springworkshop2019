package de.inmediasp.springws.zoo.animals;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    List<Animal> findAll();
}
