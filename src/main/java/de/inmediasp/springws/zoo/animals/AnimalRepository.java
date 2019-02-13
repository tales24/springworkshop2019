package de.inmediasp.springws.zoo.animals;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

@RepositoryRestResource
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    @Secured("ROLE_USER")
    List<Animal> getAllByIdGreaterThan(@Param("number") int number);
}
