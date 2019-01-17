import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.mysql.cj.protocol.Resultset;

import net.proteanit.sql.DbUtils;

public class list extends JInternalFrame {
	private JTable table;
	private JTextField att;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					list frame = new list();
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
	public list() {
		setNormalBounds(new Rectangle(0, 0, 1359, 640));
		setBounds(100, 100, 1350, 648);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 100, 1320, 530);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		att = new JTextField();
		att.setBounds(146, 46, 86, 20);
		getContentPane().add(att);
		att.setColumns(10);
		
		
		JButton btnRegresh = new JButton("regresh");
		btnRegresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
					String query= "select * from attendance where date='"+att.getText()+"'";
					PreparedStatement pa=con.prepareStatement(query);
					Resultset rs=(Resultset) pa.executeQuery();			
					table.setModel(DbUtils.resultSetToTableModel((ResultSet) rs));
				} catch(Exception e1) {
					e1.printStackTrace();
				}

				
			}
		});
		btnRegresh.setBounds(248, 45, 89, 23);
		getContentPane().add(btnRegresh);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
					String query= "select * from attendance";// where date='"+att.getText()+"'";
					PreparedStatement pa=con.prepareStatement(query);
					Resultset rs=(Resultset) pa.executeQuery();			
					table.setModel(DbUtils.resultSetToTableModel((ResultSet) rs));
				} catch(Exception e1) {
					e1.printStackTrace();
				}

				
			}
		});
		btnNewButton.setBounds(411, 45, 89, 23);
		getContentPane().add(btnNewButton);
		
	
	}
}
