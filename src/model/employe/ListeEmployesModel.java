package model.employe;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import javax.swing.event.EventListenerList;

import utils.connection.ConnectionBase;

public class ListeEmployesModel {
	private LinkedList<EmployeModel> liste;
	
	private EventListenerList listeners;
	
	public ListeEmployesModel(){
		this.liste = new LinkedList<EmployeModel>();
		this.setList();
		this.listeners = new EventListenerList();
	}
	
	public void setList(){
		Connection con = new ConnectionBase().getConnection();
		EmployeModel nouveau = null;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT idEmploye, nom, prenom FROM Employes");
			while(rs.next()){
				System.out.println(rs.getInt(1)+" : "+rs.getString(2)+" "+rs.getString(3));
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
	
}
