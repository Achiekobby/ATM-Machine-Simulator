package ASimulatorSystem;

/**
 * 
 * @author ACHIE
 * Connection with the database "ATM".
 *import the SQL utility files in java 
 */

import java.sql.*;

public class Conn {
	
	Connection connect = null;
	Statement statement = null;

	public Conn() {
		// TODO
		/**
		 * declaring the necessary connection variables for the dbConnect
		 */
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql:///atm","root","");
			statement = connect.createStatement();
			System.out.println("Connection has been achieved");
		}
		catch(Exception e) {
			System.out.println("Error: "+e);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Conn();

	}

}
