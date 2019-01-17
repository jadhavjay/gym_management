import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JInternalFrame;

import jaco.mp3.player.MP3Player;

public class musicc extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					musicc frame = new musicc();
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
	public musicc() {
		MP3Player mpp= new MP3Player(new File("C:\\Users\\User\\Downloads\\personal_alarm_buzzer.mp3"));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				mpp.play();
				//mpp.pause();
			}
		});
		btnNewButton.setBounds(150, 119, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("stop\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			mpp.pause();
			
			}
		});
		btnNewButton_1.setBounds(150, 182, 89, 23);
		getContentPane().add(btnNewButton_1);
	
		

	}
}
