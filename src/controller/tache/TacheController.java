package controller.tache;

import model.tache.TacheModel;
import view.tache.JFrameTache;

public class TacheController {
	public JFrameTache view = null;
	
	private TacheModel model = null;
	
	public TacheController(TacheModel model){
		this.model = model;
		
		view = new JFrameTache(this, model);
		addListenerToModel();
	}
	
	private void addListenerToModel(){
		model.addTacheListener(view);
	}
	
	public void displayViews(){
		view.display();
	}
	
	public void closeViews(){
		view.close();
	}
	
	public void notifyProjectNameChanged(String name){
		model.setName(name);
	}
}