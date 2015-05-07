import model.project.ProjectModel;
import controller.project.ProjectController;


public class Geproj {

	public static void main(String[] args) {
		/*
		 * Instancier un modèle
		 * Instancier un contrôleur de ce modèle
		 * Lancer la vue avec ce contrôleur
		 */
		ProjectModel projet = new ProjectModel();
		ProjectController controller = new ProjectController(projet);
		controller.displayViews();
	}
}
