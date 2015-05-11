package controller.ssprojet;

import model.ssprojet.SSProjetModel;
import view.ssprojet.JFrameSSProjet;

public class SSProjetController {
	public SSProjetView view = null;
	
	private SSProjetModel model = null;
	
	public SSProjetController(SSProjetModel model){
		this.model = model;
		
		view = new JFrameSSProjet(this, model);
		addListenerToModel();
	}
	
	private void addListenerToModel(){
		model.addLotListener(view);
	}
	
	public void displayViews(){
		view.display();
	}
	
	public void closeViews(){
		view.close();
	}
	
	public void notifySSProjetNameChanged(String name){
		model.setName(name);
	}
}