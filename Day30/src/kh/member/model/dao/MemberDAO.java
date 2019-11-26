package kh.member.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import kh.member.model.vo.Member;
import kh.myexception.MemberException;
import kh.template.common.JDBCTemplate;

public class MemberDAO {

	private Properties prop = new Properties();
	
	public MemberDAO()
	{
		try {
			prop.load(new FileReader("resources/query.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Member> printAll(Connection conn) throws MemberException
	{
		ArrayList<Member> ml = new ArrayList<>();
		String sql = prop.getProperty("selectAll");
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			
			while(rset.next())
			{			
				int memberNo = rset.getInt("member_no");
				String memberName = rset.getString("member_name");
				int age = rset.getInt("age");
				String email = rset.getString("email");
				String phone = rset.getString("phone");
				String activation = rset.getString("activation");

				Member m = new Member(memberNo, memberName, age, email, phone, activation);
				ml.add(m);
			}
		} catch (SQLException e) {
			System.out.println("DAO : " + e.getMessage());			// 첫번째 출력
			throw new MemberException("selectAll() 메소드 처리 불가 -> " + e.getMessage());	// throw로 호출한 곳으로 넘겨주고
		}
		finally
		{
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return ml;
	}
	
	public Member printNo(Connection conn, int no) throws MemberException
	{
		Member m = null;
		String sql = prop.getProperty("printNo");
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rset = pstmt.executeQuery();
			
			
			if(rset.next())
			{			
				int memberNo = rset.getInt("member_no");
				String memberName = rset.getString("member_name");
				int age = rset.getInt("age");
				String email = rset.getString("email");
				String phone = rset.getString("phone");
				String activation = rset.getString("activation");

				m = new Member(memberNo, memberName, age, email, phone, activation);
			}
			
		} catch (SQLException e) {
			System.out.println("DAO : " + e.getMessage());			// 첫번째 출력
			throw new MemberException("printNo() 메소드 처리 불가 -> " + e.getMessage());	// throw로 호출한 곳으로 넘겨주고
		}
		finally
		{
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return m;
	}
	
	
	public ArrayList<Member> printName(Connection conn, String name)
	{
		ArrayList<Member> ml = new ArrayList<>();
		//String sql = "select * from member where activation = 'Y' and member_name like ?";
		String sql = prop.getProperty("printName");
		
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + name + "%");
			rset = pstmt.executeQuery();
			
			
			while(rset.next())
			{			
				int memberNo = rset.getInt("member_no");
				String memberName = rset.getString("member_name");
				int age = rset.getInt("age");
				String email = rset.getString("email");
				String phone = rset.getString("phone");
				String activation = rset.getString("activation");

				Member m = new Member(memberNo, memberName, age, email, phone, activation);
				ml.add(m);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return ml;
	}
	
	
	public int insertMember(Connection conn, Member m)
	{
		String sql = prop.getProperty("insertMember");
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, m.getMemberNo());
			pstmt.setString(2, m.getMemberName());
			pstmt.setInt(3, m.getAge());
			pstmt.setString(4, m.getEmail());
			pstmt.setString(5, m.getPhone());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int deleteMember(Connection conn, int no)
	{
		String sql = prop.getProperty("deleteMember");
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	
}
