package org.gangseo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//MySQL용
public class MySQLDB implements SqlLang {
	final static String DRIVER = "com.mysql.cj.jdbc.Driver";
	final static String URL = "jdbc:mysql://127.0.0.1:3306/kew01"; 
	final static String USERID = "root";
	final static String USERPW = "1234";
	final static String INS_NOTICE = "insert into notice values (default, ?, ?, default, 0)";
	Connection con = null;
	
	@Override
	public Connection connect() {
		try {
			Class.forName(DRIVER);
			try {
				con = DriverManager.getConnection(URL, USERID, USERPW);
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	@Override
	public void close(Connection con, PreparedStatement pstmt) {
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

