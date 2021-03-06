package ASimulatorSystem;


/**
 * 
 * @author ACHIE
 *importing the necessary packages
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;

public class Pin extends JFrame implements ActionListener {
	   JPasswordField t1,t2;
	    JButton b1,b2;                               
	    JLabel l1,l2,l3;
	    String pin;
	    Pin(String pin){
	        this.pin = pin;
	        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
	        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
	        ImageIcon i3 = new ImageIcon(i2);
	        JLabel l4 = new JLabel(i3);
	        l4.setBounds(0, 0, 960, 1080);
	        add(l4);
	        
	        l1 = new JLabel("CHANGE YOUR PIN");
	        l1.setFont(new Font("System", Font.BOLD, 16));
	        l1.setForeground(Color.WHITE);
	        
	        l2 = new JLabel("New PIN:");
	        l2.setFont(new Font("System", Font.BOLD, 16));
	        l2.setForeground(Color.WHITE);
	        
	        l3 = new JLabel("Re-Enter New PIN:");
	        l3.setFont(new Font("System", Font.BOLD, 16));
	        l3.setForeground(Color.WHITE);
	        
	        t1 = new JPasswordField();
	        t1.setFont(new Font("Raleway", Font.BOLD, 25));
	        
	        t2 = new JPasswordField();
	        t2.setFont(new Font("Raleway", Font.BOLD, 25));
	        
	        b1 = new JButton("CHANGE");
	        b2 = new JButton("BACK");
	        
	        b1.addActionListener(this);
	        b2.addActionListener(this);
	        
	        setLayout(null);
	        
	        l1.setBounds(280,330,800,35);
	        l4.add(l1);
	        
	        l2.setBounds(180,390,150,35);
	        l4.add(l2);
	        
	        l3.setBounds(180,440,200,35);
	        l4.add(l3);
	        
	        t1.setBounds(350,390,180,25);
	        l4.add(t1);
	        
	        t2.setBounds(350,440,180,25);
	        l4.add(t2);
	        
	        b1.setBounds(390,588,150,35);
	        l4.add(b1);
	        
	        b2.setBounds(390,633,150,35);
	        l4.add(b2);
	        
	        setSize(960,1080);
	        setLocation(500,0);
	        setUndecorated(true);
	        setVisible(true);
	    
	    }

	
	public void actionPerformed(ActionEvent actionEvent) {
		
		try {
			
			String newPin = new String(t1.getPassword());
			String confirmPin = new String(t2.getPassword());
			if(!newPin.equals(confirmPin)) {
				JOptionPane.showMessageDialog(null, "Fields do not Match","WARNING",JOptionPane.WARNING_MESSAGE);
				return;
			}
			if(actionEvent.getSource()==b1) {
				if(newPin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Enter your new pin","WARNING",JOptionPane.WARNING_MESSAGE);

				}
				if(confirmPin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please re-enter your new pin","WARNING",JOptionPane.WARNING_MESSAGE);

				}
	
					Conn dbConnect = new Conn();
					String query1 = "UPDATE bank SET pin = '"+newPin+"' WHERE pin = '"+pin+"'";
					String query2 = "UPDATE login SET pin = '"+newPin+"' WHERE pin = '"+pin+"'";
					String query3 = "UPDATE signup3 SET cardPass = '"+newPin+"' WHERE cardPass = '"+pin+"'";
					
					dbConnect.statement.executeUpdate(query1);
					dbConnect.statement.executeUpdate(query2);
					dbConnect.statement.executeUpdate(query3);
					
					JOptionPane.showMessageDialog(null, "Pin changed Successfullly!!","Pin Change", JOptionPane.INFORMATION_MESSAGE);
					
					new Transaction("").setVisible(true);
					setVisible(false);
					
				
			
			}
			else if(actionEvent.getSource()==b2) {
				new Transaction("").setVisible(true);
				setVisible(false);
			}
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Pin("").setVisible(true);

	}

}
