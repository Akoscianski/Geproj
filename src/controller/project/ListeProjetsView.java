package controller.project;

import model.project.ListeProjectListener;

public class ListeProjetsView implements ListeProjectListener {
	private ListeProjetsController controller = null;
	
	public ListeProjetsView(ListeProjetsController controller){
		super();
		this.controller = controller;
	}
	public final ListeProjetsController getController(){
		return this.controller;
	}

}
