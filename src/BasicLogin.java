
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

public class BasicLogin extends JFrame implements ActionListener {
	JTextField username = null;
	JTextField password = null;

	public BasicLogin() {

		setSize(300,300);
		setVisible(true);

		this.setLayout(new GridLayout(3,2));

		JLabel un = new JLabel("Username");
		this.add(un);

		username = new JTextField(20);
		this.add(username);

		JLabel pw = new JLabel("Password");
		this.add(pw);
		password = new JTextField(20);
		this.add(password);

		JButton button = new JButton("Login!");
		button.addActionListener(this);
		this.add(button);

		JButton button2 = new JButton("Register");
		button2.addActionListener(this);
		this.add(button2);

		validate();
		repaint();
	}
	
	public static void main(String[] args) {
		new BasicLogin();
	}

	public void loginWithDatabase(){

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}catch(Exception e ){}

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn =
					DriverManager.getConnection("jdbc:mysql://127.0.0.1/test?user=root&password=");
			stmt = conn.createStatement();

			String un = username.getText();
			String pw = password.getText();

			if (stmt.execute("select * from samplelogin where username = '"+un+"' and password = '"+pw+"'")) {
				rs = stmt.getResultSet();
			}

			JOptionPane.showMessageDialog(this, "Logged in!");
			// loop over results

			while(rs.next()){
				int type = rs.getInt("type");
				if (type == 1){
					new ShowingData();
				} else {
					JOptionPane.showMessageDialog(this, "You shall not pass!");
				}
			} 

		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Login!")){
			loginWithDatabase();
		}else if(e.getActionCommand().equals("Register")){
			new Register();
		}
	}
}
