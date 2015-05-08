package controller.employe;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

	public void notifyNewEmploye(String newName, String newPrenom, String newCompetences, String newBirth, float newSalaire, float newHeureContract) {	
		model.setNom(newName);
		model.setPrenom(newPrenom);
		model.setCompetences(newCompetences);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			model.setDate(formatter.parse(newBirth));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		model.setHeuresContrat(newHeureContract);
		model.setSalaire(newSalaire);
		model.store();
	}

}
