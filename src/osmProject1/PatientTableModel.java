package osmProject1;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;


public class PatientTableModel extends AbstractTableModel {
	
	private final ArrayList<String> columnNames;
	
	//to chyba nie tak
	private ArrayList<Patient> data;
	
	public PatientTableModel()
	{
		columnNames = new ArrayList<>();
		this.setColumnNames();
	

	}
	
	
	public PatientTableModel( ArrayList<Patient> data)
	{
		columnNames = new ArrayList<>();
		this.setColumnNames();
		this.data = data;
		
	}

	@Override
	public int getRowCount() {
		
		return data.size();
	}

	@Override
	public int getColumnCount() 
	{

		return columnNames.size();
	}
	
	public String getColumnName(int col)
	{
		return columnNames.get(col);
	}
	
	
	@Override
	public Object getValueAt(int row, int col) {

		return data.get(row).getPatientAtributes().get(col);
	}
	
    public void setValueAt(Object value, int row, int col)
    {
        this.data.get(row).getPatientAtributes().set(col, value);//getArrayList
        fireTableCellUpdated(row,col);
    }
    
    private void setColumnNames()
    {
    	this.columnNames.add("Imie i Nazwisko");
    	this.columnNames.add("PESEL");
    }
    
    private void setData(ArrayList<Patient> data)
    {
    	this.data = data;
    }

}
