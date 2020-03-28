package osmProject1;

import javax.swing.table.AbstractTableModel;

public class PatientTableModel extends AbstractTableModel {
	
	private String[] columnNames = new String[] {"Imie i Nazwisko","Plec", "PESEL","Ubezpieczenie","Badanie"} ;
	private Object[][] data;

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.length;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}
	public String getColumnName(int col)
	{
		return columnNames[col];
	}
	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		return data[row][col];
	}

}
