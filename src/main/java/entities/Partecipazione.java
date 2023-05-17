package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Partecipazioni")
@Getter
@Setter
@ToString
public class Partecipazione {
	@Id
	@GeneratedValue
	private long id;

	@ManyToOne
	private Persona persona;

	@ManyToOne
	private Evento evento;

	private String stato;

	public Partecipazione() {
	}

	public Partecipazione(Persona persona, Evento evento, String stato) {
		this.persona = persona;
		this.evento = evento;
		this.stato = stato;
	}
}
