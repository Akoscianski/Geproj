package view.project;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
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
		contentPane = new JPanel();
		
		format = NumberFormat.getNumberInstance();
		format.setParseIntegerOnly(true);
		format.setGroupingUsed(false);
		format.setMaximumFractionDigits(0);
		format.setMaximumIntegerDigits(12);
		
		nom = new JTextField();
		nom.setText(model.getName());
		contentPane.add(nom);
		responsable = new JTextField();
		responsable.setText(model.getRespnsable());
		contentPane.add(responsable);
		objectif = new JTextField();
		objectif.setText(model.getObjectif());
		contentPane.add(objectif);
		resultat = new JTextField();
		resultat.setText(model.getResultat());
		contentPane.add(resultat);
		budget = new JFormattedTextField(format);
		budget.setValue(model.getBudget());
		contentPane.add(budget);
		
		button = new JButton("Enregistrer");
		button.addActionListener(this);
		contentPane.add(button);
		
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
