package model.employe;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.event.EventListenerList;

import utils.connection.ConnectionBase;

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
		this(0,"","","",new Date(),0,0);
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
	
	public String toString(){
		String retour = this.nom+" "+this.prenom+"\n";
		retour += " identifiacation : "+this.idEmploye;
		retour += " compétences : "+this.competences;
		retour += " salaire : "+this.salaire;
		retour += " heures dans le contrat : "+ this.heures_contrat;
		retour += " date de naissance : "+this.naissance.toString();
		return retour;
	}
	public String toStringMini() {
		return this.nom+" "+this.prenom;
	}
	
	public int getId(){
		return this.idEmploye;
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
		this.competences = competences;
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

	public void store() {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");	
		Connection con = new ConnectionBase().getConnection();
		System.out.println("Ici : "+this.getNom());
		try {
			Statement stmt = con.createStatement();
			String requette = "INSERT INTO Employes(idEmploye, nom, prenom, competences, naissance, salaire, heures_contrat) VALUES (0,'"+this.nom+"','"+this.prenom+"','"+this.competences+"',TO_DATE('"+df.format(this.naissance)+"','dd/mm/yyyy'),"+this.heures_contrat+","+this.salaire+")";
			ResultSet rs = stmt.executeQuery(requette);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
