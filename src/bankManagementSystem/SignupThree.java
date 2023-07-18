package bankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class SignupThree extends JFrame implements ActionListener {
	
	Long cardLongNumber, pinLongNumber ;
	String formNo;
	JRadioButton savingsRb, fixedRb, currentRb, recurringRb;
	ButtonGroup accounts;
	JCheckBox atmCb,internetCb, emailCb, eStatementCb, checkCb, mobileCb, agreeCb;
	JButton submitBtn, cancelBtn;
	
	SignupThree(String formNo){
		this.formNo = formNo;
		setLayout(null);
		
		Random random = new Random();
		cardLongNumber = Math.abs((random.nextLong() % 9000000000000000L) + 1000000000000000L);
		pinLongNumber = Math.abs((random.nextLong() % 9000L) + 1000L);
		
		
		JLabel pageTitle = new JLabel("Page 3 : Account Details");
		pageTitle.setBounds(230, 20, 500, 40);
		pageTitle.setFont(new Font("Osward", Font.BOLD, 30));
		add(pageTitle);
		
		JLabel at = new JLabel("Account Type :");
		at.setBounds(80, 100, 400, 30);
		at.setFont(new Font("Osward", Font.BOLD, 26));
		add(at);
		
		savingsRb = new JRadioButton("Savings Account");
		savingsRb.setBounds(90, 150, 300, 26 );
		savingsRb.setFont(new Font("Osward", Font.PLAIN, 20));
		savingsRb.setBackground(Color.white);
		add(savingsRb);
		
		fixedRb = new JRadioButton("Fixed Account");
		fixedRb.setBounds(450, 150, 300, 26);
		fixedRb.setFont(new Font("Osward", Font.PLAIN, 20));
		fixedRb.setBackground(Color.white);
		add(fixedRb);
		
		currentRb = new JRadioButton("Current Account");
		currentRb.setBounds(90, 190, 300, 26 );
		currentRb.setFont(new Font("Osward", Font.PLAIN, 20));
		currentRb.setBackground(Color.white);
		add(currentRb);
		
		recurringRb = new JRadioButton("Recurring Account");
		recurringRb.setBounds(450, 190, 300, 26);
		recurringRb.setFont(new Font("Osward", Font.PLAIN, 20));
		recurringRb.setBackground(Color.white);
		add(recurringRb);
		
		accounts = new ButtonGroup();
		accounts.add(savingsRb);
		accounts.add(fixedRb);
		accounts.add(currentRb);
		accounts.add(recurringRb);
		
		
		JLabel cardNo = new JLabel("Card Number");
		cardNo.setBounds(80, 250, 400, 30);
		cardNo.setFont(new Font("Osward", Font.BOLD, 26));
		add(cardNo);
		
		JLabel cardNumber = new JLabel("XXXX-XXXX-XXXX-XXXX");
		cardNumber.setBounds(400, 250, 400, 30);
		cardNumber.setFont(new Font("Osward", Font.BOLD, 28));
		add(cardNumber);
		
		JLabel cardDetail = new JLabel("Your 16 digit Card Number");
		cardDetail.setBounds(80, 280, 600, 18);
		cardDetail.setFont(new Font("Osward", Font.BOLD, 14));
		add(cardDetail);
		
		JLabel pinNo = new JLabel("PIN :");
		pinNo.setBounds(80, 350, 400, 30);
		pinNo.setFont(new Font("Osward", Font.BOLD, 26));
		add(pinNo);
		
		JLabel pinNumber = new JLabel("XXXX");
		pinNumber.setBounds(500, 350, 300, 30);
		pinNumber.setFont(new Font("Osward", Font.BOLD, 28));
		add(pinNumber);
		
		JLabel pinDetail = new JLabel("Your 4 digit Pin Number");
		pinDetail.setBounds(80, 380, 600, 18);
		pinDetail.setFont(new Font("Osward", Font.BOLD, 14));
		add(pinDetail);
		
		
		
		JLabel services = new JLabel("Services Required");
		services.setBounds(80, 450, 400, 30);
		services.setFont(new Font("Osward", Font.BOLD, 26));
		add(services);
		
		atmCb = new JCheckBox("ATM Service");
		atmCb.setBounds(100, 500, 300, 26);
		atmCb.setFont(new Font("Osward", Font.PLAIN, 20));
		atmCb.setBackground(Color.white);
		add(atmCb);
		
		emailCb = new JCheckBox("Email & SMS Alert");
		emailCb.setBounds(100, 540, 300, 26);
		emailCb.setFont(new Font("Osward", Font.PLAIN, 20));
		emailCb.setBackground(Color.white);
		add(emailCb);
		
		internetCb = new JCheckBox("Internet Banking");
		internetCb.setBounds(100, 580, 300, 26);
		internetCb.setFont(new Font("Osward", Font.PLAIN, 20));
		internetCb.setBackground(Color.white);
		add(internetCb);
		
		eStatementCb = new JCheckBox("E Statement");
		eStatementCb.setBounds(400, 500, 300, 26);
		eStatementCb.setFont(new Font("Osward", Font.PLAIN, 20));
		eStatementCb.setBackground(Color.white);
		add(eStatementCb);
		
		checkCb = new JCheckBox("Chequebook Service");
		checkCb.setBounds(400, 540, 300, 26);
		checkCb.setFont(new Font("Osward", Font.PLAIN, 20));
		checkCb.setBackground(Color.white);
		add(checkCb);
		
		mobileCb = new JCheckBox("Mobile Banking");
		mobileCb.setBounds(400, 580, 300, 26);
		mobileCb.setFont(new Font("Osward", Font.PLAIN, 20));
		mobileCb.setBackground(Color.white);
		add(mobileCb);
		
		agreeCb = new JCheckBox("I here by confirm that all the information are correct in best of my knowledge");
		agreeCb.setBounds(100, 650, 700, 26);
		agreeCb.setFont(new Font("Osward", Font.PLAIN, 16));
		agreeCb.setBackground(Color.white);
		add(agreeCb);
		
		submitBtn = new JButton("Submit");
		submitBtn.setBounds(150, 680, 200, 40);
		submitBtn.setFont(new Font("Osward", Font.BOLD, 28));
		submitBtn.setBackground(Color.black);
		submitBtn.setForeground(Color.white);
		submitBtn.addActionListener(this);
		add(submitBtn);
		
		cancelBtn = new JButton("Cancel");
		cancelBtn.setBounds(450, 680, 200, 40);
		cancelBtn.setFont(new Font("Osward", Font.BOLD, 28));
		cancelBtn.setBackground(Color.black);
		cancelBtn.setForeground(Color.white);
		cancelBtn.addActionListener(this);
		add(cancelBtn);
		
	
		setVisible(true);
		setSize(800, 770);
		setLocation(340, 10);
		getContentPane().setBackground(Color.white);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		String accounts = "";
		if(savingsRb.isSelected()) {
			accounts = "Savings Account";
		} else if(currentRb.isSelected()) {
			accounts = "Current Account";
		} else if(fixedRb.isSelected()) {
			accounts = "Fixed Account";
		} else if(recurringRb.isSelected()) {
			accounts = "Recurring Account";
		}
		
		String cardNum = cardLongNumber.toString();
		String pinNum = pinLongNumber.toString();
		boolean mobileService = mobileCb.isSelected();
		boolean chequeService = checkCb.isSelected();
		boolean internetService = internetCb.isSelected();
		boolean statementService = eStatementCb.isSelected();
		boolean emailService = emailCb.isSelected();
		boolean atmService = atmCb.isSelected();
		
		if(ae.getSource() == submitBtn) {
			if(accounts.equals("")) {
				JOptionPane.showMessageDialog(null, "Select account you want to open");
			} else {
				if(agreeCb.isSelected()) {
					
					try {
						Conn con = new Conn();
						String saveQuery = "Insert into signupthree values ('"+formNo+"','"+accounts+"', '"+cardNum+"', '"+pinNum+"','"+mobileService+"','"+emailService+"','"+statementService+"','"+internetService+"','"+chequeService+"','"+atmService+"',"+0+")";
						con.query.executeUpdate(saveQuery);
						JOptionPane.showMessageDialog(null, " Your Card Number :- " + cardNum +"\n Your Pin :- " + pinNum);
						setVisible(false);
						new Login().setVisible(true);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, e);
					}
					
				} else {
					JOptionPane.showMessageDialog(null, "Please Check the Agreement");
				}
			}
		} else if (ae.getSource() == cancelBtn) {
			setVisible(false);
			new Login().setVisible(true);
		}
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SignupThree("");
	}
	

}
