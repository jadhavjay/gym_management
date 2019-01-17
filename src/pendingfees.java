import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.mysql.cj.protocol.Resultset;

import net.proteanit.sql.DbUtils;
import javax.swing.UIManager;
import javax.swing.JCheckBox;

public class pendingfees extends JInternalFrame {
	private JTable table;
	private JTable table1;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JLabel lblPendingFees;
	private JLabel lblNewLabel_1;
	private JCheckBox checkBox;
	private JCheckBox chckbxMay;
	private JCheckBox chckbxJun;
	private JCheckBox chckbxJuly;
	private JCheckBox chckbxAug;
	private JCheckBox chckbxSep;
	private JCheckBox chckbxFeb;
	private JCheckBox chckbxOct;
	private JCheckBox chckbxJan;
	private JCheckBox chckbxNov;
	private JCheckBox chckbxDec;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pendingfees frame = new pendingfees();
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
	public pendingfees() {
		getContentPane().setBackground(UIManager.getColor("Button.background"));
		setClosable(true);
		setMaximizable(true);
		setTitle("PENDING FEES");
		setBounds(100, 100, 1375, 663);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setToolTipText("YYYY-MM-DD");
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test6", "root", "");
					String query= "select Registrationno,Fullname,Alternate,Contact,PayableDate,PendingFees,Enddate from addmember "
							+ "where Feestatus='pending' and PayableDate='"+textField.getText()+"'";
					PreparedStatement pa=con.prepareStatement(query);
					Resultset rs=(Resultset) pa.executeQuery();			
					table.setModel(DbUtils.resultSetToTableModel((ResultSet) rs));
				} catch(Exception e) {
					JOptionPane.showConfirmDialog(null, "Inavild date!!");
				
				}try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test6", "root", "");
				String query= "select Registrationno,Fullname,Alternate,Contact,Startdate,Enddate,Feestatus from addmember "
						+ "where EndDate='"+textField.getText()+"'";
				PreparedStatement pa=conn.prepareStatement(query);
				Resultset rs=(Resultset) pa.executeQuery();			
				table1.setModel(DbUtils.resultSetToTableModel((ResultSet) rs));
			} catch(Exception e) {
				JOptionPane.showConfirmDialog(null, "Inavild date!!");
			}
			}});
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 138, 627, 485);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(749, 138, 595, 485);
		getContentPane().add(scrollPane_1);
		
		table1 = new JTable();
		scrollPane_1.setViewportView(table1);
		
		
		textField.setBounds(658, 28, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		lblNewLabel = new JLabel("End of Subscriptions:-");
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(983, 95, 284, 43);
		getContentPane().add(lblNewLabel);
		
		lblPendingFees = new JLabel("Pending Fees:-");
		lblPendingFees.setBackground(UIManager.getColor("Button.foreground"));
		lblPendingFees.setForeground(Color.BLACK);
		lblPendingFees.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPendingFees.setBounds(256, 95, 176, 43);
		getContentPane().add(lblPendingFees);
		
		lblNewLabel_1 = new JLabel("Date");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(762, 25, 70, 27);
		getContentPane().add(lblNewLabel_1);
		
		JCheckBox chckbxMar = new JCheckBox("Mar");
		chckbxMar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chckbxJun.setSelected(false);
				chckbxNov.setSelected(false);
				chckbxMay.setSelected(false);
				chckbxFeb.setSelected(false);
				chckbxOct.setSelected(false);
				chckbxSep.setSelected(false);
				chckbxJuly.setSelected(false);
				checkBox.setSelected(false);
				chckbxJan.setSelected(false);
				chckbxDec.setSelected(false);
				chckbxAug.setSelected(false);
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test6", "root", "");
					String query= "SELECT Registrationno,Fullname,Contact,Alternate,Payabledate,Enddate,Pendingfees from addmember where "
							+ "DATE_FORMAT(Payabledate,'%m')='03' and Feestatus='pending'";
							
							
					PreparedStatement pa=con.prepareStatement(query);
					Resultset rs=((Resultset) pa.executeQuery());			
					table.setModel(DbUtils.resultSetToTableModel((ResultSet) rs));
				} catch(Exception e) {
					//e.printStackTrace();
					
				}try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test6", "root", "");
					String query= "SELECT Registrationno,Fullname,Contact,Alternate,Startdate,Enddate from addmember where "
							+ "DATE_FORMAT(Enddate,'%m')='03'";
							
							
					PreparedStatement pa=con.prepareStatement(query);
					Resultset rs=((Resultset) pa.executeQuery());			
					table1.setModel(DbUtils.resultSetToTableModel((ResultSet) rs));
				} catch(Exception e) {
					//e.printStackTrace();
					
				}
			}
		});
		chckbxMar.setBounds(451, 59, 70, 23);
		getContentPane().add(chckbxMar);
		
		checkBox = new JCheckBox("April");
		checkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxJun.setSelected(false);
				chckbxNov.setSelected(false);
				chckbxMay.setSelected(false);
				chckbxFeb.setSelected(false);
				chckbxOct.setSelected(false);
				chckbxSep.setSelected(false);
				chckbxJuly.setSelected(false);
				chckbxAug.setSelected(false);
				chckbxJan.setSelected(false);
				chckbxDec.setSelected(false);
				chckbxMar.setSelected(false);
				
						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test6", "root", "");
							String query= "SELECT Registrationno,Fullname,Contact,Alternate,Payabledate,Enddate,Pendingfees from addmember where "
									+ "DATE_FORMAT(Payabledate,'%m')='04' and Feestatus='pending'";
									
									
							PreparedStatement pa=con.prepareStatement(query);
							Resultset rs=((Resultset) pa.executeQuery());			
							table.setModel(DbUtils.resultSetToTableModel((ResultSet) rs));
						} catch(Exception ee) {
							//e.printStackTrace();
							
						}try {
							Class.forName("com.mysql.cj.jdbc.Driver");
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test6", "root", "");
							String query= "SELECT Registrationno,Fullname,Contact,Alternate,Startdate,Enddate from addmember where "
									+ "DATE_FORMAT(Enddate,'%m')='04'";
									
									
							PreparedStatement pa=con.prepareStatement(query);
							Resultset rs=((Resultset) pa.executeQuery());			
							table1.setModel(DbUtils.resultSetToTableModel((ResultSet) rs));
						} catch(Exception ee) {
							//e.printStackTrace();
							
						}
					}
				});
			
		
					
				
		checkBox.setBounds(523, 59, 71, 23);
		getContentPane().add(checkBox);
		
		chckbxMay = new JCheckBox("May");
		chckbxMay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			chckbxJuly.setSelected(false);
			chckbxNov.setSelected(false);
			chckbxJun.setSelected(false);
			chckbxOct.setSelected(false);
			chckbxJan.setSelected(false);
			chckbxFeb.setSelected(false);
			chckbxAug.setSelected(false);
			chckbxSep.setSelected(false);
			chckbxNov.setSelected(false);
			chckbxDec.setSelected(false);
			chckbxMar.setSelected(false);
			checkBox.setSelected(false);
			
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test6", "root", "");
					String query= "SELECT Registrationno,Fullname,Contact,Alternate,Payabledate,Enddate,Pendingfees from addmember where "
							+ "DATE_FORMAT(Payabledate,'%m')='05' and feestatus='pending'";
							
							
					PreparedStatement pa=con.prepareStatement(query);
					Resultset rs=((Resultset) pa.executeQuery());			
					table.setModel(DbUtils.resultSetToTableModel((ResultSet) rs));
				} catch(Exception ee) {
					//e.printStackTrace();
					
				}try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test6", "root", "");
					String query= "SELECT Registrationno,Fullname,Contact,Alternate,Startdate,Enddate from addmember where "
							+ "DATE_FORMAT(Enddate,'%m')='05'";
							
							
					PreparedStatement pa=con.prepareStatement(query);
					Resultset rs=((Resultset) pa.executeQuery());			
					table1.setModel(DbUtils.resultSetToTableModel((ResultSet) rs));
				} catch(Exception ee) {
					//e.printStackTrace();
					
				}
			}
		});
		chckbxMay.setBounds(596, 59, 75, 23);
		getContentPane().add(chckbxMay);
		
		chckbxJun = new JCheckBox("Jun");
		chckbxJun.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				chckbxJuly.setSelected(false);
				chckbxNov.setSelected(false);
				chckbxMay.setSelected(false);
				chckbxOct.setSelected(false);
				chckbxJan.setSelected(false);
				chckbxFeb.setSelected(false);
				chckbxAug.setSelected(false);
				chckbxSep.setSelected(false);
				//chckbxNov.setSelected(false);
				chckbxDec.setSelected(false);
				chckbxMar.setSelected(false);
				checkBox.setSelected(false);
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test6", "root", "");
					String query= "SELECT Registrationno,Fullname,Contact,Alternate,Payabledate,Enddate,Pendingfees from addmember where "
							+ "DATE_FORMAT(Payabledate,'%m')='06' and Feestatus='pending'";
							
							
					PreparedStatement pa=con.prepareStatement(query);
					Resultset rs=((Resultset) pa.executeQuery());			
					table.setModel(DbUtils.resultSetToTableModel((ResultSet) rs));
				} catch(Exception ee) {
					//e.printStackTrace();
					
				}try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test6", "root", "");
					String query= "SELECT Registrationno,Fullname,Contact,Alternate,Startdate,Enddate from addmember where "
							+ "DATE_FORMAT(Enddate,'%m')='06'";
							
							
					PreparedStatement pa=con.prepareStatement(query);
					Resultset rs=((Resultset) pa.executeQuery());			
					table1.setModel(DbUtils.resultSetToTableModel((ResultSet) rs));
				} catch(Exception ee) {
					//e.printStackTrace();
					
				}
			}
		});
		chckbxJun.setBounds(681, 59, 63, 23);
		getContentPane().add(chckbxJun);
		
		chckbxJuly = new JCheckBox("Jul");
		chckbxJuly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxJun.setSelected(false);
				chckbxNov.setSelected(false);
				chckbxMay.setSelected(false);
				chckbxOct.setSelected(false);
				chckbxJan.setSelected(false);
				chckbxFeb.setSelected(false);
				chckbxAug.setSelected(false);
				chckbxSep.setSelected(false);
				//chckbxNov.setSelected(false);
				chckbxDec.setSelected(false);
				chckbxMar.setSelected(false);
				checkBox.setSelected(false);
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test6", "root", "");
					String query= "SELECT Registrationno,Fullname,Contact,Alternate,Payabledate,Enddate,Pendingfees from addmember where "
							+ "DATE_FORMAT(Payabledate,'%m')='07' and Feestatus='pending'";
							
							
					PreparedStatement pa=con.prepareStatement(query);
					Resultset rs=((Resultset) pa.executeQuery());			
					table.setModel(DbUtils.resultSetToTableModel((ResultSet) rs));
				} catch(Exception ee) {
					//e.printStackTrace();
					
				}try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test6", "root", "");
					String query= "SELECT Registrationno,Fullname,Contact,Alternate,Startdate,Enddate from addmember where "
							+ "DATE_FORMAT(Enddate,'%m')='07'";
							
							
					PreparedStatement pa=con.prepareStatement(query);
					Resultset rs=((Resultset) pa.executeQuery());			
					table1.setModel(DbUtils.resultSetToTableModel((ResultSet) rs));
				} catch(Exception ee) {
					//e.printStackTrace();
					
				}
			}
		});
		chckbxJuly.setBounds(762, 59, 70, 23);
		getContentPane().add(chckbxJuly);
		
		chckbxAug = new JCheckBox("Aug");
		chckbxAug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxJun.setSelected(false);
				chckbxNov.setSelected(false);
				chckbxMay.setSelected(false);
				chckbxOct.setSelected(false);
				chckbxJan.setSelected(false);
				chckbxFeb.setSelected(false);
				chckbxJuly.setSelected(false);
				chckbxSep.setSelected(false);
				checkBox.setSelected(false);
				chckbxDec.setSelected(false);
				chckbxMar.setSelected(false);
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test6", "root", "");
					String query= "SELECT Registrationno,Fullname,Contact,Alternate,Payabledate,Enddate,Pendingfees from addmember where "
							+ "DATE_FORMAT(Payabledate,'%m')='08' and Feestatus='pending'";
							
							
					PreparedStatement pa=con.prepareStatement(query);
					Resultset rs=((Resultset) pa.executeQuery());			
					table.setModel(DbUtils.resultSetToTableModel((ResultSet) rs));
				} catch(Exception ee) {
					//e.printStackTrace();
					
				}try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test6", "root", "");
					String query= "SELECT Registrationno,Fullname,Contact,Alternate,Startdate,Enddate from addmember where "
							+ "DATE_FORMAT(Enddate,'%m')='08'";
							
							
					PreparedStatement pa=con.prepareStatement(query);
					Resultset rs=((Resultset) pa.executeQuery());			
					table1.setModel(DbUtils.resultSetToTableModel((ResultSet) rs));
				} catch(Exception ee) {
					//e.printStackTrace();
					
				}
			}
		});
		chckbxAug.setBounds(834, 59, 63, 23);
		getContentPane().add(chckbxAug);
		
		chckbxSep = new JCheckBox("Sep");
		chckbxSep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxJun.setSelected(false);
				chckbxAug.setSelected(false);
				chckbxMay.setSelected(false);
				chckbxOct.setSelected(false);
				chckbxJan.setSelected(false);
				chckbxFeb.setSelected(false);
				chckbxJuly.setSelected(false);
				checkBox.setSelected(false);
				chckbxNov.setSelected(false);
				chckbxDec.setSelected(false);
				chckbxMar.setSelected(false);
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test6", "root", "");
					String query= "SELECT Registrationno,Fullname,Contact,Alternate,Payabledate,Enddate,Pendingfees from addmember where "
							+ "DATE_FORMAT(Payabledate,'%m')='09' and Feestatus='pending'";
							
							
					PreparedStatement pa=con.prepareStatement(query);
					Resultset rs=((Resultset) pa.executeQuery());			
					table.setModel(DbUtils.resultSetToTableModel((ResultSet) rs));
				} catch(Exception ee) {
					//e.printStackTrace();
					
				}try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test6", "root", "");
					String query= "SELECT Registrationno,Fullname,Contact,Alternate,Startdate,Enddate from addmember where "
							+ "DATE_FORMAT(Enddate,'%m')='09'";
							
							
					PreparedStatement pa=con.prepareStatement(query);
					Resultset rs=((Resultset) pa.executeQuery());			
					table1.setModel(DbUtils.resultSetToTableModel((ResultSet) rs));
				} catch(Exception ee) {
					//e.printStackTrace();
					
				}
			}
		});
		chckbxSep.setBounds(915, 59, 64, 23);
		getContentPane().add(chckbxSep);
		
		chckbxFeb = new JCheckBox("Feb");
		chckbxFeb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxJun.setSelected(false);
				chckbxNov.setSelected(false);
				chckbxMay.setSelected(false);
				chckbxOct.setSelected(false);
				chckbxJan.setSelected(false);
				chckbxSep.setSelected(false);
				chckbxJuly.setSelected(false);
				checkBox.setSelected(false);
				chckbxAug.setSelected(false);
				chckbxDec.setSelected(false);
				chckbxMar.setSelected(false);
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test6", "root", "");
					String query= "SELECT Registrationno,Fullname,Contact,Alternate,Payabledate,Enddate,Pendingfees from addmember where "
							+ "DATE_FORMAT(Payabledate,'%m')='02' and Feestatus='pending'";
							
							
					PreparedStatement pa=con.prepareStatement(query);
					Resultset rs=((Resultset) pa.executeQuery());			
					table.setModel(DbUtils.resultSetToTableModel((ResultSet) rs));
				} catch(Exception e1) {
					//e.printStackTrace();
					
				}try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test6", "root", "");
					String query= "SELECT Registrationno,Fullname,Contact,Alternate,Startdate,Enddate from addmember where "
							+ "DATE_FORMAT(Enddate,'%m')='02'";
							
							
					PreparedStatement pa=con.prepareStatement(query);
					Resultset rs=((Resultset) pa.executeQuery());			
					table1.setModel(DbUtils.resultSetToTableModel((ResultSet) rs));
				} catch(Exception e1) {
					//e.printStackTrace();
					
				}
			}
		});
		chckbxFeb.setBounds(362, 59, 70, 23);
		getContentPane().add(chckbxFeb);
		
		chckbxOct = new JCheckBox("Oct");
		chckbxOct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxJun.setSelected(false);
				chckbxAug.setSelected(false);
				chckbxMay.setSelected(false);
				chckbxFeb.setSelected(false);
				chckbxJan.setSelected(false);
				chckbxSep.setSelected(false);
				chckbxJuly.setSelected(false);
				checkBox.setSelected(false);
				chckbxNov.setSelected(false);
				chckbxDec.setSelected(false);
				chckbxMar.setSelected(false);
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test6", "root", "");
					String query= "SELECT Registrationno,Fullname,Contact,Alternate,Payabledate,Enddate,Pendingfees from addmember where "
							+ "DATE_FORMAT(Payabledate,'%m')='10' and Feestatus='pending'";
							
							
					PreparedStatement pa=con.prepareStatement(query);
					Resultset rs=((Resultset) pa.executeQuery());			
					table.setModel(DbUtils.resultSetToTableModel((ResultSet) rs));
				} catch(Exception e1) {
					//e.printStackTrace();
					
				}try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test6", "root", "");
					String query= "SELECT Registrationno,Fullname,Contact,Alternate,Startdate,Enddate from addmember where "
							+ "DATE_FORMAT(Enddate,'%m')='10'";
							
							
					PreparedStatement pa=con.prepareStatement(query);
					Resultset rs=((Resultset) pa.executeQuery());			
					table1.setModel(DbUtils.resultSetToTableModel((ResultSet) rs));
				} catch(Exception e1) {
					//e.printStackTrace();
					
				}
			}
		});

		chckbxOct.setBounds(983, 59, 71, 23);
		getContentPane().add(chckbxOct);
		
		chckbxJan = new JCheckBox("Jan");
		chckbxJan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxJun.setSelected(false);
				chckbxNov.setSelected(false);
				chckbxMay.setSelected(false);
				chckbxFeb.setSelected(false);
				chckbxOct.setSelected(false);
				chckbxSep.setSelected(false);
				chckbxJuly.setSelected(false);
				checkBox.setSelected(false);
				chckbxAug.setSelected(false);
				chckbxDec.setSelected(false);
				chckbxMar.setSelected(false);

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test6", "root", "");
					String query= "SELECT Registrationno,Fullname,Contact,Alternate,Payabledate,Enddate,Pendingfees from addmember where "
							+ "DATE_FORMAT(Payabledate,'%m')='01'";
							
							
					PreparedStatement pa=con.prepareStatement(query);
					Resultset rs=((Resultset) pa.executeQuery());			
					table.setModel(DbUtils.resultSetToTableModel((ResultSet) rs));
				} catch(Exception ee) {
					//e.printStackTrace();
					
				}try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test6", "root", "");
					String query= "SELECT Registrationno,Fullname,Contact,Alternate,Startdate,Enddate from addmember where "
							+ "DATE_FORMAT(Enddate,'%m')='01'";
							
							
					PreparedStatement pa=con.prepareStatement(query);
					Resultset rs=((Resultset) pa.executeQuery());			
					table1.setModel(DbUtils.resultSetToTableModel((ResultSet) rs));
				} catch(Exception ee) {
					//e.printStackTrace();
					
				}
			}
		});
		chckbxJan.setBounds(288, 59, 71, 23);
		getContentPane().add(chckbxJan);
		
		chckbxNov = new JCheckBox("Nov");
		chckbxNov.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxJun.setSelected(false);
				chckbxAug.setSelected(false);
				chckbxMay.setSelected(false);
				chckbxFeb.setSelected(false);
				chckbxOct.setSelected(false);
				chckbxSep.setSelected(false);
				chckbxJuly.setSelected(false);
				checkBox.setSelected(false);
				chckbxJan.setSelected(false);
				chckbxDec.setSelected(false);
				chckbxMar.setSelected(false);
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test6", "root", "");
					String query= "SELECT Registrationno,Fullname,Contact,Alternate,Payabledate,Enddate,Pendingfees from addmember where "
							+ "DATE_FORMAT(Payabledate,'%m')='11' and Feestatus='pending'";
							
							
					PreparedStatement pa=con.prepareStatement(query);
					Resultset rs=((Resultset) pa.executeQuery());			
					table.setModel(DbUtils.resultSetToTableModel((ResultSet) rs));
				} catch(Exception ee) {
					//e.printStackTrace();
					
				}try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test6", "root", "");
					String query= "SELECT Registrationno,Fullname,Contact,Alternate,Startdate,Enddate from addmember where "
							+ "DATE_FORMAT(Enddate,'%m')='11'";
							
							
					PreparedStatement pa=con.prepareStatement(query);
					Resultset rs=((Resultset) pa.executeQuery());			
					table1.setModel(DbUtils.resultSetToTableModel((ResultSet) rs));
				} catch(Exception ee) {
					//e.printStackTrace();
					
				}
			}
		});
		chckbxNov.setBounds(1056, 59, 71, 23);
		getContentPane().add(chckbxNov);
		
		chckbxDec = new JCheckBox("Dec");
		chckbxDec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxJun.setSelected(false);
				chckbxNov.setSelected(false);
				chckbxMay.setSelected(false);
				chckbxFeb.setSelected(false);
				chckbxOct.setSelected(false);
				chckbxSep.setSelected(false);
				chckbxJuly.setSelected(false);
				checkBox.setSelected(false);
				chckbxJan.setSelected(false);
				chckbxAug.setSelected(false);
				chckbxMar.setSelected(false);
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test6", "root", "");
					String query= "SELECT Registrationno,Fullname,Contact,Alternate,Payabledate,Enddate,Pendingfees from addmember where "
							+ "DATE_FORMAT(Payabledate,'%m')='12' and Feestatus='pending'";
							
							
					PreparedStatement pa=con.prepareStatement(query);
					Resultset rs=((Resultset) pa.executeQuery());			
					table.setModel(DbUtils.resultSetToTableModel((ResultSet) rs));
				} catch(Exception ee) {
					//e.printStackTrace();
					
				}try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test6", "root", "");
					String query= "SELECT Registrationno,Fullname,Contact,Alternate,Startdate,Enddate from addmember where "
							+ "DATE_FORMAT(Enddate,'%m')='12'";
							
							
					PreparedStatement pa=con.prepareStatement(query);
					Resultset rs=((Resultset) pa.executeQuery());			
					table1.setModel(DbUtils.resultSetToTableModel((ResultSet) rs));
				} catch(Exception ee) {
					//e.printStackTrace();
					JOptionPane.showMessageDialog(null,"error ");
				}
			}
		});
		chckbxDec.setBounds(1129, 59, 71, 23);
		getContentPane().add(chckbxDec);

	}
}
