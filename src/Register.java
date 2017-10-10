import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Register extends JFrame implements ActionListener{

	// make the fields global so we can see them!!
	JTextField username = null;
	JTextField password = null;
	JTextField email = null;
	JTextField age = null;
	
	public Register(){

		setSize(350,350);
		setVisible(true);
		this.setLayout(new GridLayout(5,1));

		JLabel un = new JLabel("Username:");
        this.add(un);
		username = new JTextField(20);
		this.add(username);
		
		JLabel pw = new JLabel("Password:");
		this.add(pw);
		password = new JTextField(20);
		this.add(password);
		
		JLabel em = new JLabel("Email:");
        this.add(em);
		email = new JTextField(20);
		this.add(email);
		
		JLabel ag = new JLabel("Age:");
        this.add(ag);
		age = new JTextField(20);
		this.add(age);
		
		JButton register = new JButton("Register");
		register.addActionListener(this);
		
		this.add(register);
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new Register();
	}
	
	public void registerNewUser(){
		
		try {
			  Class.forName("com.mysql.jdbc.Driver").newInstance();
		}catch(Exception e ){}
			
		Connection conn = null;
	    Statement stmt = null;
	    try {
	    	conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/test?user=root&password=");
	    	// Do something with the Connection
	    	stmt = conn.createStatement();

	    	String un = username.getText();
	    	String pw = password.getText();
	    	String em = email.getText();
	    	String ag = age.getText();
	    	
	    	if (stmt.execute("INSERT INTO `samplelogin` (`username`, `password`, `email`, `age` ) "
	    	    	+ "VALUES ('"+un+"', '"+pw+"', '"+em+"','"+ag+"');")) {
	    	}

	    	    JOptionPane.showMessageDialog(this, "User Registered!");
                setVisible(false);
	    	     	    	   
	    	} catch (SQLException ex) {
	    	    // handle any errors
	    	    System.out.println("SQLException: " + ex.getMessage());
	    	    System.out.println("SQLState: " + ex.getSQLState());
	    	    System.out.println("VendorError: " + ex.getErrorCode());
	    	}

		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		registerNewUser();
	}

}
