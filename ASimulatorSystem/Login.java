package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
	JLabel  l1,l2,l3;
	JTextField tf1;
	JPasswordField pf2;
	JButton b1,b2,b3;
	
	Login(){
		
		setTitle("AUTOMATED TELLER MACHINE");
		
//		Setting up the image
		ImageIcon image0 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/logo.jpg"));
		Image image1 = image0.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon image2 = new ImageIcon(image1);
		
		JLabel imageLabel = new JLabel(image2);
		imageLabel.setBounds(150, 50, 100, 100);
		add(imageLabel);
		

		
		l1 = new JLabel("WELCOME TO ATM");
		l1.setFont(new Font("Roboto",Font.BOLD,38));
		l1.setForeground(Color.BLACK);
		l1.getAlignmentX();		
		
		l2 = new JLabel("Card No:");
		l2.setFont(new Font("Poppins",Font.BOLD,28));
		l2.setForeground(Color.BLACK);
		
		l3 = new JLabel("PIN:");
		l3.setFont(new Font("Poppins",Font.BOLD,28));
		l3.setForeground(Color.BLACK);
		
//		setting the text field for both the login and password inputs
		tf1 = new JTextField(20);
		pf2 = new JPasswordField(20);
		
//		setting up the three buttons
		b1 = new JButton("SIGN IN");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Roboto",Font.BOLD,20));
		
		b2 = new JButton("CLEAR");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("Roboto",Font.BOLD,20));
		
		b3 = new JButton("SIGN UP");
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.setFont(new Font("Roboto",Font.BOLD,20));
		
		setLayout(null);
		
		l1.setBounds(250,50,450,100);
		add(l1);
		
		l2.setBounds(125,100,375,200);
		add(l2);
		
		l3.setBounds(185,180,375,200);
		add(l3);
		
		tf1.setFont(new Font("Arial",Font.BOLD,14));
		tf1.setBounds(250,180,330,60);
		add(tf1);
		
		pf2.setFont(new Font("Arial",Font.BOLD,14));
		pf2.setBounds(250,250,330,60);
		add(pf2);
		
		b1.setFont(new Font("Arial",Font.BOLD,14));
		b1.setBounds(200,350,150,50);
		add(b1);
		
		b2.setFont(new Font("Arial",Font.BOLD,14));
		b2.setBounds(450,350,150,50);
		add(b2);
		
		b3.setFont(new Font("Arial",Font.BOLD,14));
		b3.setBounds(280,430,230,50);
		add(b3);
		
		/**
		 * Adding action listeners to the three buttons
		 */
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		/**
		 * set the window size and positions
		 * set the background Color of the window
		 * set the location of the frame
		 * calling the set visible method to show the window
		 */
		getContentPane().setBackground(Color.WHITE);
		setSize(750,550);
		setLocation(550,200);
		setVisible(true);
		
		
	}
	
	public void actionPerformed(ActionEvent actionEvent) {
		try {
			Conn dbConnect= new Conn();
			String cardNumber = tf1.getText();
			String pin = new String(pf2.getPassword());
			
			String query = "Select * from login where cardno ='"+cardNumber+"' and pin = '"+pin+"' ";
			ResultSet resultSet = dbConnect.statement.executeQuery(query);
			
			if(actionEvent.getSource()==b1) {
				if(resultSet.next()) {
					new Transaction(pin).setVisible(true);
					setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null,"Incorrect Card number or Pin");
				}
			}
			else if(actionEvent.getSource() == b2) {
				tf1.setText(" ");
				pf2.setText(" ");
			}
			else if(actionEvent.getSource() == b3) {
				new SignUp().setVisible(true);
				setVisible(false);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("error: "+e);
		}
	}
	
	
	public static void main(String[] args) {
		new Login().setVisible(true);
	}

}


