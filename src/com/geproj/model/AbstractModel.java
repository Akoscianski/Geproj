package com.geproj.model;

import com.geproj.observer.Observable;

public abstract class AbstractModel implements Observable {
	int identifiant;
	
	//Effacer
	public abstract void reset();
	
	//Recup�rer dans la BD
	public abstract void get();
	
	//Mettre � jour
	public abstract void update();
	
	//Enregistrer dans la BD
	//public abstract void commit();
	
	//Obtenir l'identifiant :
	public int getId(){
		return identifiant;
	}
}
