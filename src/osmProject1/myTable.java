package osmProject1;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class myTable extends AbstractTableModel{
	
	private String[] columnNames = {"Imię i Nazwisko", "Płec", "PESEL", "Ubezpieczenie", "Badanie"};
	private ArrayList<Patient> patient;
	
	public myTable(ArrayList<Patient> clist) {
		this.patient=clist;
	}
	
	@Override
	public int getRowCount() {
		
		int size;
		if(patient==null) {
			size = 0;
		}else {
			size=patient.size();
		}
		
		return size;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object temp =null;
		if(columnIndex==0) {
			temp = patient.get(rowIndex).getName();				//add surname
		}else if(columnIndex==1){
			temp = patient.get(rowIndex).getGender();
		}else if(columnIndex==2) {
			temp = patient.get(rowIndex).getPESEL();
		}else if(columnIndex==3) {
			temp = patient.get(rowIndex).getInsurance();
		}else if(columnIndex==4){
			temp = patient.get(rowIndex).getExam();
		}
		return temp;
	}
	public String getColumnName(int col) {
		return columnNames[col];
	}
	
	@Override
	public Class getColumnClass(int col) {
		if(col==4) {
			return Examination.class;
		}else{
			return String.class;
		}
	}

}
