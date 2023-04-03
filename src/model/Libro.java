package model;

import javax.persistence.*;

import enum_.enum_genere;

@Entity
@DiscriminatorValue(value = "book")
public class Libro extends Archivio {
	@Column(name = "author")
	String author;
	@Enumerated(EnumType.STRING)
	private enum_genere genere;

	public Libro(String author, enum_genere genre, String titolo, int yearOfPublishing, int numberOfPages) {
		super(titolo, yearOfPublishing, numberOfPages);
		this.author = author;
		this.genere = genre;
	}

	public Libro() {
		super();
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public enum_genere getGenere() {
		return genere;
	}

	public void setGenere(enum_genere genere) {
		this.genere = genere;
	}

	public String toString() {
		return "\n" + "\nTitolo: " + this.getTitolo() + "\nAutore: " + this.author + "\nGenere: " + this.genere
				+ "\nNumero di pagine: " + this.getNumberOfPages() + "\nAnno di pubblicazione: "
				+ this.getYearOfPublishing() + "\nCodice ISBN: " + this.getISBNcode();

	}

}