package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Partecipazione;

public class PartecipazioneDAO {
	private final EntityManager em;

	public PartecipazioneDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Partecipazione partecipazione) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(partecipazione);
		transaction.commit();
		System.out.println("Partecipazione salvata");
	}
}
