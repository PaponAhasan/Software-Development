package Inventory_Management_System;

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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JCheckBox;

public class Login {

	private JFrame frame;
	private JTextField txtEmail;
	private JPasswordField txtPassword;
	private JLabel lblMatch;
	public static String emailStr = "";
	private JCheckBox RCheckBox;

	// This will be the file where the username and password will be saved
	File file = new File(System.getProperty("user.home") + "/Documents/save.txt");

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
		UPDATE();
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

	public void SAVE() { // Save the UserName and Password (for one user)
		try {
			if (!file.exists())
				file.createNewFile(); // if the file !exist create a new one

			BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsolutePath()));
			bw.write(txtEmail.getText()); // write the name
			bw.newLine(); // leave a new Line
			bw.write(txtPassword.getPassword()); // write the password
			bw.close(); // close the BufferdWriter

		} catch (IOException e) {
			e.printStackTrace();
		}

	}// End Of Save

	public void UPDATE() { // UPDATE ON OPENING THE APPLICATION

		try {
			if (file.exists()) { // if this file exists

				Scanner scan = new Scanner(file); // Use Scanner to read the File

				txtEmail.setText(scan.nextLine()); // append the text to name field
				txtPassword.setText(scan.nextLine()); // append the text to password field
				scan.close();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}// End OF UPDATE

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

		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (RCheckBox.isSelected()) {
					SAVE(); // Save This UserName and his PassWord
				}
			}
		});
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// final String QUERY = "select id,CName,CEmail,UName,Phone,Password,NPassword
				// from users";
				emailStr = txtEmail.getText();
				char[] PStr = txtPassword.getPassword();
				String PasswordStr = String.valueOf(PStr);

				try {
					Statement statement = connection.createStatement();
					ResultSet rs = statement.executeQuery("SELECT * FROM users");
					while (rs.next()) {
						String CEmail = rs.getString(3);
						String Password = rs.getString(6);

						if (CEmail.equals(emailStr) && PasswordStr.equals(Password)) {
							Main main = new Main();
							main.NewScreen();
							frame.dispose();
							break;
						} else {
							RCheckBox.setVisible(false);
							lblMatch.setVisible(true);
							lblMatch.setText("Email or password invalid");
						}

//			          String data = rs.getString(2);
//			          System.out.println("Fetching data by column index for row " + rs.getRow() + " : " + Phone);
					}
				} catch (Exception e2) {
					System.out.println(e);
				}
			}
		});
		btnLogin.setForeground(new Color(0, 128, 128));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogin.setBackground(new Color(64, 224, 208));
		btnLogin.setBounds(216, 202, 73, 38);
		frame.getContentPane().add(btnLogin);

		JLabel lblNewLabel_4 = new JLabel("Login Start to Your Session");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(60, 37, 199, 17);
		frame.getContentPane().add(lblNewLabel_4);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(10, 114, 64, 14);
		frame.getContentPane().add(lblEmail);

		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(10, 157, 89, 14);
		frame.getContentPane().add(lblPassword);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(81, 107, 208, 29);
		frame.getContentPane().add(txtEmail);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtEmail.setText("");
				txtPassword.setText("");
				lblMatch.setVisible(false);
				RCheckBox.setVisible(true);
				RCheckBox.setSelected(false);
			}
		});
		btnReset.setForeground(new Color(0, 128, 128));
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReset.setBackground(new Color(64, 224, 208));
		btnReset.setBounds(81, 202, 73, 38);
		frame.getContentPane().add(btnReset);

		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPassword.setBounds(81, 150, 208, 29);
		frame.getContentPane().add(txtPassword);

		JLabel lblCreateAccount = new JLabel("Create an account?");
		lblCreateAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Users users = new Users();
				users.NewScreen();
				frame.dispose();
			}
		});
		lblCreateAccount.setForeground(Color.WHITE);
		lblCreateAccount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCreateAccount.setBounds(81, 251, 129, 17);
		frame.getContentPane().add(lblCreateAccount);

		lblMatch = new JLabel("");
		lblMatch.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMatch.setForeground(new Color(255, 0, 0));
		lblMatch.setBounds(81, 182, 208, 14);
		frame.getContentPane().add(lblMatch);

		RCheckBox = new JCheckBox("Remember Me");
		RCheckBox.setForeground(new Color(255, 255, 255));
		RCheckBox.setBackground(new Color(100, 149, 237));
		RCheckBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		RCheckBox.setBounds(81, 178, 109, 23);
		frame.getContentPane().add(RCheckBox);
	}
}
