package bankManagementSystem;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;


public class SignupOne extends JFrame implements ActionListener{
	
	long randomNo;
	JTextField nameTextField, fatherTextField, emailTextField, addressTextField, cityTextField, stateTextField, pincodeTextField;
	JButton next;
	JRadioButton male, female, other;
	JDateChooser datePicker;
	JComboBox marritalStatusBox;
	
	SignupOne(){
		
		
		setLayout(null);
		
		Random random = new Random();
		randomNo = Math.abs((random.nextLong() % 900000L) + 100000L);
		
		String[] marriedList = {"Select","Married", "Unmarried", "Divorce"};

		setTitle("SignUp Form");
		
		JLabel formNo = new JLabel("APPLICATION NO :- " + randomNo);
		formNo.setBounds(130, 20, 600, 30);
		formNo.setFont(new Font("Osward", Font.BOLD, 30));
		add(formNo);
		
		JLabel perDetail = new JLabel("PAGE 1 : PERSONAL DETAILS");
		perDetail.setBounds(170, 60, 400, 30);
		perDetail.setFont(new Font("Osward", Font.BOLD, 22));
		add(perDetail);
		
		JLabel name = new JLabel("NAME :");
		name.setBounds(80, 130, 220, 25);
		name.setFont(new Font("Osward", Font.BOLD, 20));
		add(name);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(300, 130, 280, 30);
		nameTextField.setFont(new Font("Osward", Font.PLAIN, 18));
		add(nameTextField);
		
		JLabel fatherName = new JLabel("FATHER'S NAME :");
		fatherName.setBounds(80, 175, 220, 25);
		fatherName.setFont(new Font("Osward", Font.BOLD, 20));
		add(fatherName);
		
		fatherTextField = new JTextField();
		fatherTextField.setBounds(300, 175, 280, 30);
		fatherTextField.setFont(new Font("Osward", Font.PLAIN, 18));
		add(fatherTextField);
		
		JLabel dob = new JLabel("DATE OF BIRTH :");
		dob.setBounds(80, 220, 220, 25);
		dob.setFont(new Font("Osward", Font.BOLD, 20));
		add(dob);
		
		datePicker = new JDateChooser();
		datePicker.setBounds(300, 220, 280, 30);
		datePicker.setFont(new Font("Osward", Font.PLAIN, 18));
		add(datePicker);
		
		JLabel gender = new JLabel("GENDER :");
		gender.setBounds(80, 265, 220, 25);
		gender.setFont(new Font("Osward", Font.BOLD, 20));
		add(gender);
		
		male = new JRadioButton("Male");
		male.setBounds(300, 265, 100, 25);
		male.setFont(new Font("Osward", Font.PLAIN, 18));
		male.setBackground(Color.WHITE);
		add(male);
		
		female = new JRadioButton("Female");
		female.setBounds(400, 265, 100, 25);
		female.setFont(new Font("Osward", Font.PLAIN, 18));
		female.setBackground(Color.WHITE);
		add(female);
		
		other = new JRadioButton("Other");
		other.setBounds(510, 265, 100, 25);
		other.setFont(new Font("Osward", Font.PLAIN, 18));
		other.setBackground(Color.WHITE);
		add(other);
		
		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(other);
		genderGroup.add(female);
		genderGroup.add(male);
		
		
		
//		JComboBox genderBox = new JComboBox(genderList);
//		genderBox.setBounds(300, 265, 280, 30);
//		genderBox.setFont(new Font("Osward", Font.PLAIN, 18));
//		add(genderBox);
		
		
		JLabel email = new JLabel("EMAIL ADDRESS :");
		email.setBounds(80, 310, 220, 25);
		email.setFont(new Font("Osward", Font.BOLD, 20));
		add(email);
		
		emailTextField = new JTextField();
		emailTextField.setBounds(300, 310, 280, 30);
		emailTextField.setFont(new Font("Osward", Font.PLAIN, 18));
		add(emailTextField);
		
		JLabel marritalStatus = new JLabel("MARRITAL STATUS :");
		marritalStatus.setBounds(80, 355, 220, 25);
		marritalStatus.setFont(new Font("Osward", Font.BOLD, 20));
		add(marritalStatus);
		
		marritalStatusBox = new JComboBox(marriedList);
		marritalStatusBox.setBounds(300, 355, 280, 30);
		marritalStatusBox.setFont(new Font("Osward", Font.PLAIN, 18));
		add(marritalStatusBox);
		
		JLabel address = new JLabel("ADDRESS :");
		address.setBounds(80, 400, 220, 25);
		address.setFont(new Font("Osward", Font.BOLD, 20));
		add(address);
		
		addressTextField = new JTextField();
		addressTextField.setBounds(300, 400, 280, 30);
		addressTextField.setFont(new Font("Osward", Font.PLAIN, 18));
		add(addressTextField);
		
		JLabel city = new JLabel("CITY :");
		city.setBounds(80, 445, 220, 25);
		city.setFont(new Font("Osward", Font.BOLD, 20));
		add(city);
		
		cityTextField = new JTextField();
		cityTextField.setBounds(300, 445, 280, 30);
		cityTextField.setFont(new Font("Osward", Font.PLAIN, 18));
		add(cityTextField);
		
		JLabel state = new JLabel("STATE :");
		state.setBounds(80, 490, 220, 25);
		state.setFont(new Font("Osward", Font.BOLD, 20));
		add(state);
		
		stateTextField = new JTextField();
		stateTextField.setBounds(300, 490, 280, 30);
		stateTextField.setFont(new Font("Osward", Font.PLAIN, 18));
		add(stateTextField);
		
		JLabel pincode = new JLabel("PINCODE :");
		pincode.setBounds(80, 535, 220, 25);
		pincode.setFont(new Font("Osward", Font.BOLD, 20));
		add(pincode);
		
		pincodeTextField = new JTextField();
		pincodeTextField.setBounds(300, 535, 280, 30);
		pincodeTextField.setFont(new Font("Osward", Font.PLAIN, 18));
		add(pincodeTextField);
		
		next = new JButton("Next");
		next.setBounds(480, 590, 100, 40);
		next.setFont(new Font("Osward", Font.BOLD, 20));
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.addActionListener(this);
		add(next);
		
		setVisible(true);
		setSize(650, 700);
		setLocation(400, 50);
		
		getContentPane().setBackground(Color.WHITE);
	}
	
