package fr.larive.pascal.lentilles.modele.metier;

import javax.persistence.*;

/**
 * 
 * @author Pascal Larivé
 * 
 * Classe Lentille
 *
 */
@Entity
@Table(name="lens")
@NamedQuery(name = "Lentille.findAll", query = "SELECT l FROM Lentille l")
public class Lentille {
	
	@Id
	private String reference;

	private String matiere;
	
	private String segment;
	
	private String periodicite;
	
	private String prix;
	
	public Lentille() {
		matiere = "Matière";
		segment = "Segment";
		periodicite = "Périodicité";
		prix = "Prix";
	}

	public Lentille(String matiere, String segment, String periodicite, String prix) {
		super();
		this.matiere = matiere;
		this.segment = segment;
		this.periodicite = periodicite;
		this.prix = prix;
	}
	
	

	public String getReference() {
		return reference;
	}

	public String getMatiere() {
		return matiere;
	}

	public String getSegment() {
		return segment;
	}

	public String getPeriodicite() {
		return periodicite;
	}

	public String getPrix() {
		return prix;
	}

	@Override
	public String toString() {
		return "Lentille [reference=" + reference + ", matiere=" + matiere + ", segment=" + segment + ", periodicite="
				+ periodicite + ", prix=" + prix + "]";
	}

}
