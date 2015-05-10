package model.project;

import java.text.DecimalFormat;
import java.util.LinkedList;

import javax.swing.event.EventListenerList;

import model.employe.EmployeModel;

public class ProjectModel {
	private int id;
	private String name;
	private String objectif;
	private String resultats;
	private EmployeModel responsable; //A changer en Employ�
	private float budget;
	private LinkedList<Integer> lots; //A changer en lots
	
	private EventListenerList listeners;
	
	public ProjectModel(){
		this(0, "","","",0);
	}
	
	public ProjectModel(int id, String nom, String objectif, String resultat, float budget){
		this.id = id;
		this.name = nom;
		this.objectif = objectif;
		this.resultats = resultat;
		this.budget = budget;
		this.responsable = new EmployeModel();
		this.lots = new LinkedList<Integer>(); //Changer en lots
		
		this.listeners = new EventListenerList();
	}
	
	/*
	 * ===================================================
	 *       ACCESSEURS
	 * ===================================================
	 */
	public String getDesc(){
		DecimalFormat decimal = new DecimalFormat("#.00");
		String retour = id+" : "+name;
		retour += "; "+objectif+"; "+resultats;
		retour += "; "+decimal.format(budget);
		return retour;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getObjectif(){
		return this.objectif;
	}
	
	public String getResultat(){
		return this.resultats;
	}
	
	public float getBudget(){
		return this.budget;
	}
	
	public EmployeModel getRespnsable(){
		return this.responsable;
	}
	
	/*
	 * ===================================================
	 *       MUTATEURS
	 * ===================================================
	 */
	
	public void setId(int id){
		this.id = id;
	}
	public void setName(String name){
		this.name = name;
		fireNameChanged();
	}
	public void setObjectif(String objectif){
		this.objectif = objectif;
	}
	public void setResultats(String res){
		this.resultats = res;
	}
	public void setBudget(float budget){
		this.budget = budget;
	}
	public void setResponsable(EmployeModel resp){ //A changer avec employ�
		this.responsable = resp;
		System.out.println("ProjectModel : setResponsable");
		fireNewResp();
	}
	public void addLot(int lot){ //A changer avec lot
		this.lots.add(lot);
	}
	
	
	public void addProjectListener(ProjectListener listener){
		listeners.add(ProjectListener.class, listener);
	}
	public void removeProjectListener(ProjectListener l){
		 listeners.remove(ProjectListener.class, l);
	} 
	public void fireNameChanged(){
		ProjectListener[] listenerList = (ProjectListener[])listeners.getListeners(ProjectListener.class);
 
		for(ProjectListener listener : listenerList){
			listener.nameChanged(new ProjectNameChangedEvent(this, getName()));
		}
	}
	
	public void fireNewResp(){
		System.out.println("ProjectModel : fireNewResp()");
		ProjectListener[] listenerList = (ProjectListener[])listeners.getListeners(ProjectListener.class);
		 
		for(ProjectListener listener : listenerList){
			listener.respChanged(new ProjectNameChangedEvent(this, getName()));
		}
	}
}
