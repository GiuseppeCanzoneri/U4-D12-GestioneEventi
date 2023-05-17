package entities;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Persone")
@Getter
@Setter
@ToString
public class Persona {
	@Id
	@GeneratedValue
	private long id;
	private String nome;
	private String cognome;
	private String email;
	private LocalDate dataNascita;
	private String sesso;

	@OneToMany(mappedBy = "persona")
	private List<Partecipazione> listaPartecipazioni = new ArrayList<>();

	public Persona() {
	}

	public Persona(String nome, String cognome, String email, LocalDate dataNascita, String sesso) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.dataNascita = dataNascita;
		this.sesso = sesso;
	}
}
