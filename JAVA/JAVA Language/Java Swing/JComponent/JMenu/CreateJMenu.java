package JMenu;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class CreateJMenu extends JFrame implements ActionListener {
		private Container container;
		private JMenuBar menuBar;
		private JMenu fileMenu,editMenu,helpMenu;
		private JMenuItem newItem,openItem,exitItem,cutItem,copyItem,pasteItem,selectAlItem;
		private ImageIcon newIcon,Cuticon;
		
		public CreateJMenu(){
			Componant();
		}
		
		public void Componant() {
			//container create
			container = this.getContentPane();
			container.setLayout(null);
			
			//Icon create
			newIcon = new ImageIcon("JComponent/JMenu/Cut.png");
			Cuticon = new ImageIcon("JComponent/JMenu/new.png");
			
			/*..3(child)...*/
			newItem = new JMenuItem("New");
			newItem.setIcon(Cuticon);
			newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
			
			openItem = new JMenuItem("Open");
			
			exitItem = new JMenuItem("Exit");
			
			cutItem = new JMenuItem("Cut");
			cutItem.setIcon(newIcon);
			cutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
			
			copyItem = new JMenuItem("Copy");
			
			pasteItem = new JMenuItem("Paste");
			
			selectAlItem = new JMenuItem("Select All");
			
			/*..2(parent)...*/
			fileMenu = new JMenu("File");
			fileMenu.add(newItem);
			fileMenu.addSeparator();
			fileMenu.add(openItem);
			fileMenu.addSeparator();
			fileMenu.add(exitItem);
			
			editMenu = new JMenu("Edit");
			editMenu.add(cutItem);
			editMenu.addSeparator();
			editMenu.add(copyItem);
			editMenu.add(pasteItem);
			editMenu.add(selectAlItem);
			
			helpMenu = new JMenu("Help");
			
			/*..1...*/
			menuBar = new JMenuBar();
			menuBar.add(fileMenu);
			menuBar.add(editMenu);
			menuBar.add(helpMenu);
			this.setJMenuBar(menuBar);
			
			//Listener create
			newItem.addActionListener(this);
			exitItem.addActionListener(this);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==newItem) {
				JFrame frame = new JFrame();
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setBounds(200, 100, 500, 400);
				frame.setTitle("New Frame");
			}
			else if(e.getSource()==exitItem) {
				System.exit(0);
			}
			
		}
		
	public static void main(String[] args) {
		CreateJMenu icon = new CreateJMenu();
		icon.setVisible(true);
		icon.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    icon.setBounds(200, 100, 500, 400);
		icon.setTitle("Menu Demo");
	}
}
