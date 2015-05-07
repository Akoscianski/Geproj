package controller.employe;

import model.employe.EmployeModel;
import view.employe.JFrameEmploye;


public class EmployeController {
	public EmployeView view = null;
	
	private EmployeModel model = null;
	
	public EmployeController(EmployeModel model){
		this.model = model;
		
		view = new JFrameEmploye(this, model);
		addListenerToModel();
	}
	
	private void addListenerToModel(){
		model.addEmployeListener(view);
	}
	
	public void displayViews(){
		view.display();
	}
	
	public void closeViews(){
		view.close();
	}
	
	public void notifyProjectNameChanged(String name){
		model.setNom(name);
	}
}
