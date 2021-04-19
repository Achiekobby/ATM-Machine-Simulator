package ASimulatorSystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class Transaction extends JFrame implements ActionListener {
	
	/**
	 * 
	 * defining the values needed in this Transaction Section
	 * seven buttons
	 * one label
	 * define the constructor
	 * 
	 */
	String pin;
	JLabel l1;
	JButton b1,b2,b3,b4,b5,b6,b7;
	
	Transaction(String pin){
		this.pin = pin;
		
		ImageIcon image0 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
		Image image1 = image0.getImage().getScaledInstance(1000,1180, Image.SCALE_DEFAULT);
		ImageIcon image2= new ImageIcon(image1);
		
		JLabel imageLabel = new JLabel(image2);
		imageLabel.setBounds(0, 0, 960,1080);
		add(imageLabel);
		
//		defining LABEL elements for this section
		l1 = new JLabel("Please Select your Transaction");
		l1.setFont(new Font("Roboto",Font.BOLD,16));
		l1.setForeground(Color.WHITE);
		
//		Defining the BUTTON Elements for this section
		b1 = new JButton("DEPOSIT");
		
		b2 = new JButton("CASH WITHDRAWAL");
		
		
		b3 = new JButton("FAST CASH");
		
		b4 = new JButton("MINI STATEMENT");
		
		
		b5 = new JButton("PIN CHANGE");
		
		
		b6 = new JButton("BALANCE ENQUIRY");
		
		b7 = new JButton("EXIT");
		
		
		setLayout(null);
	
//		Arranging the buttons and labels on the section
		l1.setBounds(250,400,700,40);
		imageLabel.add(l1);
		
		b1.setBounds(170, 499, 150, 35);
		imageLabel.add(b1);

		b2.setBounds(390, 499, 150, 35);
		imageLabel.add(b2);
		
		b3.setBounds(170, 543, 150, 35);
		imageLabel.add(b3);
		
		b4.setBounds(390, 543, 150, 35);
		imageLabel.add(b4);
		
		b5.setBounds(170, 588, 150, 35);
		imageLabel.add(b5);
		
		b6.setBounds(390, 588, 150, 35);
		imageLabel.add(b6);
		
		b7.setBounds(390, 633, 150, 35);
		imageLabel.add(b7);
		
		
		/**
		 * adding the buttons up to the action listener
		 * 
		 *
		 */
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		
		/**
		 * setting up the size, location and background color of the section
		 * 
		 */
		
		setSize(960,1080);
		setLocation(400,50);
		setUndecorated(true);
		setVisible(true);
	}
	
	
	
	public void actionPerformed(ActionEvent actionEvent) {
		
		/**
		 * 
		 * 
		 * Getting all the button elements from the section
		 * use the getSource() method to find the buttons
		 * 
		 */
		
		try {
			
			if(actionEvent.getSource() == b1) {
				new Deposit(pin).setVisible(true);
				setVisible(false);
			}
			else if(actionEvent.getSource()==b2) {
				new Withdrawal(pin).setVisible(true);
				setVisible(false);
			}
			else if(actionEvent.getSource()==b3) {
				new FastCash(pin).setVisible(true);
				setVisible(false);
			}
			else if(actionEvent.getSource()==b4) {
				new MiniStatement(pin).setVisible(true);
				setVisible(false);
			}
			
			else if(actionEvent.getSource()==b5) {
				new Pin(pin).setVisible(true);
				setVisible(false);
			}
			else if(actionEvent.getSource()==b6) {
				new BalanceEnquiry(pin).setVisible(true);
			}
			else if(actionEvent.getSource()==b7) {
				System.exit(0);
			}
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Transaction("").setVisible(true);

	}








}
