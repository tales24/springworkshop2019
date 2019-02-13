package de.inmediasp.springws.zoo.buildings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EnclosureRepository extends JpaRepository<Enclosure, Long> {
}
