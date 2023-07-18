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
import javax.swing.JTextField;

public class More extends JFrame implements ActionListener {
	String formNo;
	JTextField amount;
	JButton cont, home;
	
	More(String formNo){
		this.formNo = formNo;
		setLayout(null);
		
		JLabel detail = new JLabel("Enter how much money you want!");
		detail.setBounds(110, 150, 600, 40);
		detail.setFont(new Font("Osward", Font.BOLD, 30));
		add(detail);
		
		JLabel enterAmount = new JLabel("Amount :");
		enterAmount.setBounds(150, 300, 150, 30);
		enterAmount.setFont(new Font("Osward", Font.BOLD, 28));
		add(enterAmount);
		
		amount = new JTextField();
		amount.setBounds(290, 300, 300, 30);
		amount.setFont(new Font("Osward", Font.BOLD, 28));
		add(amount);
		
		cont = new JButton("Continue");
		cont.setBounds(150, 400, 200, 50);
		cont.setFont(new Font("Osward", Font.BOLD, 28));
		cont.setBackground(Color.blue);
		cont.setForeground(Color.white);
		cont.addActionListener(this);
		add(cont);
		
		home = new JButton("Back");
		home.setBounds(400, 400, 200, 50);
		home.setFont(new Font("Osward", Font.BOLD, 28));
		home.setBackground(Color.blue);
		home.setForeground(Color.white);
		home.addActionListener(this);
		add(home);
		
		
		
		
		setSize(700, 700);
		setLocation(100, 20);
		setVisible(true);
		getContentPane().setBackground(Color.CYAN);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		double amt = Double.parseDouble(amount.getText());
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		if(ae.getSource() == cont) {
			try {
				Conn con = new Conn();
				String newQuery = "update signupthree set current_deposit = current_deposit - "+amt+" where formno = '"+formNo+"'";
				String getQuery = "select current_deposit from signupthree where formno = '"+formNo+"'";
				double curDep = 0;
				con.query.executeUpdate(newQuery);
				ResultSet rs = con.query.executeQuery(getQuery);
				while(rs.next()) {
					curDep = rs.getDouble("current_deposit");
				}
				String saveQuery = "Insert into entry values ('"+formNo+"', '"+(dtf.format(now))+"', "+amt+", "+0+","+curDep+")";
				con.query.executeUpdate(saveQuery);
				JOptionPane.showMessageDialog(null, "You have Withdraw " + amt + "Rs.");
				setVisible(false);
				new Login().setVisible(true);
			} catch(Exception e) {
				System.out.println(e);
			}
		} else if (ae.getSource() == home) {
			setVisible(false);
			new Home(formNo).setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		new More("");
	}
}


