package de.inmediasp.springws.zoo;

import de.inmediasp.springws.zoo.buildings.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class InitialZooLoader implements ApplicationListener<ContextRefreshedEvent> {
    private final EnclosureRepository enclosureRepository;
    private final AuthenticationManager authenticationManager;
    private final EnclosureTypeRepository enclosureTypeRepository;

    private boolean alreadySetup;

    @Autowired
    public InitialZooLoader(final EnclosureRepository enclosureRepository, final AuthenticationManager authenticationManager, final EnclosureTypeRepository enclosureTypeRepository) {
        this.enclosureRepository = enclosureRepository;
        this.authenticationManager = authenticationManager;
        this.enclosureTypeRepository = enclosureTypeRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        if (alreadySetup) {
            return;
        }

        final UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken("Director", "secret");
        final Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        enclosureRepository.deleteAll();
        enclosureTypeRepository.deleteAll();

        createZoo();

        alreadySetup = true;
    }

    @Transactional
    public void createZoo() {
        createEnclosureTypes();
        createEnclosures();
    }

    @Transactional
    public void createEnclosures() {
        final Enclosure enclosure = new Enclosure();
        enclosure.setName("Ape House");
        enclosure.setSize(new Building.Size(10, 10));
        enclosure.setLocation(new Building.Location(0, 0));
        enclosure.setType(enclosureTypeRepository.findByName("Cage").orElse(null));

        enclosureRepository.save(enclosure);
    }

    @Transactional
    public void createEnclosureTypes() {
        final EnclosureType cage = new EnclosureType();
        cage.setName("Cage");

        enclosureTypeRepository.save(cage);
    }
}
