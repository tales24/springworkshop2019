package de.inmediasp.springws.zoo.buildings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.annotation.Secured;

import java.util.Optional;

@Secured({"ROLE_KEEPER", "ROLE_DIRECTOR"})
@RepositoryRestResource
public interface EnclosureTypeRepository extends JpaRepository<EnclosureType, Long> {

    @Override
    @Secured("ROLE_DIRECTOR")
    <S extends EnclosureType> S save(S entity);

    Optional<EnclosureType> findByName(String value);
}
