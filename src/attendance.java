import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.text.DateFormatter;

import java.text.DateFormat;
public class attendance extends JInternalFrame {
	private JTextField atdregister;
	private JTextField atdtodaysdate;
	private JTextField atdtime;
	private JTextField enddate;
	private JTextField payable;
	public String ww,g;
	public JLabel la;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					attendance frame = new attendance();
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
	public attendance() {
		setClosable(true);
		setTitle("ATTENDANCE");
		setBounds(100, 100, 1274, 639);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration no.");
		lblNewLabel.setBounds(136, 81, 112, 14);
		getContentPane().add(lblNewLabel);
		Date d11= new Date();
		SimpleDateFormat sf1=new SimpleDateFormat("MM-dd");
		
		JLabel name = new JLabel("--");
		name.setFont(new Font("Tahoma", Font.BOLD, 13));
		name.setBounds(1084, 272, 112, 35);
		getContentPane().add(name);
		
		JLabel lblTodaysDate = new JLabel("Todays date");
		lblTodaysDate.setBounds(298, 81, 86, 14);
		getContentPane().add(lblTodaysDate);
		
		//la.setText(g);
		JLabel time = new JLabel("Time");
		time.setBounds(483, 81, 89, 14);
		getContentPane().add(time);

		JPanel panel = new JPanel();
		panel.setBounds(1056, 81, 140, 144);
		getContentPane().add(panel);
		panel.setLayout(null);
		JLabel photo = new JLabel("");
		photo.setBounds(0, 0, 140, 144);
		panel.add(photo);
		
		JLabel lblNewLabel_1 = new JLabel("Name:-");
		lblNewLabel_1.setBounds(980, 283, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblRegistrationNo = new JLabel("Registration no:-");
		lblRegistrationNo.setBounds(980, 328, 112, 14);
		getContentPane().add(lblRegistrationNo);
		
		JLabel reg = new JLabel("--");
		reg.setFont(new Font("Tahoma", Font.BOLD, 13));
		reg.setBounds(1084, 317, 112, 35);
		getContentPane().add(reg);
		
		JLabel lblStratDate = new JLabel("Start Date :-");
		lblStratDate.setBounds(981, 368, 86, 14);
		getContentPane().add(lblStratDate);
		
		JLabel std = new JLabel("--");
		std.setFont(new Font("Tahoma", Font.BOLD, 13));
		std.setBounds(1084, 357, 164, 35);
		getContentPane().add(std);
		
		JLabel lblEndDate_1 = new JLabel("End Date:-");
		lblEndDate_1.setBounds(981, 403, 86, 14);
		getContentPane().add(lblEndDate_1);
		
		JLabel end = new JLabel("--");
		end.setFont(new Font("Tahoma", Font.BOLD, 13));
		end.setBounds(1084, 392, 112, 35);
		getContentPane().add(end);
		JLabel lblNewLabel_4 = new JLabel("Pending Fees:-");
		lblNewLabel_4.setBounds(980, 478, 87, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel pendingfees = new JLabel("--");
		pendingfees.setFont(new Font("Tahoma", Font.BOLD, 13));
		pendingfees.setBounds(1084, 470, 112, 29);
		getContentPane().add(pendingfees);
		JLabel lblPayableDate_1 = new JLabel("Payable Date:-");
		lblPayableDate_1.setBounds(981, 441, 86, 14);
		getContentPane().add(lblPayableDate_1);
		
		JLabel pyd = new JLabel("--");
		pyd.setFont(new Font("Tahoma", Font.BOLD, 13));
		pyd.setBounds(1084, 430, 112, 35);
		getContentPane().add(pyd);
		 
		
			//catch(Exception ee4){ee4.printStackTrace();}
		
		atdregister = new JTextField();
		atdregister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				Timer t= new Timer (10,new ActionListener() {
					public void actionPerformed(ActionEvent e)  {
				SimpleDateFormat sff=new SimpleDateFormat("HH:mm:ss");
				atdtime.setText(sff.format(new java.util.Date()));
					} 
					});
		t.start();
		
		
		
		
		
				try {
					String val="^[0-9]";
				Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
					
					
						
					String pay = "select * from addmember where Registrationno='"+atdregister.getText()+"' ";
							//+ "and"
						//	+ "DATE_FORMAT(Dob,'%m-%d')='"+dob.getText()+"'";
					PreparedStatement ps=conn.prepareStatement(pay);
					ResultSet rs=ps.executeQuery();
					
					if(rs.next()) {
						byte [] img= rs.getBytes("photo");
						ImageIcon Myimg= new ImageIcon(img); 
						Image im= Myimg.getImage();
						Image myImg = im.getScaledInstance(photo.getWidth(), photo.getHeight(),Image.SCALE_SMOOTH);
			             ImageIcon newImage = new ImageIcon(myImg);
			             photo.setIcon(newImage);
					enddate.setText(rs.getString(12));
					payable.setText(rs.getString(18));
					name.setText(rs.getString(1));
					pyd.setText(rs.getString(18));
					String g=rs.getString(10);
					String dd=rs.getString(5);//1997-02-10
				
					
					
					
					//Date date1=new SimpleDateFormat("yyyy").parse(g);
				//	String gg = String.valueOf(date1);
					std.setText(g);
					//std.setText(g);
					end.setText(rs.getString(12));
					reg.setText(atdregister.getText());
					pendingfees.setText(rs.getString(15));
					}
					
					Date d2=new Date();
					SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
					Date d5=sd.parse(payable.getText());
					Date d1=sd.parse(enddate.getText());
					Date d3=sd.parse(atdtodaysdate.getText());
					//long daysp=(d5.getDate()-d3.getDate());
					@SuppressWarnings("deprecation")
					//long diff3=(d1.getDate()-d3.getDate());
					long days =daysBetween(d3,d1);
					long daysp1=daysBetween(d3,d5);
			
			if(d1.getTime()>d3.getTime()) {
					if(days==7) {
						getToolkit().beep();
							JOptionPane.showMessageDialog(null,"Subscription ends in 7 days");
						}
					if(days==6) {
						getToolkit().beep();
							JOptionPane.showMessageDialog(null,"Subscription ends in 6 days");
						}
					if(days==5) {
						getToolkit().beep();
							JOptionPane.showMessageDialog(null,"Subscription ends in 5 days");
						}
					if(days==4) {
						 music a= new music();
						    a.main(null);
						//getToolkit().beep();
							JOptionPane.showMessageDialog(null,"Subscription ends in 4 days");
					}if(days==3) {
							 music a= new music();
							    a.main(null);
							//getToolkit().beep();
							JOptionPane.showMessageDialog(null,"Subscription ends in 3 days");
						}if(days==2) {
							music a= new music();
							a.main(null);
							//getToolkit().beep();
							JOptionPane.showMessageDialog(null,"Subscription ends in 2 days!!!");
						}
						if(days==1) {
							getToolkit().beep();
								JOptionPane.showMessageDialog(null,"Subscription ends TOMMOROW!!!");
							}}
					if(d3.getTime()<d5.getTime()) {
						if(daysp1==3) {
							getToolkit().beep();
								JOptionPane.showMessageDialog(null,"Fess pending kindly pay within 3 days!!!");
							}
						
					if(daysp1==2) {
						music aa= new music();   	
						getToolkit().beep();
								JOptionPane.showMessageDialog(null,"Fess pending kindly pay within 2 days");
							}
						
						if(daysp1==1) {
							 music aa= new music();   
								//a.main(null);
						
								JOptionPane.showMessageDialog(null,"Fess pending kindly pay TOMORROW!!");
							}}
						if(d3.getTime()>=d5.getTime()) {
							 music a= new music();   
							a.main(null);
							JOptionPane.showMessageDialog(null,"Fess Pending!!!");
						}
						if(d3.getTime()>=d1.getTime()) {
							 music a= new music();
							    music.main(null);
							getToolkit().beep();
				JOptionPane.showMessageDialog(null,"Subscription has ENDED!!!!");
				atdregister.setText(null);
				payable.setText(null);
				enddate.setText(null);
			
						}
						
						
		
			else { 
				String query1="insert into attendance (Registrationno,Date,Time) values"
					+ "(?,?,?)";
			PreparedStatement pst=conn.prepareStatement(query1);
				pst.setString(1,atdregister.getText());
				pst.setString(2,atdtodaysdate.getText());
				pst.setString(3,atdtime.getText());			
				
				//String q="select Fullname from addmember where Registrationno='"+atdregister.getText()+"'";
			//	PreparedStatement pss=con.prepareStatement(q);
			//	ResultSet rss=pss.executeQuery();
				pst.execute();
				 g=(rs.getString(1));
				//String ww=(rs.getString(2));
				 //music2 an= new music2();
				// an.main(null);
			JOptionPane.showMessageDialog(null,"Attendance Marked for"+"   "+"' "+g+" '"+" ");
				
			
			atdregister.setText(null);
			payable.setText(null);
			enddate.setText(null);
		
			
			}
			
		
			
					}catch(Throwable e3) {
				    // e3.printStackTrace();
				   
				    getToolkit().beep();
				     JOptionPane.showMessageDialog(null,"Member Unavilable");
				     atdregister.setText(null);
				}
		
			}

			private long daysBetween(Date d3, Date d1) {
				long difff=(d3.getTime()-d1.getTime())/86400000;
				return Math.abs(difff);
			}private long daysBetweenp(Date d3, Date d5) {
				long difff=(d3.getTime()-d5.getTime())/86400000;
				return Math.abs(difff);
			}
			
		});
		
	
		
			
		atdregister.setBounds(136, 121, 86, 20);
		getContentPane().add(atdregister);
		atdregister.setColumns(10);
		
