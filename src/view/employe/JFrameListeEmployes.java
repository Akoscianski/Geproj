package view.employe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import model.employe.EmployeModel;
import model.employe.ListeEmployesModel;
import controller.employe.ListeEmployesController;
import controller.employe.ListeEmployesView;

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
		DefaultListModel<EmployeModel> model = new DefaultListModel<EmployeModel>();
		for(EmployeModel e : employes.getListe()){
			model.addElement(e); 
		}
		frame = new JFrame("Choisir un employé");
		contentPane = new JPanel(new BorderLayout());
		liste = new JList(model);
		ListCellRenderer renderer = new ListeEmployeRender();
	    liste.setCellRenderer(renderer);
		contentPane.add(liste, BorderLayout.CENTER);
		choose = new JButton("Chosir");
		choose.addActionListener(this);
		contentPane.add(choose, BorderLayout.SOUTH);
		
		frame.setContentPane(contentPane);
		frame.setMinimumSize(new Dimension(200,400));
		frame.pack();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Chosir"){
			getController().notifyChoice((EmployeModel)liste.getSelectedValue());
			frame.dispose();
		}
		
	}
	
	public void display() {
		frame.setVisible(true);
		
	}
	
	public void close() {
		frame.dispose();
		
	}
	
	
}
