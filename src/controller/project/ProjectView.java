package controller.project;

import model.project.ProjectListener;
import model.project.ProjectNewRespEvent;


public abstract class ProjectView implements ProjectListener {
	private ProjectController controller = null;
	
	public ProjectView(ProjectController controller){
		super();
		
		this.controller = controller;
	}
	
	public final ProjectController getController(){
		return controller;
	}
	
	public abstract void display();
	public abstract void close();
	
}