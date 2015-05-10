import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

import model.employe.EmployeModel;
import model.project.ProjectModel;
import utils.connection.ConnectionBase;
import view.MainView;
import controller.employe.EmployeController;
import controller.project.ProjectController;

public class Geproj {

	public static void main(String[] args) throws ParseException {
		/*
		 * Instancier un mod�le
		 * Instancier un contr�leur de ce mod�le
		 * Lancer la vue avec ce contr�leur
		 */
		
		Connection con = new ConnectionBase().getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Employes");
			if(rs.next()){
				System.out.println("Un r�sultat a �t� trouv�.");
			}else{
				System.out.println("Aucun r�sultat trouv�.");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new MainView();
		ProjectModel projet = new ProjectModel();
		ProjectController controller = new ProjectController(projet);
		controller.displayViews();
		//LotsModel lots = new LotsModel();
		//LotController controllerlot = new LotController(lots);
		//controllerlot.displayViews();
		//TacheModel tache = new TacheModel();
		//TacheController controllertache = new TacheController(tache);
		//controllertache.displayViews();
		EmployeModel employe = new EmployeModel();
		EmployeController employe_controller = new EmployeController(employe);
		employe_controller.displayViews();
	}
}
