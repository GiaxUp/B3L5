package model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "catalogo")
@NamedQuery(name = "Archivio.findByYear", query = "SELECT a FROM Archivio a WHERE a.yearOfPublishing = :anno")
@NamedQuery(name = "Archivio.findByAuthor", query = "SELECT a FROM Archivio a WHERE a.author = :author")
@NamedQuery(name = "Archivio.findByTitle", query = "SELECT a FROM Archivio a WHERE LOWER(a.titolo) LIKE LOWER('%'||  :titolo  ||'%')")
public abstract class Archivio implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ISBNcode;
	private String titolo;
	private int yearOfPublishing;
	private int numberOfPages;

	public Archivio(String title, int year, int numOfPages) {
		this.titolo = title;
		this.yearOfPublishing = year;
		this.numberOfPages = numOfPages;
	}

	public Archivio() {
		super();
	}

	public Archivio(Long iSBNcode, String titolo, int yearOfPublishing, int numberOfPages) {
		super();
		ISBNcode = iSBNcode;
		this.titolo = titolo;
		this.yearOfPublishing = yearOfPublishing;
		this.numberOfPages = numberOfPages;
	}

	public Long getISBNcode() {
		return ISBNcode;
	}

	public void setISBNcode(Long iSBNcode) {
		ISBNcode = iSBNcode;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getYearOfPublishing() {
		return yearOfPublishing;
	}

	public void setYearOfPublishing(int yearOfPublishing) {
		this.yearOfPublishing = yearOfPublishing;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	@Override
	public String toString() {
		return "Archivio [Codice ISBN: " + ISBNcode + ", Titolo: " + titolo + ", Anno di pubblicazione: "
				+ yearOfPublishing + ", Numero di pagine: " + numberOfPages + "]";
	}

}
