package model.project;

import java.util.EventObject;

import model.employe.EmployeModel;

public class ProjectNewRespEvent extends EventObject {
	private EmployeModel newResp;
	
	public ProjectNewRespEvent(Object source, EmployeModel e){
		super(source);
		this.newResp = e;
	}
	
	public EmployeModel getNewResp(){
		return this.newResp;
	}
}
