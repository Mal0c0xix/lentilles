package fr.larive.pascal.lentilles.utilitaires;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import fr.larive.pascal.lentilles.stockage.Dao;

public class Injecteur {

	public static Dao<?> getDao()
	{
		Dao<?> ret = null;
		String classe = null;
		Properties p = new Properties();
		
		try {
			p.load(new FileInputStream("acces.properties"));
			classe = p.getProperty("acces");
			ret = (Dao<?>) Class.forName(classe).newInstance();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ret;
	}

}
