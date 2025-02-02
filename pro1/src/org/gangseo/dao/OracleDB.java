package org.gangseo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Oracle용
public class OracleDB implements SqlLang {
	final static String DRIVER = "oracle.jdbc.OracleDriver";
	final static String URL = "jdbc:oracle:thin:@localhost:1521:xe"; 
	final static String USERID = "system";
	final static String USERPW = "1234";
	final static String INS_NOTICE = "insert into notice values (nseq.nextval, ?, ?, sysdate, 0)";
	final static String LATEST_NOTICE = "select * from (select * from notice order by no desc) where rownum<=5";
	final static String LATEST_QNA = "select * from (select * from qna order by parno desc, plevel asc) where rownum<=5";
	final static String INS_ANSWER = "insert into qna values(qseq.nextval,2,?,?,?,default,0,?)";
	final static String INS_QUESTION = "insert into qna values(qseq.nextval,1,null,?,?,default,0,?)";
	final static String UPD_PARNO_QUESTION = "update qna set parno=qseq.currval where no = (select * from (select no from qna order by no desc) where rownum<=1)";
	final static String INS_TRAFFIC = "insert into traffic values (tseq.nextval,?,?,?,?,?);";
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