package view.lot;

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

import model.lot.LotNameChangedEvent;
import model.lot.LotsModel;
import controller.lot.LotController;
import controller.lot.LotView;

public class JFrameLot extends LotView implements ActionListener{
	private JFrame frame = null;
	private JPanel contentPane = null;
	private JTextField nom = null;
	private JTextField responsable = null;
	private JFormattedTextField budget = null;
	private JButton button = null;
	private NumberFormat format = null;
	
	public JFrameLot(LotController controller){
		this(controller, null);
	}
	public JFrameLot(LotController controller, LotsModel model){
		super(controller);
		buildFrame(model);
	}
	
	private void buildFrame(LotsModel model){
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
		
		contentPane.add(formulaire, BorderLayout.CENTER);
		
		button = new JButton("Enregistrer");
		button.addActionListener(this);
		contentPane.add(button, BorderLayout.SOUTH);
		
		frame.setContentPane(contentPane);
		frame.setTitle("JFrameFieldLots");
		frame.setMinimumSize(new Dimension(250,250));
		frame.pack();
	}
	public void nameChanged(LotNameChangedEvent event) {
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
