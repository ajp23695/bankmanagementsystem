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
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

public class SignupTwo extends JFrame implements ActionListener {
	
	JComboBox religionBox, categoryBox, incomeBox, qualificationBox;
	JRadioButton srYes, srNo, accYes, accNo;
	JTextField aadharField;
	JPasswordField pancardField;
	ButtonGroup seniorBG, accountBG;
	JButton nextBtn;
	String formNo;
	SignupTwo(String formNo){
		this.formNo = formNo;
		setLayout(null);
		String[] religionList = {"Select","Hindu", "Muslim", "Sikh", "Christian"};
		String[] categoryList = {"Select","Open", "SEBC", "SC"};
		String[] incomeList = {"Select","10,000 to 20,000", "20,000 to 50,000", "50,000 to 2,50,000", "More then 2,50,000"};
		String[] qualificationList = {"Select","10th Pass", "Bachelors", "Masters", "PHD"};
		
		
		
		JLabel detail = new JLabel("Form 2: Additional Details");
		detail.setBounds(220, 20, 600, 40);
		detail.setFont(new Font("Osward", Font.BOLD, 30));
		add(detail);
		
		JLabel religion = new JLabel("Religion :");
		religion.setBounds(60, 100, 300, 30);
		religion.setFont(new Font("Osward", Font.BOLD, 24));
		add(religion);
		
		religionBox = new JComboBox(religionList);
		religionBox.setBounds(300, 100, 430, 30);
		religionBox.setFont(new Font("Osward", Font.PLAIN,24));
		add(religionBox);
		
		JLabel category = new JLabel("Category :");
		category.setBounds(60, 160, 300, 30);
		category.setFont(new Font("Osward", Font.BOLD, 24));
		add(category);
		
		categoryBox = new JComboBox(categoryList);
		categoryBox.setBounds(300, 160, 430, 30);
		categoryBox.setFont(new Font("Osward", Font.PLAIN, 24));
		add(categoryBox);
		
		JLabel income = new JLabel("Income :");
		income.setBounds(60, 220, 300, 30);
		income.setFont(new Font("Osward", Font.BOLD, 24));
		add(income);
		
		incomeBox = new JComboBox(incomeList);
		incomeBox.setBounds(300, 220, 430, 30);
		incomeBox.setFont(new Font("Osward", Font.PLAIN, 24));
		add(incomeBox);
	
		JLabel qualification = new JLabel("Qualification :");
		qualification.setBounds(60, 280, 300, 30);
		qualification.setFont(new Font("Osward", Font.BOLD, 24));
		add(qualification);
		
		qualificationBox = new JComboBox(qualificationList);
		qualificationBox.setBounds(300, 280, 430, 30);
		qualificationBox.setFont(new Font("Osward", Font.PLAIN, 24));
		add(qualificationBox);
		
		JLabel pancard = new JLabel("Pancard No :");
		pancard.setBounds(60, 340, 300, 30);
		pancard.setFont(new Font("Osward", Font.BOLD, 24));
		add(pancard);
		
		pancardField = new JPasswordField();
		pancardField.setBounds(300, 340, 430, 30);
		pancardField.setFont(new Font("Osward", Font.PLAIN, 24));
		add(pancardField);
		
		JLabel aadhar = new JLabel("Aadhar No :");
		aadhar.setBounds(60, 400, 300, 30);
		aadhar.setFont(new Font("Osward", Font.BOLD, 24));
		add(aadhar);
		
		aadharField = new JTextField();
		aadharField.setBounds(300, 400, 430, 30);
		aadharField.setFont(new Font("Osward", Font.PLAIN, 24));
		add(aadharField);
		
		JLabel senior = new JLabel("Senior Citizen :");
		senior.setBounds(60, 460, 300, 30);
		senior.setFont(new Font("Osward", Font.BOLD, 24));
		add(senior);
		
		srYes = new JRadioButton("Yes");
		srYes.setBounds(370, 460, 100, 30);
		srYes.setFont(new Font("Osward", Font.PLAIN, 24));
		srYes.setBackground(Color.white);
		add(srYes);
		
		srNo = new JRadioButton("No");
		srNo.setBounds(570, 460, 100, 30);
		srNo.setFont(new Font("Osward", Font.PLAIN, 24));
		srNo.setBackground(Color.white);
		add(srNo);
		
		seniorBG = new ButtonGroup();
		seniorBG.add(srYes);
		seniorBG.add(srNo);
		
		
		JLabel existing = new JLabel("Existing Account :");
		existing.setBounds(60, 520, 300, 30);
		existing.setFont(new Font("Osward", Font.BOLD, 24));
		add(existing);
		
		accYes = new JRadioButton("Yes");
		accYes.setBounds(370, 520, 100, 30);
		accYes.setFont(new Font("Osward", Font.PLAIN, 24));
		accYes.setBackground(Color.white);
		add(accYes);
		
		accNo = new JRadioButton("No");
		accNo.setBounds(570, 520, 100, 30);
		accNo.setFont(new Font("Osward", Font.PLAIN, 24));
		accNo.setBackground(Color.white);
		add(accNo);
		
		accountBG = new ButtonGroup();
		accountBG.add(accYes);
		accountBG.add(accNo);
		
		nextBtn = new JButton("Next");
		nextBtn.setBounds(600, 570, 130, 40);
		nextBtn.setFont(new Font("Osward", Font.PLAIN, 24));
		nextBtn.setBackground(Color.BLACK);
		nextBtn.setForeground(Color.white);
		nextBtn.addActionListener(this);
		add(nextBtn);
		
		
		
		
		setVisible(true);
		setSize(800,700);
		setLocation(250, 30);
		getContentPane().setBackground(Color.white);
	}
	
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent ae) {
		String religion, category, income, qualification, pancardNo, aadharNo, senior, account;
		religion = religionBox.getSelectedItem().toString();
		category = categoryBox.getSelectedItem().toString();
		income = incomeBox.getSelectedItem().toString();
		qualification = qualificationBox.getSelectedItem().toString();
		pancardNo = pancardField.getText();
		aadharNo = aadharField.getText();
		
		senior = "";
		if(srYes.isSelected()) {
			senior = "Yes";
		} else if (srNo.isSelected()) {
			senior = "No";
		}
		
		account = "";
		if(accYes.isSelected()) {
			account = "Yes";
		} else if (accNo.isSelected()) {
			account = "No";
		}
		
		if(religion.equals("Select")) {
			JOptionPane.showMessageDialog(null, "Choose your Religion");
		} else if (category.equals("Select")) {
			JOptionPane.showMessageDialog(null, "Choose your Category");
		} else if (income.equals("Select")) {
			JOptionPane.showMessageDialog(null, "Choose your Income Range");
		} else if (qualification.equals("Select")) {
			JOptionPane.showMessageDialog(null, "Choose your Qualification");
		} else if (pancardNo.equals("")) {
			JOptionPane.showMessageDialog(null, "Enter Your Pancard No");
		} else if (aadharNo.equals("")) {
			JOptionPane.showMessageDialog(null, "Enter Your Aadhar No");
		} else if (senior.equals("")) {
			JOptionPane.showMessageDialog(null, "Choose that you are Senior Citizen or Not");
		} else if (account.equals("")) {
			JOptionPane.showMessageDialog(null, "Do you have a existing account or not");
		
		} else {
			try {
				String saveQuery = "Insert into signuptwo values ('"+formNo+"','"+religion+"','"+category+"','"+income+"','"+qualification+"','"+aadharNo+"','"+pancardNo+"','"+senior+"','"+account+"')";
				Conn con = new Conn();
				con.query.executeUpdate(saveQuery);
				setVisible(false);
				new SignupThree(formNo).setVisible(true);
			} catch (Exception e) {
				System.out.println(e);
				
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		new SignupTwo("");
	}
	
	
}