	public void actionPerformed(ActionEvent ae) {
		String formNo = "" + randomNo;
		String name = nameTextField.getText();
		String fatherName = fatherTextField.getText();
		String dob = datePicker.getDate().toString();
		String gender = "";
		if(male.isSelected()) {
			gender = "Male";
		} else if(female.isSelected()) {
			gender = "Female";
		} else if(other.isSelected()) {
			gender = "Other";
		}
		String marriedBoxAns = marritalStatusBox.getSelectedItem().toString();
		String email = emailTextField.getText();
		String address = addressTextField.getText();
		String city = cityTextField.getText();
		String state = stateTextField.getText();
		String pincode = pincodeTextField.getText();
		
		try {
			if(name.equals("")) {
				JOptionPane.showMessageDialog(null, "Name is Required");
			}
			else if(fatherName.equals("")) {
				JOptionPane.showMessageDialog(null, "Father Name is Required");
			}
			else if(dob == null) {
				JOptionPane.showMessageDialog(null, "Date of Birth Required");
			}
			else if(gender.equals("")) {
				JOptionPane.showMessageDialog(null, "Choose your Gender");
			}
			else if(marriedBoxAns == "Select") {
				JOptionPane.showMessageDialog(null, "Select your Relationship Status");
			}
			else if(email.equals("")) {
				JOptionPane.showMessageDialog(null, "Email is Required");
			}
			else if(address.equals("")) {
				JOptionPane.showMessageDialog(null, "Address is Required");
			}
			else if(city.equals("")) {
				JOptionPane.showMessageDialog(null, "City Name is Required");
			}
			else if(state.equals("")) {
				JOptionPane.showMessageDialog(null, "State Name is Required");
			}
			else if(pincode.equals("")) {
				JOptionPane.showMessageDialog(null, "Pincode is Required");
			}
			else {
				
				Conn con = new Conn();
				String saveQuery = "Insert into signup values ('"+formNo+"', '"+name+"', '"+fatherName+"', '"+dob+"', '"+gender+"','"+marriedBoxAns+"','"+email+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
				con.query.executeUpdate(saveQuery);
				
				setVisible(false);
				new SignupTwo(formNo).setVisible(true);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SignupOne();
	}


}
