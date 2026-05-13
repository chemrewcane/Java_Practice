import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class HRS extends JFrame {

	JTextField txtGuest, txtRoom, txtCheckIn, txtCheckOut;

	JTable table;
	DefaultTableModel model;

	JButton btnAdd, btnUpdate, btnDelete, btnExit;

	public HRS() {

		setTitle("Hotel Reservation System");

		JLabel lblGuest = new JLabel("Guest Name");
		lblGuest.setBounds(10, 580, 120, 20);
		add(lblGuest);

		txtGuest = new JTextField();
		txtGuest.setBounds(10, 600, 130, 25);
		add(txtGuest);
		
		JLabel lblRoom = new JLabel("Room Type");
		lblRoom.setBounds(150, 580, 120, 20);
		add(lblRoom);
		
		txtRoom = new JTextField();
		txtRoom.setBounds(150, 600, 130, 25);
		add(txtRoom);

		JLabel lblCheckIn = new JLabel("Check in Date");
		lblCheckIn.setBounds(290, 580, 120, 20);
		add(lblCheckIn);
		
		txtCheckIn = new JTextField();
		txtCheckIn.setBounds(290, 600, 130, 25);
		add(txtCheckIn);

		JLabel lblCheckOut = new JLabel("Check out Date");
		lblCheckOut.setBounds(430, 580, 120, 20);
		add(lblCheckOut);

		txtCheckOut = new JTextField();
		txtCheckOut.setBounds(430, 600, 130, 25);
		add(txtCheckOut);

		btnAdd = new JButton("Add");
		btnAdd.setBounds(610, 598, 90, 25);
		add(btnAdd);

		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(610, 635, 90, 25);
		add(btnUpdate);

		btnDelete = new JButton("Delete");
		btnDelete.setBounds(610, 672, 90, 25);
		add(btnDelete);

		btnExit = new JButton("Exit");
		btnExit.setBounds(610, 709, 90, 25);
		add(btnExit);

		String columns[] = {
				"Guest Name",
				"Room Type",
				"Check In",
				"Check Out"
		};

		model = new DefaultTableModel(columns, 0);

		table = new JTable(model);

		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(10, 10, 740, 550);
		add(pane);

		btnAdd.addActionListener(e -> {

			if (txtGuest.getText().isEmpty() ||
					txtRoom.getText().isEmpty() ||
					txtCheckIn.getText().isEmpty() ||
					txtCheckOut.getText().isEmpty()) {

				JOptionPane.showMessageDialog(
						null,
						"Please complete all fields!"
						);

				return;
			}

			String data[] = {
					txtGuest.getText(),
					txtRoom.getText(),
					txtCheckIn.getText(),
					txtCheckOut.getText()
			};

			model.addRow(data);

			JOptionPane.showMessageDialog(
					null,
					"Reservation Added Successfully!"
					);

			clear();
		});

		table.getSelectionModel().addListSelectionListener(e -> {

			int row = table.getSelectedRow();

			if (row != -1) {

				txtGuest.setText(
						model.getValueAt(row, 0).toString());

				txtRoom.setText(
						model.getValueAt(row, 1).toString());

				txtCheckIn.setText(
						model.getValueAt(row, 2).toString());
				txtCheckOut.setText(
						model.getValueAt(row, 3).toString());
			}
		});

		btnUpdate.addActionListener(e -> {

			int row = table.getSelectedRow();

			if (row == -1) {

				JOptionPane.showMessageDialog(
						null,
						"Select a reservation first!"
						);

				return;
			}

			model.setValueAt(txtGuest.getText(), row, 0);
			model.setValueAt(txtRoom.getText(), row, 1);
			model.setValueAt(txtCheckIn.getText(), row, 2);
			model.setValueAt(txtCheckOut.getText(), row, 3);

			JOptionPane.showMessageDialog(
					null,
					"Reservation Updated!"
					);

			clear();
		});

		btnDelete.addActionListener(e -> {

			int row = table.getSelectedRow();

			if (row == -1) {

				JOptionPane.showMessageDialog(
						null,
						"Select a reservation first!"
						);

				return;
			}

			int confirm = JOptionPane.showConfirmDialog(
					null,
					"Delete this reservation?",
					"Confirm",
					JOptionPane.YES_NO_OPTION
					);

			if (confirm == JOptionPane.YES_OPTION) {

				model.removeRow(row);

				JOptionPane.showMessageDialog(
						null,
						"Reservation Deleted!"
						);

				clear();
			}
		});

		btnExit.addActionListener(e -> {

			int confirm = JOptionPane.showConfirmDialog(
					null,
					"Exit application?",
					"Confirm Exit",
					JOptionPane.YES_NO_OPTION
					);

			if (confirm == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		});

		setLayout(null);
		setSize(770, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void clear() {

		txtGuest.setText("");
		txtRoom.setText("");
		txtCheckIn.setText("");
		txtCheckOut.setText("");
	}

	public static void main(String[] args) {
		new HRS();
	}
}