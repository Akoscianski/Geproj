package controller.employe;

import model.employe.EmployeListener;


public abstract class EmployeView implements EmployeListener {
	private EmployeController controller = null;
	
	public EmployeView(EmployeController controller){
		super();
		
		this.controller = controller;
	}
	
	public final EmployeController getController(){
		return controller;
	}
	
	public abstract void display();
	public abstract void close();
}
