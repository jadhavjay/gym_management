import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.mysql.cj.protocol.Resultset;

import net.proteanit.sql.DbUtils;
import java.awt.SystemColor;

public class reminder extends JInternalFrame {
	private JTable table;
	private JTextField td;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reminder frame = new reminder();
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
	public reminder() {
		getContentPane().setForeground(Color.WHITE);
		getContentPane().setBackground(SystemColor.inactiveCaption);
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setResizable(true);
		setBounds(100, 100, 1432, 630);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 109, 880, 202);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		td = new JTextField();
		td.setBounds(370, 49, 86, 20);
		getContentPane().add(td);
		td.setColumns(10);
		Date d= new Date();
		SimpleDateFormat sf=new SimpleDateFormat("MM-dd");
		td.setText(sf.format(d));
		td.setVisible(false);
		
		//JLabel label = new JLabel("New label");
	//	label.setBounds(175, 52, 68, 14);
	//	getContentPane().add(label);
	//	label.setText((String)td.getText());
		JButton btnNewButton = new JButton("BIRTHDAY'S!!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test6", "root", "");
					String query= "SELECT Registrationno,Fullname,Contact,Alternate,Dob from addmember where "
							+ "DATE_FORMAT(Dob,'%m-%d')='"+td.getText()+"'";
							
							
					PreparedStatement pa=con.prepareStatement(query);
					Resultset rs=((Resultset) pa.executeQuery());			
					table.setModel(DbUtils.resultSetToTableModel((ResultSet) rs));
				} catch(Exception e) {
					//e.printStackTrace();
					
				}
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test6", "root", "");
					String query= "SELECT Trainerid,Fullname,Gender,Contactno,Alternateno,Shift,Dob from addtrainer where "
							+ "DATE_FORMAT(Dob,'%m-%d')='"+td.getText()+"'";
							
							
					PreparedStatement pa=con.prepareStatement(query);
					Resultset rs=((Resultset) pa.executeQuery());			
					table_1.setModel(DbUtils.resultSetToTableModel((ResultSet) rs));
				}
		
			catch(Exception ee4){ee4.printStackTrace();}
			}});
		btnNewButton.setBounds(230, 48, 128, 23);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\User\\Downloads\\HBD.png"));
		lblNewLabel.setBounds(1037, 165, 285, 304);
		getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(31, 385, 880, 205);
		getContentPane().add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblTrainers = new JLabel("TRAINER'S!!!");
		lblTrainers.setForeground(Color.WHITE);
		lblTrainers.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblTrainers.setBounds(31, 341, 217, 33);
		getContentPane().add(lblTrainers);
		
		JLabel lblMembers = new JLabel("MEMBER'S!!!");
		lblMembers.setForeground(Color.WHITE);
		lblMembers.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblMembers.setBounds(31, 65, 217, 33);
		getContentPane().add(lblMembers);
		
		
		
	
	}
}
