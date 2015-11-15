package fr.larive.pascal.lentilles.vue.fxml.vue;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LentilleFXML {
	
	private final StringProperty reference;
	private final StringProperty matiere;
	private final StringProperty segment;
	private final StringProperty periodicite;
	private final StringProperty prix;

	public LentilleFXML() {
		this(null, null, null, null, null);
	}
	
	public LentilleFXML(String reference, String matiere, String segment, String periodicite, String prix)
	{
		this.reference = new SimpleStringProperty(reference);
		this.matiere = new SimpleStringProperty(matiere);
		this.segment = new SimpleStringProperty(segment);
		this.periodicite = new SimpleStringProperty(periodicite);
		this.prix = new SimpleStringProperty(prix);
	}

	public StringProperty referenceProperty() {
		return reference;
	}
	
	public StringProperty matiereProperty() {
		return matiere;
	}
	
	public StringProperty segmentProperty() {
		return segment;
	}
	
	public StringProperty periodiciteProperty() {
		return periodicite;
	}
	
	public StringProperty prixProperty() {
		return prix;
	}
	
	public String getReference() {
		return reference.get();
	}
	
	public void setReference(String reference)
	{
		this.reference.set(reference);
	}

	public String getMatiere() {
		return matiere.get();
	}
	
	public void setMatiere(String matiere)
	{
		this.matiere.set(matiere);
	}

	public String getSegment() {
		return segment.get();
	}
	
	public void setSegment(String segment)
	{
		this.segment.set(segment);
	}

	public String getPeriodicite() {
		return periodicite.get();
	}
	
	public void setPeriodicite(String periodicite)
	{
		this.periodicite.set(periodicite);
	}

	public String getPrix() {
		return prix.get();
	}
	
	public void setPrix(String prix)
	{
		this.prix.set(prix);
	}
	
	
}
