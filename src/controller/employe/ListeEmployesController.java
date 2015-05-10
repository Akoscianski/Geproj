package controller.employe;

import controller.project.ProjectController;
import view.employe.JFrameListeEmployes;
import model.employe.EmployeModel;
import model.employe.ListeEmployesModel;


public class ListeEmployesController {
	public ListeEmployesView view = null;
	
	private ProjectController projectController = null;
	private ListeEmployesModel model = null;
	
	public ListeEmployesController(ProjectController projectController, ListeEmployesModel model){
		this.model = model;
		this.projectController = projectController;
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
		//model.setChoice(e);
		projectController.setchoice(e);
	}
	
}