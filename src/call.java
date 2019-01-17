import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.sun.nio.sctp.InvalidStreamException;
import com.toedter.calendar.JDateChooser;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class call extends JInternalFrame {
	private JTextField atfullname;
	private JTextField atcontact;
	private JTextField atoccupation;
	private JTextField atemail;
	private JTextField atalternate;
	private JTextField atFees;
	private JTextField atpendingFees;
	private JTextField atregister;
	private String fileName;
	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) throws IOException{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					call frame = new call();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	
	
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * Create the frame.
	 */
	public call() {
		//setIconifiable(true);
		getContentPane().setForeground(SystemColor.window);
		setTitle("ADD MEMBER");
		// setBounds(100,100,1187,625);
		setBackground(Color.PINK);
		setMaximizable(true);
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 15));
		getContentPane().setBackground(UIManager.getColor("Button.background"));
		getContentPane().setLayout(null);

		JLabel lblPersonalDetails = new JLabel("PERSONAL DETAILS. ");
		lblPersonalDetails.setForeground(UIManager.getColor("Button.foreground"));
		lblPersonalDetails.setBounds(183, 81, 153, 14);
		lblPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblPersonalDetails);

		JLabel lblNewMember = new JLabel("NEW MEMBER");
		lblNewMember.setBackground(UIManager.getColor("CheckBox.focus"));
		lblNewMember.setForeground(UIManager.getColor("Button.foreground"));
		lblNewMember.setBounds(377, 34, 245, 14);
		lblNewMember.setFont(new Font("Tahoma", Font.BOLD, 17));
		getContentPane().add(lblNewMember);

		JLabel lblFullName = new JLabel("Full name :");
		lblFullName.setForeground(UIManager.getColor("Button.foreground"));
		lblFullName.setBounds(196, 132, 76, 14);
		getContentPane().add(lblFullName);

		JLabel lblGender = new JLabel("Gender :");
		lblGender.setForeground(UIManager.getColor("Button.foreground"));
		lblGender.setBounds(484, 132, 66, 14);
		getContentPane().add(lblGender);

		JLabel lblAlternateNo = new JLabel("Alternate no. :");
		lblAlternateNo.setForeground(UIManager.getColor("Button.foreground"));
		lblAlternateNo.setBounds(196, 295, 87, 14);
		getContentPane().add(lblAlternateNo);

		JLabel lblContactNo = new JLabel("Contact no. :");
		lblContactNo.setForeground(UIManager.getColor("Button.foreground"));
		lblContactNo.setBounds(196, 187, 87, 14);
		getContentPane().add(lblContactNo);

		JLabel lblNewLabel = new JLabel("Occupation :");
		lblNewLabel.setForeground(UIManager.getColor("Button.foreground"));
		lblNewLabel.setBounds(484, 187, 76, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Email :");
		lblNewLabel_1.setForeground(UIManager.getColor("Button.foreground"));
		lblNewLabel_1.setBounds(484, 241, 66, 14);
		getContentPane().add(lblNewLabel_1);

		atfullname = new JTextField();
		atfullname.setBackground(new Color(255, 255, 255));
		atfullname.setBounds(293, 129, 147, 20);
		getContentPane().add(atfullname);
		atfullname.setColumns(20);

		atcontact = new JTextField();
		atcontact.setBackground(new Color(255, 255, 255));
		atcontact.setBounds(293, 184, 147, 20);
		getContentPane().add(atcontact);
		atcontact.setColumns(20);

		atoccupation = new JTextField();
		atoccupation.setBackground(new Color(255, 255, 255));
		atoccupation.setBounds(560, 184, 134, 20);
		getContentPane().add(atoccupation);
		atoccupation.setColumns(20);

		
		JLabel lblDateOfBirth = new JLabel("D.O.B :");
		lblDateOfBirth.setForeground(UIManager.getColor("Button.foreground"));
		lblDateOfBirth.setBounds(196, 241, 76, 14);
		getContentPane().add(lblDateOfBirth);

		JLabel lblNewLabel_4 = new JLabel("Address :");
		lblNewLabel_4.setForeground(UIManager.getColor("Button.foreground"));
		lblNewLabel_4.setBounds(484, 295, 66, 14);
		getContentPane().add(lblNewLabel_4);

		TextArea ataddress = new TextArea();
		ataddress.setBackground(SystemColor.text);
		ataddress.setForeground(new Color(0, 0, 0));
		ataddress.setBounds(560, 295, 134, 94);
		getContentPane().add(ataddress);
		

		JComboBox atgender = new JComboBox();
		atgender.setBounds(560, 129, 134, 20);
		atgender.setModel(new DefaultComboBoxModel(new String[] {null, "MALE", "FEMALE" }));
		getContentPane().add(atgender);

		atemail = new JTextField();
		atemail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				atemail.setText(null);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(atemail.getText().isEmpty()==true){
					atemail.setText("jai@gmail.com");
				}
			}
		});
		atemail.setBackground(new Color(255, 255, 255));
		atemail.setBounds(560, 238, 111, 20);
		atemail.setColumns(20);
		atemail.setText("jai@gmail.com");
		getContentPane().add(atemail);


		JSeparator separator = new JSeparator();
		separator.setBounds(183, 106, 511, 2);
		getContentPane().add(separator);

		JLabel lblNewLabel_2 = new JLabel("GYM DETAILS.");
		lblNewLabel_2.setForeground(UIManager.getColor("Button.foreground"));
		lblNewLabel_2.setBounds(183, 381, 153, 14);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblNewLabel_2);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(183, 406, 511, 2);
		getContentPane().add(separator_1);

		JLabel lblSubscription = new JLabel("Subscription :");
		lblSubscription.setForeground(UIManager.getColor("Button.foreground"));
		lblSubscription.setBounds(183, 500, 89, 14);
		getContentPane().add(lblSubscription);

		atalternate = new JTextField();
		atalternate.setBackground(new Color(255, 255, 255));
		atalternate.setBounds(293, 292, 147, 20);
		atalternate.setColumns(20);
		getContentPane().add(atalternate);

		JLabel lblNewLabel_3 = new JLabel("Start date :");
		lblNewLabel_3.setForeground(UIManager.getColor("Button.foreground"));
		lblNewLabel_3.setBounds(183, 426, 76, 14);
		getContentPane().add(lblNewLabel_3);

		JLabel lblFees = new JLabel("Fees :");
		lblFees.setForeground(UIManager.getColor("Button.foreground"));
		lblFees.setBounds(484, 426, 76, 14);
		getContentPane().add(lblFees);

		JLabel lblFeesStatus = new JLabel("Fees status :");
		lblFeesStatus.setForeground(UIManager.getColor("Button.foreground"));
		lblFeesStatus.setBounds(484, 500, 76, 14);
		getContentPane().add(lblFeesStatus);
		atFees = new JTextField();
		atFees.setBackground(new Color(255, 255, 255));
		atFees.setBounds(560, 419, 147, 20);
		atFees.setColumns(20);
		getContentPane().add(atFees);

		JLabel lblNewLabel_5 = new JLabel("Pending Fees :");
		lblNewLabel_5.setForeground(UIManager.getColor("Button.foreground"));
		lblNewLabel_5.setBounds(183, 542, 111, 14);
		getContentPane().add(lblNewLabel_5);

		JLabel lblTrainer = new JLabel("Trainer :");
		lblTrainer.setForeground(UIManager.getColor("Button.foreground"));
		lblTrainer.setBounds(484, 542, 66, 14);
		getContentPane().add(lblTrainer);

		JLabel lblEndDate = new JLabel("End date :");
		lblEndDate.setForeground(UIManager.getColor("Button.foreground"));
		lblEndDate.setBounds(183, 466, 66, 14);
		getContentPane().add(lblEndDate);
		//Date t = new Date();
		//SimpleDateFormat sfdd= new SimpleDateFormat("HH:mm:ss");
	    
		

		atpendingFees = new JTextField();
		atpendingFees.setBackground(new Color(255, 255, 255));
		atpendingFees.setBounds(293, 539, 147, 20);
		atpendingFees.setColumns(20);
		getContentPane().add(atpendingFees);

		JComboBox attrainer = new JComboBox();
		attrainer.setBounds(560, 539, 147, 20);
		attrainer.setModel(new DefaultComboBoxModel(new String[] {" "}));
		getContentPane().add(attrainer);
		

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
			String sql="select Fullname from addtrainer";
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				String subscription= rs.getString("Fullname");
				attrainer.addItem(rs.getString("Fullname"));
			}
			
			
		}catch(Exception e) {
		
		}

		JComboBox atsubscription = new JComboBox();
		atsubscription.setBounds(293, 497, 147, 20);
		atsubscription.setModel(new DefaultComboBoxModel(new String[] {null}));
		getContentPane().add(atsubscription);
		
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
			String sql="select * from addsubscription";
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				String subscription= rs.getString("subs");
				atsubscription.addItem(rs.getString("subs"));
			}
			
			
		}catch(Exception e) {
		
		}
				

		JComboBox atFeesstatus = new JComboBox();
		atFeesstatus.setBounds(560, 497, 147, 20);
		atFeesstatus.setModel(new DefaultComboBoxModel(new String[] {"paid", "pending"}));
		getContentPane().add(atFeesstatus);

		JComboBox atfacility = new JComboBox();
		atfacility.setBounds(293, 585, 147, 20);
		atfacility.setModel(new DefaultComboBoxModel(new String[] {}));
		getContentPane().add(atfacility);

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","");
			String sql="select * from addfacility";
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				String subscription= rs.getString("subs");
				atfacility.addItem(rs.getString("subs"));
			}
			
			
		}catch(Exception e) {
		
		}
		
		JPanel panel = new JPanel();
		panel.setBounds(804, 106, 147, 147);
		getContentPane().add(panel);
		panel.setLayout(null);
		JLabel labelphoto = new JLabel("             Select photo!");
		labelphoto.setBounds(0, 0, 147, 147);
		panel.add(labelphoto);
		labelphoto.setForeground(UIManager.getColor("Button.foreground"));
		JLabel lblFacility = new JLabel("Facility :");
		lblFacility.setForeground(UIManager.getColor("Button.foreground"));
		lblFacility.setBounds(183, 588, 66, 14);
		getContentPane().add(lblFacility);

		
		JButton btnNewButton = new JButton("UPLOAD");
		btnNewButton.setBounds(773, 307, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				//labelphoto.setIcon(new ImageIcon("C:\\Users\\User\\Pictures\\oct.png"));
//		
//		    }
			}	});
		getContentPane().add(btnNewButton);

		JLabel lblRegistrationNo = new JLabel("   REGISTRATION NO.");
		lblRegistrationNo.setForeground(UIManager.getColor("Button.foreground"));
		lblRegistrationNo.setBounds(831, 365, 111, 14);
		getContentPane().add(lblRegistrationNo);

		atregister = new JTextField();
		atregister.setBackground(new Color(255, 255, 255));
		atregister.setBounds(843, 393, 86, 20);
		getContentPane().add(atregister);
		atregister.setColumns(10);
		
		JDateChooser atenddate = new JDateChooser();
		atenddate.setBounds(293, 460, 147, 20);
		atenddate.getCalendarButton().setText("date");
		atenddate.setDateFormatString("yyyy-MM-dd");
		getContentPane().add(atenddate);
		
		JDateChooser atpayable = new JDateChooser();
		atpayable.setBounds(570, 460, 137, 20);
		atpayable.getCalendarButton().setText("date");
		atpayable.setDateFormatString("yyyy-MM-dd");
		getContentPane().add(atpayable);
		
		JLabel na = new JLabel("Enter name properly!");
		na.setFont(new Font("SansSerif", Font.PLAIN, 11));
		na.setForeground(Color.RED);
		na.setBounds(293, 149, 147, 14);
		getContentPane().add(na);
		na.setVisible(false);
		
		JLabel co = new JLabel("Enter Contactno.properly!");
		co.setFont(new Font("SansSerif", Font.PLAIN, 11));
		co.setForeground(Color.RED);
		co.setBounds(293, 202, 200, 14);
		getContentPane().add(co);
		co.setVisible(false);
		
		JLabel al = new JLabel("Enter Alternateno. properly!");
		al.setFont(new Font("SansSerif", Font.PLAIN, 11));
		al.setForeground(Color.RED);
		al.setBounds(293, 316, 167, 20);
		getContentPane().add(al);
		al.setVisible(false);
		
		JLabel occ = new JLabel("Enter Occupation properly!");
		occ.setFont(new Font("SansSerif", Font.PLAIN, 11));
		occ.setForeground(Color.RED);
		occ.setBounds(560, 202, 178, 20);
		getContentPane().add(occ);
		occ.setVisible(false);
		
		JLabel em = new JLabel("Enter Email properly!");
		em.setFont(new Font("SansSerif", Font.PLAIN, 11));
		em.setForeground(Color.RED);
		em.setBounds(560, 256, 147, 20);
		getContentPane().add(em);
		em.setVisible(false);
		
		JLabel fee = new JLabel("Enter Fees Amount properly!");
		fee.setFont(new Font("SansSerif", Font.PLAIN, 11));
		fee.setForeground(Color.RED);
		fee.setBounds(560, 435, 210, 20);
		getContentPane().add(fee);
		fee.setVisible(false);
		
		JLabel pfee = new JLabel("Enter Fees Amount properly!");
		pfee.setFont(new Font("SansSerif", Font.PLAIN, 11));
		pfee.setForeground(Color.RED);
		pfee.setBounds(293, 554, 200, 20);
		getContentPane().add(pfee);
		pfee.setVisible(false);
		
		JLabel regi = new JLabel("Enter Registration no. properly!");
		regi.setFont(new Font("SansSerif", Font.PLAIN, 11));
		regi.setForeground(Color.RED);
		regi.setBounds(812, 423, 244, 20);
		getContentPane().add(regi);
		regi.setVisible(false);
		

		JDateChooser atdob = new JDateChooser();
		atdob.setBounds(293, 235, 147, 20);
		atdob.getCalendarButton().setText("date");
		atdob.setDateFormatString("yyyy-MM-dd");
		getContentPane().add(atdob);
		
		JLabel lblPayableDate = new JLabel("Payable date :");
		lblPayableDate.setForeground(UIManager.getColor("Button.foreground"));
		lblPayableDate.setBounds(484, 466, 87, 14);
		getContentPane().add(lblPayableDate);

		
		
		JDateChooser atstartdate = new JDateChooser();
		atstartdate.setBounds(293, 420, 147, 20);
		atstartdate.setDateFormatString("yyyy-MM-dd");
		atstartdate.getCalendarButton().setText("date");
		getContentPane().add(atstartdate);
		setEnabled(false);
		setForeground(SystemColor.window);
		setRootPaneCheckingEnabled(false);
		setClosable(true);
		setBounds(100, 100, 1361, 664);
		InputStream is = null;
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.setBounds(759, 462, 89, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			private InputStream is;

			public void actionPerformed(ActionEvent arg0) throws InvalidStreamException {
				try {

										Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
									String query = "insert into addmember (Fullname,Gender,Contact,Occupation,Dob,Email,"
							+ "Alternate,Address,Subscription,Startdate,Fees,Enddate,Feestatus,Trainer,"
							+ "PendingFees,"
							+ "Facility,PayableDate,Registrationno,photo) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement pst = con.prepareStatement(query);
					//now try to run once
//					try {
//					is = new FileInputStream(new File(getFileName()));
//					}catch(Throwable e4) {
//						
//						JOptionPane.showMessageDialog(null,"insert photo");
//					}
					String reg="^[0-9]+";
					String Fees="^[0-9]+";
					  String  regex = "^[a-zA-Z\\s]+$";
					//  String add= "J.*\\d[0-35-9]-\\d\\d-\\d\\d";
					String no= "^[0-9]{10}$[a-z]{0}$";
String email=  "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		  + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";	
			if(atfullname.getText().isEmpty()&&atgender.getSelectedItem()==null&&
				atcontact.getText().isEmpty()&&atFees.getText().isEmpty()&&
				atemail.getText().isEmpty()&&atalternate.getText().isEmpty()
			&&atFees.getText().isEmpty()&&ataddress.getText().isEmpty()&&
			atoccupation.getText().isEmpty()&&atpendingFees.getText().isEmpty()
			&&atsubscription.getSelectedItem()==null&&(((JTextField)atenddate.getDateEditor().
					getUiComponent()).getText())==null
							&&(((JTextField)atdob.getDateEditor().getUiComponent()).
									getText())==null&&
			atregister.getText().isEmpty()&&atfacility.getSelectedItem()==null&&
			atdob.getDate()==null&&atstartdate.getDate()==null&&atenddate.getDate()==null
			&&labelphoto.getText()==null)
			{
			//	JOptionPane.showMessageDialog(null,"enter all the details");
			al.setVisible(true);	
			co.setVisible(true);
			em.setVisible(true);
			occ.setVisible(true);
			na.setVisible(true);
			pfee.setVisible(true);
			fee.setVisible(true);
			regi.setVisible(true);
			}
			if(atdob.getDate()==null) {
				//JOptionPane.showMessageDialog(null,"Enter date of Birth");
			}if(atstartdate.getDate()==null) {
				//JOptionPane.showMessageDialog(null,"Enter Start date");
			}
			
			if(atenddate.getDate()==null) {
				//JOptionPane.showMessageDialog(null,"Enter End Date");
			}
			if(atfullname.getText().matches(regex)==false||atfullname.getText().isEmpty()) {
				na.setVisible(true);
			}
			else{
				na.setVisible(false);
			}
			
			if(atcontact.getText().matches(no)==false||	atcontact.getText().isEmpty()) {
				co.setVisible(true);
			}else{
				co.setVisible(false);
			}
			
			
			if(atalternate.getText().matches(no)==false||atalternate.getText().isEmpty()) {
				al.setVisible(true);
			}else{
				al.setVisible(false);
			}
			
			
			if(atoccupation.getText().matches(regex)==false||atoccupation.getText().isEmpty()) {
				occ.setVisible(true);
				}
			else{
				occ.setVisible(false);
			}
			
			if(atemail.getText().matches(email)==false||atemail.getText().isEmpty()) {
				em.setVisible(true);
			}else{
				em.setVisible(false);
			}
			
			if(atregister.getText().matches(reg)==false||atregister.getText().isEmpty()) {
				regi.setVisible(true);
			}else{
				regi.setVisible(false);
			}
			
			
			if(atFees.getText().matches(Fees)==false||atFees.getText().isEmpty()) {
				fee.setVisible(true);
			}
			else{
				fee.setVisible(false);
			}
			if(atpendingFees.getText().matches(Fees)) {
				pfee.setVisible(false);
			}
			if(atpendingFees.getText().matches(Fees)==false||atpendingFees.getText().isEmpty()) {
				pfee.setVisible(true);
			}				
			else if(atfullname.getText().matches(regex)&&atcontact.getText().matches(no)&&
		  			atalternate.getText().matches(no)&&atoccupation.getText().
		  			matches(regex)&&atemail.getText().matches(email)&&atFees.getText().matches(Fees)
		  			&&atpendingFees.getText().matches(Fees)&&atoccupation.getText().matches(regex)
		  			&&atregister.getText().matches(reg)&&ataddress.getText().isEmpty()==false&&
		  			atdob.getDate()!=null&&atenddate.getDate()!=null&&atpayable.getDate()!=null
		  			&&atstartdate.getDate()!=null) {
				
				pst.setString(1, atfullname.getText());
				pst.setString(2, (String)atgender.getSelectedItem());
				pst.setString(3, atcontact.getText());
				pst.setString(4, atoccupation.getText());
				pst.setString(5, (((JTextField)atdob.getDateEditor().getUiComponent()).getText()));
				pst.setString(6, atemail.getText());
				pst.setString(7, atalternate.getText());
				pst.setString(8,  ataddress.getText());
				pst.setString(9, (String)atsubscription.getSelectedItem());
				pst.setString(10, (((JTextField)atstartdate.getDateEditor().getUiComponent()).getText()));
				pst.setString(11, atFees.getText()); 
				pst.setString(12,(((JTextField)atenddate.getDateEditor().getUiComponent()).getText()));
				pst.setString(13, (String) atFeesstatus.getSelectedItem());
				pst.setString(14, (String) attrainer.getSelectedItem());
				pst.setString(15, atpendingFees.getText());
				pst.setString(16, (String) atfacility.getSelectedItem());
				pst.setString(18,atregister.getText());
				pst.setString(17,(((JTextField)atpayable.getDateEditor().getUiComponent()).getText()));
				pst.setBlob(19,is);
				pst.execute(); 
						JOptionPane.showMessageDialog(null, "data saved");
						atfullname.setText(null);
						atcontact.setText(null);
						atalternate.setText(null);
						ataddress.setText(null);
						atgender.setSelectedItem(null);
						atoccupation.setText(null);
						attrainer.setSelectedItem(null);
						atFees.setText(null);
						atstartdate.setCalendar(null);
						atenddate.setCalendar(null);
						atdob.setCalendar(null);
						atFeesstatus.setSelectedItem(null);
						atemail.setText(null);
						atsubscription.setSelectedItem(null);
						atfacility.setSelectedItem(null);
						atpendingFees.setText(null);
						atregister.setText(null);
					}
			
				} catch (SQLException e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
//					JOptionPane.showMessageDialog(null,"Registration no. is already taken!!");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		getContentPane().add(btnNewButton_1);

		JButton btnPrintBill = new JButton("Print bill");
		btnPrintBill.setBounds(894, 462, 89, 23);
		getContentPane().add(btnPrintBill);
		
		JButton btnClick = new JButton("CLICK");
		btnClick.setBounds(894, 307, 89, 23);
		btnClick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				try {
					webcam.main(null);
				} catch (Throwable e) {
				
					JOptionPane.showMessageDialog(null, "Webcam error!!");
				//	e.printStackTrace();
				} 
				//throw(Exception e){}
				String path = "C:\\photo.png";
	             labelphoto.setIcon(ResizeImage(path));
	             setFileName(path);
	              
	}
	private Icon ResizeImage(String imgPath) {
       ImageIcon MyImage = new ImageIcon(imgPath);
   Image img = MyImage.getImage();
       Image newImage = img.getScaledInstance(labelphoto.getWidth(), labelphoto.getHeight(),Image.SCALE_SMOOTH);
       ImageIcon image = new ImageIcon(newImage);
       return image;
   }
				
			
			
		});
		getContentPane().add(btnClick);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atemail.setText("default@gmail.com");
			}
		});
		chckbxNewCheckBox.setBounds(673, 238, 21, 23);
		getContentPane().add(chckbxNewCheckBox);
}}