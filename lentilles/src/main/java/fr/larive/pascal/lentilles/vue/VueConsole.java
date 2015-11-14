package fr.larive.pascal.lentilles.vue;

import java.util.List;

import fr.larive.pascal.lentilles.controleur.Manager;
import fr.larive.pascal.lentilles.modele.metier.Lentille;

public class VueConsole {

	public VueConsole() {
		
	}

	public static void main(String[] args) {

		VueConsole vue = new VueConsole();

		vue.afficher();
		
	}
	
	public void afficher()
	{
		List<Lentille> lens = Manager.getInstance().getInfos();
		
		for(Lentille l: lens)
			System.out.println(l);
		
	}

}
