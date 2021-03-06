package DigitalClock;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Watch implements Runnable {

	private JFrame frame;
	private JLabel TimeConsole;
	private JLabel DateConsole;
    
	int hour ;
	int minute;
	int second;
	int year;
	int month;
	int day;
	String timeStr;
	String dateStr;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Watch window = new Watch();
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
	public Watch() {
		initialize();
		Thread thread = new Thread(this);
		thread.start();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\JAVA Language\\Java Swing\\Swing Apps\\DigitalClock\\digital-clock (3).png"));
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 450, 239);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBounds(0, 0, 434, 58);
		frame.getContentPane().add(panel);

		JLabel lblNewLabel = new JLabel("DIGITAL CLOCK");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel_1.setBounds(81, 69, 276, 58);
		frame.getContentPane().add(panel_1);

		TimeConsole = new JLabel("00:00:00");
		TimeConsole.setForeground(Color.GREEN);
		TimeConsole.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel_1.add(TimeConsole);
				
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\JAVA Language\\Java Swing\\Swing Apps\\DigitalClock\\icons8-future-20 (1).png"));
		lblNewLabel_1.setBounds(145, 130, 23, 34);
		frame.getContentPane().add(lblNewLabel_1);
				
		DateConsole = new JLabel("27:09:2020");
		DateConsole.setBounds(170, 127, 102, 37);
		frame.getContentPane().add(DateConsole);
		DateConsole.setFont(new Font("Tahoma", Font.BOLD, 18));
		DateConsole.setBackground(new Color(0, 0, 0));
		DateConsole.setForeground(new Color(0, 255, 0));
	}

	@Override
	public void run() {
		while (true) {
			try {
				Calendar calendar = Calendar.getInstance();

			     hour = calendar.get(Calendar.HOUR_OF_DAY);
				 minute = calendar.get(Calendar.MINUTE);
				 second = calendar.get(Calendar.SECOND);
				 year = calendar.get(Calendar.DAY_OF_YEAR);
				 month = calendar.get(Calendar.DAY_OF_MONTH);
				 day = calendar.get(Calendar.DAY_OF_MONTH);
				
				if (hour > 12)
					hour -= 12;

				SimpleDateFormat simpleDate = new SimpleDateFormat("hh:mm:ss a");
				SimpleDateFormat simpleTime = new SimpleDateFormat("dd:MM:yyyy");

				Date date = calendar.getTime();

				timeStr = simpleDate.format(date);
				dateStr = simpleTime.format(date);
				
				TimeConsole.setText(timeStr);
				DateConsole.setText(dateStr);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
