

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

public class main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
				
					frame.setVisible(true);
				//	frame.setIconImage(Toolkit.getDefaultToolkit().getImage
				//			(getClass().getResource("C:\\photo.png")));
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public main() {
		setTitle("Gym_Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 00, 1380, 734);
		contentPane = new JPanel();
	//	contentPane.setBackground(new Color());
	//	 contentPane.add(hh);
		call cc= new call();
		cc.setVisible(true);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.setBackground(Color.ORANGE);
		menuBar.setBounds(0, 0, 1364, 31);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu_1 = new JMenu("MEMBERSHIP");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mnNewMenu_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//allmembers asw=new allmembers();
				//asw.setVisible(true);;
				//contentPane.add(asw).setBounds(0,29,1360,665);
				
			}
		});
		menuBar.add(mnNewMenu_1);
		JMenuItem mntmAddMember = new JMenuItem("ADD MEMBER");
		mntmAddMember.setFont(new Font("Segoe UI", Font.BOLD, 12));;;;;;;;;;;
		mntmAddMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				call c= new call();
				c.setVisible(true);
			contentPane.add(c).setBounds(0, 29, 1360, 665);
			}
		});
		mntmAddMember.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
			
		});
		mnNewMenu_1.add(mntmAddMember);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("UPDATE/DELETE MEMBER");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updatedelete dd= new updatedelete();
				dd.setVisible(true);
				contentPane.add(dd).setBounds(0,29,1360,670);
			}
		});
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JSeparator separator = new JSeparator();
		mnNewMenu_1.add(separator);
		
		JMenuItem mntmEnquiryForm = new JMenuItem("ENQUIRY FORM");
		mntmEnquiryForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame2 h = new frame2();
				h.setVisible(true);
				contentPane.add(h).setBounds(0,29,1360,665);
			}
		});
		mntmEnquiryForm.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewMenu_1.add(mntmEnquiryForm);
		
		JMenuItem mntmEnquiryList = new JMenuItem("ENQUIRY LIST");
		mntmEnquiryList.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewMenu_1.add(mntmEnquiryList);
		mntmEnquiryList.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae) {
			enquirylist ew = new enquirylist();
			ew.setVisible(true);
			contentPane.add(ew).setBounds(0,29,1360,665);
		}});
				
		JMenu mnReminder = new JMenu("REMINDER");
		mnReminder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				reminder d= new reminder();
				d.setVisible(true);
				contentPane.add(d).setBounds(0,29,1360,665);
			}
		});
		
		JMenu mnTrainer = new JMenu("TRAINER");
		mnTrainer.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		menuBar.add(mnTrainer);
		
		JMenuItem mntmAddTrainer = new JMenuItem("ADD TRAINER");
		mntmAddTrainer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addtrainer asd= new addtrainer();
				asd.setVisible(true);
			contentPane.add(asd).setBounds(0,29,1360,665);
			}
		});
		mntmAddTrainer.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnTrainer.add(mntmAddTrainer);
		
		JMenuItem mntmUpdatedeleteTrainer = new JMenuItem("UPDATE/DELETE TRAINER");
		
		
		mntmUpdatedeleteTrainer.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent ae) {
				updtrainer id = new updtrainer();
				id.setVisible(true);
				contentPane.add(id).setBounds(0,29,1360,665);
				
		}
		});
		mntmUpdatedeleteTrainer.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnTrainer.add(mntmUpdatedeleteTrainer);
		mnReminder.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		menuBar.add(mnReminder);
		
		JLabel lblNewLabel = new JLabel("1");
		menuBar.add(lblNewLabel);
		
		JMenu mnAttendance = new JMenu("ADD-ONS");
		mnAttendance.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		menuBar.add(mnAttendance);
		
		JMenuItem mntmAddSubscription = new JMenuItem("ADD SUBSCRIPTION");
		mntmAddSubscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addsubs sdd= new addsubs();
				sdd.setVisible(true);
			contentPane.add(sdd).setBounds(0, 0, 1360, 665);
			}
		});
		mntmAddSubscription.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnAttendance.add(mntmAddSubscription);
		
		JMenuItem mntmAddFacility = new JMenuItem("ADD FACILITY");
		mntmAddFacility.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			addfacility sd = new addfacility();
			sd.setVisible(true);
			contentPane.add(sd).setBounds(0,29,1360,665);
			}
		});
		mntmAddFacility.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnAttendance.add(mntmAddFacility);
		
		JMenu menu_1 = new JMenu("");
		menu_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		menuBar.add(menu_1);
		
		JMenuItem menuItem_3 = new JMenuItem("ALL MEMBERS");
		menu_1.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("ALL TRAINERS");
		menu_1.add(menuItem_4);
		
		JMenu menu_2 = new JMenu("ATTENDANCE");
		menu_2.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		menuBar.add(menu_2);
		
		JMenuItem mntmCheckAttendance = new JMenuItem("FEED ATTENDANCE");
		mntmCheckAttendance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				attendance as= new attendance();
				as.setVisible(true);
			contentPane.add(as).setBounds(0,29,1360,670);
			}
		});
		mntmCheckAttendance.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menu_2.add(mntmCheckAttendance);
		
		JMenuItem mntmCheckAttendance_1 = new JMenuItem("CHECK ATTENDANCE");
		mntmCheckAttendance_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkattendance as= new checkattendance();
				as.setVisible(true);
			contentPane.add(as).setBounds(0,29,1360,670);
			}
		});
		mntmCheckAttendance_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menu_2.add(mntmCheckAttendance_1);
		
		JMenu menu = new JMenu(" VIEW ");
		menu.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		menuBar.add(menu);
		
		JMenuItem menuItem_1 = new JMenuItem("ALL MEMBERS");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				allmembers sd= new allmembers();
				sd.setVisible(true);
				contentPane.add(sd).setBounds(0, 29, 1360, 665);
			}
		});
		menuItem_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menu.add(menuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("ALL TRAINERS");
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				alltrainers ad= new alltrainers();
				ad.setVisible(true);
				contentPane.add(ad).setBounds(0,29,1360,665);
		//a.event
			}
		});
		mntmNewMenuItem_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
			}
		});
		menu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu = new JMenu("TRANSACTIONS");
		mnNewMenu.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				pendingfees o = new pendingfees();
				o.setVisible(true);
			contentPane.add(o).setBounds(0,29,1360,665);
			}
		});
		mnNewMenu.setIcon(null);
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		menuBar.add(mnNewMenu);
		
	}	
}
	