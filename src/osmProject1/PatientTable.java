package osmProject1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.*;

public class PatientTable extends JPanel implements ActionListener {

	private myTable tableModel;
	private JTable table;
	private ArrayList<Patient> patient;
	
	public PatientTable() {
		initializePanel();
		
	}
	
	private void initializePanel() {
		myTable model = new myTable(patient);
		
		JTable table = new JTable(model);
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		
		this.setPreferredSize(new Dimension(380,350));
		this.setLayout(new BorderLayout());
		this.add(scrollPane, BorderLayout.CENTER);
		this.setVisible(true);
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}

}



/*
public PatientTable(String title) {
	super(title);
	setBounds(10,10,400,300);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	patient=new ArrayList<>();
	tableModel = new myTable(patient);
	table.setAutoCreateRowSorter(true);
	JScrollPane scrollPane = new JScrollPane(table);
	scrollPane.setPreferredSize(new Dimension (380, 280));
	
//	JPanel panel = new JPanel();
//	panel.add(scrollPane);
//	add(panel, BorderLayout.CENTER);
	}

*/
