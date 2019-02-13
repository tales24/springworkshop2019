package de.inmediasp.springws.zoo.buildings;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Enclosure extends Building {
    @OneToOne
    private EnclosureType type;
}
