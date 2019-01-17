import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
public class updatedelete extends JInternalFrame {
	private JTextField fullname;
	private JTextField contactno;
	private JTextField occupation;
	private JTextField dob;
	private JTextField email;
	private JTextField alternateno;
	private JTextField amount;
	private JTextField pendingamount;
	private JTextField searchreg;
	private String s;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updatedelete frame = new updatedelete();
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
	public updatedelete() {
		setTitle("UPDATE DETAILS");
		//setBounds(100,100,1187,625);
		setBackground(Color.PINK);
		setMaximizable(true);
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 15));
		getContentPane().setBackground(SystemColor.menu);
		getContentPane().setLayout(null);
		//Frame.show(true);
		JLabel lblPersonalDetails = new JLabel("PERSONAL DETAILS. ");
		lblPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPersonalDetails.setBounds(183, 81, 153, 14);
		getContentPane().add(lblPersonalDetails);
		
		JLabel lblNewMember = new JLabel(" MEMBER DETAILS.");
		lblNewMember.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewMember.setBounds(377, 34, 245, 14);
		getContentPane().add(lblNewMember);
		
		JLabel lblFullName = new JLabel("Full name :");
		lblFullName.setBounds(196, 132, 76, 14);
		getContentPane().add(lblFullName);
		
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setBounds(484, 132, 66, 14);
		getContentPane().add(lblGender);
		
		JLabel lblAlternateNo = new JLabel("Alternate no. :");
		lblAlternateNo.setBounds(196, 295, 87, 14);
		getContentPane().add(lblAlternateNo);
		
		JLabel lblContactNo = new JLabel("Contact no. :");
		lblContactNo.setBounds(196, 187, 87, 14);
		getContentPane().add(lblContactNo);
		
		JLabel lblNewLabel = new JLabel("Occupation :");
		lblNewLabel.setBounds(484, 187, 76, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email :");
		lblNewLabel_1.setBounds(484, 241, 66, 14);
		getContentPane().add(lblNewLabel_1);
		
		fullname = new JTextField();
		fullname.setBounds(293, 129, 147, 20);
		getContentPane().add(fullname);
		fullname.setColumns(20);
		
		contactno = new JTextField();
		contactno.setBounds(293, 184, 147, 20);
		getContentPane().add(contactno);
		contactno.setColumns(20);
		
		occupation = new JTextField();
		occupation.setBounds(560, 184, 134, 20);
		getContentPane().add(occupation);
		occupation.setColumns(20);
		
		JLabel lblDateOfBirth = new JLabel("D.O.B :");
		lblDateOfBirth.setBounds(196, 241, 76, 14);
		getContentPane().add(lblDateOfBirth);
		
		JLabel lblNewLabel_4 = new JLabel("Address :");
		lblNewLabel_4.setBounds(484, 295, 66, 14);
		getContentPane().add(lblNewLabel_4);
		
		dob = new JTextField();
		dob.setColumns(20);
		dob.setBounds(293, 238, 147, 20);
		getContentPane().add(dob);
		
		TextArea address = new TextArea();
		address.setBounds(560, 295, 147, 87);
		getContentPane().add(address);
		
		JComboBox gender = new JComboBox();
		gender.setModel(new DefaultComboBoxModel(new String[] {"", "MALE", "FEMALE"}));
		gender.setBounds(560, 129, 134, 20);
		getContentPane().add(gender);
		
		email = new JTextField();
		email.setColumns(20);
		email.setBounds(560, 238, 134, 20);
		getContentPane().add(email);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(183, 106, 511, 2);
		getContentPane().add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("GYM DETAILS.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(183, 394, 153, 14);
		getContentPane().add(lblNewLabel_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(183, 419, 511, 2);
		getContentPane().add(separator_1);
		
		JLabel lblSubscription = new JLabel("Subscription :");
		lblSubscription.setBounds(484, 476, 89, 14);
		getContentPane().add(lblSubscription);
		
		alternateno = new JTextField();
		alternateno.setColumns(20);
		alternateno.setBounds(293, 292, 147, 20);
		getContentPane().add(alternateno);
		
		JLabel lblNewLabel_3 = new JLabel("Start date :");
		lblNewLabel_3.setBounds(183, 432, 76, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblAmount = new JLabel("Fees :");
		lblAmount.setBounds(484, 512, 76, 14);
		getContentPane().add(lblAmount);
		
		JLabel lblAmountStatus = new JLabel("Fees status :");
		lblAmountStatus.setBounds(183, 512, 105, 14);
		getContentPane().add(lblAmountStatus);
		
		amount = new JTextField();
		amount.setColumns(20);
		amount.setBounds(560, 506, 147, 20);
		getContentPane().add(amount);
		
		JLabel lblNewLabel_5 = new JLabel("Pending Fees :");
		lblNewLabel_5.setBounds(183, 543, 97, 14);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblTrainer = new JLabel("Trainer :");
		lblTrainer.setBounds(484, 585, 66, 14);
		getContentPane().add(lblTrainer);
		
		JLabel lblEndDate = new JLabel("End date :");
		lblEndDate.setBounds(183, 476, 66, 14);
		getContentPane().add(lblEndDate);
		
		pendingamount = new JTextField();
		pendingamount.setColumns(20);
		pendingamount.setBounds(293, 540, 147, 20);
		getContentPane().add(pendingamount);
		
		JComboBox trainer = new JComboBox();
		trainer.setModel(new DefaultComboBoxModel(new String[] {" "}));
		trainer.setBounds(560, 582, 147, 20);
		getContentPane().add(trainer);
		
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
			String sql="select Fullname from addtrainer";
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				String subscription= rs.getString("Fullname");
				trainer.addItem(rs.getString("Fullname"));
			}
			
			
		}catch(Exception e) {
		
		}
		
		JComboBox subscription = new JComboBox();
		subscription.setBounds(573, 473, 134, 20);
		getContentPane().add(subscription);
		
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
			String sql="select * from addsubscription";
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				String subscription1= rs.getString("subs");
				subscription.addItem(rs.getString("subs"));
			}
			
			
		}catch(Exception e) {
		
		}
				
		
		
		JComboBox amountstatus = new JComboBox();
		amountstatus.setModel(new DefaultComboBoxModel(new String[] {"paid", "pending"}));
		amountstatus.setBounds(293, 509, 147, 20);
		getContentPane().add(amountstatus);
		
		JComboBox facility = new JComboBox();
		facility.setBounds(560, 540, 147, 20);
		getContentPane().add(facility);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
			String sq="select * from addfacility";
			PreparedStatement pst=con.prepareStatement(sq);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
				String facitiltyw= rs.getString("subs");
				facility.addItem(rs.getString("subs"));
			}
		} catch(Exception e) {
			e.printStackTrace();
			
		}
	          
		
		JLabel lblFacility = new JLabel("Facility :");
		lblFacility.setBounds(484, 543, 66, 14);
		getContentPane().add(lblFacility);
		
		 JLabel photo = new JLabel("");
		 photo.setBounds(484, 512, 76, 14);
			JDateChooser date = new JDateChooser();
			date.setDateFormatString("yyyy-MM-dd");
			date.setBounds(293, 432, 134, 20);
			getContentPane().add(date);
		 
			JDateChooser ed = new JDateChooser();
			ed.setDateFormatString("yyyy-MM-dd");
			ed.setBounds(293, 470, 134, 20);
			getContentPane().add(ed);
			
			JDateChooser pd = new JDateChooser();
			pd.setDateFormatString("yyyy-MM-dd");
			pd.setBounds(573, 432, 134, 20);
			getContentPane().add(pd);
			
			
		JLabel lblRegistrationNo = new JLabel("REGISTRATION NO.");
		lblRegistrationNo.setBounds(815, 295, 111, 14);
		getContentPane().add(lblRegistrationNo);
		setEnabled(false);
		setForeground(SystemColor.window);
		setRootPaneCheckingEnabled(false);
		setClosable(true);
		setBounds(100, 100, 1378, 660);
		
		searchreg = new JTextField();
		searchreg.setBounds(826, 327, 86, 20);
		getContentPane().add(searchreg);
		searchreg.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
				String q="update addmember set Fullname=?,Gender=?,Contact=?,Occupation=?,Dob=?,Email=?,Alternate=?"
						+ ",Address=?,Subscription=?,Startdate=?,Fees=?,Enddate=?,Feestatus=?,"
						+ "Trainer=?,PendingFees=?,Facility=?,PayableDate=? where Registrationno='"+searchreg.getText()+"'";
				PreparedStatement pst = con.prepareStatement(q);
				// InputuStream is=new FileInputStream(new File(s));

			
			//	InputStream is=new FileInputStream(new File(s));
				String reg="^[0-9]{2}$[a-z]{0}$";
				String aount="^[0-9]+";
				String eemail= "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
						  + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
				  String  regex = "^[a-zA-Z\\s]+$";
				//  String add= "J.*\\d[0-35-9]-\\d\\d-\\d\\d";
				String no= "^[0-9]{10}$[a-z]{0}$";
	
		if(fullname.getText().isEmpty()||gender.getSelectedItem()==null||
			contactno.getText().isEmpty()||amount.getText().isEmpty()||
			email.getText().isEmpty()||alternateno.getText().isEmpty()
		||amount.getText().isEmpty()||address.getText().isEmpty()||
		occupation.getText().isEmpty()||pendingamount.getText().isEmpty()
		||subscription.getSelectedItem()==null||
		dob.getText().isEmpty()||
		searchreg.getText().isEmpty()||facility.getSelectedItem()==null)
		
		{
			JOptionPane.showMessageDialog(null,"enter all the details");
			}
		//if(payable.getText().isEmpty()) {
		//	JOptionPane.showMessageDialog(null,"Enter payable date properly");
		//}
		if(fullname.getText().matches(regex)==false) {
			JOptionPane.showMessageDialog(null,"Enter name properly");
		}
		if(contactno.getText().matches(no)==false) {
			JOptionPane.showMessageDialog(null,"Enter contactno properly");
		}
		if(alternateno.getText().matches(no)==false) {
			JOptionPane.showMessageDialog(null,"Enter alternateno properly");
		}
		if(occupation.getText().matches(regex)==false) {
			JOptionPane.showMessageDialog(null,"Enter occupation  properly");
		}
		if(email.getText().matches(eemail)==false) {
			JOptionPane.showMessageDialog(null,"Enter email properly");
		}
		if(searchreg.getText().matches(reg)==false) {
			JOptionPane.showMessageDialog(null,"Enter registration no properly");
		}
		if(amount.getText().matches(aount)==false) {
			JOptionPane.showMessageDialog(null,"Enter amount properly");
		}
		if(pendingamount.getText().matches(aount)==false) {
			JOptionPane.showMessageDialog(null,"Enter pendingamount properly");
		}
		else if(fullname.getText().matches(regex)&&contactno.getText().matches(no)&&
	  			alternateno.getText().matches(no)&&occupation.getText().
	  			matches(regex)&&email.getText().matches(eemail)&&amount.getText().matches(aount)
	  			&&pendingamount.getText().matches(aount)
	  			&&searchreg.getText().matches(reg)) {
			
			pst.setString(1, fullname.getText());
			pst.setString(2, (String)gender.getSelectedItem());
			pst.setString(3, contactno.getText());
			pst.setString(4, occupation.getText());
			pst.setString(5, dob.getText());
			pst.setString(6, email.getText());
			pst.setString(7, alternateno.getText());
			pst.setString(8,  address.getText());
			pst.setString(9, (String)subscription.getSelectedItem());
			pst.setString(10, ((JTextField)date.getDateEditor().getUiComponent()).getText());
			pst.setString(11, amount.getText()); 
			pst.setString(12,((JTextField)ed.getDateEditor().getUiComponent()).getText());
			pst.setString(13, (String) amountstatus.getSelectedItem());
			pst.setString(14, (String) trainer.getSelectedItem());
			pst.setString(15, pendingamount.getText());
			pst.setString(16, (String) facility.getSelectedItem());
		//	pst.setString(18,searchreg.getText());
			pst.setString(17,((JTextField)pd.getDateEditor().getUiComponent()).getText());
			//pst.setString(19,photo.getText());
				pst.executeUpdate(); 
					JOptionPane.showMessageDialog(null, "data saved");
					
					
		}
		
				}catch(Exception ww) {
					ww.printStackTrace();
				}
				
				
			}

			private Blob ToBlob(String text) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		btnNewButton_1.setBounds(768, 439, 89, 23);
		getContentPane().add(btnNewButton_1);
		JLabel photo1 = new JLabel("");
		photo1.setBounds(812, 106, 114, 155);
		getContentPane().add(photo1);
		JButton btnPrintBill = new JButton("Delete");
		btnPrintBill.setBounds(884, 439, 89, 23);
		getContentPane().add(btnPrintBill);
		
          btnPrintBill.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
			
				
			try {

							Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
	String query = "delete from addmember where Registrationno='"+searchreg.getText()+"'";

		PreparedStatement psst = con.prepareStatement(query);
		psst.execute(); 
		JOptionPane.showMessageDialog(null, "record deleted Succesfully");
		
		fullname.setText(null);
		contactno.setText(null);
		alternateno.setText(null);
		address.setText(null);
		gender.setSelectedItem(null);
		occupation.setText(null);
		trainer.setSelectedItem(null);
		amount.setText(null);
	//	startdate.setText(null);
		//enddate.setText(null);
		//dob.setText(null);
		amountstatus.setSelectedItem(null);
		email.setText(null);
		subscription.setSelectedItem(null);
		facility.setSelectedItem(null);
		pendingamount.setText(null);
		searchreg.setText(null);
			//payable.setText(null);
			}
 catch(Exception e){
		e.printStackTrace();
	}
	
			} });
  		
		JButton btnNewButton_3 = new JButton("Search");
		btnNewButton_3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				try {
							Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
		String query = "select * from addmember where Registrationno= '"+searchreg.getText()+"'" ;

		PreparedStatement pst = con.prepareStatement(query);
		ResultSet rs= pst.executeQuery();
	
		if(rs.next())
		{
			
			 byte[] img = rs.getBytes("photo");



             //Resize The ImageIcon
             ImageIcon image = new ImageIcon(img);
             Image im = image.getImage();
             Image myImg = im.getScaledInstance(photo1.getWidth(), photo1.getHeight(),Image.SCALE_SMOOTH);
             ImageIcon newImage = new ImageIcon(myImg);
             photo1.setIcon(newImage);
			fullname.setText(rs.getString(1));
			gender.setSelectedItem(rs.getString(2));
			contactno.setText(rs.getString(3));
			occupation.setText(rs.getString(4));
			dob.setText(rs.getString(5));
			email.setText(rs.getString(6));
			alternateno.setText(rs.getString(7));
			address.setText(rs.getString(8));
			subscription.setSelectedItem(rs.getString(9));
		//	startdate.setText(rs.getString(10));
			amount.setText(rs.getString(11));
		//	enddate.setText(rs.getString(12));
			amountstatus.setSelectedItem(rs.getString(13));
			trainer.setSelectedItem(rs.getString(14));
			pendingamount.setText(rs.getString(15));
			facility.setSelectedItem(rs.getString(16));
			//payable.setText(rs.getString(18));
			
			String sDate1=(rs.getString(10));
			Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
			date.setDate(date1);
			//------------
			String edd=(rs.getString(12));
			Date date2=new SimpleDateFormat("yyyy-MM-dd").parse(edd);
			ed.setDate(date2);
			///-----------
			String pdd=(rs.getString(18));
			Date date3=new SimpleDateFormat("yyyy-MM-dd").parse(pdd);
			pd.setDate(date3);
		}
		else {
			JOptionPane.showMessageDialog(null, "Record not found");
		} 
				}catch (Exception e1) {
		e1.printStackTrace();
		}
				}

			

			private Date ToDate(String string) {
				// TODO Auto-generated method stub
				return null;
			}
				});
		btnNewButton_3.setBounds(823, 373, 89, 23);
		getContentPane().add(btnNewButton_3);
		
		JLabel lblPayableDate = new JLabel("Payable date:");
		lblPayableDate.setBounds(484, 432, 76, 14);
		getContentPane().add(lblPayableDate);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\User\\Google Drive\\gym_img\\bs.jpg"));
		lblNewLabel_6.setBounds(1005, 44, 339, 260);
		getContentPane().add(lblNewLabel_6);
		
	
	
		
		
			
		
	}
}
