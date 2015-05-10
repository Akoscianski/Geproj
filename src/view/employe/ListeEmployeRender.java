package view.employe;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import model.employe.EmployeModel;

public class ListeEmployeRender implements ListCellRenderer {
	
	 protected static Border noFocusBorder = new EmptyBorder(15, 1, 1, 1);

	  protected static TitledBorder focusBorder = new TitledBorder(LineBorder.createGrayLineBorder(), "Sélection");

	  protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();

	  public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
	    /*
		  JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
	    renderer.setBorder(cellHasFocus ? focusBorder : noFocusBorder);
	    return renderer;
	    */
		EmployeModel model = (EmployeModel) value;
		String affichage = "<html>";
		affichage +="<b>"+model.getNom()+" "+model.getPrenom()+"</b>";
		affichage +="<ul><li>Compétences : "+model.getCompetences()+"</li>";
		affichage +="<li>Contact : "+model.getHeuresContrat()+"H/semaine, "+model.getSalaire()+"€/mois</li>";
		affichage +="</ul></html>";
		JLabel renderer = new JLabel(affichage);
		renderer.setBorder(cellHasFocus ? focusBorder : noFocusBorder);
		return renderer;
	  }

}
