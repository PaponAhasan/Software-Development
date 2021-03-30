package Inventory_Management_System;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Profile{

	private JFrame frame;
	private JTextField txtFName;
	private JTextField txtLName;
	private JTextField txtCName;
	private JTextField txtEmail;
	private JTextField txtUName;
	private JTextField txtPhone;
	private JTextField txtNPassword;
	private JTextField txtCPassword;

	/**
	 * Launch the application.
	 */
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile window = new Profile();
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
	public Profile() {
		initialize();
		connect();
		SetProfile();
	}
	
	Connection connection;
	PreparedStatement preparedStatement;
	DefaultTableModel defaultTableModel;

	public void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/inventorymanagement", "root", "");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void SetProfile() {
		txtEmail.setEnabled(false);
		Statement statement;
		
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM users");
			while (rs.next()) {
                String Email = rs.getString(3);
                //System.out.println(Email);
                if(Email.equals(Login.emailStr)) {
                	String cname = rs.getString(2);
                	String cemail = rs.getString(3);
                	String uname = rs.getString(4);
                	String phone = rs.getString(5);
                	String fname = rs.getString(8);
                	String lname = rs.getString(9);
                	
                	txtCName.setText(cname);
                	txtEmail.setText(cemail);
                	txtUName.setText(uname);
                	txtPhone.setText(phone);
                	txtFName.setText(fname);
                	txtLName.setText(lname);
                	break;
                }
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(100, 149, 237));
		frame.getContentPane().setForeground(new Color(100, 149, 237));
		frame.setBounds(100, 100, 371, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lblProfile = new JLabel("Profile");
		lblProfile.setForeground(Color.WHITE);
		lblProfile.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblProfile.setBounds(144, 11, 65, 38);
		frame.getContentPane().add(lblProfile);
		
		JButton btnNewButton_2_1_1_1 = new JButton("Update");
		btnNewButton_2_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fname = txtFName.getText();
				String lname = txtLName.getText();
				String Cname = txtCName.getText();
				String email = txtEmail.getText();
				String Name = txtUName.getText();
				String phone = txtPhone.getText();
				String password = txtNPassword.getText();
				String Npassword = txtCPassword.getText();
				
				int choice = JOptionPane.showConfirmDialog(null, "Are you sure to Update?", "Update",
						JOptionPane.YES_NO_OPTION);
				
				if(Cname.equals("") && Name.equals("") && phone.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Set your Profile","Warning",3);
				}
				else if(!password.equals(Npassword)) {
					JOptionPane.showMessageDialog(null, "Password do not match","Warning",3);
				}
				else if(password.equals("") || Npassword.equals("")) {
					try {
						preparedStatement = connection.prepareStatement("update users set CName=?,CEmail=?,UName=?,Phone=?,FName=?,LName=? where CEmail=?");
						preparedStatement.setString(1, Cname);
						preparedStatement.setString(2, email);
						preparedStatement.setString(3, Name);
						preparedStatement.setString(4, phone);
						preparedStatement.setString(5, fname);
						preparedStatement.setString(6, lname);
						preparedStatement.setString(7, email);
						preparedStatement.executeUpdate();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Your profile have been update","Warning",3);
				}
				else if(choice==JOptionPane.YES_OPTION ) {
					try {
						preparedStatement = connection.prepareStatement("update users set CName=?,CEmail=?,UName=?,Phone=?,Password=?,NPassword=?,FName=?,LName=? where CEmail=?");
						preparedStatement.setString(1, Cname);
						preparedStatement.setString(2, email);
						preparedStatement.setString(3, Name);
						preparedStatement.setString(4, phone);
						preparedStatement.setString(5, password);
						preparedStatement.setString(6, Npassword);
						preparedStatement.setString(7, fname);
						preparedStatement.setString(8, lname);
						preparedStatement.setString(9, email);
						preparedStatement.executeUpdate();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Your profile have been update","Warning",3);
				}
			}
		});
		btnNewButton_2_1_1_1.setForeground(new Color(0, 128, 128));
		btnNewButton_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2_1_1_1.setBackground(new Color(64, 224, 208));
		btnNewButton_2_1_1_1.setBounds(135, 382, 79, 38);
		frame.getContentPane().add(btnNewButton_2_1_1_1);
		
		JButton btnNewButton_2_1_1_1_1 = new JButton("Clear");
		btnNewButton_2_1_1_1_1.setForeground(new Color(0, 128, 128));
		btnNewButton_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2_1_1_1_1.setBackground(new Color(64, 224, 208));
		btnNewButton_2_1_1_1_1.setBounds(264, 382, 79, 38);
		frame.getContentPane().add(btnNewButton_2_1_1_1_1);
		
		txtFName = new JTextField();
		txtFName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFName.setColumns(10);
		txtFName.setBounds(135, 60, 208, 29);
		frame.getContentPane().add(txtFName);
		
		JLabel lblFirstName = new JLabel("First Name :");
		lblFirstName.setForeground(new Color(255, 255, 255));
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFirstName.setBounds(10, 67, 76, 14);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name :");
		lblLastName.setForeground(new Color(255, 255, 255));
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLastName.setBounds(10, 106, 95, 14);
		frame.getContentPane().add(lblLastName);
		
		txtLName = new JTextField();
		txtLName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtLName.setColumns(10);
		txtLName.setBounds(135, 100, 208, 29);
		frame.getContentPane().add(txtLName);
		
		txtCName = new JTextField();
		txtCName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCName.setColumns(10);
		txtCName.setBounds(135, 139, 208, 29);
		frame.getContentPane().add(txtCName);
		
		JLabel lblNewLabel_1 = new JLabel("Company Name :");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 146, 102, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Company Email :");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 186, 102, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(135, 179, 208, 29);
		frame.getContentPane().add(txtEmail);
		
		JLabel lblNewLabel_3 = new JLabel("User Name :");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 226, 95, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		txtUName = new JTextField();
		txtUName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUName.setColumns(10);
		txtUName.setBounds(135, 220, 208, 29);
		frame.getContentPane().add(txtUName);
		
		JLabel lblNewLabel_4 = new JLabel("Phone :");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(10, 266, 95, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		txtPhone = new JTextField();
		txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPhone.setColumns(10);
		txtPhone.setBounds(135, 260, 208, 29);
		frame.getContentPane().add(txtPhone);
		
		JLabel lblNewLabel_5 = new JLabel("New Password :");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(10, 306, 115, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		txtNPassword = new JTextField();
		txtNPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNPassword.setColumns(10);
		txtNPassword.setBounds(135, 299, 208, 29);
		frame.getContentPane().add(txtNPassword);
		
		JLabel lblNewLabel_6 = new JLabel("Confirm Password :");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(10, 346, 125, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		txtCPassword = new JTextField();
		txtCPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCPassword.setColumns(10);
		txtCPassword.setBounds(135, 339, 208, 29);
		frame.getContentPane().add(txtCPassword);
		
		JLabel lblClose = new JLabel("x");
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				Main main = new Main();
				main.NewScreen();
			}
		});
		lblClose.setForeground(Color.RED);
		lblClose.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblClose.setBounds(10, 0, 18, 28);
		frame.getContentPane().add(lblClose);
	}
}
