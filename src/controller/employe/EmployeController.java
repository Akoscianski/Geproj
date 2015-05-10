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
	

	public void notifyNewEmploye(String newName, String newPrenom, String newCompetences, String newBirth, float newSalaire, float newHeureContract) {	
		System.out.println("newName : "+newName);
		model.setNom(newName);
		System.out.println("enregistré1 : "+model.getNom());
		model.setPrenom(newPrenom);
		System.out.println("enregistré2 : "+model.getNom());
		model.setCompetences(newCompetences);
		System.out.println("enregistré3 : "+model.getNom());
		System.out.println(model.toString());
		System.out.println("enregistré3 : "+model.getNom());
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
