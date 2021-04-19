package ASimulatorSystem;

/**
 * 
 * @author ACHIE
 * The third sign up page for the account registration
 */

/**
 * 
 * Importing useful files for the sign up
 *
 */
import java.sql.*;
import java.util.Random;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SignUp3 extends JFrame implements ActionListener {
	
//	Useful properties for this class
	
	JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l10a;
	JRadioButton r1,r2,r3,r4;
	JButton b1,b2;
	JCheckBox c1,c2,c3,c4,c5,c6,c7;
	JTextField tf1;
	String formNumber;
	
	SignUp3(String formNumber){
		
		this.formNumber = formNumber;
		
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
		
//		setting up the image
		ImageIcon image0 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/logo.jpg"));
		Image image1 = image0.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
		ImageIcon image2= new ImageIcon(image1);
		
		JLabel imageLabel = new JLabel(image2);
		imageLabel.setBounds(150, 0, 100,100);
		add(imageLabel);
		/**
		 * Specifying the labels for this section
		 */
		
		l0 = new JLabel("Page 3: Account Details");
		l0.setFont(new Font("Roboto",Font.BOLD,20));
		l0.setForeground(Color.gray);
		
		l1 = new JLabel("Account Type:");
		l1.setFont(new Font("Roboto",Font.BOLD,18));
		
		l2 = new JLabel("Card Number:");
		l2.setFont(new Font("Roboto",Font.BOLD,18));
		
		l3 = new JLabel("XXXX-XXXX-XXXX-4184");
		l3.setFont(new Font("Roboto",Font.BOLD,18));
		
		l4 = new JLabel("(Your 16-digit Card Number)");
		l4.setFont(new Font("Roboto",Font.BOLD,13));
		l4.setForeground(Color.gray);
		
		l5 = new JLabel("(It would appear on ATM Card/Cheque Book and Statement)");
		l5.setFont(new Font("Roboto",Font.BOLD,13));
		l5.setForeground(Color.gray);
		
		l6 = new JLabel("PIN:");
		l6.setFont(new Font("Roboto",Font.BOLD,18));
		
		l7 = new JLabel("XXXX");
		l7.setFont(new Font("Roboto",Font.BOLD,18));
		
		l8 = new JLabel("(4-digit password)");
		l8.setFont(new Font("Roboto",Font.BOLD,13));
		l8.setForeground(Color.gray);
		
		l9 = new JLabel("Services Required:");
		l9.setFont(new Font("Roboto",Font.BOLD,18));
		
		l10 = new JLabel("Form No.");
		l10.setFont(new Font("Roboto",Font.BOLD,14));
		
		l10a = new JLabel(formNumber);
		l10a.setFont(new Font("Roboto",Font.BOLD,14));
		
		/**
		 * Specifying the radio buttons for the section account type
		 * 
		 */
		
		r1 = new JRadioButton("Saving Account");
		r1.setFont(new Font("Roboto",Font.BOLD,16));
		r1.setBackground(Color.WHITE);

		r2 = new JRadioButton("Fixed Deposit Account");
		r2.setFont(new Font("Roboto",Font.BOLD,16));
		r2.setBackground(Color.WHITE);
	
		r3 = new JRadioButton("Current Account");
		r3.setFont(new Font("Roboto",Font.BOLD,16));
		r3.setBackground(Color.WHITE);
	
		r4 = new JRadioButton("Recurring Deposit Account");
		r4.setFont(new Font("Roboto",Font.BOLD,16));
		r4.setBackground(Color.WHITE);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(r1);
		buttonGroup.add(r2);
		buttonGroup.add(r3);
		buttonGroup.add(r4);
	
		/**
		 * 
		 * Specifying the check box for the section account type
		 * 
		 */
		c1  = new JCheckBox("ATM CARD");
		c1.setFont(new Font("Roboto",Font.BOLD,16));
		c1.setBackground(Color.WHITE);
		
		c2  = new JCheckBox("Internet Banking");
		c2.setFont(new Font("Roboto",Font.BOLD,16));
		c2.setBackground(Color.WHITE);

		c3  = new JCheckBox("Mobile Banking");
		c3.setFont(new Font("Roboto",Font.BOLD,16));
		c3.setBackground(Color.WHITE);

		c4  = new JCheckBox("EMAIL Alerts");
		c4.setFont(new Font("Roboto",Font.BOLD,16));
		c4.setBackground(Color.WHITE);

		c5  = new JCheckBox("Cheque Book");
		c5.setFont(new Font("Roboto",Font.BOLD,16));
		c5.setBackground(Color.WHITE);

		c6  = new JCheckBox("E-Statement");
		c6.setFont(new Font("Roboto",Font.BOLD,16));
		c6.setBackground(Color.WHITE);

		c7  = new JCheckBox("I hereby declare that the above entered details correct to the best of my knowledge.",true);
		c7.setFont(new Font("Roboto",Font.BOLD,13));
		c7.setBackground(Color.WHITE);
		
		/**
		 * 
		 * Specifying the button for the section account type
		 * 
		 */
		
		b1 = new JButton("SUBMIT");
		b1.setFont(new Font("Roboto",Font.BOLD,16));
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		

		b2 = new JButton("CANCEL");
		b2.setFont(new Font("Roboto",Font.BOLD,16));
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		

		/**
		 * 
		 * Specifying the text field for the section account type
		 * 
		 */
		
		tf1 = new JTextField();
		tf1.setFont(new Font("Roboto",Font.BOLD,12));
		
		setLayout(null);
		
//		setting the bounds for the form number element
		l10.setBounds(660,10,70,30);
		add(l10);
		
		l10a.setBounds(720, 10, 60, 30);
		add(l10a);
		
//		setting the bounds for the page title
		l0.setBounds(280, 50, 400, 40);
		add(l0);
		
//		setting the bounds for the type of account
		l1.setBounds(100, 140, 200, 20);
		add(l1);
		
		r1.setBounds(100, 180, 150,30);
		add(r1);
		
		r2.setBounds(350,180,300,30);
		add(r2);
		
		r3.setBounds(100, 220, 250, 30);
		add(r3);
		
		r4.setBounds(350, 220, 250, 30);
		add(r4);
		
		l2.setBounds(100, 300, 200, 30);
		add(l2);
		
		l3.setBounds(330, 300, 250, 30);
		add(l3);
		
		l4.setBounds(100, 330, 200, 20);
		add(l4);
		
		l5.setBounds(330, 330,500,20);
		add(l5);
		
		l6.setBounds(100,370,200,20);
		add(l6);
		
		l7.setBounds(330, 370, 200, 30);
		add(l7);
		
		l8.setBounds(100,400,200,20);
		add(l8);
		
		l9.setBounds(100, 450, 200, 20);
		add(l9);
		
//		setting the bounds for the check box
		c1.setBounds(100, 500, 200, 30);
		add(c1);
		
		c2.setBounds(350, 500, 200, 30);
		add(c2);
		
		c3.setBounds(100, 550, 200, 30);
		add(c3);
		
		c4.setBounds(350, 550, 200, 30);
		add(c4);
		
		c5.setBounds(100, 600, 200, 30);
		add(c5);
		
		c6.setBounds(350, 600, 200, 30);
		add(c6);
		
		c7.setBounds(100, 650, 600, 30);
		add(c7);
		
//		setting the button bounds 
		b1.setBounds(300,720,100,30);
		add(b1);
		
		b2.setBounds(420, 720, 100, 30);
		add(b2);

		b1.addActionListener(this);
		b2.addActionListener(this);
		getContentPane().setBackground(Color.WHITE);
		setSize(800,800);
		setLocation(400,50);
		setVisible(true);	
	}
	
	public void actionPerformed(ActionEvent actionEvent) {
		/**
		 * getting all the elements in the form created by the constructor.
		 * JComboBox makes use of the getSelectedItem() method.
		 * JTextField makes use of the getText() method.
		 * JRadioButton makes use of the isSelected() method.
		 */
		
		String accountType = null;
		if(r1.isSelected()) {
			accountType = "Saving Account";
		}
		else if(r2.isSelected()) {
			accountType = "Fixed Deposit Account";
		}
		else if(r3.isSelected()) {
			accountType = "Current Account";
		}
		else if(r4.isSelected()) {
			accountType = "Recurrent Deposit Account";
		}
		
		/**
		 * Generating a cardNumber and cardPassword
		 */
		Random rand = new Random();
		long first7 = (rand.nextLong() % 90000000L)+5040936000000000L;
		long cardNumber = Math.abs(first7);
		
		long first4 = (rand.nextLong()%9000L)+1000L;
		long cardPass = Math.abs(first4);
		
		String servicesRequired = "";
		if(c1.isSelected()) {
			servicesRequired = servicesRequired + " -ATM Card ";
		}
		if(c2.isSelected()) {
			servicesRequired  = servicesRequired + " -Internet Banking ";
		}
		if(c3.isSelected()) {
			servicesRequired = servicesRequired + " -Mobile Banking ";
		}
		if(c4.isSelected()) {
			servicesRequired = servicesRequired + " -EMAIL Alerts";
		}
		if(c5.isSelected()) {
			servicesRequired = servicesRequired + " -Cheque Book";
		}
		if(c6.isSelected()) {
			servicesRequired = servicesRequired + " -E-Statement";
		}
		
		
			
		try {
			if(actionEvent.getSource()==b1) {
				
				if(servicesRequired.equals("") || accountType.equals("")) {
					JOptionPane.showMessageDialog(null, "Fill all the required Fields");
				}
			
			else {
				Conn dbConnect= new Conn();
				String query1 = "insert into signup3 values('"+formNumber+"','"+accountType+"','"+cardNumber+"','"+cardPass+"','"+servicesRequired+"') ";
				String query2 = "insert into login values('"+formNumber+"','"+cardNumber+"','"+cardPass+"')";
				
				dbConnect.statement.execute(query1);
				dbConnect.statement.execute(query2);
				
				JOptionPane.showMessageDialog(null, "Card Number: "+cardNumber+"\n Pin: "+cardPass);
				
				new Login().setVisible(true);
				setVisible(false);
				
				
				}
			}
			else if(actionEvent.getSource()==b2) {
				System.exit(0);
			}
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SignUp3("").setVisible(true);
	}

}
