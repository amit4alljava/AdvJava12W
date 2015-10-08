import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;


public class EmployeeTableModel extends AbstractTableModel  {
	ArrayList<EmployeeDTO> empList ;
	private String columns[]={"Id","Name","Salary"};
	
	 public EmployeeTableModel(ArrayList<EmployeeDTO> empList) {
		this.empList = empList;
	}
	 
	 
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return empList.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columns.length;
	}
	
	  public String getColumnName(int col) {
	      return columns[col];
	    }
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		EmployeeDTO empObject  = empList.get(rowIndex);
		switch(columnIndex){
		case 0:
			return empObject.getId();
		case 1:
			return empObject.getName();
		case 2:
			return empObject.getSalary();
		}
		return null;
	}

}
