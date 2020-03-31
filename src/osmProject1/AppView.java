package osmProject1;
import javax.swing.*;
<<<<<<< src/osmProject1/AppView.java
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
=======

>>>>>>> src/osmProject1/AppView.java
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.GridLayout;

import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.Calendar;
import java.util.Date;


public class AppView extends JFrame implements ActionListener {

	/* Attributes */
	private JTextField mNameTxt, mSurnameTxt, mPESELTxt, mBloodGlucoseLevelTxt, mUrineSugarLevelTxt;
	private JLabel mNameLabel, mSurnameLabel, mPESELLabel, mGenderLabel, mInsuranceLabel, mDateLabel,  
	mGhbPresenceLabel, mBloodGlucoseLevelLabel, mUrineSugarLevelLabel;
	private JButton mSaveButton, mCancellButton;
	private JRadioButton mMaleButton, mFemaleButton;
	private JComboBox<String> mInsuranceBox;
	private Border mPatientBorder;
	private ButtonGroup mGenderGroup;
	private Box mGenderBox;
	private JPanel mMainPanel, mMinorPanel, mSuperPatientPanel, mPatientPanel, mExaminationPanel, mPatientListPanel;
	private JTable mPatientTable;
	
	private String[] columnNames; //?? czy aby tak
	private ArrayList<Patient> mData;; //czy aby tak
	
	
	// constructor
	public AppView() {
		this.initializeElements();
		this.setFrame();
		this.setMenu();
<<<<<<< src/osmProject1/AppView.java
		
		/*this.setPatientPanel();
		
		
		
=======
		this.setGui();
		
		
		
	}
	
	/*			METHOD FOR WINDOW CLOSING  not implemented yet but it will be used */
	public void actionPerformed(ActionEvent evt) {
		if (evt.getActionCommand().equals("Zamknij")) {
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}
	}
	
	
	
	
	private void setGui() {
		
		// Main Panel for placing other panels
		JPanel mainPanel = new JPanel();
		this.getContentPane().add(mainPanel);
		mainPanel.setPreferredSize(new Dimension(1000, 600));
		mainPanel.setBackground(Color.gray);
		this.pack();
>>>>>>> src/osmProject1/AppView.java
		
		/*
		
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
		patientPanel.setBorder(BorderFactory.createTitledBorder("Dane pacjenta"));
		
		// Examination Panel
		JPanel examPanel = new JPanel();
		c.fill=GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx=0;
		c.gridy=1;
		mainPanel.add(examPanel,c);
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
		listPanel.setBorder(BorderFactory.createTitledBorder("Lista pacjentow"));
		
		// Setting layout for patient panel
		GroupLayout patientLayout = new GroupLayout(patientPanel);
		patientPanel.setLayout(patientLayout);
		
		// patient panel components
		JLabel name = new JLabel("Imie:");
		JTextField nameTextField = new JTextField();
		JLabel surname = new JLabel("Nazwisko:");
		JTextField surnameTextField = new JTextField();
		JLabel pesel = new JLabel("PESEL:");
		JTextField peselTextField = new JTextField();
		JLabel gender = new JLabel("Plec:");
		JLabel insurance =  new JLabel("Ubezpieczenie:");
		
		
		patientLayout.setAutoCreateGaps(true);
		// not working
		//patientLayout.setHorizontalGroup(patientLayout.createSequentialGroup().addGroup(patientLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(name).addComponent(surname).addComponent(pesel).addComponent(gender).addComponent(gender)));
		
		
		
<<<<<<< src/osmProject1/AppView.java
		*/
		
	}
	
	private void setGui() {
		
	
		this.getContentPane().add(mMainPanel);
		mMainPanel.setPreferredSize(new Dimension(800, 600));
		mMainPanel.setBackground(Color.gray);
		this.pack();
		
		mMainPanel.setLayout(new GridLayout(1,2));
		
		
		mMinorPanel.setLayout(new GridLayout(2,1));
		
		mSuperPatientPanel.setBorder(new TitledBorder(new LineBorder(Color.black, 1),
		        "Pacjent"));
		
		
		mExaminationPanel.setBorder(new TitledBorder(new LineBorder(Color.black,1),"Badanie"));
		
		
	
		mPatientListPanel.setBorder(new TitledBorder(new LineBorder(Color.black,1),"Lista Pacjentow"));
		
		mMinorPanel.add(mSuperPatientPanel);
		mMinorPanel.add(mExaminationPanel);
		mMainPanel.add(mMinorPanel);
		
		
		mMainPanel.add(mPatientListPanel);
//		GroupLayout layout = new GroupLayout(mPatientPanel);
//		layout.setAutoCreateGaps(true);
//		layout.setHorizontalGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(mNameLabel).addComponent(mSurnameLabel).addComponent(mPESELLabel)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(mNameTxt).addComponent(mSurnameTxt).addComponent(mPESELTxt)));
//		layout.setVerticalGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(mNameLabel).addComponent(mNameTxt)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(mSurnameLabel).addComponent(mSurnameTxt)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(mPESELLabel).addComponent(mPESELTxt)));
		
//		mPatientPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
//		mPatientPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
	
		mSuperPatientPanel.setLayout(new BoxLayout(mSuperPatientPanel,BoxLayout.Y_AXIS));
		

		mPatientPanel.setLayout(new BoxLayout(mPatientPanel,BoxLayout.X_AXIS));
		mSuperPatientPanel.add(mPatientPanel);
		mNameLabel.setPreferredSize(new Dimension(90,25));
		mNameLabel.setMinimumSize(new Dimension(90,25));
		mNameLabel.setMaximumSize(new Dimension(90,25));
		mPatientPanel.add(mNameLabel);
		
		mPatientPanel.add(Box.createHorizontalGlue());
		mNameTxt.setPreferredSize(new Dimension(180,20));
		mNameTxt.setMinimumSize(new Dimension(180,20));
		mNameTxt.setMaximumSize(new Dimension(180,20));
		mPatientPanel.add(mNameTxt);
		
		mPatientPanel = new JPanel();		//po co
		mPatientPanel.setLayout(new BoxLayout(mPatientPanel,BoxLayout.X_AXIS));
		mSuperPatientPanel.add(mPatientPanel);
		
		mSurnameLabel.setPreferredSize(new Dimension(90,25));
		mSurnameLabel.setMinimumSize(new Dimension(90,25));
		mSurnameLabel.setMaximumSize(new Dimension(90,25));
		mPatientPanel.add(mSurnameLabel);
		
		mPatientPanel.add(Box.createHorizontalGlue());
		mSurnameTxt.setPreferredSize(new Dimension(180,20));
		mSurnameTxt.setMinimumSize(new Dimension(180,20));
		mSurnameTxt.setMaximumSize(new Dimension(180,20));
		mPatientPanel.add(mSurnameTxt);
		
	
		mPatientPanel = new JPanel();		//po co
		mPatientPanel.setLayout(new BoxLayout(mPatientPanel,BoxLayout.X_AXIS));
		mSuperPatientPanel.add(mPatientPanel);
		
		mPESELLabel.setPreferredSize(new Dimension(90,25));
		mPESELLabel.setMinimumSize(new Dimension(90,25));
		mPESELLabel.setMaximumSize(new Dimension(90,25));
		mPatientPanel.add(mPESELLabel);
		
		mPatientPanel.add(Box.createHorizontalGlue());
		mPESELTxt.setPreferredSize(new Dimension(180,20));
		mPESELTxt.setMinimumSize(new Dimension(180,20));
		mPESELTxt.setMaximumSize(new Dimension(180,20));
		mPatientPanel.add(mPESELTxt);
		

		
		mPatientPanel = new JPanel();
		mPatientPanel.setLayout(new BoxLayout(mPatientPanel,BoxLayout.X_AXIS));
		mSuperPatientPanel.add(mPatientPanel);
		
		mGenderLabel.setPreferredSize(new Dimension(90,25));
		mGenderLabel.setMaximumSize(new Dimension(90,25));
		mGenderLabel.setMinimumSize(new Dimension(90,25));
		mPatientPanel.add(mGenderLabel);
		
		mPatientPanel.add(Box.createHorizontalGlue());
		mGenderGroup.add(mMaleButton);
		mGenderGroup.add(mFemaleButton);
		mPatientPanel.add(mMaleButton);
		mPatientPanel.add(mFemaleButton);
		
		
		mPatientPanel = new JPanel();
		mPatientPanel.setLayout(new BoxLayout(mPatientPanel, BoxLayout.X_AXIS));
		mSuperPatientPanel.add(mPatientPanel);
		
		mInsuranceLabel.setPreferredSize(new Dimension(90,25));
		mInsuranceLabel.setMaximumSize(new Dimension(90,25));
		mInsuranceLabel.setMinimumSize(new Dimension(90,25));
		mPatientPanel.add(mInsuranceLabel);
		
		mPatientPanel.add(Box.createHorizontalGlue());				//czy to tak?
		//mInsuranceBox = this.createInsuranceComboBox();
		mInsuranceBox.setPreferredSize(new Dimension(180,20));
		mInsuranceBox.setMinimumSize(new Dimension(180,20));
		mInsuranceBox.setMaximumSize(new Dimension(180,20));
		mPatientPanel.add(mInsuranceBox);
		
	
		mPatientPanel = new JPanel();
		mPatientPanel.setLayout(new BoxLayout(mPatientPanel, BoxLayout.X_AXIS));
		mSuperPatientPanel.add(mPatientPanel);
		
		
		mPatientPanel.add(mSaveButton);
		mPatientPanel.add(mCancellButton);
		mPatientPanel.add(Box.createHorizontalGlue());
		
		mPatientListPanel.add(mPatientTable);
		mPatientListPanel.setLayout(new BorderLayout());
		mPatientListPanel.add(mPatientTable.getTableHeader(), BorderLayout.PAGE_START);
		mPatientListPanel.add(mPatientTable, BorderLayout.CENTER);
		
		
		
//		UtilDateModel model = new UtilDateModel();
//		//model.setDate(20,04,2014);
//		// Need this...
//		Properties p = new Properties();
//		p.put("text.today", "Today");
//		p.put("text.month", "Month");
//		p.put("text.year", "Year");
//		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
//		// Don't know about the formatter, but there it is...
//		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
//		
		
		
		
=======
		
		

		
>>>>>>> src/osmProject1/AppView.java
		
		
	}
	
	private void setFrame() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setVisible(true);
<<<<<<< src/osmProject1/AppView.java
		this.setTitle("Rejestracja wynikow badania");
=======
		this.setTitle("Rejestracja wynikow badan");
>>>>>>> src/osmProject1/AppView.java
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
	
<<<<<<< src/osmProject1/AppView.java
	private void setPatientPanel(JPanel patientPanel) {
		patientPanel = new JPanel();
		patientPanel.setBorder(new TitledBorder(new LineBorder(Color.black, 5),
		        "Pacjent"));
		
		
		
	
		
	}
	
	private void initializeElements()
	{
		mMainPanel = new JPanel();
		mSuperPatientPanel = new JPanel();
		mPatientPanel = new JPanel();
		mExaminationPanel = new JPanel();
		mPatientListPanel = new JPanel();
		mMinorPanel = new JPanel();
		this.mNameLabel = new JLabel("Imie:");
		this.mSurnameLabel = new JLabel("Nazwisko:");
		this.mPESELLabel = new JLabel("PESEL:");
		this.mGenderLabel = new JLabel("Plec:");
		this.mInsuranceLabel = new JLabel("Ubezpieczenie:");
		this.mNameTxt = new JTextField(20);
		this.mSurnameTxt = new JTextField(20);
		this.mPESELTxt = new JTextField(20);
		this.mMaleButton = new JRadioButton("Mezczyzna");
		this.mFemaleButton = new JRadioButton("Kobieta");
		this.mGenderGroup = new ButtonGroup();
		String[] InsuranceTypes = new String[] {"NFZ", "Prywatne", "Brak"};
		this.mInsuranceBox = new JComboBox<String>(InsuranceTypes);
		this.mSaveButton = new JButton("Zapisz");
		this.mCancellButton = new JButton("Anuluj");
		this.mBloodGlucoseLevelLabel = new JLabel("Stezenie glukozy we krwi:");
		this.mGhbPresenceLabel = new JLabel("Obecnosc glikowanej hemoglobiny GHB:");
		this.mUrineSugarLevelLabel = new JLabel("Poziom cukru w moczu");
		this.mData = new ArrayList();
		
		columnNames = new String[] {"Imie i Nazwisko","Plec", "PESEL","Ubezpieczenie","Badanie"} ;//czy tedy droga
		this.mPatientTable = new JTable(new PatientTableModel(mData));	//czy tedy droga
		
		//initialize method 
		//label dimension czy deklarowac
		
	}
	
//	JComboBox<String> createInsuranceComboBox()
//	{
//		mInsuranceBox = new JComboBox<String>();
//		mInsuranceBox.addItem("NFZ");
//		mInsuranceBox.addItem("Prywatne");
//		mInsuranceBox.addItem("Brak");
//		mInsuranceBox.setPreferredSize(new Dimension(180,20));
//		mInsuranceBox.setMinimumSize(new Dimension(180,20));
//		mInsuranceBox.setMaximumSize(new Dimension(180,20));
//		return(mInsuranceBox);
//		
//	}
	
=======

>>>>>>> src/osmProject1/AppView.java

}
