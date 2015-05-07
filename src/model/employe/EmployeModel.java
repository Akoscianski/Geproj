package model.employe;

import java.util.Date;

import javax.swing.event.EventListenerList;

public class EmployeModel {
	private int idEmploye;
	private String nom;
	private String prenom;
	private String competences;
	private Date naissance;
	private float salaire;
	private float heures_contrat;
	
	private EventListenerList Employelisteners;
	
	public EmployeModel(){
		this(0,"","","",null,0,0);
	}
	
	public EmployeModel(int idEmploye, String nom, String prenom, String competences, Date naissance, float salaire, float heures_contrat){
		this.idEmploye = idEmploye;
		this.nom = nom;
		this.prenom = prenom;
		this.competences = competences;
		this.naissance = naissance;
		this.salaire = salaire;
		this.heures_contrat = heures_contrat;
		
		this.Employelisteners = new EventListenerList();
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String getPrenom() {
		return this.prenom;
	}
	
	public String getCompetences() {
		return this.competences;
	}
	
	public Date getNaissance() {
		return this.naissance;
	}
	
	public float getSalaire() {
		return this.salaire;
	}
	
	public float getHeuresContrat() {
		return this.heures_contrat;
	}
	
	/*
	 * ===================================================
	 *       MUTATEURS
	 * ===================================================
	 */
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public void setCompetences(String competences) {
		this.nom = competences;
	}
	
	public void setDate(Date naissance) {
		this.naissance = naissance;
	}
	
	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}
	
	public void setHeuresContrat(float heures_contrat) {
		this.heures_contrat = heures_contrat;
	}
	
	
	public void addEmployeListener(EmployeListener listener){
		Employelisteners.add(EmployeListener.class, listener);
	}
	public void removeEmployeListener(EmployeListener l){
		Employelisteners.remove(EmployeListener.class, l);
	} 
	public void fireNameChanged(){
		EmployeListener[] listenerList = (EmployeListener[])Employelisteners.getListeners(EmployeListener.class);
 
		for(EmployeListener Employelisteners : listenerList){
			Employelisteners.nameChanged(new EmployeNameChangedEvent(this, getNom()));
		}
	}
	
}
