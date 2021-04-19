package ASimulatorSystem;
/**
 * 
 * @author ACHIE
 * Importing useful classes to the project
 */

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class SignUp2 extends JFrame implements ActionListener {
	
	JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l4a,l10a;
	JTextField tf1,tf2,tf3;
	JRadioButton r1,r2,r3,r4;
	JComboBox c1,c2,c3,c4,c5;
	JButton b;
	String formNumber;
	
	SignUp2(String formNumber) {
		
		this.formNumber = formNumber;
		/**
		 * The Application title
		 * The page two label at the top of the page
		 * Centering the title of the page
		 */
		
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
		
//		setting up the image file
		ImageIcon image0 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/logo.jpg"));
		Image image1 = image0.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon image2 = new ImageIcon(image1);
		
		JLabel imageLabel = new JLabel(image2);
		imageLabel.setBounds(150 , 0, 100, 100);
		add(imageLabel);
		
		
		/**
		 * Specifying the page labels of this registration page
		 */
		
		l0 = new JLabel("Page 2: Additional Details");
		l0.setFont(new Font("Roboto",Font.BOLD,20));
		l0.setForeground(Color.gray);
		
		l1 = new JLabel("Religion:");
		l1.setFont(new Font("Roboto",Font.BOLD,20));
		
		l2 = new JLabel("Category:");
		l2.setFont(new Font("Roboto",Font.BOLD,20));
		
		l3 = new JLabel("Income:");
		l3.setFont(new Font("Roboto",Font.BOLD,20));
		
		l4 = new JLabel("Educational");
		l4.setFont(new Font("Roboto",Font.BOLD,20));
		
		l4a = new JLabel("Background:");
		l4a.setFont(new Font("Roboto",Font.BOLD,20));
		
		l5 = new JLabel("Occupation:");
		l5.setFont(new Font("Roboto",Font.BOLD,20));
		
		l6 = new JLabel("PAN Number:");
		l6.setFont(new Font("Roboto",Font.BOLD,20));
		
		l7 = new JLabel("Aadhar Number:");
		l7.setFont(new Font("Roboto",Font.BOLD,20));
		
		l8 = new JLabel("Senior Citizen:");
		l8.setFont(new Font("Roboto",Font.BOLD,20));
		
		l9 = new JLabel("Existing Account:");
		l9.setFont(new Font("Roboto",Font.BOLD,20));
		
		l10 = new JLabel("Form N0.");
		l10.setFont(new Font("Roboto",Font.BOLD,14));
		
		l10a = new JLabel(formNumber);
		l10a.setFont(new Font("Roboto",Font.BOLD,14));
		
		/**
		 * Specifying the combo box fields for the label created above.
		 */
		
		String[] religion = {"Hindu","Christian","Muslim","Bhuddist","Other"};
		c1 = new JComboBox(religion);
		c1.setFont(new Font("Roboto",Font.BOLD,14));
		c1.setBackground(Color.WHITE);
		
		String[] category = {"General","OBC","SC","Other"};
		c2 = new JComboBox(category);
		c2.setFont(new Font("Roboto",Font.BOLD,14));
		c2.setBackground(Color.WHITE);
		
		String[] income = {"< $1000","> $1000","< $5000","> $5000","> $10,000"};
		c3 = new JComboBox(income);
		c3.setFont(new Font("Roboto",Font.BOLD,14));
		c3.setBackground(Color.WHITE);
		
		String[] educationalBackground = {"Non-Graduate","Graduate","Undergraduate","Masters","Doctorate"};
		c4 = new JComboBox(educationalBackground);
		c4.setFont(new Font("Roboto",Font.BOLD,14));
		c4.setBackground(Color.WHITE);
		
		
		String[] occupation = {"Salaried","Self Employed","Retired","Unemployed"};
		c5 = new JComboBox(occupation);
		c5.setFont(new Font("Roboto",Font.BOLD,14));
		c5.setBackground(Color.WHITE);
		
		
		/**
		 * Specifying the text fields of this registration page
		 */
		
		tf1 = new JTextField();
		tf1.setFont(new Font("Roboto",Font.BOLD,14));
		
		tf2 = new JTextField();
		tf2.setFont(new Font("Roboto",Font.BOLD,14));
		
		tf3 = new JTextField();
		tf3.setFont(new Font("Roboto",Font.BOLD,13));
		
		
		/**
		 * Specifying the radio buttons of this registration page
		 * creating a button group
		 * 
		 * 
		 */
		
		r1 = new JRadioButton("Yes");
		r1.setFont(new Font("Roboto",Font.BOLD,14));
		r1.setBackground(Color.WHITE);
		
		r2 = new JRadioButton("No");
		r2.setFont(new Font("Roboto",Font.BOLD,14));
		r2.setBackground(Color.WHITE);
		
		
		r3 = new JRadioButton("Yes");
		r3.setFont(new Font("Roboto",Font.BOLD,14));
		r3.setBackground(Color.WHITE);
		
		r4 = new JRadioButton("No");
		r4.setFont(new Font("Roboto",Font.BOLD,14));
		r4.setBackground(Color.WHITE);
		
		ButtonGroup buttonGroup1 = new ButtonGroup();
		buttonGroup1.add(r1);
		buttonGroup1.add(r2);
		
		ButtonGroup buttonGroup2 = new ButtonGroup();
		buttonGroup2.add(r3);
		buttonGroup2.add(r4);
		
		
		/**
		 * Specifying the next button of this registration page
		 */
		b = new JButton("NEXT");
		b.setBackground(Color.BLACK);
		b.setForeground(Color.WHITE);
		b.setFont(new Font("Roboto",Font.BOLD,18));
		
		setLayout(null);
		/**
		 * 
		 * 
		 * Setting up the position of the form fields and labels of the registration.
		 * setting up the size of the form fields of the registration.
		 * 
		 * 
		 */
//		for form number
		l10.setBounds(570,10,60,30);
		add(l10);
		
		l10a.setBounds(650,10,60,30);
		add(l10a);
		
//		for the page title
		l0.setBounds(280,30,600,40);
		add(l0);
		
//		for the religion field
		l1.setBounds(100,120,100,30);
		add(l1);
		
		c1.setBounds(280,120,320,30);
		add(c1);
		
//		for the category field
		l2.setBounds(100,170,100,30);
		add(l2);
		
		c2.setBounds(280,170,320,30);
		add(c2);
		
//		for the income field
		l3.setBounds(100,220,100,30);
		add(l3);
		
		c3.setBounds(280,220,320,30);
		add(c3);
		
//		for the educational background
		l4.setBounds(100,270,150,30);
		add(l4);
		
		c4.setBounds(280,280,320,30);
		add(c4);
		
		l4a.setBounds(100,290,150,30);
		add(l4a);
		
//		for the occupation field
		l5.setBounds(100,350,150,30);
		add(l5);
		
		c5.setBounds(280,350,320,30);
		add(c5);
		
//		for the PAN Number field
		l6.setBounds(100,400,150,30);
		add(l6);
		
		tf1.setBounds(280, 400, 320, 30);
		add(tf1);
		
//		for the Aadhar Number field
		
		l7.setBounds(100, 450, 150, 30);
		add(l7);
		
		tf2.setBounds(280, 450, 320, 30);
		add(tf2);
		
//		setting up the radio buttons for the senior citizen (yes / no)
		l8.setBounds(100, 500, 150, 30);
		add(l8);
		
		r1.setBounds(280, 500, 150, 30);
		add(r1);
		
		r2.setBounds(460, 500, 100, 30);
		add(r2);
		
//		setting up the radio buttons for the Existing Account(yes/no)
		l9.setBounds(100, 550, 180, 30);
		add(l9);
		
		r3.setBounds(280, 550, 100, 30);
		add(r3);
		
		r4.setBounds(460, 550, 100, 30);
		add(r4);
		
//		for the next button
		b.setBounds(570, 650, 80, 30);
		add(b);
		
		
		b.addActionListener(this);
		
		/**
		 * 
		 * Showing the on the screen the page created
		 * 
		 */
		
		getContentPane().setBackground(Color.WHITE);
		setSize(750,750);
		setLocation(500,120);
		setVisible(true);		
		
	}
	
	/**
	 * 
	 * function for the action event
	 * @param actionEvent
	 *  
	 */
	public void actionPerformed(ActionEvent actionEvent) {
		/**
		 * getting all the elements in the form created by the constructor.
		 * JComboBox makes use of the getSelectedItem() method.
		 * JTextField makes use of the getText() method.
		 * JRadioButton makes use of the isSelected() method.
		 */
//		for the JComboBox Fields
		String religion = (String)c1.getSelectedItem();
		String category = (String)c2.getSelectedItem();
		String income   = (String)c3.getSelectedItem();
		String educationalQualification = (String)c4.getSelectedItem();
		String occupation = (String)c5.getSelectedItem();
		
//		for the JTextField Field
		String panNumber    = tf1.getText();
		String aadharNumber = tf2.getText();
		
//		for the JRadioButton Field
		String seniorCitizen ="";
		if(r1.isSelected()) {
			seniorCitizen = "Yes";
		}
		else if(r2.isSelected()) {
			seniorCitizen = "No";
		}
		
		String existingAccount = null;
		if(r3.isSelected()) {
			existingAccount = "Yes";
		}
		else if(r4.isSelected()) {
			existingAccount = "No";
		}
		
		/**
		 * 
		 * checking to see if the pan number field was filled
		 * Inserting the data into the database
		 * using a try catch to detect any errors during the query execution
		 * 
		 */
		
		try {
			if(tf1.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "The Pan Number should be provided");
			}
			else {
				Conn dbConnect= new Conn();
				String query = "insert into signup2 values('"+formNumber+"','"+religion+"','"+category+"','"+income+"','"+educationalQualification+"','"+occupation+"','"+panNumber+"','"+aadharNumber+"','"+seniorCitizen+"','"+existingAccount+"')";
				dbConnect.statement.executeUpdate(query);
				
				new SignUp3(formNumber).setVisible(true);
				setVisible(false);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
			
	}
	
	
	public static void main(String[] args) {

		/**
		 * main function to show the second registration account
		 */
		
		SignUp2 obj = new SignUp2("");
		obj.setVisible(true);
//		new SignUp2().setVisible(true);
	}

}
