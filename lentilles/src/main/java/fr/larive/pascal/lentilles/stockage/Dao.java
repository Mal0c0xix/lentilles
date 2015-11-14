package fr.larive.pascal.lentilles.stockage;

import java.util.List;

public interface Dao<T> {
	
	public T lire(int index);
	public List<T> lireTous();

}
