package osmProject1;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.*;



public class AppView extends JFrame  {

	/* Attributes */
	protected JTextField mNameTxt, mSurnameTxt, mPESELTxt, mBloodGlucoseLevelTxt, mUrineSugarLevelTxt;
	private JLabel mNameLabel, mSurnameLabel, mPESELLabel, mGenderLabel, mInsuranceLabel, mDateLabel,  
	mGhbPresenceLabel, mBloodGlucoseLevelLabel, mUrineSugarLevelLabel;
	protected JButton mSaveButton, mCancellButton, mSaveExamButton, mCancelExamButton, mAddButton, mDeleteButton;
	protected JRadioButton mMaleButton, mFemaleButton;
	protected JComboBox<String> mInsuranceBox;
	protected ButtonGroup mGenderGroup;
	private JPanel mMainPanel, mPatientPanel, mExaminationPanel, mPatientListPanel, testList;
	protected JCheckBox mGhbCheckBox;
	protected JDateChooser mDateCalendar;
	protected JTable table;
	protected ArrayList<Patient> mData;
	protected MyTable tableModel;
	protected JMenuBar menuBar;
	protected JMenu menu;
	protected JMenuItem menuItem;
	
	
	
	

	

	
	
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
		mMainPanel.setPreferredSize(new Dimension(900, 500));
		mMainPanel.setBackground(Color.gray);
		this.pack();
		
		
		
		// setting layout of JPanels
				GridBagLayout mainLayout = new GridBagLayout();
				mMainPanel.setLayout(mainLayout);
				GridBagConstraints c = new GridBagConstraints();
		
		
		//========================================================= Creating JPanel for each part of an app
				
		//Patient Panel
		c.fill=GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		mMainPanel.add(mPatientPanel,c);
		mPatientPanel.setBorder(BorderFactory.createTitledBorder("Dane pacjenta"));
		
		// Examination Panel
		c.fill=GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx=0;
		c.gridy=1;
		mMainPanel.add(mExaminationPanel,c);
		mExaminationPanel.setBorder(BorderFactory.createTitledBorder("Badanie"));
		
		// List Panel
		c.fill=GridBagConstraints.BOTH;
		c.weightx = 1;
		c.weighty = 1;
		c.gridx=1;
		c.gridy=0;
		c.gridheight=2;
		mMainPanel.add(mPatientListPanel,c);
		mPatientListPanel.setBorder(BorderFactory.createTitledBorder("Lista pacjentow"));
		
		
		//========================================================== patientPanel
		GridBagLayout patientLayout =new GridBagLayout();
		mPatientPanel.setLayout(patientLayout);
		GridBagConstraints patientConstraints = new GridBagConstraints();
		
		// Name
		patientConstraints.fill=GridBagConstraints.BOTH;
		patientConstraints.insets = new Insets(10, 0, 10, 10);
		patientConstraints.gridx=0;
		patientConstraints.gridy=0;
		patientConstraints.weightx=0.1;
		patientConstraints.weighty=0.1;
		patientConstraints.gridwidth=2;
		mPatientPanel.add(mNameLabel, patientConstraints);
		
		patientConstraints.gridx=3;
		patientConstraints.gridy=0;
		patientConstraints.gridwidth=2;
		mPatientPanel.add(mNameTxt, patientConstraints);
		
		// Surname
		patientConstraints.gridx=0;
		patientConstraints.gridy=1;
		patientConstraints.gridwidth=2;
		mPatientPanel.add(mSurnameLabel, patientConstraints);
	
		patientConstraints.gridx=3;
		patientConstraints.gridy=1;
		patientConstraints.gridwidth=2;
		mPatientPanel.add(mSurnameTxt, patientConstraints);
		
		// PESEL
		patientConstraints.gridx=0;
		patientConstraints.gridy=2;
		patientConstraints.gridwidth=2;
		mPatientPanel.add(mPESELLabel, patientConstraints);
		
		patientConstraints.gridx=3;
		patientConstraints.gridy=2;
		mPatientPanel.add(mPESELTxt, patientConstraints);
		
		// Gender
		patientConstraints.gridx=0;
		patientConstraints.gridy=3;
		mPatientPanel.add(mGenderLabel, patientConstraints);
		
		patientConstraints.gridx=3;
		patientConstraints.gridy=3;
		patientConstraints.gridwidth=1;
		mGenderGroup.add(mFemaleButton);
		mGenderGroup.add(mMaleButton);
		mPatientPanel.add(mFemaleButton, patientConstraints);
		patientConstraints.gridx=4;
		patientConstraints.gridy=3;
		patientConstraints.gridwidth=1;
		mPatientPanel.add(mMaleButton, patientConstraints);
		
		// Insurance
		
		patientConstraints.gridx=0;
		patientConstraints.gridy=4;
		patientConstraints.gridwidth=2;
		mPatientPanel.add(mInsuranceLabel, patientConstraints);
		
		patientConstraints.gridx=3;
		patientConstraints.gridy=4;
		mPatientPanel.add(mInsuranceBox, patientConstraints);
		
		// Buttons
		patientConstraints.gridx=0;
		patientConstraints.gridy=5;
		patientConstraints.gridwidth=1;
		mPatientPanel.add(mSaveButton, patientConstraints);
		patientConstraints.gridx=1;
		patientConstraints.gridy=5;
		mPatientPanel.add(mCancellButton, patientConstraints);
		
