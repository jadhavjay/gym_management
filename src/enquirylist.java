import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.mysql.cj.protocol.Resultset;

import net.proteanit.sql.DbUtils;

public class enquirylist extends JInternalFrame {
	private JTable table;
	private JTextField del;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					enquirylist frame = new enquirylist();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public enquirylist() {
		getContentPane().setBackground(new Color(154, 205, 50));
		setClosable(true);
		setTitle("ENQUIRY LIST");
		setBounds(100, 100, 1323, 670);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Refresh");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test6", "root", "");
					String query= "select * from enquiry order by Date desc";
					PreparedStatement pa=con.prepareStatement(query);
					Resultset rs=(Resultset) pa.executeQuery();			
					table.setModel(DbUtils.resultSetToTableModel((ResultSet) rs));
				} catch(Exception e) {
					
				}
				
				//allmembers a=new allmembers();
			//	a.exportTable(table, file);
				
			}
		});
		btnNewButton.setBounds(604, 229, 129, 23);
		getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(224, 274, 883, 280);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Export to Excel!");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 export exw= new export();
				 try {
					exw.exportTable(table, new File("C:\\Users\\User\\Google Drive\\enquirylist.xls"));
				JOptionPane.showMessageDialog(null,"Records exported Successfully!!");
				 } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(1149, 28, 135, 23);
		getContentPane().add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\User\\eclipse-workspace\\gym_management\\src\\enquiry1.jpg"));
		lblNewLabel.setBounds(509, 8, 489, 210);
		getContentPane().add(lblNewLabel);
		
		del = new JTextField();
		del.setBounds(1174, 82, 86, 20);
		getContentPane().add(del);
		del.setColumns(10);
		//del.setText(date.getDateFormatString());
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test6", "root", "");
					String query= "delete from enquiry where Fullname='"+del.getText()+"'";
					PreparedStatement pa=con.prepareStatement(query);
					String rg="^[a-zA-Z\\s]+$";	
					if(del.getText().matches(rg)) {
					pa.execute();
					JOptionPane.showMessageDialog(null,"Enquiry deleted!!");
					del.setText(null);}
					else {
						JOptionPane.showMessageDialog(null, "enter name properly");
					}
				} catch(Exception eq) {
					eq.printStackTrace();
					JOptionPane.showMessageDialog(null,"Invalid Name!!");
				}
			}
		});
		btnNewButton_2.setBounds(1174, 130, 89, 23);
		getContentPane().add(btnNewButton_2);
		
		
	}
}
