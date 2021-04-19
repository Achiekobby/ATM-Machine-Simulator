package ASimulatorSystem;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;
import java.util.Date;


public class FastCash extends JFrame implements ActionListener{
	
	JLabel l1,l2;
	JTextField tf1;
	JButton b1,b2,b3,b4,b5,b6,b7,b8;
	String pin;
	public FastCash(String pin) {
		this.pin = pin;
		
//		loading up the image
		
		ImageIcon image0 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
		Image image1 = image0.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
		ImageIcon image2 = new ImageIcon(image1);
		JLabel imageLabel = new JLabel(image2);
		imageLabel.setBounds(0, 0, 960, 1080);
		add(imageLabel);
		
//		defining LABEL elements for this section
		l1 = new JLabel("SELECT WITHDRAWAL AMOUNT");
		l1.setFont(new Font("Roboto",Font.BOLD,16));
		l1.setForeground(Color.WHITE);
		
		tf1 = new JTextField();
		tf1.setFont(new Font("Roboto",Font.BOLD,14));
		tf1.setForeground(Color.BLACK);
		
//		Defining the BUTTON Elements for this section
		b1 = new JButton("GHc.100");
		
		b2 = new JButton("GHc.500");
		
		b3 = new JButton("GHc.1000");
		
		b4 = new JButton("GHc.2000");

		b5 = new JButton("GHc.5000");
		
		b6 = new JButton("GHc.10,000");
		
		b7 = new JButton("EXIT");
	
		setLayout(null);
	
//		Arranging the buttons and labels on the section
		
		l1.setBounds(235,400,700,40);
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
		 * 
		 * adding the buttons up to the action listener
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
		setLocation(500,0);
		setUndecorated(true);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent actionEvent) {
		
		try {
			
			String amount = ((JButton)actionEvent.getSource()).getText().substring(4);
			Date date = new Date();
			Conn dbConnect = new Conn();
			ResultSet dataFromDB = dbConnect.statement.executeQuery("SELECT * FROM bank WHERE pin = '"+pin+"'");	
			int balance = 0;
			
			while(dataFromDB.next()) {
				if(dataFromDB.getString("mode").equals("Deposit")) {
					
					balance += Integer.parseInt(dataFromDB.getString("amount"));
				}
				else {
					balance -= Integer.parseInt(dataFromDB.getString("amount"));
				}
			}
			if(actionEvent.getSource()!=b7 && balance < Integer.parseInt(amount)) {
				JOptionPane.showMessageDialog(null, "Insufficient Balance");
				return;
			}
			
			if(actionEvent.getSource()==b7) {
				setVisible(false);
				new Transaction(pin).setVisible(true);
			}
			
			else {
			
			String query1 = "insert into bank values('"+pin+"','"+date+"','Withdrawal','"+balance+"')";
			dbConnect.statement.executeUpdate(query1);
			JOptionPane.showMessageDialog(null,  "GHc."+amount+" has been Debited from your account");
			
			setVisible(false);
			new Transaction(pin).setVisible(true);
			}
		}		
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new FastCash("").setVisible(true);

	}

}
