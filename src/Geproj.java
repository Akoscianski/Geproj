import java.text.ParseException;

import model.lot.LotsModel;
import model.project.ProjectModel;
import model.tache.TacheModel;
import controller.lot.LotController;
import controller.project.ProjectController;
import controller.tache.TacheController;


public class Geproj {

	public static void main(String[] args) throws ParseException {
		/*
		 * Instancier un modèle
		 * Instancier un contrôleur de ce modèle
		 * Lancer la vue avec ce contrôleur
		 */
		ProjectModel projet = new ProjectModel();
		ProjectController controller = new ProjectController(projet);
		controller.displayViews();
		LotsModel lots = new LotsModel();
		LotController controllerlot = new LotController(lots);
		controllerlot.displayViews();
		TacheModel tache = new TacheModel();
		TacheController controllertache = new TacheController(tache);
		controllertache.displayViews();
	}
}
