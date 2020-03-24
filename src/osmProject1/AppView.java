package osmProject1;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.GridLayout;


public class AppView extends JFrame implements ActionListener {

	/* Attributes */
	
	public AppView() {
		
		this.setFrame();
		this.setGui();
		this.setMenu();
		
		
	}
	
	/*			METHOD FOR WINDOW CLOSING */
	public void actionPerformed(ActionEvent evt) {
		if (evt.getActionCommand().equals("Zamknij")) {
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}
	}
	
	
	
	
	private void setGui() {
		
		JPanel mainPanel = new JPanel();
		this.getContentPane().add(mainPanel);
		mainPanel.setPreferredSize(new Dimension(1000, 600));
		mainPanel.setBackground(Color.gray);
		this.pack();
		
		GridLayout mainLayout = new GridLayout(2, 1);
		mainPanel.setLayout(mainLayout);
		
		
		JPanel patientPanel = new JPanel();
		mainPanel.add(patientPanel);
		patientPanel.setBackground(Color.gray);
		patientPanel.setPreferredSize(new Dimension(300, 400));
		patientPanel.setBorder(BorderFactory.createTitledBorder("Dane pacjenta"));
		
		JPanel examPanel = new JPanel();
		mainPanel.add(examPanel);
		examPanel.setPreferredSize(new Dimension(300, 500));
		examPanel.setBorder(BorderFactory.createTitledBorder("Badanie"));
		
		JPanel listPanel = new JPanel();
		mainPanel.add(listPanel);
		listPanel.setPreferredSize(new Dimension(700, 600));
		listPanel.setBorder(BorderFactory.createTitledBorder("Lista pacjentow"));
		
		
		
	}
	
	private void setFrame() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setVisible(true);
		this.setTitle("Rejestracja wynikow badan");
	}
	
	private void setMenu() {
		
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		menuBar.setVisible(true);
		
		JMenu menu = new JMenu("Aplikacja");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("Zamknij");
		//menuItem.addActionListener(this);				//add thread handling   need AppControler for proper work
		menu.add(menuItem);
	}
	


}
