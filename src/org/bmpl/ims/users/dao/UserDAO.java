package org.bmpl.ims.users.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bmpl.ims.common.ConnectionUtils;
import org.bmpl.ims.common.Queries;
import org.bmpl.ims.users.Dashboard;
import org.bmpl.ims.users.dto.UserDTO;

public class UserDAO {
	
	public UserDTO login(UserDTO dto) throws 
				SQLException, ClassNotFoundException {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		
		try {
			
			con = ConnectionUtils.createConnection();
			
			pstmt = con.prepareStatement(Queries.LOGIN_SQL);
			
			
			
			pstmt.setString(1,dto.getUserid());
			pstmt.setString(2,dto.getPassword());
			
			result = pstmt.executeQuery();
			
			if(result.next()) {
				dto.setUserid(result.getString("userid"));
				dto.setLoginSuccess(true);
			}
			
		}
		finally {
			if(result != null) {
				result.close();
			}
			
			if(pstmt != null) {
				pstmt.close();
			}
			
			if(con != null) {
				con.close();
			}
			
		}
		
		return dto;
	}
	
	
	public boolean register(UserDTO dto) 
			throws ClassNotFoundException, SQLException {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ConnectionUtils.createConnection();
			
			pstmt = con.prepareStatement(Queries.REGISTER_SQL);
			
			
			pstmt.setString(1,dto.getUserid());
			pstmt.setString(2,dto.getPassword());
			
			
			int result = pstmt.executeUpdate();
			
			if(result >0) {
				return true;
			}
			
		}
		finally {
			
			if(pstmt != null) {
				pstmt.close();
			}
			
			if(con != null) {
				con.close();
			}
			
		}
		
		return false;	
		
	}
	
	
	

}
