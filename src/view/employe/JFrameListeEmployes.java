package view.employe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

import controller.employe.ListeEmployesController;
import controller.employe.ListeEmployesView;
import model.employe.EmployeModel;
import model.employe.ListeEmployesModel;

public class JFrameListeEmployes extends ListeEmployesView implements ActionListener{
	private JFrame frame = null;
	private JPanel contentPane = null;
	private JList liste = null;
	private JButton choose = null;
	
	public JFrameListeEmployes(ListeEmployesController controller, ListeEmployesModel employes) {
		super(controller);
		buidFrame(employes);
	}
	private void buidFrame(ListeEmployesModel employes) {
		frame = new JFrame("Choisir un employé");
		contentPane = new JPanel(new BorderLayout());
		liste = new JList();
		contentPane.add(liste, BorderLayout.CENTER);
		choose = new JButton("Chosir");
		contentPane.add(choose, BorderLayout.SOUTH);
		
		frame.setContentPane(contentPane);
		frame.setMinimumSize(new Dimension(200,400));
		frame.pack();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void display() {
		frame.setVisible(true);
		
	}
	
	public void close() {
		frame.dispose();
		
	}
	
	
}
