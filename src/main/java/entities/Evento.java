package entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "GestioneEventi")
@Getter
@Setter
@ToString
public class Evento {
	@Id
	@GeneratedValue
	private long id;
	private String titolo;
	private String descrizione;
	private LocalDate dataEvento;
	private String tipoEvento;
	private int numeroMassimoPartecipanti;

	@OneToOne(cascade = CascadeType.ALL)
	private Location location;

	@OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
	private Set<Partecipazione> partecipazioni = new HashSet<>();

	public Evento() {
	}

	public Evento(String titolo, String descrizione ,LocalDate dataEvento, String tipoEvento, int numeroMassimoPartecipanti) {
		this.titolo = titolo;
		this.descrizione= descrizione;
		this.dataEvento = dataEvento;
		this.tipoEvento = tipoEvento;
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
	}
}
