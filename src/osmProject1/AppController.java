package osmProject1;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


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
		this.mView.mSaveButton.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				int selectedPatientIdx = mView.table.getSelectedRow();
				if (selectedPatientIdx == -1)
				{
					addPatient();
				}
				else
				{
					updatePatientData(selectedPatientIdx); //TO DO refresh Patient Data
				}
				
			}		
		});
		this.mView.mAddButton.addActionListener((new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				visualizePatientTable();
				clearPatientFields();
				clearExamFields();
						
			}
				
		}));
		this.mView.mSaveExamButton.addActionListener((new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
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
				//TO DO add exception handling if any patient is not selected and you press button
				deletePatientFromList();
				visualizePatientTable();
				
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
		this.mModel.add(this.preparePatientFromForm());
	}
	

	//creates new Patient with data from PatientFields
	private Patient preparePatientFromForm()
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
			gender = this.mView.mFemaleButton.getText(); //TO DO more clever exception??
		}
		return new Patient(this.mView.mNameTxt.getText(),
							this.mView.mSurnameTxt.getText(),
							gender,
							this.mView.mPESELTxt.getText(),
							(String)this.mView.mInsuranceBox.getSelectedItem(),null);
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
		this.mModel.mList.get(this.mModel.mList.size() - 1).setExam(exam);;
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
		}
	}
	
	//updates data of Patient selected from PatientTable
	private void updatePatientData(int selectedPatientIdx)
	{
		Patient data = preparePatientFromForm();

		for(int col=0; col<(this.mView.tableModel.getColumnCount()-1);col++ )
		{
		this.mView.tableModel.setValueAt(data, selectedPatientIdx, col);
		}		
	}
	
	private void updateExamData(int selectedPatientIdx)
	{
		Patient data = preparePatientFromForm();
		Examination exam = prepareExamFromForm();
		data.setExam(exam);
		this.mView.tableModel.setValueAt(data, selectedPatientIdx, this.mView.tableModel.getColumnCount()-1);
	}
}
