package model.project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.EventListener;
import java.util.LinkedList;

import javax.swing.event.EventListenerList;

import model.employe.EmployeModel;
import utils.connection.ConnectionBase;

public class ProjectListeModel {
	private LinkedList<ProjectModel> liste;
	
	private EventListenerList listeners;
	
	public ProjectListeModel(){
		this.liste = new LinkedList<ProjectModel>();
		this.setList();
		this.listeners = new EventListenerList();
	}
	
	public LinkedList<ProjectModel> getListe(){
		return this.liste;
	}
	
	public void setList(){
		Connection con = new ConnectionBase().getConnection();
		String requette = "SELECT p.idProjet, p.nom, e.idEmploye, e.nom as nomEmp, e.prenom as pNomEmp, p.objectif	 "
				+ "FROM Projets p, Employes e "
				+ "WHERE e.idEmploye = p.responsable";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(requette);
			ProjectModel model = null;
			while (rs.next()){
				// (int id, String nom, String objectif, String resultat, float budget
				model = new ProjectModel(
						rs.getInt("idProjet"),
						rs.getString("nom"),
						rs.getString("objectif"),
						"",
						0);
				model.setResponsable(new EmployeModel( //int idEmploye, String nom, String prenom, String competences, Date naissance, float salaire, float heures_contrat
								rs.getInt("idEmploye"),
								rs.getString("nomEmp"),
								rs.getString("pNomEmp"),
								"", null, 0, 0));
				liste.add(model);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	public void addListeProjectListener(ListeProjectListener listener){
		listeners.add(ListeProjectListener.class, listener);
	}
	public void removeListeProjectListener(ListeProjectListener l){
		listeners.remove(ListeProjectListener.class, l);
	}
}
