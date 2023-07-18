package bankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PinChange extends JFrame implements ActionListener {
	String formNo;
	JPasswordField oPassTf, nPassTf, cPassTf;
	JButton conButton, backButton;
	
	PinChange(String formNo){
		this.formNo = formNo;
		setLayout(null);
		
		JLabel oPass = new JLabel("Enter your old PIN :");
		oPass.setBounds(70, 200, 300, 28);
		oPass.setFont(new Font("Osward", Font.BOLD, 24));
		add(oPass);
		
		oPassTf = new JPasswordField("");
		oPassTf.setBounds(370, 200, 300, 28);
		oPassTf.setFont(new Font("Osward", Font.BOLD, 24));
		add(oPassTf);
		
		JLabel nPass = new JLabel("Enter New PIN :");
		nPass.setBounds(70, 300, 300, 28);
		nPass.setFont(new Font("Osward", Font.BOLD, 24));
		add(nPass);
		
		nPassTf = new JPasswordField("");
		nPassTf.setBounds(370, 300, 300, 28);
		nPassTf.setFont(new Font("Osward", Font.BOLD, 24));
		add(nPassTf);
		
		JLabel cPass = new JLabel("Comfirm your PIN :");
		cPass.setBounds(70, 400, 300, 28);
		cPass.setFont(new Font("Osward", Font.BOLD, 24));
		add(cPass);
		
		cPassTf = new JPasswordField("");
		cPassTf.setBounds(370, 400, 300, 28);
		cPassTf.setFont(new Font("Osward", Font.BOLD, 24));
		add(cPassTf);
		
		conButton = new JButton("Continue");
		conButton.setBounds(150, 550, 200, 40);
		conButton.setFont(new Font("Osward", Font.BOLD, 28));
		conButton.setForeground(Color.white);
		conButton.setBackground(Color.blue);
		conButton.addActionListener(this);
		add(conButton);
		
		backButton = new JButton("Back");
		backButton.setBounds(400, 550, 200, 40);
		backButton.setFont(new Font("Osward", Font.BOLD, 28));
		backButton.setForeground(Color.white);
		backButton.setBackground(Color.blue);
		backButton.addActionListener(this);
		add(backButton);
		
		setVisible(true);
		setSize(700, 700);
		setLocation(100, 50);
		getContentPane().setBackground(Color.CYAN);
	}
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent ae){
		String oldPass = oPassTf.getText();
		String newPass = nPassTf.getText();
		String confirmPass = cPassTf.getText();
				;
		
		if(ae.getSource() == conButton) {
			System.out.println(formNo);
			if(oldPass.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter your old PIN : ");
			} else if (newPass.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter your new PIN : ");
			} else if (confirmPass.equals("")) {
				JOptionPane.showMessageDialog(null, "Confirm PIN : ");
			} else {
				try {
					String existingPin = "";
					Conn con = new Conn();
					String getQuery = "Select pinnumber from signupthree where formno = '"+formNo+"' ";
					String saveQuery = "update signupthree set pinnumber = '"+newPass+"' where formno = '"+formNo+"'";
					ResultSet rs = con.query.executeQuery(getQuery);
					while(rs.next()) {
						existingPin = rs.getString("pinnumber");
					}
					if(existingPin.equals(oldPass)) {
						if(newPass.equals(confirmPass)) {
							con.query.executeUpdate(saveQuery);
							JOptionPane.showMessageDialog(null, "Your Pin Successfully Changed");
							setVisible(false);
							new Login().setVisible(true);
						} else {
							JOptionPane.showMessageDialog(null, "Password Does not Mactch");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Your OLD pin is incorrect");
					}
				} catch(Exception e) {
					System.out.println(e);
				}
			}
		} else if (ae.getSource() == backButton) {
			setVisible(false);
			new Home(formNo).setVisible(true);
		}
	}
	public static void main(String[] args) {
		new PinChange("");
	}
}
