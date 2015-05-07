package controller.tache;

import model.tache.TacheListener;


public abstract class TacheView implements TacheListener {
	private TacheController controller = null;
	
	public TacheView(TacheController controller){
		super();
		
		this.controller = controller;
	}
	
	public final TacheController getController(){
		return controller;
	}
	
	public abstract void display();
	public abstract void close();
}