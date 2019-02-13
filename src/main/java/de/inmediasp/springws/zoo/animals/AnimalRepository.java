package de.inmediasp.springws.zoo.animals;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

@Secured({"ROLE_KEEPER", "ROLE_DIRECTOR", "ROLE_VISITOR"})
@RepositoryRestResource
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    @Secured({"ROLE_DIRECTOR"})
    @Override
    <S extends Animal> S save(S entity);

    @Secured({"ROLE_DIRECTOR"})
    @Override
    <S extends Animal> List<S> saveAll(Iterable<S> entities);

    @Secured({"ROLE_KEEPER", "ROLE_DIRECTOR"})
    @Override
    void flush();

    @Secured({"ROLE_DIRECTOR"})
    @Override
    <S extends Animal> S saveAndFlush(S entity);

    @Secured({"ROLE_DIRECTOR"})
    @Override
    void deleteInBatch(Iterable<Animal> entities);

    @Secured({"ROLE_DIRECTOR"})
    @Override
    void deleteAllInBatch();

    List<Animal> getAllByIdGreaterThan(@Param("number") Long number);
}
