package de.inmediasp.springws.zoo.buildings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.annotation.Secured;

@Secured({"ROLE_KEEPER", "ROLE_DIRECTOR"})
@RepositoryRestResource
public interface EnclosureRepository extends JpaRepository<Enclosure, Long> {
}
