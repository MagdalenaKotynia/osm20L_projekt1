package osmProject1;
import javax.swing.*;
import java.awt.*;


public class AppView extends JFrame {

	/* Attributes */
	
	public AppView() {
		
		this.setFrame();
		this.setGui();
		this.setMenu();
		this.setPatientPanel();
		
		
		
		
		/*
		
		
		
		
		JMenuBar menu = new JMenuBar();
		mainPanel.add(BorderLayout.NORTH, menu);
		
		
		JPanel patientPanel = new JPanel();
		mainPanel.add(BorderLayout.WEST, patientPanel);
		patientPanel.setBackground(Color.red);
		patientPanel.setPreferredSize(new Dimension(300, 400));
		
		
		patientPanel.setBorder(BorderFactory.createTitledBorder("Pacjent"));
		
		
		*/
	}
	
	private void setGui() {
		
		JPanel mainPanel = new JPanel();
		this.getContentPane().add(mainPanel);
		mainPanel.setPreferredSize(new Dimension(800, 600));
		mainPanel.setBackground(Color.gray);
		this.pack();
		
		mainPanel.setLayout(new BorderLayout());
		
		
	}
	
	private void setFrame() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setVisible(true);
		this.setTitle("Rejestracja wyników badań");
	}
	
	private void setMenu() {
		
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		menuBar.setVisible(true);
		
		JMenu menu = new JMenu("Aplikacja");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("Zamknij");
		// menuItem.addActionListener(this);				//add thread handling
		menu.add(menuItem);
	}
	
	private void setPatientPanel() {
		
	}
	

}
