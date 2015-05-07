package model.employe;

import java.util.EventObject;

public class EmployeNameChangedEvent extends EventObject {
	private static final long serialVersionUID = 1L;
	private String newName;
	
	public EmployeNameChangedEvent(Object source, String newName){
		super(source);
		
		this.newName = newName;
	}
	
	public String getNewName(){
		return newName;
	}

}
