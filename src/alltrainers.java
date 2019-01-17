import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
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
import javax.swing.table.TableModel;

import com.mysql.cj.protocol.Resultset;

import net.proteanit.sql.DbUtils;
import subframe.Conn;
public class alltrainers extends JInternalFrame {
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	}

	/**
	 * Create the frame.
	 */
	public alltrainers() {
		getContentPane().setBackground(new Color(107, 142, 35));
		setClosable(true);
		setMaximizable(true);
		setTitle("ALL MEMEBERS");
		setBounds(100, 100, 1390, 641);
		getContentPane().setLayout(null);


		
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(632, 251, 89, 23);
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12269826", "sql12269826", 
					"zYYpzlsecc");
					//Conn.getConnection(title, title, title);
				//Connection con=Conn.getConnection();
					//Conn.getConnection();
					String query= "select Fullname,Gender,Contactno,dob,Alternateno,Email,DateofJoining,"
							+ "Shift,Trainerid,Salary from addtrainer order by DateofJoining desc";
					PreparedStatement pa=con.prepareStatement(query);
					Resultset rs=(Resultset) pa.executeQuery();			
					table.setModel(DbUtils.resultSetToTableModel((ResultSet) rs));
				} catch(Exception e) {
					e.printStackTrace();
					
				}
			
			//public expro() {}
				
				
			}
		});
		getContentPane().add(btnRefresh);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 285, 1332, 327);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnExportExcel = new JButton("Export to excel");
		btnExportExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				 export ex= new export();
				 try {
					ex.exportTable(table, new File("C:\\All Trainers.xls"));
					JOptionPane.showMessageDialog(null,"Records exported to All trainers.xls" );
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnExportExcel.setBounds(1183, 24, 148, 23);
		getContentPane().add(btnExportExcel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\User\\eclipse-workspace\\gym_management\\src\\trainer.jpg"));
		lblNewLabel.setBounds(421, 11, 520, 229);
		getContentPane().add(lblNewLabel);
		}

	public void exportTable(JTable table, File file) throws IOException
	{
	     TableModel model = table.getModel();
	     FileWriter excel = new FileWriter(file);
	     for(int i = 0; i < model.getColumnCount(); i++)
	     {
	       excel.write(model.getColumnName(i) + "\t");
	     }
	    excel.write("\n");
	    for(int i=0; i< model.getRowCount(); i++) {
	     for(int j=0; j < model.getColumnCount(); j++) {
	       excel.write(model.getValueAt(i,j).toString()+"\t");
	    }
	   excel.write("\n");
	}
	 excel.close();
	}
}
