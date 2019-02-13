package de.inmediasp.springws.zoo.buildings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface EnclosureTypeRepository extends JpaRepository<EnclosureType, Long> {
    Optional<EnclosureType> findByName(String value);
}
