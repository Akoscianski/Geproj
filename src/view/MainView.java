package view;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainView {
	JFrame frame;
	JPanel cp;
	
	public MainView(){
		frame = new JFrame("Geproj");
		frame.setSize(new Dimension(800,600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cp = new JPanel();
		frame.setVisible(true);
	}
	

}
