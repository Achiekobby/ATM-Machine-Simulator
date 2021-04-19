package ASimulatorSystem;

/**
 * 
 * @author ACHIE
 * Withdrawal class to allow the user to retrieve money from the accounts.
 * importing the values
 * 
 */

import java.awt.*;
import java.util.*;
import java.util.Date;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Withdrawal extends JFrame implements ActionListener{
	
	JLabel l1,l2,l3,l4;
	JTextField tf1,tf2;
	JButton b1,b2,b3;
	String pin;

	public Withdrawal(String pin) {
		
		this.pin = pin;

		ImageIcon image0 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
		Image image1 = image0.getImage().getScaledInstance(1000,1180, Image.SCALE_DEFAULT);
		ImageIcon image2= new ImageIcon(image1);
		
		JLabel imageLabel = new JLabel(image2);
		imageLabel.setBounds(0, 0, 960,1080);
		add(imageLabel);
		
//		setting up the labels
		l1 = new JLabel("MAXIMUM DIALY WITHDRAWAL IS GHc.10,000");
		l1.setFont(new Font("Roboto",Font.PLAIN,16));
		l1.setForeground(Color.WHITE);
		
		l2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
		l2.setFont(new Font("Roboto",Font.PLAIN,16));
		l2.setForeground(Color.WHITE);
		
		
//		setting up the text field
		tf1 = new JTextField();
		tf1.setFont(new Font("Roboto",Font.BOLD,16));
		tf1.setForeground(Color.BLACK);
		
//		setting up the three buttons
		b1 = new JButton("WITHDRAW");
		
		b2 = new JButton("BACK");
		
		b3  = new JButton("EXIT");
		
//		setting up the size of the withdrawal window
		setLayout(null);
		
//		setting up the position of the above defined elements;
		
		l1.setBounds(180, 350, 350, 40);
		imageLabel.add(l1);
		
		l2.setBounds(220, 380, 300, 40);
		imageLabel.add(l2);
		
		tf1.setBounds(210, 430, 280, 40);
		imageLabel.add(tf1);
		
		b1.setBounds(390, 543, 150, 35);
		imageLabel.add(b1);
		
		b2.setBounds(390, 588, 150, 35);
		imageLabel.add(b2);
		
		b3.setBounds(390, 633, 150, 35);
		imageLabel.add(b3);
		
		setUndecorated(true); 
		setSize(960,960);
		setLocation(500,0);
		setVisible(true);
	
//		adding the action listeners to the buttons
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent actionEvent) {
		
		/**
		 * getting the input value
		 * 
		 */
		
		try {
			
			Conn dbConnect = new Conn();
			if(actionEvent.getSource() == b1) {
				if(tf1.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "All fields must be filled", "ERROR",JOptionPane.ERROR_MESSAGE);
				}
				else {
					String withdrawalAmount = tf1.getText();
					Date date = new Date();
					ResultSet result = dbConnect.statement.executeQuery("SELECT * FROM bank WHERE pin = '"+pin+"'");
					
					int balanceInAccount = 0;
					while(result.next()) {
						if(result.getString("mode").equals("Deposit")) {
							
							balanceInAccount += Integer.parseInt(result.getString("amount"));
						}
						else {
							balanceInAccount -= Integer.parseInt(result.getString("amount"));
						}
					}
					if(balanceInAccount < Integer.parseInt(withdrawalAmount)) {
						JOptionPane.showMessageDialog(null, "Insufficient Balance");
						return;
					}
					
					String withdrawQuery = "insert into bank values('"+pin+"','"+date+"','Withdrawal','"+withdrawalAmount+"')";
					
					dbConnect.statement.execute(withdrawQuery);
					
					JOptionPane.showMessageDialog(null, "You have just taken \n GHc."+withdrawalAmount+" from your account", "SUCCESS!!!",JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);
					new Transaction(pin).setVisible(true);
					
						}
						
					}
			
			else if(actionEvent.getSource()==b2) {
				new Transaction(pin).setVisible(true);
				setVisible(false);
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
		new Withdrawal("").setVisible(true);

	}

}
