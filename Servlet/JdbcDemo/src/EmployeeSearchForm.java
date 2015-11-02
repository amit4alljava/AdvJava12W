import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class EmployeeSearchForm extends JFrame {
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;

	
	public static void main(String[] args) {
		
					EmployeeSearchForm frame = new EmployeeSearchForm();
					frame.setVisible(true);
				
	}

	/**
	 * Create the frame.
	 */
	public EmployeeSearchForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 479);
		getContentPane().setLayout(null);
		
		JLabel lblEnterEmpno = new JLabel("Enter Salary");
		lblEnterEmpno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEnterEmpno.setBounds(21, 35, 118, 14);
		getContentPane().add(lblEnterEmpno);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setText("0");
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(160, 32, 188, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doSearch();
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSearch.setBounds(25, 120, 89, 23);
		getContentPane().add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 154, 389, 155);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setText("0");
		textField_1.setBounds(160, 63, 188, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEnterEmpno_1 = new JLabel("Enter Empno");
		lblEnterEmpno_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEnterEmpno_1.setBounds(21, 66, 118, 14);
		getContentPane().add(lblEnterEmpno_1);
		
	}
	private boolean checkDigit(String value, JTextField txt){
		boolean isNumber = true;
		if(value.trim().length()>0){
			for(Character c: value.toCharArray()){
				if(!Character.isDigit(c)){
					isNumber = false;
					txt.setText("0");
					break;
				}
			}
		}
		return isNumber;
	}
	private void doSearch(){
		
		String salary= textField.getText();
		String empno = textField_1.getText();
		try {
			EmployeeDTO empDTO = new EmployeeDTO();
			empDTO.setId(checkDigit(empno,textField)?Integer.parseInt(empno):0);
			empDTO.setSalary(checkDigit(salary,textField_1)?Double.parseDouble(salary):0.0);
			ArrayList<EmployeeDTO> empList = JDBC.dynamicSQL(empDTO);
			EmployeeTableModel empModel = new EmployeeTableModel(empList);
			table.setModel(empModel);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "Invalid Data");
			e.printStackTrace();
		}
	}
}
