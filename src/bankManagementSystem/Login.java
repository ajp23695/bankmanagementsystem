package bankManagementSystem;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {
	String formNo;
	JButton login, clear, signUp; 
	JTextField cardNumberField;
	JPasswordField pinNumberField;
	Login(){
		
		setLayout(null);
		setTitle("Bank Management System");
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/banklogo.png"));
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label1 = new JLabel(i3);
		label1.setBounds(100, 20, 100, 100);
		add(label1);
		
		
		
		JLabel textTitle = new JLabel("Welcome to ATM");
		textTitle.setBounds(250, 50, 400, 60);
		textTitle.setFont(new Font("Osward", Font.BOLD, 40));
		add(textTitle);
		
		JLabel cardNo = new JLabel("Card No :");
		cardNo.setBounds(180, 200, 200, 60);
		cardNo.setFont(new Font("Osward", Font.BOLD, 30));
		add(cardNo);
		
		cardNumberField = new JTextField();
		cardNumberField.setBounds(380, 200, 300, 50);
		cardNumberField.setFont(new Font("Osward", Font.PLAIN, 24));
		add(cardNumberField);
		
		JLabel pinNo = new JLabel("Pin :");
		pinNo.setBounds(250, 300, 200, 60);
		pinNo.setFont(new Font("Osward", Font.BOLD, 30));
		add(pinNo);
		
		pinNumberField = new JPasswordField();
		pinNumberField.setBounds(380, 300, 300, 50);
		pinNumberField.setFont(new Font("Osward", Font.PLAIN, 24));
		add(pinNumberField);
		
		login = new JButton("SIGN IN");
		login.setBounds(260, 420, 140, 50);
		login.setFont(new Font("Osward", Font.BOLD, 20));
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		add(login);
		
		clear = new JButton("CLEAR");
		clear.setBounds(430, 420, 140, 50);
		clear.setFont(new Font("Osward", Font.BOLD, 20));
		clear.setBackground(Color.BLACK);
		clear.setForeground(Color.WHITE);
		clear.addActionListener(this);
		add(clear);
		
		signUp = new JButton("SIGN UP");
		signUp.setBounds(260, 490, 310, 50);
		signUp.setFont(new Font("Osward", Font.BOLD, 20));
		signUp.setBackground(Color.BLACK);
		signUp.setForeground(Color.WHITE);
		signUp.addActionListener(this);
		add(signUp);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(800, 600);
		setVisible(true);
		setLocation(350, 100);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		@SuppressWarnings("deprecation")
		String pass = pinNumberField.getText();
		String cardNum = cardNumberField.getText(); 
		if(ae.getSource() == clear) {
			cardNumberField.setText("");
			pinNumberField.setText("");
		} else if(ae.getSource() == login) {
			if(cardNum.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter Card Number");
			} else if(pass.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter your 4 digit Pin :");
			} else {
				try {
					String getQuery = "Select * from signupthree where cardnumber = '"+cardNum+"' and pinnumber = '"+pass+"'";
					Conn con = new Conn();
					ResultSet rs = con.query.executeQuery(getQuery);
					if(rs.next()) {
						formNo = rs.getString("formno");
						setVisible(false);
						new Home(formNo).setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Your username or password is wrong");
					}
						
				}catch(Exception e) {
					System.out.println(e);
				}
			}
			
		} else if(ae.getSource() == signUp) {
			setVisible(false);
			new SignupOne().setVisible(true);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Login();
	}

}
