package model.employe;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import javax.swing.event.EventListenerList;

import model.project.ProjectListener;
import model.project.ProjectNewRespEvent;
import utils.connection.ConnectionBase;

public class ListeEmployesModel {
	private LinkedList<EmployeModel> liste;
	private EmployeModel choix = null;
	
	private EventListenerList listeners;
	
	public ListeEmployesModel(){
		this.liste = new LinkedList<EmployeModel>();
		this.setList();
		this.listeners = new EventListenerList();
	}
	
	public LinkedList<EmployeModel> getListe(){
		return this.liste;
	}
	
	public void setChoice(EmployeModel e){
		this.choix = e;
		
		fireChoiceDone();
	}
	
	public EmployeModel getChoice(){
		return this.choix;
	}
	
	public void setList(){
		Connection con = new ConnectionBase().getConnection();
		EmployeModel nouveau = null;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Employes");
			while(rs.next()){
				liste.add(new EmployeModel(
							rs.getInt("idEmploye"), 
							rs.getString("nom"),
							rs.getString("prenom"), 
							rs.getString("competences"),
							rs.getDate("naissance"),
							rs.getFloat("salaire"),
							rs.getFloat("heures_contrat")
						));
				// public EmployeModel(String competences, Date naissance, float salaire, float heures_contrat)
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addListeEmployesListener(ListeEmployesListener listener){
		listeners.add(ListeEmployesListener.class, listener);
	}
	public void removeListeEmployesListener(ListeEmployesListener l){
		listeners.remove(ListeEmployesListener.class, l);
	} 
	
	public void fireChoiceDone(){
		ProjectListener[] listenerList = (ProjectListener[])listeners.getListeners(ProjectListener.class);
 
		for(ProjectListener listener : listenerList){
			listener.choiceDone(new ProjectNewRespEvent(this, getChoice()));
		}
	}
}
