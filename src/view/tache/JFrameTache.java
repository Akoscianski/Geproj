package view.tache;

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

import model.tache.TacheNameChangedEvent;
import model.tache.TacheModel;
import controller.tache.TacheController;
import controller.tache.TacheView;

public class JFrameTache extends TacheView implements ActionListener{
	private JFrame frame = null;
	private JPanel contentPane = null;
	private JTextField nom = null;
	private JTextField responsable = null;
	private JFormattedTextField budget = null;
	private JFormattedTextField objectif = null;
	private JFormattedTextField resultats = null;
	private JFormattedTextField charge = null;
	private JFormattedTextField dteDebSooner = null;
	private JFormattedTextField dteDebLater = null;
	private JFormattedTextField dteFinSooner = null;
	private JFormattedTextField dteFinLater = null;
	private JButton button = null;
	private NumberFormat format = null;
	
	public JFrameTache(TacheController controller){
		this(controller, null);
	}
	public JFrameTache(TacheController controller, TacheModel model){
		super(controller);
		buildFrame(model);
	}
	
	private void buildFrame(TacheModel model){
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
		formulaire.add(new JLabel("Budget"));
		budget = new JFormattedTextField(format);
		budget.setValue(model.getBudget());
		formulaire.add(budget);
		formulaire.add(new JLabel("Objectif"));
		objectif = new JFormattedTextField(format);
		objectif.setText(model.getObjectif());
		formulaire.add(objectif);
		formulaire.add(new JLabel("Resultats"));
		resultats = new JFormattedTextField(format);
		resultats.setText(model.getResultat());
		formulaire.add(resultats);
		formulaire.add(new JLabel("Charge"));
		charge = new JFormattedTextField(format);
		charge.setText(model.getCharge());
		formulaire.add(charge);
		formulaire.add(new JLabel("DateDebSooner"));
		dteDebSooner = new JFormattedTextField(format);
		dteDebSooner.setText(model.getDateDebSooner());
		formulaire.add(dteDebSooner);
		formulaire.add(new JLabel("DateDebLater"));
		dteDebLater = new JFormattedTextField(format);
		dteDebLater.setText(model.getDateDebLater());
		formulaire.add(dteDebLater);
		formulaire.add(new JLabel("DateFinSooner"));
		dteFinSooner = new JFormattedTextField(format);
		dteFinSooner.setText(model.getDateFinSooner());
		formulaire.add(dteFinSooner);
		formulaire.add(new JLabel("DateFinLater"));
		dteFinLater = new JFormattedTextField(format);
		dteFinLater.setText(model.getDateFinLater());
		formulaire.add(dteFinLater);
		
		contentPane.add(formulaire, BorderLayout.CENTER);
		
		button = new JButton("Enregistrer");
		button.addActionListener(this);
		contentPane.add(button, BorderLayout.SOUTH);
		
		frame.setContentPane(contentPane);
		frame.setTitle("JFrameFieldTaches");
		frame.setMinimumSize(new Dimension(250,450));
		frame.pack();
	}
	public void nameChanged(TacheNameChangedEvent event) {
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
