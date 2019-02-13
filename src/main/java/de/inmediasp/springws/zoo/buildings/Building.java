package de.inmediasp.springws.zoo.buildings;

import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
public class Building {

    @Embeddable
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @ToString
    public static class Location {
        @Getter
        private @Range(min = -90L, max = 90L) int lat;
        @Getter
        private @Range(min = -180L, max = 180L) int lon;
    }

    @Embeddable
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @ToString
    public static class Size {

        @Getter
        private @Min(1) int length;
        @Getter
        private @Min(1) int width;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private @NotEmpty String name;
    private @Valid Size size;
    private @Valid Location location;

}
