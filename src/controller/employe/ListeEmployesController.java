package controller.employe;

import view.employe.JFrameListeEmployes;
import model.employe.EmployeModel;
import model.employe.ListeEmployesModel;


public class ListeEmployesController {
	public ListeEmployesView view = null;
	
	private ListeEmployesModel model = null;
	
	public ListeEmployesController(ListeEmployesModel model){
		this.model = model;
		
		view = new JFrameListeEmployes(this, model);
		addListenerToModel();
	}
	
	private void addListenerToModel(){
		model.addListeEmployesListener(view);
	}
	
	public void displayViews(){
		view.display();
	}
	
	public void closeViews(){
		view.close();
	}

	public void notifyChoice(EmployeModel e) {
		model.setChoice(e);
	}
	
}