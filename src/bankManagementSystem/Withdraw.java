package bankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Withdraw extends JFrame implements ActionListener{
	
	String formNo;
	JButton fifty, hundred, fiveHundred, thousand, fiveThousand, more;
	
	
	Withdraw(String formNo){
		this.formNo = formNo;
		setLayout(null);
		
		setVisible(true);
		setSize(700, 700);
		setLocation(100, 50);
		
		fifty = new JButton("50");
		fifty.setBounds(10, 300, 250, 50);
		fifty.setFont(new Font("Osward", Font.BOLD, 28));
		fifty.setBackground(Color.blue);
		fifty.setForeground(Color.white);
		fifty.addActionListener(this);
		add(fifty);
		
		hundred = new JButton("100");
		hundred.setBounds(430, 300, 250, 50);
		hundred.setFont(new Font("Osward", Font.BOLD, 28));
		hundred.setBackground(Color.blue);
		hundred.setForeground(Color.white);
		hundred.addActionListener(this);
		add(hundred);
		
		fiveHundred = new JButton("500");
		fiveHundred.setBounds(10, 400, 250, 50);
		fiveHundred.setFont(new Font("Osward", Font.BOLD, 28));
		fiveHundred.setBackground(Color.blue);
		fiveHundred.setForeground(Color.white);
		fiveHundred.addActionListener(this);
		add(fiveHundred);
		
		thousand = new JButton("1000");
		thousand.setBounds(430, 400, 250, 50);
		thousand.setFont(new Font("Osward", Font.BOLD, 28));
		thousand.setBackground(Color.blue);
		thousand.setForeground(Color.white);
		thousand.addActionListener(this);
		add(thousand);
		
		fiveThousand = new JButton("5000");
		fiveThousand.setBounds(10, 500, 250, 50);
		fiveThousand.setFont(new Font("Osward", Font.BOLD, 28));
		fiveThousand.setBackground(Color.blue);
		fiveThousand.setForeground(Color.white);
		fiveThousand.addActionListener(this);
		add(fiveThousand);
		
		more = new JButton("More");
		more.setBounds(430, 500, 250, 50);
		more.setFont(new Font("Osward", Font.BOLD, 28));
		more.setBackground(Color.blue);
		more.setForeground(Color.white);
		more.addActionListener(this);
		add(more);
		
		JLabel detail = new JLabel("Select How much you want to withdraw :");
		detail.setBounds(80, 160, 600, 30);
		detail.setFont(new Font("Osward", Font.BOLD, 28));
		add(detail);
		getContentPane().setBackground(Color.CYAN);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == fifty) {
			getData(50);
			setVisible(false);
			new Login().setVisible(true);
		} else if (ae.getSource() == hundred) {
			getData(100);
			setVisible(false);
			new Login().setVisible(true);
		} else if (ae.getSource() == fiveHundred) {
			getData(500);
			setVisible(false);
			new Login().setVisible(true);
		} else if (ae.getSource() == thousand) {
			getData(1000);
			setVisible(false);
			new Login().setVisible(true);
		} else if (ae.getSource() == fiveThousand) {
			getData(5000);
			setVisible(false);
			new Login().setVisible(true);
		} else if (ae.getSource() == more) {
			setVisible(false);
			new More(formNo).setVisible(true);
		}
		
	}
	
	public void getData(double amount) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		try {
			Conn con = new Conn();
			String newQuery = "update signupthree set current_deposit = current_deposit - "+amount+" where formno = '"+formNo+"'";
			String getQuery = "select current_deposit from signupthree where formno = '"+formNo+"'";
			double curDep = 0;
			con.query.executeUpdate(newQuery);
			ResultSet rs = con.query.executeQuery(getQuery);
			while(rs.next()) {
				curDep = rs.getDouble("current_deposit");
			}
			String saveQuery = "Insert into entry values ('"+formNo+"', '"+(dtf.format(now))+"', "+amount+", "+0+","+curDep+")";
			con.query.executeUpdate(saveQuery);
			JOptionPane.showMessageDialog(null, "You have Withdraw " + amount + "Rs.");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[]args) {
		new Withdraw("");
	}
}
