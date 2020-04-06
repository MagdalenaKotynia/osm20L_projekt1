package osmProject1;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

// TODO Create interface for ActionListener or ModelListener and ViewListener ----- will take some work 

public class AppController 
{
	
	/* Attributes */
	private AppView mView = null;
	private AppModel mModel = null;
	private Patient mPatientModel = null;
	private Examination mExamModel = null;
	
	public AppController(AppView view, AppModel model)
	{
		this.mView = view;
		this.mModel = model;
		this.visualizePatientTable();
		this.setListeners();
	}
	private void visualizePatientTable() {
		this.mView.mData = this.mModel.mList;
		this.mView.tableModel.patient = this.mModel.mList;
		this.mView.tableModel.fireTableDataChanged();
		
	}
	
	private void setListeners() 
	{
		this.mView.mSaveButton.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				addPatient();
				
			}		
		});
		this.mView.mAddButton.addActionListener((new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e) 
				{
					visualizePatientTable();
					
				}
				
				}));
	}
	
	private void addPatient() 
	{
		this.mModel.add(this.preparePatientFromForm());
	}
	

	
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
			gender = this.mView.mFemaleButton.getText();
		}
		return new Patient(this.mView.mNameTxt.getText(),
				this.mView.mSurnameTxt.getText(),
				this.mView.mPESELTxt.getText(),
				gender,
				(String)this.mView.mInsuranceBox.getSelectedItem(),null);
	}
	
	

//	@Override
//	public void actionPerformed(ActionEvent event) {
//		Object source = event.getSource();
//		
//		if(source==this.mView.mNameTxt)
//			//this.mView.mNameTxt.requestFocusInWindow();
//			this.mPatientModel.setName(this.mView.mNameTxt.getText());
//		else if(source==this.mView.mSurnameTxt)
//			this.mPatientModel.setName(this.mView.mSurnameTxt.getText());
//		else if(source==this.mView.mPESELTxt)
//			this.mPatientModel.setPESEL(this.mView.mPESELTxt.getText());
//		else if(source==this.mView.mAddButton)
//			this.mModel.add(mPatientModel);
//			this.mView.tableModel = new myTable(this.mModel.mList);
//			this.mView.table = new JTable(this.mView.tableModel);
//			
//			
//		
//		
//	}
	
	
	
	
	

}
