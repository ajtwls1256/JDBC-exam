package kh.template.common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {

	private static Properties prop = new Properties();
	
	public JDBCTemplate() 
	{

	}
	
	// Connection 객체 생성 메소드
	public static Connection getConnection()
	{
		Connection conn = null;
		
		try {

			prop.load(new FileReader("resources/DBConnection.properties"));
			
			Class.forName(prop.getProperty("Driver"));
			conn = DriverManager.getConnection(prop.getProperty("Url"), prop.getProperty("DBuser"), prop.getProperty("DBpw"));
			
			// 자동으로 commit을 지원해주는 기능을 해제
			conn.setAutoCommit(false);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	
	// close용 메소드
	public static void close(Connection conn)
	{
		// 존재하지않거나 이미 닫혀있을 때를 거르기위한 조건
		try {
			
			if(conn != null && !conn.isClosed())
			{
				conn.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	// 커밋용 메소드
	public static void commit(Connection conn)
	{
		try {
			if(conn != null && !conn.isClosed())
			{
				conn.commit();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	// 롤백용 메소드
	public static void rollback(Connection conn)
	{
		try {
			if(conn != null && !conn.isClosed())
			{
				conn.rollback();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	// stmt,pstmt
	public static void close(Statement stmt)
	{
		try {
			if(stmt != null && !stmt.isClosed())
			{
				stmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// rset
	public static void close(ResultSet rset)
	{
		try {
			if(rset != null && !rset.isClosed())
			{
				rset.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
