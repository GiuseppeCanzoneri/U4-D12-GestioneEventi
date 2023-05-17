package main;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.EventoDAO;
import dao.LocationDAO;
import dao.PartecipazioneDAO;
import dao.PersonaDAO;
import entities.Evento;
import entities.Location;
import entities.Partecipazione;
import entities.Persona;
import utils.JpaUtil;

public class Main {
	private static Logger logger = LoggerFactory.getLogger(Main.class);
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		
		    logger.info("Prova");
		    EntityManager em = emf.createEntityManager();
		    EventoDAO eventoDAO = new EventoDAO(em);
		    PersonaDAO personaDAO = new PersonaDAO(em);
		    LocationDAO locationDAO = new LocationDAO(em);
		    PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);

		    // Salva una persona
		    Persona persona = new Persona("Mario", "Rossi", "mario@example.com", LocalDate.of(1990, 5, 10), "Maschio");
		    personaDAO.save(persona);

		    // Salva una location
		    Location location = new Location("Stadio San Siro", "Milano");
		    locationDAO.save(location);

		    // Salva un evento con la partecipazione della persona nella location
		    Evento evento = new Evento("Concerto bylli"	, LocalDate.now(), "PUBBLICO", 20000);
		    evento.setLocation(location);
		    eventoDAO.save(evento);

		    Partecipazione partecipazione = new Partecipazione(persona, evento, "CONFERMATA");
		    partecipazioneDAO.save(partecipazione);

		    em.close();
		    emf.close();
		}
}
