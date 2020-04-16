package osmProject1;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import org.apache.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;


public class AppController 
{
	
	/* Attributes */
	private AppView mView = null;
	private AppModel mModel = null;
	
	public AppController(AppView view, AppModel model)
	{
		this.mView = view;
		this.mModel = model;
			
		this.visualizePatientTable();
		this.setListeners();
	}

	//sets ActionListeners to buttons
	private void setListeners() 
	{
		
		this.mView.menuItem.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent evt) {
				if (evt.getActionCommand().equals("Zamknij")) {
					mView.dispose();
				}
			}
		});
		
		this.mView.mGhbCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if(mView.mGhbCheckBox.isSelected()) {
					JOptionPane.showMessageDialog(mView, "Obecnosc GHB nie jest normalna dla zdrowego pacjenta!");
					
				}
			}
		});
		
		// TODO input control
		AbstractDocument document = (AbstractDocument) this.mView.mNameTxt.getDocument();
		document.setDocumentFilter(new DocumentFilter() {
			
			public void replace(FilterBypass fb, int offs, int length, String str, AttributeSet a) throws BadLocationException {
				
				String text = fb.getDocument().getText(0, fb.getDocument().getLength());
				text=str;
				
				if(!NumberUtils.isCreatable(fb.getDocument().getText(0, fb.getDocument().getLength()))) {
					
					super.replace(fb, offs, length, str, a);
					
				}else {
					Toolkit.getDefaultToolkit().beep();
				}
				
				
			}
			public void insertString(FilterBypass fb, int offs, String str, AttributeSet a) throws BadLocationException {
				
				String text = fb.getDocument().getText(0, fb.getDocument().getLength());
				text = str;
				
				if(NumberUtils.isCreatable(fb.getDocument().getText(0, fb.getDocument().getLength()))) {
					super.insertString(fb, offs, str, a);
				}else {
					Toolkit.getDefaultToolkit().beep();
				}
                
			}
			
			
			
		});
		
		
		
		
		this.mView.mBloodGlucoseLevelTxt.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent evt) {
				
			}
			public void removeUpdate(DocumentEvent evt) {
				
				changeColor();
			}
			public void insertUpdate(DocumentEvent evt) {
				
				changeColor();
				
			}
		});
		
		
		
		this.mView.mUrineSugarLevelTxt.getDocument().addDocumentListener(new DocumentListener() {
			
			public void changedUpdate(DocumentEvent evt) {
				
			}
			public void removeUpdate(DocumentEvent evt) {
				
				changeColorOfUrine();
			}
			public void insertUpdate(DocumentEvent evt) {
				
				changeColorOfUrine();
				
			}
		});
			
			
		
		
		this.mView.mSaveButton.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					int selectedPatientIdx = mView.table.getSelectedRow();
					if (selectedPatientIdx == -1)
					{
						addPatient();
					}
					else
					{
						updatePatientData(selectedPatientIdx); 
					}
				}
				catch(NullPointerException evt)
				{
					JOptionPane.showMessageDialog(mView, "Nie mozna zapisac pacjenta. Sprawdz poprawnosc danych");
				}
				

				
			}		
		});
		
		this.mView.mAddButton.addActionListener((new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					visualizePatientTable();
					clearPatientFields();
					clearExamFields();
				}
				catch(Exception evt)
				{
					JOptionPane.showMessageDialog(mView, "Nie mozna dodac pacjenta do listy. Prosze sprawdzic poprawnosc danych");
				}
						
			}
				
		}));
		this.mView.mSaveExamButton.addActionListener((new ActionListener()
		{
			
			
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try {
				
				int selectedPatientIdx = mView.table.getSelectedRow();
				Examination exam = prepareExamFromForm();
				if (selectedPatientIdx == -1)
				{
					addExamToPatient(exam);
				}
				else
				{
					updateExamData(selectedPatientIdx);
				}
				
				}
				catch(NumberFormatException evt) {
					
					JOptionPane.showMessageDialog(mView, "Nie utworzono pacjenta do ktorego mozna by bylo dodac badanie! \n"
							+ " Prosze najpierw wprowadzic i zapisac dane w panelu pacjenta!");
				}
				
			}	
			
			
			
		}));
		this.mView.mCancellButton.addActionListener((new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				clearPatientFields();
			}
			
		}));
		this.mView.mCancelExamButton.addActionListener((new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				clearExamFields();
			}
			
		}));
		this.mView.mDeleteButton.addActionListener((new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try {
				
				deletePatientFromList();
				clearExamFields();
				clearPatientFields();
				visualizePatientTable();
				}
				catch(Exception evt) {
					JOptionPane.showMessageDialog(mView, "Nie zaznaczono pacjenta do usuniecia!");
				}
			}
		}));
		
		this.mView.table.getSelectionModel().addListSelectionListener((ListSelectionListener) (new ListSelectionListener()
				{

					@Override
					public void valueChanged(ListSelectionEvent e)
					{
						int selectedPatientIdx = mView.table.getSelectedRow();
						if(selectedPatientIdx > -1)
						{
							getPatientFromTable(selectedPatientIdx);
							
						}
						
					}
			
				}));
	}
	
	//adds patient to List
	private void addPatient() 
	{
		if(preparePatientFromFormUpdate()!=null)
		{
			this.mModel.add(this.preparePatientFromFormUpdate());
		}
//		else 
//		{
//			JOptionPane.showMessageDialog(mView, "Nie mozna dodac pacjenta. Sprawdz poprawnosc danych");
//		}

	}
	

	//creates new Patient with data from PatientFields
	private Patient preparePatientFromFormUpdate()
	{
		String gender;
		
		if (this.mView.mMaleButton.isSelected())
		{
			gender = this.mView.mMaleButton.getText();
		}
		else if (this.mView.mFemaleButton.isSelected())
		{
			gender = this.mView.mFemaleButton.getText();
		}
		else
		{
			gender = null; 
		}
		
		// Condition preventing from adding two patients with the same PESEL
		boolean PESELtest = mModel.mList.contains(new Patient(this.mView.mNameTxt.getText(),
							this.mView.mSurnameTxt.getText(),
							gender,
							this.mView.mPESELTxt.getText(),
							(String)this.mView.mInsuranceBox.getSelectedItem(),null));
		if(PESELtest==true)
		{		
			JOptionPane.showMessageDialog(mView, "Pacjent o podanym numerze PESEL juz istnieje!");
			return null;		
		}
		else {
			Patient patient = new Patient(this.mView.mNameTxt.getText(),
					this.mView.mSurnameTxt.getText(),
					gender,
					this.mView.mPESELTxt.getText(),
					(String)this.mView.mInsuranceBox.getSelectedItem(),null);
					
			if (patient.checkPatient()==true)
			{
				return patient;
			}
			else {
				JOptionPane.showMessageDialog(mView, "Wprowadzono bledne dane pacjenta");
				return null;
			}
	}
	}
		
	
	//visualizes PatientTable and updates if any changes
	private void visualizePatientTable() {
		
		
		this.mView.mData = this.mModel.mList;
		this.mView.tableModel.patient = this.mModel.mList;
		this.mView.tableModel.fireTableDataChanged();
		
	}
	
	//creates new Examination from data from ExamFields
	private Examination prepareExamFromForm()
	{
		double bloodGlucoseLevelTxtToDouble = Double.parseDouble(this.mView.mBloodGlucoseLevelTxt.getText());
		double urineSugarLevelTxtToDouble = Double.parseDouble(this.mView.mUrineSugarLevelTxt.getText());
		
		return new Examination(this.mView.mDateCalendar.getDate(),
				this.mView.mGhbCheckBox.isSelected(),
				bloodGlucoseLevelTxtToDouble,
				urineSugarLevelTxtToDouble
				);
	}
	
	//adds Exam to Patient 
	private void addExamToPatient(Examination exam)
	{
		this.mModel.mList.get(this.mModel.mList.size() - 1).setExam(exam);
	}
	
	//clears fields in PatientPanel
	private void clearPatientFields()
	{
		this.mView.mNameTxt.setText(null);
		this.mView.mSurnameTxt.setText(null);
		this.mView.mPESELTxt.setText(null);
		this.mView.mGenderGroup.clearSelection();
	}
	
	//clears fields in ExamPanel
	private void clearExamFields()
	{
		this.mView.mDateCalendar.setDate(null);
		this.mView.mGhbCheckBox.setSelected(false);
		this.mView.mBloodGlucoseLevelTxt.setText(null);
		this.mView.mUrineSugarLevelTxt.setText(null);
	}
	
	//deletes Patient from List
	private void deletePatientFromList()
	{
		int selectedPatientIdx = this.mView.table.getSelectedRow();
		this.mModel.mList.remove(selectedPatientIdx);
	}
	
	//gets Patient's data from selected Patient in PatientTable and puts them into Patient and Exam fields
	private void getPatientFromTable(int selectedPatientIdx)
	{
		//int selectedPatientIdx = this.mView.table.getSelectedRow();
		Patient selectedPatient = this.mModel.mList.get(selectedPatientIdx);
		this.mView.mNameTxt.setText(selectedPatient.getName());
		this.mView.mSurnameTxt.setText(selectedPatient.getSurname());
		this.mView.mPESELTxt.setText(selectedPatient.getPESEL());
		if (selectedPatient.getGender()=="Kobieta")
		{
			this.mView.mFemaleButton.setSelected(true);
		}
		else if (selectedPatient.getGender()=="Mezczyzna")
		{
			this.mView.mMaleButton.setSelected(true);
		}
		this.mView.mInsuranceBox.setSelectedItem(selectedPatient.getInsurance());
		
		if (selectedPatient.getExam()!=null)
		{
			String BloodGlucoseLevelToString = Double.toString(selectedPatient.getExam().getBloodGlucoseLevel());
			String UrineSugarLevelToString = Double.toString(selectedPatient.getExam().getUrineSugarLevel());
			this.mView.mDateCalendar.setDate(selectedPatient.getExam().getDate());
			this.mView.mBloodGlucoseLevelTxt.setText(BloodGlucoseLevelToString);
			this.mView.mUrineSugarLevelTxt.setText(UrineSugarLevelToString);
			this.mView.mGhbCheckBox.setSelected(selectedPatient.getExam().getGhb());	
		}else {
			this.mView.mDateCalendar.setDate(null);
			this.mView.mBloodGlucoseLevelTxt.setText(null);
			this.mView.mUrineSugarLevelTxt.setText(null);
			this.mView.mGhbCheckBox.setSelected(false);
		}
	}
	
	// Method for changing font color if the values are out of range 
	private void changeColor() {
		try {
		if(!mView.mBloodGlucoseLevelTxt.getText().trim().isEmpty()) {
		
		double bloodGlucoseLevelTxtToDouble1 = Double.parseDouble(mView.mBloodGlucoseLevelTxt.getText());
		if (bloodGlucoseLevelTxtToDouble1<70 || bloodGlucoseLevelTxtToDouble1>99) {
				mView.mBloodGlucoseLevelTxt.setForeground(Color.RED);
				
			}else {
				mView.mBloodGlucoseLevelTxt.setForeground(Color.GREEN);
			}
		}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(mView, "Nieprawidlowe dane wejsciowe!");
			mView.mBloodGlucoseLevelTxt.setForeground(Color.RED);
		}
	}
	
	// Method for changing font color if the values are out of range for diffrent JTextField
	private void changeColorOfUrine() {
		try {
		if(!mView.mUrineSugarLevelTxt.getText().trim().isEmpty()) {
			
			double urineLevels = Double.parseDouble(mView.mUrineSugarLevelTxt.getText());
			if (urineLevels>0.8 || urineLevels<0) {
					mView.mUrineSugarLevelTxt.setForeground(Color.RED);
					
				}else {
					mView.mUrineSugarLevelTxt.setForeground(Color.GREEN);
				}
			}
		}
		catch(Exception e) {
			
			JOptionPane.showMessageDialog(mView, "Nieprawidlowe dane wejsciowe!");
			mView.mUrineSugarLevelTxt.setForeground(Color.RED);	
		}
		
		}
	
	
	//updates data of Patient selected from PatientTable
	private void updatePatientData(int selectedPatientIdx)
	{
		
		Patient data = preparePatientFromFormUpdate();
		
		if (data!=null)
		{

			for(int col=0; col<(this.mView.tableModel.getColumnCount()-1);col++ )
			{
			this.mView.tableModel.setValueAt(data, selectedPatientIdx, col);
			}
		}

		
		
		
	}
	
	private void updateExamData(int selectedPatientIdx)
	{
		Patient data = preparePatientFromFormUpdate();
		Examination exam = prepareExamFromForm();
		data.setExam(exam);
		this.mView.tableModel.setValueAt(data, selectedPatientIdx, this.mView.tableModel.getColumnCount()-1);
	}
}
