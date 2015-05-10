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
		 * Instancier un modèle
		 * Instancier un contrôleur de ce modèle
		 * Lancer la vue avec ce contrôleur
		 */
		
		Connection con = new ConnectionBase().getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Employes");
			if(rs.next()){
				System.out.println("Un résultat a été trouvé.");
			}else{
				System.out.println("Aucun résultat trouvé.");
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
