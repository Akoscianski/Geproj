package controller.project;

import model.project.ProjectModel;

public class ProjectController {
	public ProjectView view = null;
	
	private ProjectModel model = null;
	
	public ProjectController(ProjectModel model){
		this.model = model;
		
		//view = new JFrameProject(this, model.getProject());
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
}