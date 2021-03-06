package BackupInventoryManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void NewScreen() {
		Change obj = new Change();
		obj.name();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(100, 149, 237));
		frame.setBounds(100, 100, 300, 473);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("   Inventory Management System");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(24, 11, 255, 41);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Items");
		btnNewButton.setForeground(new Color(0, 139, 139));
		btnNewButton.setBackground(new Color(64, 224, 208));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(95, 212, 101, 41);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSales = new JButton("Sales");
		btnSales.setForeground(new Color(0, 139, 139));
		btnSales.setBackground(new Color(64, 224, 208));
		btnSales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Sales sales = new Sales();
				sales.NewScreen();
			}
		});
		btnSales.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSales.setBounds(95, 273, 101, 41);
		frame.getContentPane().add(btnSales);
		
		JButton btnPurchases = new JButton("Purchases");
		btnPurchases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Purchases frame = new Purchases();
				frame.NewScreen();
			}
		});
		btnPurchases.setForeground(new Color(0, 139, 139));
		btnPurchases.setBackground(new Color(64, 224, 208));
		btnPurchases.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPurchases.setBounds(95, 337, 101, 41);
		frame.getContentPane().add(btnPurchases);
		
		JButton btnLogout = new JButton("Profile");
		btnLogout.setForeground(new Color(0, 139, 139));
		btnLogout.setBackground(new Color(64, 224, 208));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogout.setBounds(95, 153, 101, 41);
		frame.getContentPane().add(btnLogout);
		
		JButton btnAccount = new JButton("Account");
		btnAccount.setForeground(new Color(0, 139, 139));
		btnAccount.setBackground(new Color(64, 224, 208));
		btnAccount.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAccount.setBounds(95, 91, 101, 41);
		frame.getContentPane().add(btnAccount);
	}
}
