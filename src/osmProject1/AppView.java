package osmProject1;
import javax.swing.*;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.Calendar;
import java.util.Date;
import com.toedter.*;
import com.toedter.calendar.*;

public class AppView extends JFrame implements ActionListener {

	/* Attributes */
	private JTextField mNameTxt, mSurnameTxt, mPESELTxt, mBloodGlucoseLevelTxt, mUrineSugarLevelTxt;
	private JLabel mNameLabel, mSurnameLabel, mPESELLabel, mGenderLabel, mInsuranceLabel, mDateLabel,  
	mGhbPresenceLabel, mBloodGlucoseLevelLabel, mUrineSugarLevelLabel;
	private JButton mSaveButton, mCancellButton, mSaveExamButton, mCancelExamButton;
	private JRadioButton mMaleButton, mFemaleButton;
	private JComboBox<String> mInsuranceBox;
	//private Border mPatientBorder;
	private ButtonGroup mGenderGroup;
	//private Box mGenderBox;
	private JPanel mMainPanel, mMinorPanel, mSuperPatientPanel, mPatientPanel, mExaminationPanel, mPatientListPanel;
	private JTable mPatientTable;
	private JCheckBox mGhbCheckBox;
	private JDateChooser mDateCalendar;
	
	private String[] columnNames; //?? czy aby tak
	private ArrayList<Patient> mData;; //czy aby tak
	
	
	// constructor
	public AppView() {
		this.initializeElements();
		this.setFrame();
		this.setMenu();
		this.setGui();
	}

		
	
	private void setGui() {
		
	// mainPanel
		this.getContentPane().add(mMainPanel);
		mMainPanel.setPreferredSize(new Dimension(800, 450));
		mMainPanel.setBackground(Color.gray);
		this.pack();
		
		// mainPanel layout
		mMainPanel.setLayout(new GridLayout(1,2));	
		mMinorPanel.setLayout(new GridLayout(2,1));
		
		// setting border text for minor panels
		mSuperPatientPanel.setBorder(new TitledBorder(new LineBorder(Color.black, 1),
		        "Pacjent"));	
		mExaminationPanel.setBorder(new TitledBorder(new LineBorder(Color.black,1),"Badanie"));
		mPatientListPanel.setBorder(new TitledBorder(new LineBorder(Color.black,1),"Lista Pacjentow"));
		
		// adding minor Panels to mainPanel
		mMinorPanel.add(mSuperPatientPanel);
		mMinorPanel.add(mExaminationPanel);
		mMainPanel.add(mMinorPanel);
		
		
		mMainPanel.add(mPatientListPanel);

		// major patientPanel settings
		mSuperPatientPanel.setLayout(new BoxLayout(mSuperPatientPanel,BoxLayout.Y_AXIS));
		mPatientPanel.setLayout(new BoxLayout(mPatientPanel,BoxLayout.X_AXIS));
		mSuperPatientPanel.add(mPatientPanel);
		mNameLabel.setPreferredSize(new Dimension(90,25));
		mNameLabel.setMinimumSize(new Dimension(90,25));
		mNameLabel.setMaximumSize(new Dimension(90,25));
		mPatientPanel.add(mNameLabel);
		// minor patientPanel settings
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
		
		
		// examPanel
		GridBagLayout examLayout = new GridBagLayout();
		mExaminationPanel.setLayout(examLayout);
		GridBagConstraints constraints = new GridBagConstraints();
		
		
		constraints.fill=GridBagConstraints.BOTH;
		constraints.insets= new Insets(10,0,0,10);
		constraints.weightx=0.1;
		constraints.weighty=0.1;
		constraints.gridwidth = 2;
		constraints.gridx=0;
		constraints.gridy=0;
		mExaminationPanel.add(mDateLabel, constraints);
		
		constraints.gridwidth = 1;
		constraints.gridx=2;
		constraints.gridy=0;
		mExaminationPanel.add(mDateCalendar, constraints);
		
		constraints.gridwidth = 2;
		constraints.gridx=0;
		constraints.gridy=1;
		mExaminationPanel.add(mBloodGlucoseLevelLabel, constraints);
		
		constraints.gridwidth = 1;
		constraints.gridx=2;
		constraints.gridy=1;
		mExaminationPanel.add(mBloodGlucoseLevelTxt, constraints);
		
		constraints.gridwidth = 2;
		constraints.gridx=0;
		constraints.gridy=2;
		mExaminationPanel.add(mGhbPresenceLabel, constraints);
		
		
		constraints.gridwidth = 1;
		constraints.gridx=2;
		constraints.gridy=2;
		mExaminationPanel.add(mGhbCheckBox, constraints);
		
		constraints.gridwidth = 2;
		constraints.gridx=0;
		constraints.gridy=3;
		mExaminationPanel.add(mUrineSugarLevelLabel, constraints);
		
		constraints.gridwidth = 1;
		constraints.gridx=2;
		constraints.gridy=3;
		mExaminationPanel.add(mUrineSugarLevelTxt, constraints);
		
		constraints.fill=GridBagConstraints.NONE;
		constraints.anchor=GridBagConstraints.LAST_LINE_START;
		constraints.insets= new Insets(5,0,5,5);
		constraints.gridx=0;
		constraints.gridy=4;
		mExaminationPanel.add(mSaveExamButton, constraints);
		
		constraints.insets= new Insets(5,5,5,5);
		constraints.gridx=1;
		constraints.gridy=4;
		mExaminationPanel.add(mCancelExamButton, constraints);
		
	}
	
