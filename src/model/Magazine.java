package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import enum_.enum_frequenza;

@Entity
@DiscriminatorValue(value = "magazine")
public class Magazine extends Archivio {

	@Enumerated(EnumType.STRING)
	private enum_frequenza frequencyOfPublishing;

	public Magazine() {
		super();
	}

	public Magazine(Long iSBNcode, String titolo, int yearOfPublishing, int numberOfPages,
			enum_frequenza frequencyOfPublishing) {
		super(iSBNcode, titolo, yearOfPublishing, numberOfPages);
		this.frequencyOfPublishing = frequencyOfPublishing;
	}

	public Magazine(enum_frequenza frequencyOfPublishing, String titolo, int yearOfPublishing, int numberOfPages) {
		super(titolo, yearOfPublishing, numberOfPages);
		this.frequencyOfPublishing = frequencyOfPublishing;
	}

	public String toString() {
		return "\n" + "\nTitolo: " + this.getTitolo() + "\nPeriodicità: " + this.frequencyOfPublishing
				+ "\nNumero di pagine: " + this.getNumberOfPages() + "\nAnno di pubblicazione: "
				+ this.getYearOfPublishing() + "\nCodice ISBN: " + this.getISBNcode();

	}

	public enum_frequenza getFrequencyOfPublishing() {
		return frequencyOfPublishing;
	}

	public void setFrequencyOfPublishing(enum_frequenza frequencyOfPublishing) {
		this.frequencyOfPublishing = frequencyOfPublishing;
	}

}