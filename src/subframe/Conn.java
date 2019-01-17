package subframe;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.*;
public class Conn {

	//public Connection getConnection(String dbname,String uname,String pass) {
		 static Connection con=null;
		
		public static Connection getConnection() {
		try {
			if(con==null) {
	Class.forName("com.mysql.cj.jdbc");
	con=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12269826",
			"sql12269826",
			"zYYpzlsecc");}
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return con;

	
}


}
