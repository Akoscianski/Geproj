package view.project;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.employe.EmployeModel;
import model.employe.ListeEmployesModel;
import model.project.ProjectModel;
import model.project.ProjectNameChangedEvent;
import model.project.ProjectNewRespEvent;
import controller.employe.ListeEmployesController;
import controller.project.ProjectController;
import controller.project.ProjectView;

public class JFrameProject extends ProjectView implements ActionListener{
	private JFrame frame = null;
	private JPanel contentPane = null;
	private JTextField nom = null;
	private JLabel responsable = null;
	private JTextArea objectif = null;
	private JTextField resultat = null;
	private JFormattedTextField budget = null;
	private JButton button = null;
	private JButton chooseEmploye = null;
	private NumberFormat format = null;
	private ProjectModel model = null;
	
	public JFrameProject(ProjectController controller){
		this(controller, null);
	}
	public JFrameProject(ProjectController controller, ProjectModel model){
		super(controller);
		this.model = model;
		buildFrame(model);
	}
	
	private void buildFrame(ProjectModel model){
		frame = new JFrame();
		contentPane = new JPanel(new BorderLayout());
		JPanel formulaire = new JPanel(new GridLayout(5,2));
		
		
		format = NumberFormat.getNumberInstance();
		format.setParseIntegerOnly(true);
		format.setGroupingUsed(false);
		format.setMaximumFractionDigits(0);
		format.setMaximumIntegerDigits(12);
		
		formulaire.add(new JLabel("Nom"));
		nom = new JTextField();
		nom.setText(model.getName());
		formulaire.add(nom);
		responsable = new JLabel("Responsable : "+model.getResponsable().toStringMini());
		formulaire.add(responsable);
		chooseEmploye = new JButton("Choisir un responsable");
		chooseEmploye.addActionListener(this);
		formulaire.add(chooseEmploye);
		formulaire.add(new JLabel("Objectif"));
		// cr�er un nouveau JPanel pour le textArea d'ojectif et lui rajouter le scrollpane
		objectif = new JTextArea();
		objectif.setLineWrap(true);
		objectif.add(new JScrollPane());
		objectif.setText(model.getObjectif());
		formulaire.add(objectif);
		// Fin modifs � faire
		formulaire.add(new JLabel("Resultats"));
		resultat = new JTextField();
		resultat.setText(model.getResultat());
		formulaire.add(resultat);
		formulaire.add(new JLabel("Budget"));
		budget = new JFormattedTextField(format);
		budget.setValue(model.getBudget());
		formulaire.add(budget);
		
		contentPane.add(formulaire, BorderLayout.CENTER);
		
		button = new JButton("Enregistrer");
		button.addActionListener(this);
		contentPane.add(button, BorderLayout.SOUTH);
		
		frame.setContentPane(contentPane);
		frame.setTitle("JFrameFieldVolume");
		frame.setMinimumSize(new Dimension(250,350));
		frame.pack();
	}
	@Override
	public void nameChanged(ProjectNameChangedEvent event) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand() == "Choisir un responsable"){
			ListeEmployesModel liste = new ListeEmployesModel();
			ListeEmployesController controller = new ListeEmployesController(this.getController(), liste);
			controller.displayViews();
		}else{
			if(arg0.getActionCommand() == "Enregistrer"){
				String newName = nom.getText();
				String newObjectif = objectif.getText();
				String newRes = resultat.getText();
				float newBudget = Float.parseFloat(budget.getText());
				getController().notifyNewProject(newName, model.getResponsable(), newObjectif, newRes, newBudget);
				frame.dispose();
			}
		}
		
	}
	@Override
	public void display() {
		frame.setVisible(true);
		
	}
	@Override
	public void close() {
		frame.dispose();
		
	}
	@Override
	public void choiceDone(ProjectNewRespEvent pnre) {		
	}
	
	@Override
	public void respChanged(ProjectNameChangedEvent projectNameChangedEvent) {
		System.out.println("JFrameProjetct - respChanged");
		this.responsable.setText("responsable : "+model.getResponsable().toStringMini());
		this.responsable.repaint();
	}
}
