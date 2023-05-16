package main;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.EventoDAO;
import entities.Evento;
import utils.JpaUtil;

public class Main {
	private static Logger logger = LoggerFactory.getLogger(Main.class);
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		logger.info("Prova");
		EntityManager em = emf.createEntityManager();
		EventoDAO sd = new EventoDAO(em);

		// ************************ SAVE *********************
		Evento fiera = new Evento("Concerto Lazza", LocalDate.now(),"Stadio San Siro","PUBBLICO",20000);
		sd.save(fiera);

		// ************************ FIND BY ID *********************

	System.out.println(sd.findById(7));

		// ************************ DELETE *********************
		sd.findByIdAndDelete(3);
		
		// ************************ REFRESH ********************
		sd.refresh(7);
		em.close();

		emf.close();

	}

}
