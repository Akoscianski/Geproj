package view.ssprojet;

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

import model.ssprojet.SSProjetNameChangedEvent;
import model.ssprojet.SSProjetModel;
import controller.ssprojet.SSProjetView;
import controller.ssprojet.SSProjetController;

public class JFrameSSProjet extends SSProjetView implements ActionListener{
	private JFrame frame = null;
	private JPanel contentPane = null;
	private JTextField nom = null;
	private JTextField responsable = null;
	private JTextField objectif = null;
	private JTextField resultat = null;
	private JFormattedTextField budget = null;
	private JButton button = null;
	private NumberFormat format = null;
	
	public JFrameSSProjet(SSProjetController controller){
		this(controller, null);
	}
	public JFrameSSProjet(SSProjetController controller, SSProjetModel model){
		super(controller);
		buildFrame(model);
	}
	
	private void buildFrame(SSProjetModel model){
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
		formulaire.add(new JLabel("Resultat"));
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
		frame.setTitle("JFrameFieldSSProjet");
		frame.setMinimumSize(new Dimension(250,250));
		frame.pack();
	}
	public void nameChanged(SSProjetNameChangedEvent event) {
		// TODO Auto-generated method stub
		
	}
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void display() {
		frame.setVisible(true);
		
	}
	public void close() {
		frame.dispose();
		
	}
}
