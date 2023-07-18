package bankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Home extends JFrame implements ActionListener {

	JButton withdraw, deposit, changePin, viewBalance;
	String formNo;
	
	Home(String formNo){
		this.formNo = formNo;
		setLayout(null);
		
		JLabel detail = new JLabel("Welcome to ATM Simulator");
		detail.setBounds(170, 50, 400, 30);
		detail.setFont(new Font("Osward", Font.BOLD, 28));
		add(detail);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(0, 250, 200, 38);
		deposit.setFont(new Font("Osward", Font.PLAIN, 30));
		deposit.setSize(200, 50);
		deposit.setForeground(Color.white);
		deposit.setBackground(Color.blue);
		deposit.addActionListener(this);
		add(deposit);
		
		changePin = new JButton("Change PIN");
		changePin.setBounds(0, 350, 200, 38);
		changePin.setFont(new Font("Osward", Font.PLAIN, 30));
		changePin.setSize(200, 50);
		changePin.setForeground(Color.white);
		changePin.setBackground(Color.blue);
		changePin.addActionListener(this);
		add(changePin);
		
		withdraw = new JButton("Withdraw");
		withdraw.setBounds(500, 250, 200, 38);
		withdraw.setFont(new Font("Osward", Font.PLAIN, 30));
		withdraw.setSize(200, 50);
		withdraw.setForeground(Color.white);
		withdraw.setBackground(Color.blue);
		withdraw.addActionListener(this);
		add(withdraw);
		
		viewBalance = new JButton("View Balance");
		viewBalance.setBounds(500, 350, 200, 38);
		viewBalance.setFont(new Font("Osward", Font.PLAIN, 30));
		viewBalance.setSize(200, 50);
		viewBalance.setForeground(Color.white);
		viewBalance.setBackground(Color.blue);
		viewBalance.addActionListener(this);
		add(viewBalance);
		
		
		
		setVisible(true);
		setSize(700, 700);
		setLocation(100, 50);
		getContentPane().setBackground(Color.CYAN);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == deposit) {
			setVisible(false);
			new Deposit(formNo).setVisible(true);
		}else if(ae.getSource() == withdraw) {
			setVisible(false);
			new Withdraw(formNo).setVisible(true);
		}else if(ae.getSource() == viewBalance) {
			setVisible(false);
			new viewBalance(formNo).setVisible(true);
		}else if(ae.getSource() == changePin) {
			setVisible(false);
			new PinChange(formNo).setVisible(true);
		}
		
	}
	
	public static void main(String[] args) {
		new Home("");
	}
}
