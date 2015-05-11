package view.project;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import model.project.ProjectListeModel;
import model.project.ProjectModel;
import view.employe.ListeEmployeRender;
import controller.project.ListeProjetsController;
import controller.project.ListeProjetsView;

public class JPanelListeProjets extends ListeProjetsView implements ActionListener {
	private JList liste = null;
	private JPanel panel = null;
	
	public JPanelListeProjets(ListeProjetsController controller, ProjectListeModel projets) {
		super(controller);
		DefaultListModel<ProjectModel> model = new DefaultListModel<ProjectModel>();
		for(ProjectModel e : projets.getListe()){
			model.addElement(e);
		}
		panel = new JPanel(new BorderLayout());
		liste = new JList(model);
		ListCellRenderer renderer = new ListeProjetsRender();
		liste.setCellRenderer(renderer);
		panel.add(liste, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("JPanelListeProjets : "+arg0.getActionCommand());
		
	}
	
	public JPanel getPanel(){
		return this.panel;
	}

}
