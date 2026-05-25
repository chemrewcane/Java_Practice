package LAB3;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;

public class LAB3 extends JFrame {

	DefaultTableModel mod;
	JTable table;
	JScrollPane pane;

	static JTextField txtname, txtc, txty, txtw, txts;

	LAB3() {
		setTitle("School Canteen Wallet");
		setSize(800,550);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);

		JLabel lblname = new JLabel("Full Name");
		txtname = new JTextField();
		add(lblname).setBounds(30,210,100,10);
		add(txtname).setBounds(30,230,200,20);

		JLabel lblc = new JLabel("Course/Dept");
		txtc = new JTextField();
		add(lblc).setBounds(30,260,100,10);
		add(txtc).setBounds(30,280,200,20);

		JLabel lbly = new JLabel("Year Level");
		txty = new JTextField();
		add(lbly).setBounds(30,310,100,10);
		add(txty).setBounds(30,330,200,20);

		JLabel lblw = new JLabel("Wallet Balance");
		txtw = new JTextField();
		add(lblw).setBounds(30,360,100,10);
		add(txtw).setBounds(30,380,200,20);

		JLabel lbls = new JLabel("Status (Active or Suspended)");
		txts = new JTextField();
		add(lbls).setBounds(30,410,180,10);
		add(txts).setBounds(30,430,200,20);

		JButton ad = new JButton("Add");
		JButton upt = new JButton("Update");
		JButton del = new JButton("Delete");
		JButton c = new JButton("Clear");
		add(ad).setBounds(300,470,100,20);
		add(upt).setBounds(410,470,100,20);
		add(del).setBounds(520,470,100,20);
		add(c).setBounds(630,470,100,20);

		String[] col = {"Full Name", "Course/Dept", "Year Level", "Wallet Balance", "Status"};
		mod = new DefaultTableModel(col, 0);

		table = new JTable(mod);
		pane = new JScrollPane(table);
		table.getTableHeader().setBackground(new Color(185, 209, 234));
		pane.setBounds(250,30,510,420);
		add(pane);

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				if(row != -1) {
					txtname.setText(mod.getValueAt(row, 0).toString());
					txtc.setText(mod.getValueAt(row, 1).toString());
					txty.setText(mod.getValueAt(row, 2).toString());
					txtw.setText(mod.getValueAt(row, 3).toString());
					txts.setText(mod.getValueAt(row, 4).toString());
				}
			}
		});

		ad.addActionListener(e->{
			if(txtname.getText().isEmpty()||
					txtc.getText().isEmpty()||
					txty.getText().isEmpty()||
					txtw.getText().isEmpty()||
					txts.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null,"Please fill in the remaining");
				return;
			} else if (!Intt(txty.getText().trim())) {
				JOptionPane.showMessageDialog(null, "Year Level must be a number!");
				return;
			} else if (!DOUBLEE(txtw.getText().trim())) {
				JOptionPane.showMessageDialog(null, "Wallet Balance must be a valid currency value!");
				return;
			} else if (!txts.getText().trim().equalsIgnoreCase("Active") &&
					!txts.getText().trim().equalsIgnoreCase("Suspended")) {
				JOptionPane.showMessageDialog(null, "Status must be either 'Active' or 'Suspended'.");
				return;
			}

				double balance = Double.parseDouble(txtw.getText().trim());
				String dobbal = String.format("%.2f", balance);

				mod.addRow(new Object[]{txtname.getText(), txtc.getText(), txty.getText(), dobbal, txts.getText()});
				JOptionPane.showMessageDialog(null,"Done Adding!");
				clear();
				saveToFile();
		});

		upt.addActionListener(e -> {
			int i = table.getSelectedRow();
			if (i == -1) {
				JOptionPane.showMessageDialog(null, "Select a row first");
				return;
			}

			if(txtname.getText().isEmpty() ||
					txtc.getText().isEmpty() ||
					txty.getText().isEmpty() ||
					txtw.getText().isEmpty() ||
					txts.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please fill in the remaining before updating");
				return;
			} else if (!Intt(txty.getText().trim())) {
				JOptionPane.showMessageDialog(null, "Year Level must be a number!");
				return;
			} else if (!DOUBLEE(txtw.getText().trim())) {
				JOptionPane.showMessageDialog(null, "Wallet Balance must be a valid currency value!");
				return;
			} else if (!txts.getText().trim().equalsIgnoreCase("Active") &&
					!txts.getText().trim().equalsIgnoreCase("Suspended")) {
				JOptionPane.showMessageDialog(null, "Status must be either 'Active' or 'Suspended'.");
				return;
			}
				double balance = Double.parseDouble(txtw.getText().trim());
				String dobbal = String.format("%.2f", balance);

				mod.setValueAt(txtname.getText(), i, 0);
				mod.setValueAt(txtc.getText(), i, 1);
				mod.setValueAt(txty.getText(), i, 2);
				mod.setValueAt(dobbal, i, 3);
				mod.setValueAt(txts.getText(), i, 4);
				
				JOptionPane.showMessageDialog(null,"Done Updating!");
				clear();
				saveToFile();
		});

		del.addActionListener(e -> {
			int i = table.getSelectedRow();
			if (i == -1) {

				JOptionPane.showMessageDialog(null, "Select a row first!");
				return;
			}
			mod.removeRow(i);
			JOptionPane.showMessageDialog(null,"Done Deleting!");
			clear();
			saveToFile();
		});

		c.addActionListener(e -> clear());
		
		try {
			File file = new File("canteen_data.txt");
			if (file.exists()) {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line;
				while ((line = br.readLine()) != null) {
					String[] rowData = line.split(","); 
					if (rowData.length == 5) {
						mod.addRow(rowData);
					}
				}
				br.close();
			}
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "Error loading saved data: " + ex.getMessage());
		}

		setVisible(true);
	}
		
	public void clear() {
		txtname.setText("");
		txtc.setText("");
		txty.setText("");
		txtw.setText("");
		txts.setText("");
	}
	
	public void saveToFile() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("canteen_data.txt"));
			for (int i = 0; i < mod.getRowCount(); i++) {
				bw.write(mod.getValueAt(i, 0) + "," +
						 mod.getValueAt(i, 1) + "," +
						 mod.getValueAt(i, 2) + "," +
						 mod.getValueAt(i, 3) + "," +
						 mod.getValueAt(i, 4));
				bw.newLine();
			}
			bw.close();
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "Error saving data: " + ex.getMessage());
		}
	}

	public boolean Intt(String text) {
		return text.matches("\\d+");
	}

	public boolean DOUBLEE(String text) {
		return text.matches("\\d+(\\.\\d+)?"); 
	}

	public static void main(String[] args) {
		new LAB3();
	}
}