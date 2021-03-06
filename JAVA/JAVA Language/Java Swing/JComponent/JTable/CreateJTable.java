package JTable;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class CreateJTable extends JFrame {
	private Container container;
	private JLabel label;
	private JScrollPane scrollPane;
	private Font font;
	private JTable table;
	
	private String[] cols = {"ID","Name","CGPA"};
	private String[][] rows = {
			{"022","Papon","3.50"},
			{"023","Rahim","3.00"},
			{"024","Karim","3.60"},
			{"025","Nill","3.90"},
			{"026","Imran","2.50"},
			{"027","Jarin","4.00"},
			{"022","Papon","3.50"},
			{"023","Rahim","3.00"},
			{"024","Karim","3.60"},
			{"025","Nill","3.90"},
			{"026","Imran","2.50"},
			{"027","Jarin","4.00"},
	};
	
	public CreateJTable() {
		Componant();
	}

	public void Componant() {
		// container create
		container = this.getContentPane();
		container.setLayout(null);
		
		font = new Font("Arial",Font.BOLD,14);
		
		label = new JLabel("Student Details");
		label.setFont(font);
		label.setBounds(250, 20, 200, 50);
		container.add(label);
		
		table = new JTable(rows,cols);
		table.setSelectionBackground(Color.orange);
		//table.setEnabled(false);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(50, 60, 600, 200);
		container.add(scrollPane);
	}
	
	public static void main(String[] args) {
		CreateJTable icon = new CreateJTable();
		icon.setVisible(true);
		icon.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		icon.setBounds(100, 100, 700, 350);
		icon.setTitle("Color Chooser Demo");
	}
}
