import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.protocol.Resultset;

import net.proteanit.sql.DbUtils;
import java.awt.Font;
import java.awt.Frame;
public class checkattendance extends JInternalFrame {
	private JTable table;
	private JTextField txtYyyymmdd;
	private JLabel lblEnterDate;
	private JButton btnNewButton;
	private JTextField textField;
	private JButton btnNewButton_1;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					checkattendance frame = new checkattendance();
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
	public checkattendance() {
		getContentPane().setBackground(SystemColor.menu);
		setNormalBounds(new Rectangle(0, 0, 1350, 650));
		setClosable(true);
		//if(checkattendance.is) {
			
	//	}
		
		setBounds(100, 100, 1348, 539);
		getContentPane().setLayout(null);
		String [] columnnames= {"registration no","date","time","fullname","contactno"};
		Object data[]= {};
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(141, 141, 1046, 369);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setColumnSelectionAllowed(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		Date d= new Date();
		SimpleDateFormat sd= new SimpleDateFormat("yyyy-MM-dd");
		
		txtYyyymmdd = new JTextField();
		txtYyyymmdd.setText(sd.format(d));
		txtYyyymmdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
					String query= "select a.Registrationno,a.Date,a.Time,b.Fullname,b.Contact from "
							+ "attendance a,addmember b where "
							+ "a.Registrationno=b.Registrationno having a.Date='"+txtYyyymmdd.getText()+"' order by Time desc" ;
					PreparedStatement pa=con.prepareStatement(query);
					Resultset rs=(Resultset) pa.executeQuery();			
					table.setModel(DbUtils.resultSetToTableModel((ResultSet) rs));
				} catch(Exception e1) {
					//e1.printStackTrace();
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
			}
		});
		txtYyyymmdd.setBounds(569, 97, 86, 20);
		getContentPane().add(txtYyyymmdd);
		txtYyyymmdd.setColumns(10);
		
		lblEnterDate = new JLabel("Enter date : (yyyy-MM-dd)");
		lblEnterDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEnterDate.setForeground(SystemColor.windowText);
		lblEnterDate.setBounds(540, 59, 159, 27);
		getContentPane().add(lblEnterDate);
		
		btnNewButton = new JButton("Export to Excel!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 export ex= new export();
				 try {
					ex.exportTable(table, new File("C:\\Users\\User\\Google Drive\\attendance.xls"));
				JOptionPane.showMessageDialog(null,"record exported Successfully!!");
				 } catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(1171, 30, 151, 23);
		getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(1213, 97, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
					String query= "delete from attendance where Date='"+textField.getText()+"'";
					PreparedStatement pa=con.prepareStatement(query);
					pa.execute();
					JOptionPane.showMessageDialog(null,"Records Deleted SuccessFully!!");
				} catch(Exception e1) {
					e1.printStackTrace();
					//JOptionPane.showMessageDialog(null,"invalid date");
				}
				
			}
		});
		btnNewButton_1.setBounds(1213, 138, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		label = new JLabel("Enter date : (yyyy-MM-dd)");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setForeground(SystemColor.menuText);
		label.setBounds(1171, 59, 159, 27);
		getContentPane().add(label);

	}
}
