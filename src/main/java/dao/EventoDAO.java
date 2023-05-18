package dao;

import javax.persistence.TypedQuery;


import entities.Evento;
import entities.PartitaDiCalcio;
import entities.Persona;
import entities.GaraDiAtletica;
import entities.Concerto;
import entities.GenereConcerto;



import java.util.List;



import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;



public class EventoDAO {
	private final EntityManager em;

	public EventoDAO(EntityManager em) {
		this.em = em;
	}

	public void save(PartitaDiCalcio partita) {
	    EntityTransaction transaction = em.getTransaction();
	    transaction.begin();
	    em.persist(partita);
	    transaction.commit();
	    System.out.println("Partita di calcio salvata");
	}

	public void save(GaraDiAtletica gara) {
	    EntityTransaction transaction = em.getTransaction();
	    transaction.begin();
	    em.persist(gara);
	    transaction.commit();
	    System.out.println("Gara di atletica salvata");
	}

	public void save(Concerto concerto) {
	    EntityTransaction transaction = em.getTransaction();
	    transaction.begin();
	    em.persist(concerto);
	    transaction.commit();
	    System.out.println("Concerto salvato");
	}
	public void save(Persona persona) {
	    EntityTransaction transaction = em.getTransaction();
	    transaction.begin();
	    em.persist(persona);
	    transaction.commit();
	    System.out.println("persona  salvata");
	}

	public Evento findById(long id) {
		
		Evento found = em.find(Evento.class, id);
		return found;
	}

	public void findByIdAndDelete(long id) {
		Evento found = em.find(Evento.class, id);
		if (found != null) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.remove(found);
			transaction.commit();
			System.out.println("Evento con id " + id + " eliminato!");
		}
	}

	public void refresh(long id) {
		Evento found = em.find(Evento.class, id);
		found.setTitolo("Festa in Barca");
		System.out.println("PRE REFRESH");
		System.out.println(found);
		em.refresh(found);
		System.out.println("POST REFRESH");
		System.out.println(found);
	}
	
	public List<Concerto> getConcertiInStreaming(boolean inStreaming) {
	    TypedQuery<Concerto> query = em.createQuery("SELECT c FROM Concerto c WHERE c.inStreaming = :inStreaming", Concerto.class);
	    query.setParameter("inStreaming", inStreaming);
	    return query.getResultList();
	}

	public List<Concerto> getConcertiPerGenere(List<GenereConcerto> generi) {
	    TypedQuery<Concerto> query = em.createQuery("SELECT c FROM Concerto c WHERE c.genere IN :generi", Concerto.class);
	    query.setParameter("generi", generi);
	    return query.getResultList();
	}


}