		atdtodaysdate = new JTextField();
		atdtodaysdate.setColumns(10);
		atdtodaysdate.setBounds(298, 121, 86, 20);
		getContentPane().add(atdtodaysdate);
		Date d= new Date();
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
		atdtodaysdate.setText(sf.format(d));
		
		
		atdtime = new JTextField();
		atdtime.setColumns(10);
		atdtime.setBounds(470, 121, 86, 20);
		getContentPane().add(atdtime);
	
		Date t= new Date();
		SimpleDateFormat sff=new SimpleDateFormat("HH:mm:ss");
		atdtime.setText(sff.format(t));
	
		
	//	labb.setText(ww);
		
		
		enddate = new JTextField();
		enddate.setBounds(610, 121, 86, 20);
		getContentPane().add(enddate);
		enddate.setColumns(10);
		
		JLabel lblEndDate = new JLabel("END DATE");
		lblEndDate.setBounds(624, 81, 86, 14);
		getContentPane().add(lblEndDate);
		
		payable = new JTextField();
		payable.setColumns(10);
		payable.setBounds(757, 121, 86, 20);
		getContentPane().add(payable);
		
		JLabel lblPayableDate = new JLabel("PAYABLE DATE");
		lblPayableDate.setBounds(757, 81, 112, 14);
		getContentPane().add(lblPayableDate);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(936, 81, 2, 438);
		getContentPane().add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("Attendee Details.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(1058, 23, 176, 29);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\User\\eclipse-workspace\\gym_management\\src\\att11.jpg"));
		lblNewLabel_3.setBounds(57, 311, 441, 311);
		getContentPane().add(lblNewLabel_3);
		
	
	}
}
