package fr.larive.pascal.lentilles.stockage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import fr.larive.pascal.lentilles.modele.metier.Lentille;

public class DaoJPA<T> implements Dao<T> {

	private EntityManager em;
	private Class<?> c;
	
	public DaoJPA() {
		Dao<?> ret = null;
		String classe = null;
		Properties p = new Properties();
		
		try {
			p.load(new FileInputStream("acces.properties"));
			classe = p.getProperty("pojo");
			c = Class.forName(classe);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		em = Persistence.createEntityManagerFactory("lentilles").createEntityManager();
		
	}

	@Override
	public T lire(int index) {
		T ret = null;
		
		ret = (T) em.find(c.getClass(), index);
		
		return ret;
	}

	@Override
	public List<T> lireTous() {
		List<T> ret = null;
		
		ret = (List<T>) em.createNamedQuery(c.getSimpleName() + ".findAll").getResultList();
		
		return ret;
	}

}
