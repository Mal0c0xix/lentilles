package fr.larive.pascal.lentilles.controleur;

import java.util.List;

import fr.larive.pascal.lentilles.modele.metier.Lentille;
import fr.larive.pascal.lentilles.utilitaires.Injecteur;

public class Manager {

	private static Manager instance = new Manager();
	private List<Lentille> lens;
	
	private Manager() {
		lens = (List<Lentille>) Injecteur.getDao().lireTous();
	}
	
	public List<Lentille> getInfos()
	{
		return lens;
	}
	
	public static Manager getInstance()
	{
		return instance;
	}

}
