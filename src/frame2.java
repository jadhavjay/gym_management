

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
;public class frame2 extends JInternalFrame {
	private JTextField fullname;
	private JTextField contactno;
	private JTextField occupation;
	private JTextField alternateno;
	private JTextField Intrest;
	private JTextField date;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame2 frame = new frame2();
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
	public frame2() {
		setMaximizable(true);
		setTitle("ENQUIRY FORM");
		setClosable(true);
		setBounds(100, 100, 1344, 644);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Contact no. :");
		lblNewLabel.setBounds(81, 200, 85, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblFullName = new JLabel("Full name :");
		lblFullName.setBounds(81, 116, 75, 14);
		getContentPane().add(lblFullName);
		

		JLabel entername = new JLabel("enter name");
		entername.setBounds(176, 144, 89, 14);
		getContentPane().add(entername);
		entername.setVisible(false);
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setBounds(410, 116, 74, 14);
		getContentPane().add(lblDate);
		
		JLabel lblOccupation = new JLabel("Occupation :");
		lblOccupation.setBounds(410, 200, 74, 14);
		getContentPane().add(lblOccupation);
		
		fullname = new JTextField();
		fullname.setBounds(166, 113, 153, 20);
		getContentPane().add(fullname);
		fullname.setColumns(20);
		
	//	Date t= new Date();
	//	SimpleDateFormat sf=SimpleDateFormat("yyyy-MM-dd");
		
		
		date = new JTextField();
		date.setBounds(496, 113, 86, 20);
		getContentPane().add(date);
		date.setColumns(10);
		Date d= new Date();
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
		date.setText(sf.format(d));
		
		contactno = new JTextField();
		contactno.setColumns(20);
		contactno.setBounds(166, 197, 153, 20);
		getContentPane().add(contactno);
		
		occupation = new JTextField();
		occupation.setColumns(20);
		occupation.setBounds(494, 197, 153, 20);
		getContentPane().add(occupation);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test6", "root", "");
					String query="insert into enquiry (Fullname,Date,Contactno,Alternateno,Occupation,Intrest) values"
							+ "(?,?,?,?,?,?)";
					PreparedStatement pst=con.prepareStatement(query);
				String regex="^[a-zA-Z\\s]+$";
				String no="^[0-9]{10}$[a-z]{0}$";
					  	if(fullname.getText().isEmpty()||
					  			contactno.getText().isEmpty()||
					  			alternateno.getText().isEmpty()||
					  			occupation.getText().isEmpty()||Intrest.getText().isEmpty()) {
					  JOptionPane.showMessageDialog(null,"enter properly");
					  	}
					  	if(fullname.getText().matches(regex)&&contactno.getText().matches(no)&&
					  			alternateno.getText().matches(no)&&occupation.getText().
					  			matches(regex)&&Intrest.getText().matches(regex)) {
					  	
					  	 
					  		pst.setString(1,fullname.getText());
							pst.setString(2,date.getText());
							pst.setString(3,contactno.getText());			
							pst.setString(4,alternateno.getText());
							pst.setString(5,occupation.getText());
							pst.setString(6,Intrest.getText());
							pst.execute();
					  		JOptionPane.showMessageDialog(null,"record entered");
				}else {
						JOptionPane.showMessageDialog(null,"enter valid records");
				}}
				catch(Exception e1)

				{
					e1.printStackTrace();
				}				
			
			}	});
		btnSave.setBounds(336, 351, 89, 23);
		getContentPane().add(btnSave);
		
		JLabel lblAlternateNo = new JLabel("Alternate no. :");
		lblAlternateNo.setBounds(81, 270, 75, 14);
		getContentPane().add(lblAlternateNo);
		
		alternateno = new JTextField();
		alternateno.setColumns(20);
		alternateno.setBounds(166, 267, 153, 20);
		getContentPane().add(alternateno);
		
		JLabel lblNewLabel_1 = new JLabel("Intrest :");
		lblNewLabel_1.setBounds(410, 270, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		Intrest = new JTextField();
		Intrest.setColumns(20);
		Intrest.setBounds(494, 267, 153, 20);
		getContentPane().add(Intrest);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\User\\eclipse-workspace\\gym_management\\src\\eq1.jpg"));
		lblNewLabel_2.setBounds(699, 51, 574, 437);
		getContentPane().add(lblNewLabel_2);

	}

	
	}

