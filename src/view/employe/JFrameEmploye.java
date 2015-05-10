package view.employe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.employe.EmployeModel;
import model.employe.EmployeNameChangedEvent;
import controller.employe.EmployeController;
import controller.employe.EmployeView;

public class JFrameEmploye extends EmployeView implements ActionListener{
	private JFrame frame = null;
	private JPanel contentPane = null;
	private JTextField nom = null;
	private JTextField prenom = null;
	private JTextField competences = null;
	DateFormat format1 = null;
	//private JFormattedTextField naissance = null;
	private JComboBox jours;
	private JComboBox mois;
	private JComboBox annee;
	private JPanel date;
	private JTextField salaire = null;
	private JTextField heures_contrat = null;
	private JButton envoyer = null;
	private NumberFormat format = null;
	
	public JFrameEmploye(EmployeController controller){
		this(controller, null);
	}
	public JFrameEmploye(EmployeController controller, EmployeModel model){
		super(controller);
		buildFrame(model);
	}
	
	private void buildFrame(EmployeModel model){
		frame = new JFrame();
		contentPane = new JPanel(new BorderLayout());
		JPanel formulaire = new JPanel(new GridLayout(10,1));
		
		
		format = NumberFormat.getNumberInstance();
		format.setParseIntegerOnly(true);
		format.setGroupingUsed(false);
		format.setMaximumFractionDigits(0);
		format.setMaximumIntegerDigits(12);
		
		formulaire.add(new JLabel("Nom"));
		nom = new JTextField();
		nom.setText(model.getNom());
		formulaire.add(nom);
		
		formulaire.add(new JLabel("Prenom"));
		prenom = new JTextField();
		prenom.setText(model.getPrenom());
		formulaire.add(prenom);
		
		formulaire.add(new JLabel("Competences"));
		competences = new JTextField();
		competences.setText(model.getCompetences());
		formulaire.add(competences);
		
		format1 = new SimpleDateFormat("dd/MM/yyyy");
		formulaire.add(new JLabel("Naissance"));
		date = new JPanel();
		jours = new JComboBox();
		for (int i = 1; i<= 31; i++){
			if(i<10){
				jours.addItem("0"+i);
			}else{
				jours.addItem(i);
			}
		}
		date.add(jours);
		mois = new JComboBox();
		for(int i = 1; i< 13; i++){
			if(i<10){
				mois.addItem("0"+i);
			}else{
				mois.addItem(i);
			}
		}
		date.add(mois);
		
		annee = new JComboBox();
		for(int i=Calendar.getInstance().get(Calendar.YEAR) - 16; i>= 1940; i--){
			annee.addItem(i);
		}
		date.add(annee);
		
		formulaire.add(date);
		
		formulaire.add(new JLabel("Salaire"));
		salaire = new JTextField();
		salaire.setText(model.getCompetences());
		formulaire.add(salaire);
		
		formulaire.add(new JLabel("Heures contrat"));
		heures_contrat = new JTextField();
		heures_contrat.setText(model.getCompetences());
		formulaire.add(heures_contrat);
		
		contentPane.add(formulaire, BorderLayout.CENTER);
		
		envoyer = new JButton("Envoyer");
		envoyer.addActionListener(this);
		contentPane.add(envoyer, BorderLayout.SOUTH);
		
		frame.setContentPane(contentPane);
		frame.setTitle("Nouvel employé");
		frame.setMinimumSize(new Dimension(640,480));
		frame.pack();
	}
	@Override
	public void nameChanged(EmployeNameChangedEvent event) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String newName = nom.getText();
		String newPrenom = prenom.getText();
		String newCompetences = competences.getText();
		String newBirth = jours.getSelectedItem()+"/"+mois.getSelectedItem()+"/"+annee.getSelectedItem();
		float newSalaire = Float.parseFloat(salaire.getText());
		float newHeureContract = Float.parseFloat(heures_contrat.getText());
		getController().notifyNewEmploye(newName, newPrenom, newCompetences, newBirth, newSalaire, newHeureContract);
		frame.dispose();
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
