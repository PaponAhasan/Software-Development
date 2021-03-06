package StudentManagement;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class Dashborad extends JFrame implements ActionListener,MouseListener {
	private Container container;
	private JLabel label,fLabel,lLabel,lPhone,lCgpa;
	private JTextField fField,lField,pField,CField;
	private JButton fButton,lButton,pButton,cButton;
	private JScrollPane scrollPane;
	private Font font;
	private JTable table;
	private DefaultTableModel model;
	
	private String[] cols = {"First Name","Last Name","CGPA","Phone Number"};
	private String[] rows = new String[4];
	
	public Dashborad() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(400, 100, 700, 600);
		Componant();
	}

	public void Componant() {
		// container create
		container = this.getContentPane();
		container.setLayout(null);
		container.setBackground(Color.orange);
		
		font = new Font("Arial",Font.BOLD,14);
		
		//Create Label
		label = new JLabel("Student Registration");
		label.setFont(font);
		label.setBounds(140, 15, 200, 50);
		container.add(label);
		
		fLabel = new JLabel("First Name");
		fLabel.setFont(font);
		fLabel.setBounds(40, 60, 200, 50);
		container.add(fLabel);
		
		lLabel = new JLabel("Last Name");
		lLabel.setFont(font);
		lLabel.setBounds(40, 100, 200, 50);
		container.add(lLabel);
		
		lPhone = new JLabel("Phone");
		lPhone.setFont(font);
		lPhone.setBounds(40, 140, 200, 50);
		container.add(lPhone);
		
		lCgpa = new JLabel("CGPA");
		lCgpa.setFont(font);
		lCgpa.setBounds(40, 180, 200, 50);
		container.add(lCgpa);
		
		//Create Text Field
		fField = new JTextField();
		fField.setFont(font);
		fField.setBounds(130, 70, 240, 30);
		container.add(fField);
		
		lField = new JTextField();
		lField.setFont(font);
		lField.setBounds(130, 110, 240, 30);
		container.add(lField);
		
		pField = new JTextField();
		pField.setFont(font);
		pField.setBounds(130, 150, 240, 30);
		container.add(pField);
		
		CField = new JTextField();
		CField.setFont(font);
		CField.setBounds(130, 190, 240, 30);
		container.add(CField);
		
		//Create Button
		fButton = new JButton("Add");
		fButton.setFont(font);
		fButton.setBounds(400, 70, 90, 30);
		container.add(fButton);
		
		lButton = new JButton("Update");
		lButton.setFont(font);
		lButton.setBounds(400, 110, 90, 30);
		container.add(lButton);
		
		pButton = new JButton("Delete");
		pButton.setFont(font);
		pButton.setBounds(400, 150, 90, 30);
		container.add(pButton);
		
		cButton = new JButton("Clear");
		cButton.setFont(font);
		cButton.setBounds(400, 190, 90, 30);
		container.add(cButton);
		
		model = new DefaultTableModel();
		model.setColumnIdentifiers(cols);
		
		table = new JTable();
		table.setSelectionBackground(Color.orange);
		table.setFont(font);
		//table.setEnabled(false);
		table.setModel(model);
		table.setSelectionBackground(Color.GREEN);
		table.setBackground(Color.white);
		table.setRowHeight(30);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(40, 250, 600, 250);
		container.add(scrollPane);
		
		fButton.addActionListener(this);
		cButton.addActionListener(this);
		pButton.addActionListener(this);
		lButton.addActionListener(this);
		table.addMouseListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==fButton) {
			rows[0] = fField.getText();
			rows[1] = lField.getText();
			rows[2] = pField.getText();
			rows[3] = CField.getText();
			
			if(!rows[0].isEmpty() && !rows[1].isEmpty() && !rows[2].isEmpty() && !rows[3].isEmpty())
				model.addRow(rows);
		}
		else if(e.getSource()==cButton) {
			fField.setText("");
			lField.setText("");
			pField.setText("");
			CField.setText("");
		}
		else if(e.getSource()==pButton) {
			int get = table.getSelectedRow();
			if(get>=0){
				model.removeRow(get);
			}
			else JOptionPane.showMessageDialog(null, "No rows has selected");
		}
		else if(e.getSource()==lButton) {
			int get = table.getSelectedRow();
			String fName = fField.getText();
			String lName = lField.getText();
			String Cgpa = pField.getText();
			String pnumber = CField.getText();
			
			model.setValueAt(fName,get,0);
			model.setValueAt(lName,get,1);
			model.setValueAt(Cgpa, get,2);
			model.setValueAt(pnumber,get,3);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int get = table.getSelectedRow();
		
		String fName = model.getValueAt(get,0).toString();
		String lName = model.getValueAt(get,1).toString();
		String Cgpa = model.getValueAt(get,2).toString();
		String pnumber = model.getValueAt(get,3).toString();
		
		fField.setText(fName);
		lField.setText(lName);
		pField.setText(Cgpa);
		CField.setText(pnumber);
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		Dashborad icon = new Dashborad();
		icon.setVisible(true);
		icon.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		icon.setBounds(400, 100, 700, 600);
		icon.setTitle("Color Chooser Demo");
	}
}
