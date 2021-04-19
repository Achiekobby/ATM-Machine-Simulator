package ASimulatorSystem;

import java.util.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class BalanceEnquiry extends JFrame implements ActionListener {
	  	JTextField t1, t2;
	    JButton b1, b2, b3;
	    JLabel l1, l2;
	    String pin;
	

	public BalanceEnquiry(String pin) {
		// TODO Auto-generated constructor stub
		this.pin = pin;
		//setting up  the image icon
		ImageIcon image0 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
		Image image1 = image0.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
		ImageIcon imageIcon = new ImageIcon(image1);
		
		JLabel imageLabel = new JLabel(imageIcon);
		imageLabel.setBounds(0, 0, 960, 1080);
		add(imageLabel);
		
		
		   	l1 = new JLabel();
	        l1.setForeground(Color.WHITE);
	        l1.setFont(new Font("System", Font.BOLD, 16));

	        b1 = new JButton("BACK");

	        setLayout(null);

	        l1.setBounds(190, 350, 400, 35);
	        imageLabel.add(l1);

	        b1.setBounds(390, 633, 150, 35);
	        imageLabel.add(b1);
	        
	        int balance = 0;
	        try{
	            Conn c1 = new Conn();
	            ResultSet rs = c1.statement.executeQuery("select * from bank where pin = '"+pin+"'");
	            while (rs.next()) {
	                if (rs.getString("mode").equals("Deposit")) {
	                    balance += Integer.parseInt(rs.getString("amount"));
	                } else {
	                    balance -= Integer.parseInt(rs.getString("amount"));
	                }
	            }
	        }catch(Exception e){
	        	e.printStackTrace();
	        }
	        
	        l1.setText("Your Current Account Balance is Rs "+balance);

	        b1.addActionListener(this);

	        setSize(960, 1080);
	        setUndecorated(true);
	        setLocation(500, 0);
	        setVisible(true);
	    }

	    public void actionPerformed(ActionEvent ae) {
	        setVisible(false);
	        new Transaction(pin).setVisible(true);
	    }
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BalanceEnquiry("").setVisible(true);
	}

}
