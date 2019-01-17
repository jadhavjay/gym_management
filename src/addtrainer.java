import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
import javax.swing.filechooser.FileNameExtensionFilter;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;
import javax.swing.JToolBar;

public class addtrainer extends JInternalFrame {
	private JTextField alternate;
	private JTextField contact;
	private JTextField fullname;
	private JTextField email;
	private JTextField salary;
	private JTextField trainerid;
	private String fileName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addtrainer frame = new addtrainer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
//	public String getFileName() {
//		
//		return fileName="C:\\photo.png";
//	}

	public void setFileName(String fileName) {
		
		this.fileName=fileName;
	}
	/**
	 * Create the frame.
	 */
	public addtrainer() {
		getContentPane().setForeground(new Color(0, 0, 0));
		getContentPane().setBackground(UIManager.getColor("Button.background"));
		setClosable(true);
		//get
		setTitle("ADD TRAINER");
		setBounds(100, 100, 1365, 665);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Full name :");
		lblNewLabel.setBounds(94, 95, 62, 14);
		lblNewLabel.setForeground(Color.BLACK);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contact no. :");
		lblNewLabel_1.setBounds(94, 163, 100, 14);
		lblNewLabel_1.setForeground(Color.BLACK);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Alternate no. :");
		lblNewLabel_2.setBounds(94, 227, 100, 14);
		lblNewLabel_2.setForeground(Color.BLACK);
		getContentPane().add(lblNewLabel_2);
		
		alternate = new JTextField();
		alternate.setBounds(193, 224, 119, 20);
		getContentPane().add(alternate);
		alternate.setColumns(10);
		
		contact = new JTextField();
		contact.setBounds(193, 160, 119, 20);
		contact.setColumns(10);
		getContentPane().add(contact);
		
		fullname = new JTextField();
		fullname.setBounds(193, 92, 119, 20);
		fullname.setColumns(10);
		getContentPane().add(fullname);
		
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setBounds(417, 95, 76, 14);
		lblGender.setForeground(Color.BLACK);
		getContentPane().add(lblGender);
		
		JLabel lblDob = new JLabel("D.O.B :");
		lblDob.setBounds(417, 163, 66, 14);
		lblDob.setForeground(Color.BLACK);
		getContentPane().add(lblDob);
		
		JComboBox gender = new JComboBox();
		gender.setBounds(503, 89, 119, 20);
		gender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		getContentPane().add(gender);
		
		JLabel lblEmailId = new JLabel("Email id :");
		lblEmailId.setBounds(417, 227, 66, 14);
		lblEmailId.setForeground(Color.BLACK);
		getContentPane().add(lblEmailId);
		
		email = new JTextField();
		email.setBounds(503, 224, 119, 20);
		email.setColumns(10);
		getContentPane().add(email);
		
		JLabel lblDateOfJoining = new JLabel("Date of joining:");
		lblDateOfJoining.setBounds(94, 309, 100, 14);
		lblDateOfJoining.setForeground(Color.BLACK);
		getContentPane().add(lblDateOfJoining);
		
		JLabel lblNewTrainer = new JLabel("NEW TRAINER");
		lblNewTrainer.setBounds(324, 29, 126, 14);
		lblNewTrainer.setForeground(Color.BLACK);
		lblNewTrainer.setFont(new Font("Tahoma", Font.BOLD, 17));
		getContentPane().add(lblNewTrainer);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setBounds(417, 309, 80, 14);
		lblAddress.setForeground(Color.BLACK);
		getContentPane().add(lblAddress);
		
		TextArea address = new TextArea();
		address.setBounds(503, 309, 145, 83);
		getContentPane().add(address);
		
		salary = new JTextField();
		salary.setBounds(193, 383, 119, 20);
		salary.setColumns(10);
		getContentPane().add(salary);
		
		JLabel lblPanCardNo = new JLabel("Salary monthly :");
		lblPanCardNo.setBounds(94, 386, 100, 14);
		lblPanCardNo.setForeground(Color.BLACK);
		getContentPane().add(lblPanCardNo);
		
		JPanel panel = new JPanel();
		panel.setBounds(764, 71, 139, 153);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel photo = new JLabel("            select photo!");
		photo.setBounds(0, 0, 139, 153);
		panel.add(photo);
		photo.setForeground(Color.BLACK);
//		photo.setIcon("C:\\photo.png");
		
		
		JLabel lblTrainerId_1 = new JLabel("TRAINER ID:-");
		lblTrainerId_1.setBounds(417, 447, 89, 14);
		lblTrainerId_1.setForeground(Color.BLACK);
		getContentPane().add(lblTrainerId_1);
		JDateChooser dob = new JDateChooser();
		dob.setBounds(503, 163, 119, 20);
		dob.getCalendarButton().setText("date");
		dob.setDateFormatString("yyyy-MM-dd");
		getContentPane().add(dob);
		
		
		
		
		
		JDateChooser doj = new JDateChooser();
		doj.setBounds(193, 303, 119, 20);
		doj.getCalendarButton().setText("date");
		doj.setDateFormatString("yyyy-MM-dd");
		getContentPane().add(doj);
		
		JComboBox shift = new JComboBox();
		shift.setBounds(193, 441, 119, 20);
		shift.setModel(new DefaultComboBoxModel(new String[] {"Morning", "Afternoon", "Evening"}));
		getContentPane().add(shift);
		
		JLabel lblShift = new JLabel("Shift :");
		lblShift.setBounds(94, 441, 80, 14);
		lblShift.setForeground(Color.BLACK);
		getContentPane().add(lblShift);
		JLabel namelbl = new JLabel("Enter valid Fullname!!");
		namelbl.setBounds(193, 111, 163, 30);
		getContentPane().add(namelbl);
		namelbl.setVisible(false);
		namelbl.setFont(new Font("SansSerif", Font.PLAIN, 11));
		namelbl.setForeground(Color.RED);
		
		JLabel conlbl = new JLabel(" enter valid contact no.");
		conlbl.setBounds(193, 180, 163, 20);
		getContentPane().add(conlbl);
		conlbl.setVisible(false);
		conlbl.setFont(new Font("SansSerif", Font.PLAIN, 11));
		conlbl.setForeground(Color.RED);
		JLabel altlbl = new JLabel("enter valid Alternate no.");
		altlbl.setBounds(193, 252, 163, 20);
		getContentPane().add(altlbl);
		altlbl.setVisible(false);
		altlbl.setFont(new Font("SansSerif", Font.PLAIN, 11));
		altlbl.setForeground(Color.RED);
		
		JLabel sallbl = new JLabel("enter valid Salary Amount");
		sallbl.setBounds(193, 403, 183, 27);
		getContentPane().add(sallbl);
		sallbl.setVisible(false);
		sallbl.setFont(new Font("SansSerif", Font.PLAIN, 11));
		sallbl.setForeground(Color.RED);
		

		JLabel dojlbl = new JLabel("Enter date of Joining!!");
		dojlbl.setForeground(Color.RED);
		dojlbl.setFont(new Font("SansSerif", Font.PLAIN, 11));
		dojlbl.setBounds(193, 334, 163, 14);
		getContentPane().add(dojlbl);
		dojlbl.setVisible(false);
		JLabel doblbl = new JLabel("Enter date of birth!!");
		doblbl.setForeground(Color.RED);
		doblbl.setFont(new Font("SansSerif", Font.PLAIN, 11));
		doblbl.setBounds(503, 184, 163, 14);
		getContentPane().add(doblbl);
		doblbl.setVisible(false);;
		
		JLabel emaillbl = new JLabel("Enter valid email id");
		emaillbl.setBounds(503, 255, 145, 14);
		getContentPane().add(emaillbl);
		emaillbl.setVisible(false);
		emaillbl.setFont(new Font("SansSerif", Font.PLAIN, 11));
		emaillbl.setForeground(Color.RED);
		
		JLabel trainerlbl = new JLabel("Enter valid Trainer id");
		trainerlbl.setBounds(503, 472, 201, 14);
		getContentPane().add(trainerlbl);
		trainerlbl.setVisible(false);
		trainerlbl.setFont(new Font("SansSerif", Font.PLAIN, 11));
		trainerlbl.setForeground(Color.RED);
		
		trainerid = new JTextField();
		trainerid.setBounds(503, 441, 119, 20);
		trainerid.setColumns(10);
		getContentPane().add(trainerid);
		JButton btnSave = new JButton("SAVE");
		btnSave.setBounds(451, 595, 89, 23);
		btnSave.addActionListener(new ActionListener() {
			private InputStream is;
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con = DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12269826\",\r\n" + 
							"			\"sql12269826\",\r\n" + 
							"			\"zYYpzlsecc");
					String q="insert into addtrainer(fullname,Gender,Contactno,Dob,Alternateno,DateofJoining,Address,Shift,Trainerid,Email,Salary,photo) values(?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement pst =con.prepareStatement(q);
					
					try {
						 is = new FileInputStream(new File("C:\\photo.png"));
						}catch(Throwable e4) {
							
							JOptionPane.showMessageDialog(null,"insert photo");
						}
					
					String reg="^[0-9]+";
					String amount="^[0-9]+";
					  String  regex = "^[a-zA-Z\\s]+$";
					//  String add= "J.*\\d[0-35-9]-\\d\\d-\\d\\d";
					String no= "^[0-9]{10}$[a-z]{0}$";
String eemail=  "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		  + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";	
					
					if(fullname.getText().isEmpty()||contact.getText().isEmpty()||
							alternate.getText().isEmpty()||trainerid.getText().isEmpty()||
							address.getText().isEmpty()||gender.getSelectedItem().equals(null)||dob.getDate()==null
							||doj.getDate()==null||photo.getText()==null) {
						JOptionPane.showMessageDialog(null, "enter valid details");
					}
				if(photo.getIcon()==null){
				JOptionPane.showMessageDialog(null,"photo not inserted!!");
				}
					if(fullname.getText().matches(regex)==false||fullname.getText()==null) {
						namelbl.setVisible(true);}
					else {
						namelbl.setVisible(false);
					}
					if(contact.getText().matches(no)==false||contact.getText()==null)
					{
						conlbl.setVisible(true);
						
					}else { conlbl.setVisible(false);
					}
					if(trainerid.getText().matches(reg)==false) {
						trainerlbl.setVisible(true);}
					else {
						trainerlbl.setVisible(false);
					}
					if(alternate.getText().matches(no)==false) {
						altlbl.setVisible(true);}
					else {
						altlbl.setVisible(false);
					}
					if(dob.getDate()==null) {
						doblbl.setVisible(true);;}
					else {
						doblbl.setVisible(false);
					}
					if(doj.getDate()==null) {
						dojlbl.setVisible(true);}
					else {dojlbl.setVisible(false);}
					if(email.getText().matches(eemail)==false) {
						emaillbl.setVisible(true);}
					else {
						emaillbl.setVisible(false);
					}
					if(salary.getText().matches(amount)==false) {
						sallbl.setVisible(true);}
					else {
						sallbl.setVisible(false);
					}
					 if(fullname.getText().matches(regex)&&contact.getText().matches(no)&&
							alternate.getText().matches(no)&&trainerid.getText().matches(reg)
							&&email.getText().matches(eemail)&&salary.getText().matches(amount)&&
							doj.getDate()!=null&&dob.getDate()!=null&&address.getText()!=null&&
							shift.getSelectedItem()!=null&&
							gender.getSelectedItem()!=null&&photo.getIcon()!=null)
							 {
					
					pst.setString(1,fullname.getText());
					pst.setString(2,(String)gender.getSelectedItem());
					pst.setString(3,contact.getText());
					pst.setString(4,(((JTextField)dob.getDateEditor().getUiComponent()).getText()));
					pst.setString(5,alternate.getText());
					pst.setString(6,(((JTextField)doj.getDateEditor().getUiComponent()).getText()));
					pst.setString(7,address.getText());
					pst.setString(8,(String)shift.getSelectedItem());
					pst.setString(9,trainerid.getText());
					pst.setString(10,email.getText());
					pst.setString(11, salary.getText());
					pst.setBlob(12,is);
					
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "Data saved");}
					
				}catch(SQLException | ClassNotFoundException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					
				}
				}});
		getContentPane().add(btnSave);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(174, 533, 647, 2);
		getContentPane().add(separator);
		
		JButton btnClick = new JButton("Click");
		btnClick.setBounds(781, 257, 111, 30);
		btnClick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
					
							try {
								webcam.main(null);
							} catch (Throwable e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						
					  String path = "C:\\photo.png";
			             photo.setIcon(ResizeImage(path));
			             setFileName(path);
			              
			}
			private Icon ResizeImage(String imgPath) {
		        ImageIcon MyImage = new ImageIcon(imgPath);
	        Image img = MyImage.getImage();
		        Image newImage = img.getScaledInstance(photo.getWidth(), photo.getHeight(),Image.SCALE_SMOOTH);
		        ImageIcon image = new ImageIcon(newImage);
		        return image;
		    }
		});
		getContentPane().add(btnClick);
		
		
		
		
	}
}
