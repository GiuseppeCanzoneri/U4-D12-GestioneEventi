package entities;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue("CONCERTO")
public class Concerto extends Evento {
    @Enumerated(EnumType.STRING)
    private GenereConcerto genere;
    private boolean inStreaming;


}