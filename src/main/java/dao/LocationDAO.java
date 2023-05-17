package dao;



import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Location;

public class LocationDAO {
	private final EntityManager em;

	public LocationDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Location location) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(location);
		transaction.commit();
		System.out.println("Location salvata");
	}
}
