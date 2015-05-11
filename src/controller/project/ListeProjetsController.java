package controller.project;

import view.project.JPanelListeProjets;
import model.project.ProjectListeModel;

public class ListeProjetsController {
	public ListeProjetsView view = null;
	
	private ProjectListeModel model = null;
	
	public ListeProjetsController(ProjectListeModel model){
		this.model = model;
		view = new JPanelListeProjets(this, model);
		addListenerToModel();
	}
	private void addListenerToModel(){
		model.addListeProjectListener(view);
	}
}
