package controller.project;

import model.employe.EmployeModel;
import model.project.ProjectModel;
import view.project.JFrameProject;

public class ProjectController {
	public ProjectView view = null;
	
	private ProjectModel model = null;
	
	public ProjectController(ProjectModel model){
		this.model = model;
		
		view = new JFrameProject(this, model);
		addListenerToModel();
	}
	
	private void addListenerToModel(){
		model.addProjectListener(view);
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
	
	public ProjectModel getModel(){
		return this.model;
	}

	public void setchoice(EmployeModel e) {
		model.setResponsable(e);
		System.out.println("ProjectController : setChoice");
	}

	public void notifyNewProject(String newName, EmployeModel newResp, String newObjectif, String newRes, float newBudget) {
		model.setName(newName);
		model.setResponsable(newResp);
		model.setObjectif(newObjectif);
		model.setResultats(newRes);
		model.setBudget(newBudget);
		model.store();		
	}
}