		//========================================================= examPanel
		GridBagLayout examLayout = new GridBagLayout();
		mExaminationPanel.setLayout(examLayout);
		GridBagConstraints constraints = new GridBagConstraints();
		
		
		// Date
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
		
		// Blood Glucose level
		constraints.gridwidth = 2;
		constraints.gridx=0;
		constraints.gridy=1;
		mExaminationPanel.add(mBloodGlucoseLevelLabel, constraints);
		
		constraints.gridwidth = 1;
		constraints.gridx=2;
		constraints.gridy=1;
		mExaminationPanel.add(mBloodGlucoseLevelTxt, constraints);
		
		// GHB
		constraints.gridwidth = 2;
		constraints.gridx=0;
		constraints.gridy=2;
		mExaminationPanel.add(mGhbPresenceLabel, constraints);
		
		
		constraints.gridwidth = 1;
		constraints.gridx=2;
		constraints.gridy=2;
		mExaminationPanel.add(mGhbCheckBox, constraints);
		
		// Urine sugar level
		constraints.gridwidth = 2;
		constraints.gridx=0;
		constraints.gridy=3;
		mExaminationPanel.add(mUrineSugarLevelLabel, constraints);
		
		constraints.gridwidth = 1;
		constraints.gridx=2;
		constraints.gridy=3;
		mExaminationPanel.add(mUrineSugarLevelTxt, constraints);
		
		//Buttons
		constraints.fill=GridBagConstraints.BOTH;
		constraints.anchor=GridBagConstraints.LAST_LINE_START;
		constraints.insets= new Insets(20,0,5,20);
		constraints.gridx=0;
		constraints.gridy=4;
		mExaminationPanel.add(mSaveExamButton, constraints);
		
		constraints.insets= new Insets(20,0,5,20);
		constraints.gridx=1;
		constraints.gridy=4;
		mExaminationPanel.add(mCancelExamButton, constraints);
		
		//++++++++++++++++++++++++++++++++++++++++++++++++++ Table
		
		GridBagLayout listLayout = new GridBagLayout();
		mPatientListPanel.setLayout(listLayout);
		GridBagConstraints listConstraints = new GridBagConstraints();
		
		listConstraints.fill=GridBagConstraints.BOTH;
		listConstraints.weightx=0.5;
		listConstraints.weighty=0.5;
		listConstraints.gridx=0;
		listConstraints.gridy=0;
		listConstraints.gridheight=2;
		listConstraints.gridwidth=8;
		listConstraints.insets = new Insets(5,5,5,5); 
		
		
		

		

		
		table.setAutoCreateRowSorter(true);
		JScrollPane scrollPane = new JScrollPane(table);				
		testList.setLayout(new BorderLayout());
		testList.add(scrollPane, BorderLayout.CENTER);
		mPatientListPanel.add(testList, listConstraints);
		
		listConstraints.fill=GridBagConstraints.HORIZONTAL;
		listConstraints.anchor=GridBagConstraints.LAST_LINE_START;
		listConstraints.insets = new Insets(5,5,5,10);
		listConstraints.gridx=0;
		listConstraints.gridy=2;
		listConstraints.gridheight=1;
		listConstraints.gridwidth=1;
		mPatientListPanel.add(mAddButton, listConstraints);
		
		listConstraints.gridx=1;
		listConstraints.gridy=2;
		listConstraints.insets = new Insets(5,5,5,300);
		mPatientListPanel.add(mDeleteButton, listConstraints);
		
		
		mMainPanel.revalidate();
		mMainPanel.repaint();
		
	}
	
	private void setFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 450);
		this.setVisible(true);
		this.setTitle("Rejestracja wynikow badan");
	}
	
	private void setMenu() {
		
		
		this.setJMenuBar(menuBar);
		menuBar.setVisible(true);
		menuBar.add(menu);			
		menu.add(menuItem);
	}
	

	private void initializeElements()
	{
		// JPanels for patient panel
		mMainPanel = new JPanel();
		
		mPatientPanel = new JPanel();
		mExaminationPanel = new JPanel();
		mPatientListPanel = new JPanel();
		
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

	
		
		this.mAddButton = new JButton("Dodaj");
		this.mDeleteButton = new JButton("Usun");
		
		
		this.mData = new ArrayList<Patient>();
		this.tableModel = new MyTable(mData);
		this.testList = new JPanel();
		this.table = new JTable(tableModel);
		
		
		// mExaminationPanel components 
		//Labels
		this.mBloodGlucoseLevelLabel = new JLabel("Stezenie glukozy we krwi [mg/dL]: ");
		this.mGhbPresenceLabel = new JLabel("GHB:");
		this.mUrineSugarLevelLabel = new JLabel("Poziom cukru w moczu [mmol/L]: ");
		this.mDateLabel = new JLabel("Data:");
		//Text fields and such
		this.mBloodGlucoseLevelTxt = new JTextField(10);
		this.mUrineSugarLevelTxt = new JTextField(10);
		this.mGhbCheckBox = new JCheckBox();
		this.mDateCalendar = new JDateChooser();
		//Buttons
		this.mSaveExamButton = new JButton("Zapisz");
		this.mCancelExamButton = new JButton("Anuluj");
		
		// MENU 
		this.menuBar = new JMenuBar();
		this.menu = new JMenu("Aplikacja");
		this.menuItem = new JMenuItem("Zamknij");
	}
	



}
