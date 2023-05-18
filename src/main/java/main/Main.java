package main;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.EventoDAO;
import entities.Concerto;
import entities.Evento;
import entities.GaraDiAtletica;
import entities.GenereConcerto;
import entities.PartitaDiCalcio;
import entities.Persona;
import entities.Sesso;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestioneEventi");
        EntityManager em = emf.createEntityManager();

        try {
            EventoDAO eventoDAO = new EventoDAO(em);

            // Creazione di un concerto
            Concerto concerto = new Concerto();
            concerto.setTitolo("Concerto di prova");
            concerto.setDataEvento(LocalDate.now());
            concerto.setDescrizione("Concerto di prova");
            concerto.setTipoEvento("Concerto");
            concerto.setNumeroMassimoPartecipanti(1000);
            concerto.setGenere(GenereConcerto.ROCK);
            concerto.setInStreaming(true);

            eventoDAO.save(concerto);

            // Creazione di una partita di calcio
            PartitaDiCalcio partitaDiCalcio = new PartitaDiCalcio();
            partitaDiCalcio.setTitolo("Partita di calcio di prova");
            partitaDiCalcio.setDataEvento(LocalDate.now());
            partitaDiCalcio.setDescrizione("Partita di calcio di prova");
            partitaDiCalcio.setTipoEvento("Partita di calcio");
            partitaDiCalcio.setNumeroMassimoPartecipanti(5000);
            partitaDiCalcio.setSquadraDiCasa("Inter");
            partitaDiCalcio.setSquadraOspite("Milan");
            partitaDiCalcio.setSquadraVincente("Inter");
            partitaDiCalcio.setNumeroGolSquadraDiCasa(3);
            partitaDiCalcio.setNumeroGolSquadraOspite(1);

            eventoDAO.save(partitaDiCalcio);

            // Creazione di una gara di atletica
            GaraDiAtletica garaDiAtletica = new GaraDiAtletica();
            garaDiAtletica.setTitolo("Gara di atletica di prova");
            garaDiAtletica.setDataEvento(LocalDate.now());
            garaDiAtletica.setDescrizione("Gara di atletica di prova");
            garaDiAtletica.setTipoEvento("Gara di atletica");
            garaDiAtletica.setNumeroMassimoPartecipanti(100);
            
            // Creazione di alcune persone per la gara di atletica
            Persona persona1 = new Persona("Mario", "Rossi", "mario@email.com",
                    LocalDate.of(1990, 5, 10), Sesso.MASCHIO);
            Persona persona2 = new Persona("Giulia", "Bianchi", "giulia@email.com",
                    LocalDate.of(1992, 8, 20), Sesso.FEMMINA);
            
            eventoDAO.save(persona1);
            eventoDAO.save(persona2);
            
            garaDiAtletica.setAtleti(new HashSet<>(Arrays.asList(persona1, persona2)));
            garaDiAtletica.setVincitore(persona1);

            eventoDAO.save(garaDiAtletica);

            // Esempio di utilizzo del metodo getConcertiInStreaming
            List<Concerto> concertiInStreaming = eventoDAO.getConcertiInStreaming(true);
            System.out.println("Concerti in streaming:");
            for (Concerto concertoInStreaming : concertiInStreaming) {
                System.out.println(concertoInStreaming);
            }

            // Esempio di utilizzo del metodo getConcertiPerGenere
            List<Concerto> concertiRock = eventoDAO.getConcertiPerGenere(Arrays.asList(GenereConcerto.ROCK));
            System.out.println("Concerti rock:");
            for (Concerto concertoRock : concertiRock) {
                System.out.println(concertoRock);
            }
        } finally {
            em.close();
            emf.close();
        }
    }
}
