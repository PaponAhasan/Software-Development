package BackupInventoryManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login {

	private JFrame frame;
	private JTextField txtEmail;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Change obj = new Change();
		obj.name();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		connect();
	}
	
	Connection connection;
	PreparedStatement preparedStatement;
	DefaultTableModel defaultTableModel;
	
	
	public void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/inventorymanagement","root","");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(100, 149, 237));
		frame.setBounds(100, 100, 329, 472);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JButton btnNewButton_2_1 = new JButton("Login");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//final String QUERY = "select id,CName,CEmail,UName,Phone,Password,NPassword from users";
				String emailStr = txtEmail.getText();
				char[] PStr = txtPassword.getPassword();
				String PasswordStr = String.valueOf(PStr);
				
				try {
					Statement statement = connection.createStatement(); 
					ResultSet rs = statement.executeQuery("SELECT * FROM users");
			            while (rs.next()) {
			                String CEmail = rs.getString(3);
			                String Password = rs.getString(6);
			                if(CEmail.equals(emailStr) && PasswordStr.equals(Password)) {
			                	Main main = new Main();
			    				main.NewScreen();
			    				frame.dispose();
			                }
			               
//			          String data = rs.getString(2);
//			          System.out.println("Fetching data by column index for row " + rs.getRow() + " : " + Phone);
			            }
			     }
				 catch (Exception e2) {
					System.out.println(e);
			     }
			}
		});
		btnNewButton_2_1.setForeground(new Color(0, 128, 128));
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2_1.setBackground(new Color(64, 224, 208));
		btnNewButton_2_1.setBounds(229, 202, 73, 38);
		frame.getContentPane().add(btnNewButton_2_1);
		
		JLabel lblNewLabel_4 = new JLabel("Login Start to Your Session");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(60, 37, 199, 17);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Email :");
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_1.setBounds(10, 106, 64, 14);
		frame.getContentPane().add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Password :");
		lblNewLabel_4_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_1_1.setBounds(10, 157, 89, 14);
		frame.getContentPane().add(lblNewLabel_4_1_1);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(94, 101, 208, 29);
		frame.getContentPane().add(txtEmail);
		
		JButton btnNewButton_2_1_1 = new JButton("Reset");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtEmail.setText("");
				txtPassword.setText("");
			}
		});
		btnNewButton_2_1_1.setForeground(new Color(0, 128, 128));
		btnNewButton_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2_1_1.setBackground(new Color(64, 224, 208));
		btnNewButton_2_1_1.setBounds(94, 202, 73, 38);
		frame.getContentPane().add(btnNewButton_2_1_1);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPassword.setBounds(94, 147, 208, 29);
		frame.getContentPane().add(txtPassword);
		
		JLabel lblNewLabel_4_2 = new JLabel("Create an account?");
		lblNewLabel_4_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Users users = new Users();
				users.NewScreen();
				frame.dispose();
			}
		});
		lblNewLabel_4_2.setForeground(Color.WHITE);
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_2.setBounds(94, 256, 129, 17);
		frame.getContentPane().add(lblNewLabel_4_2);
	}
}
