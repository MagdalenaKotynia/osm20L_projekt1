package osmProject1;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class MyTable extends AbstractTableModel{
	
	private String[] columnNames = {"Imie i Nazwisko", "Plec", "PESEL", "Ubezpieczenie", "Badanie"};
	protected ArrayList<Patient> patient;
	
	public MyTable(ArrayList<Patient> clist) {
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
			temp = patient.get(rowIndex).getName() +" "+ patient.get(rowIndex).getSurname();				//add surname
		}else if(columnIndex==1){
			temp = patient.get(rowIndex).getGender();
		}else if(columnIndex==2) {
			temp = patient.get(rowIndex).getPESEL();
		}else if(columnIndex==3) {
			temp = patient.get(rowIndex).getInsurance();
		}else if(columnIndex==4){
			if (patient.get(rowIndex).getExam() == null){
				temp = false;
			}else if (patient.get(rowIndex).getExam() != null) {
				temp = true;
			}
			
			
		}
		return temp;
	}
	public String getColumnName(int col) {
		return columnNames[col];
	}
	
	@Override
	public Class getColumnClass(int col) {
		if(col==4) {
			return Boolean.class;
		}else{
			return String.class;
		}
	}

	public boolean isCellEditable(int rwo, int col) {
		
		if (col<6) {
			return false;
		}else {
			return true;
		}
		
	}
	public void setValueAt(Patient data, int row, int col) {
		patient.set(row, data);
		fireTableCellUpdated(row, col);
	}
	
	
}
