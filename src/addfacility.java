import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import subframe.Conn;

@SuppressWarnings("serial")
public class addfacility extends JInternalFrame {
	private JTextField addsubstext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addfacility frame = new addfacility();
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
	public addfacility() {
		setClosable(true);
		setMaximizable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADD FACILITY");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(166, 26, 126, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewFacility = new JLabel("New Facility :");
		lblNewFacility.setBounds(92, 89, 83, 14);
		getContentPane().add(lblNewFacility);
		
		addsubstext = new JTextField();
		addsubstext.setBounds(185, 86, 147, 20);
		getContentPane().add(addsubstext);
		addsubstext.setColumns(40);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Conn d=new Conn();
					//d.Con();
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
					String query = "insert into addfacility (subs) values(?)";
					PreparedStatement pst = con.prepareStatement(query);

				pst.setString(1, addsubstext.getText());				
							
				pst.execute();
				JOptionPane.showMessageDialog(null, "Facility Added!");

			} catch (Exception e) {
				e.printStackTrace();
			}
				
			}
		});
		btnNewButton.setBounds(203, 142, 89, 23);
		getContentPane().add(btnNewButton);

	}
}
