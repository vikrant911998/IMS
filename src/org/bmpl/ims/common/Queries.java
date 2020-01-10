package org.bmpl.ims.common;

public interface Queries {
	String REGISTER_SQL = "insert into User(userid,password) "
			+ "values(?,?)";
	
	String LOGIN_SQL = "select userid,password from user where "
			+ "userid=? and password=?";
	
}
