import java.awt.HeadlessException;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import com.mysql.cj.protocol.Resultset;

import net.proteanit.sql.DbUtils;
import subframe.Conn;

@SuppressWarnings("serial")
public class allmembers extends JInternalFrame {
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	}

	/**
	 * Create the frame.
	 */
	public allmembers() {
		setRootPaneCheckingEnabled(false);
		setResizable(true);
		getContentPane().setBackground(SystemColor.controlShadow);
		setClosable(true);
		setMaximizable(true);
		setTitle("ALL MEMEBERS");
		setBounds(100, 100, 1403, 650);
		getContentPane().setLayout(null);
		//setUndecorated(true);

		
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(607, 42, 89, 23);
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Conn d=new Conn();
					//d.Con();
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");

					//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test6", "root", "");
					String query= "select Registrationno as 'Registration no',"
							+ "Fullname,Gender,Contact,Occupation,"
							+ "Email,Address,Subscription,Startdate as "
							+ "'Start Date',Enddate as 'End Date',Fees,"
							+ "Feestatus as 'Fees Status',"
							+ "PendingFees as 'Pending Fees',"
							+ "PayableDate as 'Payable Date',"
							+ "Facility,Trainer from addmember order by Startdate asc";
					PreparedStatement pa=con.prepareStatement(query);
					Resultset rs=(Resultset) pa.executeQuery();			
					table.setModel(DbUtils.resultSetToTableModel((ResultSet) rs));
				} catch(Exception e) {
					e.printStackTrace();
					
					
				}
			
		
			}
		});
	while(allmembers.isClosable(true)) {
			main m= new main();
				}
		getContentPane().add(btnRefresh);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 106, 1332, 504);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnExportExcel = new JButton("Export to excel");
		btnExportExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				 export ex= new export();
				 try {
					ex.exportTable(table, new File("C:\\Users\\User\\Google Drive\\members.xls"));
					JOptionPane.showMessageDialog(null,"Records Exported Successfully!"+"\n"+
										"     "+"\t"+"members.xls");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnExportExcel.setBounds(1207, 21, 135, 23);
		getContentPane().add(btnExportExcel);
		
		JButton btnCheck = new JButton("check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Socket soc = new Socket();
				InetSocketAddress addr = new InetSocketAddress("www.gonogle.com",80);
				try {
					soc.connect(addr,3000);
					soc.getLocalPort();
					JOptionPane.showMessageDialog(null,soc.getTcpNoDelay());
				}catch(Exception e) {
				e.printStackTrace();
					JOptionPane.showMessageDialog(null,e.getCause());
				}
			}
		});
		btnCheck.setBounds(777, 42, 89, 23);
		getContentPane().add(btnCheck);
		}

	private static boolean isClosable(boolean b) {
		// TODO Auto-generated method stub
		return false;
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
