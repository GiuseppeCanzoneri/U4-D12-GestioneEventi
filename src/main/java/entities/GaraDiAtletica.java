package entities;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue("GARA_ATLETICA")
public class GaraDiAtletica extends Evento {
    @ManyToMany
    private Set<Persona> atleti;
    @ManyToOne
    private Persona vincitore;

    
}