	private void setFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 450);
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
	

	private void initializeElements()
	{
		// JPanels for patient panel
		mMainPanel = new JPanel();
		mSuperPatientPanel = new JPanel();
		mPatientPanel = new JPanel();
		mExaminationPanel = new JPanel();
		mPatientListPanel = new JPanel();
		mMinorPanel = new JPanel();
		// JLabels for patient panel
		this.mNameLabel = new JLabel("Imie:");
		this.mSurnameLabel = new JLabel("Nazwisko:");
		this.mPESELLabel = new JLabel("PESEL:");
		this.mGenderLabel = new JLabel("Plec:");
		this.mInsuranceLabel = new JLabel("Ubezpieczenie:");
		// JtextFields and such
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

	// Table 
		this.mData = new ArrayList<>(); // added <>
		columnNames = new String[] {"Imie i Nazwisko","Plec", "PESEL","Ubezpieczenie","Badanie"} ;//czy tedy droga
		this.mPatientTable = new JTable(new PatientTableModel(mData));	//czy tedy droga
		
		
		// mExaminationPanel components 
		//Labels
		this.mBloodGlucoseLevelLabel = new JLabel("Stezenie glukozy we krwi: ");
		this.mGhbPresenceLabel = new JLabel("GHB:");
		this.mUrineSugarLevelLabel = new JLabel("Poziom cukru w moczu: ");
		this.mDateLabel = new JLabel("Data:");
		//Text fields and such
		this.mBloodGlucoseLevelTxt = new JTextField(10);
		this.mUrineSugarLevelTxt = new JTextField(10);
		this.mGhbCheckBox = new JCheckBox();
		this.mDateCalendar = new JDateChooser();
		//Buttons
		this.mSaveExamButton = new JButton("Zapisz");
		this.mCancelExamButton = new JButton("Anuluj");
		
	}
	


	
	// ========================================================================================= trash code for possible reuse
	
	
	/*			METHOD FOR WINDOW CLOSING  not implemented yet but it will be used */
	public void actionPerformed(ActionEvent evt) {
		if (evt.getActionCommand().equals("Zamknij")) {
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}
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
	
//	UtilDateModel model = new UtilDateModel();
//	//model.setDate(20,04,2014);
//	// Need this...
//	Properties p = new Properties();
//	p.put("text.today", "Today");
//	p.put("text.month", "Month");
//	p.put("text.year", "Year");
//	JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
//	// Don't know about the formatter, but there it is...
//	JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
//	
		
	
	
	
	
	//private void setGui() {
	
	// Main Panel for placing other panels
//	JPanel mainPanel = new JPanel();
//	this.getContentPane().add(mainPanel);
//	mainPanel.setPreferredSize(new Dimension(1000, 600));
//	mainPanel.setBackground(Color.gray);
//	this.pack();
	
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
	
	*/
	
//}
	
	
//	private void setPatientPanel(JPanel patientPanel) {
//		patientPanel = new JPanel();
//		patientPanel.setBorder(new TitledBorder(new LineBorder(Color.black, 5),
//		        "Pacjent"));
				
//	}
	
	
	
	
	

}
