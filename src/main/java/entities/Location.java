package entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Locations")
@Getter
@Setter
@ToString
public class Location {
	@Id
	@GeneratedValue
	private long id;
	private String nome;
	private String città;

	public Location() {
	}

	public Location(String nome, String città) {
		this.nome = nome;
		this.città = città;
	}
}

