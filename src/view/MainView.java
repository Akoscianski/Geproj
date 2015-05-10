package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import controller.employe.EmployeController;
import controller.project.ProjectController;
import model.employe.EmployeModel;
import model.project.ProjectModel;

public class MainView implements ActionListener {
	JFrame frame;
	JPanel cp;
	JMenuBar menu;
	JMenu menuFichier;
	JMenu menuFichierNouveau;
	JMenuItem item;
	
	public MainView(){
		frame = new JFrame("Geproj");
		frame.setSize(new Dimension(800,600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cp = new JPanel();
		menu = new JMenuBar();
		menuFichier = new JMenu("Fichier");
		menuFichierNouveau = new JMenu("Nouveau");
		item = new JMenuItem("Nouveau Projet");
		item.addActionListener(this);
		menuFichierNouveau.add(item);
		item = new JMenuItem("Nouvel employe");
		item.addActionListener(this);
		menuFichierNouveau.add(item);
		menuFichier.add(menuFichierNouveau);
		item = new JMenuItem("Quitter");
		item.addActionListener(this);
		menuFichier.add(item);
		menu.add(menuFichier);
		item = new JMenuItem("?");
		item.addActionListener(this);
		menu.add(item);
		frame.setJMenuBar(menu);
		frame.add(cp);		
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		switch(e.getActionCommand()){
		case "Nouveau Projet" :
			ProjectModel projet = new ProjectModel();
			ProjectController controller = new ProjectController(projet);
			controller.displayViews();
			break;
		case "Nouvel employe" :
			EmployeModel employe = new EmployeModel();
			EmployeController employe_controller = new EmployeController(employe);
			employe_controller.displayViews();
			break;
		case "Quitter" :
			frame.dispose();
			break;
		case "?" :
			new Help();
			break;
			
		}
		
	}

}
