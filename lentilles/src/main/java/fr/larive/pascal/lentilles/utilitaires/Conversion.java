package fr.larive.pascal.lentilles.utilitaires;

import fr.larive.pascal.lentilles.modele.metier.Lentille;
import fr.larive.pascal.lentilles.vue.fxml.vue.LentilleFXML;

public class Conversion {

	public static LentilleFXML lentilleToFXML(Lentille lens)
	{
		LentilleFXML fx = null;
		
		fx = new LentilleFXML(lens.getReference(), lens.getMatiere(), lens.getSegment(), lens.getPeriodicite(), lens.getPrix());
		
		return fx;
	}
	
	

}
