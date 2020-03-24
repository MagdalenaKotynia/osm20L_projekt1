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
		this.setMenu();
		this.setGui();
		
		
		
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
		
		
		// setting layout of JPanels
				GridBagLayout mainLayout = new GridBagLayout();
				mainPanel.setLayout(mainLayout);
				GridBagConstraints c = new GridBagConstraints();
		
		
		// Creating JPanel for each part of an app
				
		//Patient Panel
		JPanel patientPanel = new JPanel();
		c.fill=GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		mainPanel.add(patientPanel,c);
		patientPanel.setPreferredSize(new Dimension(400, 350));
		patientPanel.setBorder(BorderFactory.createTitledBorder("Dane pacjenta"));
		
		// Examination Panel
		JPanel examPanel = new JPanel();
		c.fill=GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx=0;
		c.gridy=1;
		mainPanel.add(examPanel,c);
		examPanel.setPreferredSize(new Dimension(00, 250));
		examPanel.setBorder(BorderFactory.createTitledBorder("Badanie"));
		
		// List Panel
		JPanel listPanel = new JPanel();
		c.fill=GridBagConstraints.BOTH;
		c.weightx = 1;
		c.weighty = 1;
		c.gridx=1;
		c.gridy=0;
		c.gridheight=2;
		mainPanel.add(listPanel,c);
		listPanel.setPreferredSize(new Dimension(600, 200));
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
