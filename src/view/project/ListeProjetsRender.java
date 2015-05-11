package view.project;

import java.awt.Component;
import java.util.LinkedList;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import model.employe.EmployeModel;
import model.project.ProjectModel;

public class ListeProjetsRender implements ListCellRenderer {
	protected static Border noFocusBorder = new EmptyBorder(15, 1, 1, 1);

	  protected static TitledBorder focusBorder = new TitledBorder(LineBorder.createGrayLineBorder(), "Sélection");

	  protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();

	  public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		  /*
		   * private int id;
			private String name;
			private String objectif;
			private String resultats;
			private EmployeModel responsable; //A changer en Employé
			private float budget;
			private LinkedList<Integer> lots; //A changer en lots
		   */
		ProjectModel model = (ProjectModel) value;
		String affichage = "<html>";
		affichage +="<b>"+model.getName()+"</b>";
		affichage +="<ul><li>référent : "+model.getResponsable().getNom()+" "+model.getResponsable().getPrenom()+"</li>";
		String objectif = model.getObjectif();
		if(objectif.length() >= 150){
			objectif = objectif.substring(0, 150);
		}
		affichage +="<li>Objectif : "+objectif+"</li>";
		affichage +="</ul></html>";
		JLabel renderer = new JLabel(affichage);
		renderer.setBorder(cellHasFocus ? focusBorder : noFocusBorder);
		return renderer;
	  }
}
