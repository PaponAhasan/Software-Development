package Inventory_Management_System;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Invoices {

	private JFrame frame;
	private JTextField txtcustomer;
	private JTextField txtItems;
	private JTextField txtInvoicedate;
	private JTextField txtQuantity;
	private JTextField txtPrice;
	private JTextField txtInvoiceNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Invoices window = new Invoices();
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
	public Invoices() {
		initialize();
		connect();
	}
	
	Connection connection;
	PreparedStatement preparedStatement;
	
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
		frame.setBounds(100, 100, 584, 408);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(37, 46, 498, 271);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCuestomer = new JLabel("Customer :");
		lblCuestomer.setForeground(new Color(0, 0, 0));
		lblCuestomer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCuestomer.setBounds(34, 18, 81, 14);
		panel.add(lblCuestomer);
		
		txtcustomer = new JTextField();
		txtcustomer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtcustomer.setColumns(10);
		txtcustomer.setBounds(145, 11, 295, 29);
		panel.add(txtcustomer);
		
		JLabel lblItem = new JLabel("Item :");
		lblItem.setForeground(Color.BLACK);
		lblItem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblItem.setBounds(34, 58, 64, 14);
		panel.add(lblItem);
		
		txtItems = new JTextField();
		txtItems.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtItems.setColumns(10);
		txtItems.setBounds(145, 51, 295, 29);
		panel.add(txtItems);
		
		JLabel lblInvoiceDate = new JLabel("Invoice Date :");
		lblInvoiceDate.setForeground(Color.BLACK);
		lblInvoiceDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInvoiceDate.setBounds(34, 98, 92, 14);
		panel.add(lblInvoiceDate);
		
		txtInvoicedate = new JTextField();
		txtInvoicedate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtInvoicedate.setColumns(10);
		txtInvoicedate.setBounds(145, 91, 295, 29);
		panel.add(txtInvoicedate);
		
		JLabel lblEmail_3 = new JLabel("Quantity :");
		lblEmail_3.setForeground(Color.BLACK);
		lblEmail_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail_3.setBounds(34, 138, 64, 14);
		panel.add(lblEmail_3);
		
		txtQuantity = new JTextField();
		txtQuantity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(145, 131, 295, 29);
		panel.add(txtQuantity);
		
		JLabel lblEmail_4 = new JLabel("Price :");
		lblEmail_4.setForeground(Color.BLACK);
		lblEmail_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail_4.setBounds(34, 178, 64, 14);
		panel.add(lblEmail_4);
		
		txtPrice = new JTextField();
		txtPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPrice.setColumns(10);
		txtPrice.setBounds(145, 171, 295, 29);
		panel.add(txtPrice);
		
		JLabel lblEmail_5 = new JLabel("Invoice Number :");
		lblEmail_5.setForeground(Color.BLACK);
		lblEmail_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail_5.setBounds(34, 218, 106, 14);
		panel.add(lblEmail_5);
		
		txtInvoiceNumber = new JTextField();
		txtInvoiceNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtInvoiceNumber.setColumns(10);
		txtInvoiceNumber.setBounds(145, 211, 295, 29);
		panel.add(txtInvoiceNumber);
		
		JLabel lblNewLabel = new JLabel("Invoices");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(241, 21, 86, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnCancle = new JButton("X Cancle");
		btnCancle.setBackground(new Color(220, 20, 60));
		btnCancle.setForeground(new Color(255, 255, 255));
		btnCancle.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancle.setBounds(37, 324, 89, 37);
		frame.getContentPane().add(btnCancle);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String customer = txtcustomer.getText();
					String Items = txtItems.getText();
					String InvoiceDate = txtInvoicedate.getText();
					String Quantity = txtQuantity.getText();
					String Price = txtPrice.getText();
					String InvoiceNumber = txtInvoiceNumber.getText();
	
					
					if(!customer.equals("") && !Items.equals("") && !InvoiceDate.equals("") && !Quantity.equals("") && !Price.equals("") && !InvoiceNumber.equals("")) {
						int choice = JOptionPane.showConfirmDialog(null, "Are you sure to Add?","Update",JOptionPane.YES_NO_OPTION);
						if(choice==JOptionPane.YES_NO_OPTION) {
							preparedStatement = connection.prepareStatement("insert into invoice(customer,item,date,quantity,price,Inumber)values(?,?,?,?,?,?)");
							preparedStatement.setString(1, customer);
							preparedStatement.setString(2, Items);
							preparedStatement.setString(3, InvoiceDate);
							preparedStatement.setString(4, Quantity);
							preparedStatement.setString(5, Price);
							preparedStatement.setString(6, InvoiceNumber);
							preparedStatement.executeUpdate();
							JOptionPane.showMessageDialog(null, "Invoice Added Successfully","Warning",3);
						}
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSave.setForeground(new Color(255, 255, 255));
		btnSave.setBackground(new Color(0, 128, 0));
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSave.setBounds(136, 324, 89, 37);
		frame.getContentPane().add(btnSave);
	}
}
