package runnable;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import enum_.enum_frequenza;
import enum_.enum_genere;
import model.Archivio;
import model.Catalogo;
import model.Prestiti;
import model.Libro;

public class Runnable {

	public static void main(String[] args) {

		// Creazione degli elementi nella tabella (ricordati di commentarli mano a mano)
		// Libro book1 = new Libro("Paolo", enum_genere.HORROR, "Libro horror
		// spaventosissimo", 2022, 234);
		// Libro book2 = new Libro("Giovanni", enum_genere.THRILLER, "Un thriller
		// pazzesco", 2013, 255);

		// Magazine magazine1 = new Magazine(enum_frequenza.MENSILE, "Oggi TV", 2017,
		// 67);
		// Magazine magazine2 = new Magazine(enum_frequenza.SEMESTRALE, "Novella 2000",
		// 2021, 120);

		// Utente utente = new Utente(10l, "Giacomo", "Della Peruta", LocalDate.of(1995,
		// 6, 13));
		// Utente utente1 = new Utente(11l, "Daniele", "D'Alessio", LocalDate.of(1934,
		// 4, 12));
		// Utente utente2 = new Utente(8l, "Marco", "Peenzi", LocalDate.of(1991, 5,
		// 18));
		try {
//
//			Prestiti prestito1 = new Prestiti(utente, book1, LocalDate.of(2023, 2, 1), LocalDate.of(2023, 4, 4));
//			Prestiti prestito2 = new Prestiti(utente1, magazine1, LocalDate.of(2023, 2, 10),
//				LocalDate.of(2023, 2, 12));

			// Aggiunge un prodotto al catalogo
//			Catalogo.addToCat(book1);
//			Catalogo.addToCat(book2);
//			Catalogo.addToCat(magazine1);
//			Catalogo.addToCat(magazine2);

			// Aggiunge un utente alla tabella
//			Catalogo.addToUtente(utente);
//			Catalogo.addToUtente(utente1);
//			Catalogo.addToUtente(utente2);

			// Aggiunge prestiti alla tabella
			// Catalogo.addToPrestiti(prestito1);
			// Catalogo.addToPrestiti(prestito2);

			// Cerca un elemento tramite ID
			// Catalogo.getById(6l);

			// Elimina un elemento tramite ID
			// Catalogo.delete(6l);

			// Cerca un elemento per anno
			List<Archivio> archives = Catalogo.getByYear(2022);
			System.out.println("\nArchivi pubblicati nel 2022: " + archives);

			// Cerca un elemento per autore
			List<Archivio> ArchiveByAuthor = Catalogo.getByAuthor("Paolo");
			System.out.println("\nLibri scritti da Paolo: " + ArchiveByAuthor);

			// Cerca un elemento per titolo
			List<Archivio> archiveByTitle = Catalogo.getByTitle("lib");
			System.out.println("\nLibri cercati per titolo: " + archiveByTitle);

			// Cerca un prestito valido per numero di tessera
			List<Prestiti> Prestiticercati = Catalogo.getPrestitoById(8l);
			System.out.println(Prestiticercati);

			// Cerca un prestito scaduto o non restituito
			List<Prestiti> PrestitiScaduti = Catalogo.PrestitiScaduti();
			System.out.println("\n" + PrestitiScaduti);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
