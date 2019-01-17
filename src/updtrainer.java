import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

public class updtrainer extends JInternalFrame {
	private JTextField alternate;
	private JTextField contact;
	private JTextField fullname;
	private JTextField dob;
	private JTextField email;
	private JTextField doj;
	private JTextField salary;
	private JTextField trainerid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updtrainer frame = new updtrainer();
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
	public updtrainer() {
		setClosable(true);
		setTitle("UPDATE DETAILS.");
		setBounds(100, 100, 1335, 702);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Full name :");
		lblNewLabel.setBounds(94, 95, 62, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contact no. :");
		lblNewLabel_1.setBounds(94, 163, 80, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Alternate no. :");
		lblNewLabel_2.setBounds(94, 227, 99, 14);
		getContentPane().add(lblNewLabel_2);
		
		alternate = new JTextField();
		alternate.setBounds(193, 224, 119, 20);
		getContentPane().add(alternate);
		alternate.setColumns(10);
		
		contact = new JTextField();
		contact.setColumns(10);
		contact.setBounds(193, 160, 119, 20);
		getContentPane().add(contact);
		
		fullname = new JTextField();
		fullname.setColumns(10);
		fullname.setBounds(193, 92, 119, 20);
		getContentPane().add(fullname);
		
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setBounds(417, 95, 46, 14);
		getContentPane().add(lblGender);
		
		JLabel lblDob = new JLabel("D.O.B :");
		lblDob.setBounds(417, 163, 46, 14);
		getContentPane().add(lblDob);
		
		dob = new JTextField();
		dob.setColumns(10);
		dob.setBounds(503, 160, 119, 20);
		getContentPane().add(dob);
		
		JComboBox gender = new JComboBox();
		gender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		gender.setBounds(503, 89, 119, 20);
		getContentPane().add(gender);
		
		JLabel lblEmailId = new JLabel("Email id :");
		lblEmailId.setBounds(417, 227, 46, 14);
		getContentPane().add(lblEmailId);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(503, 224, 119, 20);
		getContentPane().add(email);
		
		JLabel lblDateOfJoining = new JLabel("Date of joining:");
		lblDateOfJoining.setBounds(94, 309, 99, 17);
		getContentPane().add(lblDateOfJoining);
		
		JLabel lblNewTrainer = new JLabel("TRAINER DETAILS");
		lblNewTrainer.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewTrainer.setBounds(337, 24, 186, 14);
		getContentPane().add(lblNewTrainer);
		
		doj = new JTextField();
		doj.setColumns(10);
		doj.setBounds(193, 306, 119, 20);
		getContentPane().add(doj);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setBounds(417, 309, 80, 14);
		getContentPane().add(lblAddress);
		
		TextArea address = new TextArea();
		address.setBounds(503, 309, 145, 83);
		getContentPane().add(address);
		
		JLabel lblAdharNo = new JLabel("Salary Monthly :");
		lblAdharNo.setBounds(94, 370, 99, 14);
		getContentPane().add(lblAdharNo);
		
		salary = new JTextField();
		salary.setColumns(10);
		salary.setBounds(193, 367, 119, 20);
		getContentPane().add(salary);
		
		JComboBox shift = new JComboBox();
		shift.setModel(new DefaultComboBoxModel(new String[] {"Morning", "Afternoon", "Evening"}));
		shift.setBounds(193, 425, 119, 20);
		getContentPane().add(shift);

		
		JLabel lblPanCardNo = new JLabel("Shift :");
		lblPanCardNo.setBounds(94, 428, 80, 14);
		getContentPane().add(lblPanCardNo);
		
		JLabel label = new JLabel("");
		label.setBounds(417, 441, 80, 14);
		getContentPane().add(label);
		
		JLabel lblTrainerId = new JLabel("           TRAINER ID.");
		lblTrainerId.setBounds(734, 267, 129, 14);
		getContentPane().add(lblTrainerId);
		
		trainerid = new JTextField();
		trainerid.setColumns(10);
		trainerid.setBounds(734, 292, 129, 20);
		getContentPane().add(trainerid);
		
		JButton btnSave = new JButton("Update");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test6", "root", "");
					String q="update addtrainer set Fullname=?,Gender=?,Contactno=?,Dob=?,"
							+ "Alternateno=?,Email=?,DateofJoining=?"
							+ ",Address=?,Shift=?,Salary=? where Trainerid='"+trainerid.getText()+"'";
					PreparedStatement pst = con.prepareStatement(q);
					
					String reg="^[0-9]{2}$[a-z]{0}$";
					String aount="^[0-9]+";
					String eemail= "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
							  + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
					  String  regex = "^[a-zA-Z\\s]+$";
					//  String add= "J.*\\d[0-35-9]-\\d\\d-\\d\\d";
					String no= "^[0-9]{10}$[a-z]{0}$";
					
					
					
				if(fullname.getText()==null||alternate.getText()==null|doj.getText()==null||dob.getText()==null
						||email.getText()==null||address.getText()==null||trainerid.getText()==null
						||contact.getText()==null||salary.getText()==null||
						!salary.getText().matches(aount)) {
					JOptionPane.showMessageDialog(null,"Enter all details properly");
				}
				else if(fullname.getText().matches(regex)&&contact.getText().matches(no)
						&&alternate.getText().matches(no)&&email.getText().matches(eemail)
						&&salary.getText().matches(aount)&&dob.getText()!=null&&doj.getText()!=null
						)
				{
					pst.setString(1,fullname.getText());
					pst.setString(2,(String)gender.getSelectedItem());
					pst.setString(3,contact.getText());
					pst.setString(4,dob.getText());
					pst.setString(5,alternate.getText());
					pst.setString(6,email.getText());
					pst.setString(7,doj.getText());
					pst.setString(8,address.getText());
					pst.setString(9,(String)shift.getSelectedItem());
					pst.setString(10, salary.getText());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Record Updated Successfully!!");
				}
				 
			}catch(Exception e) 
				{
				e.printStackTrace();
				}
				}
		});
		btnSave.setBounds(384, 576, 89, 23);
		getContentPane().add(btnSave);
		
	
		
		JSeparator separator = new JSeparator();
		separator.setBounds(174, 533, 647, 2);
		getContentPane().add(separator);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test6", "root", "");
		String queryy = " delete  from addtrainer where Trainerid='"+trainerid.getText()+"' ";

			PreparedStatement pssst = con.prepareStatement(queryy);
			pssst.execute(); 
			JOptionPane.showMessageDialog(null, "record deleted Succesfully");
			
			fullname.setText(null);
			contact.setText(null);
			alternate.setText(null);
			address.setText(null);
			trainerid.setText(null);
			dob.setText(null);
			email.setText(null);
			doj.setText(null);
			salary.setText(null);
				gender.setSelectedItem(null);
				shift.setSelectedItem(null);
				}
	 catch(Exception e){
			e.printStackTrace();
		}
		
				
			}
		});
		btnDelete.setBounds(518, 576, 89, 23);
		getContentPane().add(btnDelete);
		
		JPanel panel = new JPanel();
		panel.setBounds(734, 92, 129, 148);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 129, 148);
		panel.add(scrollPane);

		JLabel photoo = new JLabel("");
		scrollPane.setViewportView(photoo);
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test6", "root", "");
String query = "select * from addtrainer where Trainerid= '"+trainerid.getText()+"'" ;

PreparedStatement pst = con.prepareStatement(query);
ResultSet rs= pst.executeQuery();

if(rs.next())
{
	
	 byte[] img = rs.getBytes("photo");
     //Resize The ImageIcon
     ImageIcon image = new ImageIcon(img);
     Image im = image.getImage();
     Image myImg = im.getScaledInstance(photoo.getWidth(), photoo.getHeight(),Image.SCALE_SMOOTH);
     ImageIcon newImage = new ImageIcon(myImg);
     photoo.setIcon(newImage);
	fullname.setText(rs.getString(1));
	gender.setSelectedItem(rs.getString(2));
	contact.setText(rs.getString(3));
	dob.setText(rs.getString(4));
	alternate.setText(rs.getString(5));
	email.setText(rs.getString(6));
	doj.setText(rs.getString(7));
	address.setText(rs.getString(8));
	shift.setSelectedItem(rs.getString(9));
	salary.setText(rs.getString(11));
}
else {
	JOptionPane.showMessageDialog(null, "Record not found");
} 
		}catch (Exception e1) {
e1.printStackTrace();
}
		}
		});
		btnSearch.setBounds(758, 324, 80, 23);
		getContentPane().add(btnSearch);
		
		
		
		
		
		
		
	}
}
