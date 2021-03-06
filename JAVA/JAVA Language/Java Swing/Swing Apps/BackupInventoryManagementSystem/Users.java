package BackupInventoryManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Users {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtCName;
	private JPasswordField txtPassword;
	private JTextField txtEmail;
	private JPasswordField txtNPassword;
	private JTextField txtPhone;

	/**
	 * Launch the application.
	 */
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Users window = new Users();
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
	public Users() {
		initialize();
		connect();
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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(100, 149, 237));
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("Create Your Account");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(97, 24, 145, 17);
		frame.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_4_1 = new JLabel("Company Name :");
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_1.setBounds(10, 80, 111, 17);
		frame.getContentPane().add(lblNewLabel_4_1);

		JLabel lblNewLabel_4_1_1 = new JLabel("Company Email :");
		lblNewLabel_4_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_1_1.setBounds(10, 120, 111, 14);
		frame.getContentPane().add(lblNewLabel_4_1_1);

		JLabel lblNewLabel_4_1_2 = new JLabel("User Name :");
		lblNewLabel_4_1_2.setForeground(Color.WHITE);
		lblNewLabel_4_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_1_2.setBounds(10, 160, 89, 14);
		frame.getContentPane().add(lblNewLabel_4_1_2);

		JLabel lblNewLabel_4_1_1_1 = new JLabel("Phone :");
		lblNewLabel_4_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_1_1_1.setBounds(10, 200, 89, 14);
		frame.getContentPane().add(lblNewLabel_4_1_1_1);

		JLabel lblNewLabel_4_1_3 = new JLabel("Password :");
		lblNewLabel_4_1_3.setForeground(Color.WHITE);
		lblNewLabel_4_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_1_3.setBounds(10, 240, 79, 14);
		frame.getContentPane().add(lblNewLabel_4_1_3);

		JLabel lblNewLabel_4_1_1_2 = new JLabel("Confirm Password :");
		lblNewLabel_4_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_1_1_2.setBounds(10, 280, 119, 14);
		frame.getContentPane().add(lblNewLabel_4_1_1_2);

		JButton btnNewButton_2_1_1 = new JButton("Cancle");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				frame.dispose();
			}
		});
		btnNewButton_2_1_1.setForeground(new Color(0, 128, 128));
		btnNewButton_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2_1_1.setBackground(new Color(64, 224, 208));
		btnNewButton_2_1_1.setBounds(140, 313, 79, 38);
		frame.getContentPane().add(btnNewButton_2_1_1);

		JButton btnNewButton_2_1_1_1 = new JButton("Sign Up");
		btnNewButton_2_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String emailStr = txtEmail.getText();
					Statement statement = connection.createStatement();
					ResultSet rs = statement.executeQuery("SELECT * FROM users");
					while (rs.next()) {
						String CEmail = rs.getString(3);
						if (CEmail.equals(emailStr)) {
							JOptionPane.showMessageDialog(null, "All ready taken this email", "Warning", 3);
						} else {
							String CName = txtCName.getText();
							String email = txtEmail.getText();
							String Name = txtName.getText();
							String Phone = txtPhone.getText();
							char[] password = txtPassword.getPassword();
							String Password = String.valueOf(password);
							char[] Npassword = txtNPassword.getPassword();
							String NPassword = String.valueOf(Npassword);
							
							if(!Password.equals(NPassword)) {
								JOptionPane.showMessageDialog(null, "password does not match", "Warning",3);
								break;
							}
							else if (!CName.equals("") && !Name.equals("") && !Phone.equals("") && !email.equals("")
									&& !Password.equals("") && !NPassword.equals("")) {
								int choice = JOptionPane.showConfirmDialog(null, "Are you sure to Add?", "Insert",
										JOptionPane.YES_NO_OPTION);
								if (choice == JOptionPane.YES_NO_OPTION) {
									preparedStatement = connection.prepareStatement(
											"insert into users(CName,CEmail,UName,Phone,Password,NPassword)values(?,?,?,?,?,?)");
									preparedStatement.setString(1, CName);
									preparedStatement.setString(2, email);
									preparedStatement.setString(3, Name);
									preparedStatement.setString(4, Phone);
									preparedStatement.setString(5, Password);
									preparedStatement.setString(6, NPassword);
									preparedStatement.executeUpdate();
									JOptionPane.showMessageDialog(null, "Your account added Successfully", "Warning",
											3);

									txtCName.setText("");
									txtEmail.setText("");
									txtName.setText("");
									txtPhone.setText("");
									txtPassword.setText("");
									txtNPassword.setText("");
									txtCName.requestFocus();
									break;
								}
							}else {
								JOptionPane.showMessageDialog(null, "Please fullfield your all Textfield", "Warning",3);
								break;
							}

						}
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2_1_1_1.setForeground(new Color(0, 128, 128));
		btnNewButton_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2_1_1_1.setBackground(new Color(64, 224, 208));
		btnNewButton_2_1_1_1.setBounds(269, 313, 79, 38);
		frame.getContentPane().add(btnNewButton_2_1_1_1);

		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtName.setColumns(10);
		txtName.setBounds(140, 153, 208, 29);
		frame.getContentPane().add(txtName);

		txtCName = new JTextField();
		txtCName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCName.setColumns(10);
		txtCName.setBounds(140, 73, 208, 29);
		frame.getContentPane().add(txtCName);

		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPassword.setBounds(140, 233, 208, 29);
		frame.getContentPane().add(txtPassword);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(140, 113, 208, 29);
		frame.getContentPane().add(txtEmail);

		txtNPassword = new JPasswordField();
		txtNPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNPassword.setBounds(140, 273, 208, 29);
		frame.getContentPane().add(txtNPassword);

		txtPhone = new JTextField();
		txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPhone.setColumns(10);
		txtPhone.setBounds(140, 193, 208, 29);
		frame.getContentPane().add(txtPhone);
		frame.setBounds(100, 100, 385, 458);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}

}
