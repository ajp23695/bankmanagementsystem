package bankManagementSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.JPanel;

public class viewBalance extends JFrame{
	String formNo;
	JButton viewStatement;
	Object[] columns;
	Object[][] data;
	private JTable table;
	viewBalance(String formNo){
		this.formNo = formNo;
		getContentPane().setLayout(null);
	        //add the table to the frame
		
		setVisible(true);
		setSize(700, 700);
		setLocation(100, 50);
		getContentPane().setBackground(Color.CYAN);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 67, 589, 410);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		try {
			Conn con = new Conn();
			Statement st = con.query;
			String getQuery = "Select activity_date, withdraw, deposit, total_left from entry where formno = '"+formNo+"'";
			ResultSet rs = st.executeQuery(getQuery);
			ResultSetMetaData rsmd = rs.getMetaData();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			
			int cols = rsmd.getColumnCount();
			String[] colsName = new String[cols];
			for(int i=0;i<cols;i++) {
				colsName[i] = rsmd.getColumnName(i + 1);
			}
			model.setColumnIdentifiers(colsName);
			String date, withdraw, deposit, balance;
			while(rs.next()) {
				date = rs.getString(1);
				withdraw = rs.getString(2);
				deposit = rs.getString(3);
				balance = rs.getString(4);
				String[] row = {date, withdraw, deposit, balance};
				model.addRow(row);
			}
			
			
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	public void filledData(String formNo) {
		
	}
	public static void main(String[] args) {
		new viewBalance("");
	}
}
