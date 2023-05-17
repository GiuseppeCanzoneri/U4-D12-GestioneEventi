package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Persona;

public class PersonaDAO {
	private final EntityManager em;

	public PersonaDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Persona persona) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(persona);
		transaction.commit();
		System.out.println("Persona salvata");
	}
}
