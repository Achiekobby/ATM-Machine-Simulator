package ASimulatorSystem;


import java.util.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MiniStatement extends JFrame implements ActionListener {
	JTable table1;
	JButton b1,b2;
	JLabel l1;
	String pin;
	
	

	public MiniStatement(String pin) {
		super("Mini Statement");
		this.pin = pin;
		setSize(400,600);
		setLocation(20,20);
		
		l1 = new JLabel();
		add(l1);
		
		JLabel l2 = new JLabel("Bank of Ghana");
		l2.setBounds(150, 20, 100, 20);
		add(l2);
		
		JLabel l3 = new JLabel();
		l3.setBounds(20, 80, 300, 20);
		add(l3);
		
		JLabel l4 = new JLabel();
		l4.setBounds(20, 400, 300, 20);
		add(l4);
		
		try {
			Conn dbConnect = new Conn();
			ResultSet result = dbConnect.statement.executeQuery("select * from login where pin ='"+pin+"'");
			
			while(result.next()) {
				l3.setText("Card Number:    " + result.getString("cardno").substring(0, 4) + "XXXXXXXX" + result.getString("cardno").substring(12));
			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		 try{
	            int balance = 0;
	            Conn dbConnect  = new Conn();
	            ResultSet result = dbConnect.statement.executeQuery("SELECT * FROM bank where pin = '"+pin+"'");
	            while(result.next()){
	                l1.setText(l1.getText() + "<html>"+result.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + result.getString("mode") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + result.getString("amount") + "<br><br><html>");
	                if(result.getString("mode").equals("Deposit")){
	                    balance += Integer.parseInt(result.getString("amount"));
	                }else{
	                    balance -= Integer.parseInt(result.getString("amount"));
	                }
	            }
	            l4.setText("Your total Balance is GHc. "+balance);
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	        
	        setLayout(null);
	        
	        b1 = new JButton("Exit");
	        add(b1);
	        
	        b1.addActionListener(this);
	        
	        l1.setBounds(20, 140, 400, 200);
	        b1.setBounds(20, 500, 100, 25);
	    }
	    public void actionPerformed(ActionEvent ae){
	        this.setVisible(false);
	        new Transaction(pin).setVisible(true);
	    }
		


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MiniStatement("").setVisible(true);

	}

}
