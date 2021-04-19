package ASimulatorSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
	
	/**
	 * 
	 * @param args
	 * defining the useful swing elements
	 */
	JLabel l1,l2,l3;
	JTextField tf1, tf2;
	JButton b1,b2,b3;
	String pin;
	/**
	 * 
	 * @param null
	 * Constructor
	 */
	Deposit(String pin){
		
		this.pin = pin;
		
		ImageIcon image0 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
		Image image1 = image0.getImage().getScaledInstance(1000,1180, Image.SCALE_DEFAULT);
		ImageIcon image2= new ImageIcon(image1);
		
		JLabel imageLabel = new JLabel(image2);
		imageLabel.setBounds(0, 0, 960,1080);
		add(imageLabel);
		
		
//		setting up the fields found on the section viewport
		setLayout(null);
		
		l1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
		l1.setFont(new Font("Roboto",Font.PLAIN,16));
		l1.setForeground(Color.WHITE);
		l1.setBounds(200, 370, 300, 40);
		imageLabel.add(l1);
		
//		FOR THE TEXT FIELD
		tf1 = new JTextField();
		tf1.setFont(new Font("Roboto",Font.BOLD,16));
		tf1.setForeground(Color.black);		
		tf1.setBounds(220, 430, 250, 40);
		imageLabel.add(tf1);
		
//		FOR THE DEPOSIT BUTTON
		b1 = new JButton("DEPOSIT");
		b1.setBounds(390, 543, 150, 35);
		imageLabel.add(b1);
		b1.addActionListener(this);
		
		b2 = new JButton("BACK");
		b2.setBounds(390, 588, 150, 35);
		imageLabel.add(b2);
		b2.addActionListener(this);
		
		b3 = new JButton("EXIT");
		b3.setBounds(390, 633, 150, 35);
		imageLabel.add(b3);
		b3.addActionListener(this);
		
//		setting the viewport for the section
		setUndecorated(true);
		setSize(960,1080);
		setLocation(500,0);
		setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent actionEvent) {
		
		
		try {
			Conn dbConnect= new Conn();
			if(actionEvent.getSource()==b1) {
				if(tf1.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "All fields must be filled");
				}
				else {
					String depositValue = tf1.getText();
					Date date = new Date();
					dbConnect.statement.executeUpdate("insert into bank values ('"+pin+"','"+date+"','Deposit','"+depositValue+"')");
					
					JOptionPane.showMessageDialog(null,"GHC "+depositValue+" has been Deposited Succesfully");
					setVisible(false);
					new Transaction(pin).setVisible(true);	
				}
			}
			else if(actionEvent.getSource()==b2) {
				setVisible(false);
				new Transaction(pin).setVisible(true);
				
			}
			else if(actionEvent.getSource()==b3) {
				System.exit(0);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Deposit("").setVisible(true);

	}

}
