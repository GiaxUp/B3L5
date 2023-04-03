package model;

import java.sql.SQLException;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import connector.DbConnection;

public class Catalogo {

	static EntityManager em = DbConnection.getEntityManagerFactory().createEntityManager();

	// Aggiunge un archivio alla tabella
	public static void addToCat(Archivio a) throws SQLException {
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		System.out.println("Elemento salvato.");
	}

	// Aggiunge un utente alla tabella
	public static void addToUtente(Utente u) throws SQLException {
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		System.out.println("Utente salvato.");
	}

	// Aggiunge prestiti alla tabella
	public static void addToPrestiti(Prestiti p) throws SQLException {
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		System.out.println("Prestito salvato.");
	}

	// Cerca un elemento tramite ISBN
	public static Archivio getById(Long iSBNcode) throws SQLException {
		em.getTransaction().begin();
		Archivio e = em.find(Archivio.class, iSBNcode);
		em.getTransaction().commit();
		System.out.println(e);
		return e;
	}

	// Elimina un elemento tramite ISBN
	public static void delete(Long iSBNcode) throws SQLException {
		em.getTransaction().begin();
		Archivio e = em.find(Archivio.class, iSBNcode);
		em.remove(e);
		em.getTransaction().commit();
		System.out.println("Elemento eliminato.");
	}

	// Modifica di un evento
	public static void updateEvento(Archivio e) throws SQLException {
		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();
		System.out.println("Elemento modificato.");
		System.out.println(e);
	}

	// Cerca un elemento per anno
	public static List<Archivio> getByYear(int anno) throws SQLException {
		List<Archivio> resultList = em.createNamedQuery("Archive.findByYear", Archivio.class).setParameter("anno", anno)
				.getResultList();
		return resultList;
	}

	// Cerca un elemento per autore
	public static List<Archivio> getByAuthor(String author) throws SQLException {
		Query query = em.createNamedQuery("Archive.findByAuthor", Archivio.class);
		query.setParameter("author", author);
		return query.getResultList();
	}

	// Cerca un elemento per titolo
	public static List<Archivio> getByTitle(String titolo) throws SQLException {
		Query query = em.createNamedQuery("Archive.findByTitle");
		query.setParameter("titolo", titolo);
		return query.getResultList();
	}

	// Cerca un prestito valido per numero di tessera
	public static List<Prestiti> getPrestitoById(Long tessera) throws SQLException {
		Query query = em.createNamedQuery("Prestiti.findByTessera");
		query.setParameter("tessera", tessera);
		return query.getResultList();
	}

	// Cerca un prestito scaduto o non restituito
	public static List<Prestiti> PrestitiScaduti() throws SQLException {
		Query query = em.createNamedQuery("Prestiti.prestitiScaduti");
		return query.getResultList();
	}
}