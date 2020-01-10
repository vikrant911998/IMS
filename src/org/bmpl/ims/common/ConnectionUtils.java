package org.bmpl.ims.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public interface ConnectionUtils {
	
	static ResourceBundle rb = ResourceBundle.getBundle("db");
	
	static Connection createConnection() 
			throws ClassNotFoundException, SQLException {
			
		Connection con = null;
			
		Class.forName(rb.getString("driver"));	
		
		
		con = DriverManager.getConnection(rb.getString("url"),
				rb.getString("userid"), rb.getString("password"));
		
		
		return con;
	}
	
}
