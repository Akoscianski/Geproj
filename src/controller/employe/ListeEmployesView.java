package controller.employe;

import model.employe.ListeEmployesListener;

public abstract class ListeEmployesView implements ListeEmployesListener {
	private ListeEmployesController controller = null; 
	
	public ListeEmployesView(ListeEmployesController controller){
		super();
		
		this.controller = controller;
	}
	
	public final ListeEmployesController getControler(){
		return this.controller;
	}
	
	public abstract void display();
	public abstract void close();
}
