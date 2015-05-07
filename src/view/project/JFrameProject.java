package view.project;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.project.ProjectModel;
import model.project.ProjectNameChangedEvent;
import controller.project.ProjectController;
import controller.project.ProjectView;

public class JFrameProject extends ProjectView implements ActionListener{
	private JFrame frame = null;
	private JPanel contentPane = null;
	private JTextField nom = null;
	private JTextField responsable = null;
	private JTextField objectif = null;
	private JTextField resultat = null;
	private JFormattedTextField budget = null;
	private JButton button = null;
	private NumberFormat format = null;
	
	public JFrameProject(ProjectController controller){
		this(controller, null);
	}
	public JFrameProject(ProjectController controller, ProjectModel model){
		super(controller);
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
		formulaire.add(new JLabel("Responsable"));
		responsable = new JTextField();
		responsable.setText(model.getRespnsable());
		formulaire.add(responsable);
		formulaire.add(new JLabel("Objectif"));
		objectif = new JTextField();
		objectif.setText(model.getObjectif());
		formulaire.add(objectif);
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
		// TODO Auto-generated method stub
		
	}
	@Override
	public void display() {
		frame.setVisible(true);
		
	}
	@Override
	public void close() {
		frame.dispose();
		
	}
}
