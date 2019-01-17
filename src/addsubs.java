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

public class addsubs extends JInternalFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addsubs frame = new addsubs();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}//

	/**
	 * Create the frame.
	 */
	public addsubs() {
		setTitle("SUBSCRIPTION");
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 629, 340);
		getContentPane().setLayout(null);
		
		JLabel lblSubscription = new JLabel("NEW SUBSCRIPTION");
		lblSubscription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSubscription.setBounds(239, 25, 145, 14);
		getContentPane().add(lblSubscription);
		
		JLabel lblNewLabel = new JLabel("Subscription :");
		lblNewLabel.setBounds(126, 89, 97, 14);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(258, 86, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test6", "root", "");	
					String query = "insert into addsubscription (subs)"+" values(?)";
					PreparedStatement pst = con.prepareStatement(query);

				pst.setString(1, textField.getText());				
							
							
				pst.execute();
				JOptionPane.showMessageDialog(null, "data saved");

			} catch (Exception e) {
				e.printStackTrace();
			}
				
				
			}
			
			
		});
		btnNewButton.setBounds(200, 149, 89, 23);
		getContentPane().add(btnNewButton);

	} }

	
