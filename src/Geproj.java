import model.project.ProjectModel;
import controller.project.ProjectController;


public class Geproj {

	public static void main(String[] args) {
		/*
		 * Instancier un mod�le
		 * Instancier un contr�leur de ce mod�le
		 * Lancer la vue avec ce contr�leur
		 */
		ProjectModel projet = new ProjectModel();
		ProjectController controller = new ProjectController(projet);
		controller.displayViews();
	}
}
