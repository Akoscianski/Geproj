package controller.ssprojet;

import model.ssprojet.SSProjetListener;


public abstract class SSProjetView implements SSProjetListener {
	private SSProjetController controller = null;
	
	public SSProjetView(SSProjetController controller){
		super();
		
		this.controller = controller;
	}
	
	public final SSProjetController getController(){
		return controller;
	}
	
	public abstract void display();
	public abstract void close();
}