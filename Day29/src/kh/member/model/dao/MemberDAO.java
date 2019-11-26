package kh.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kh.member.model.vo.Member;
import kh.template.common.JDBCTemplate;

public class MemberDAO {

	
	
	public ArrayList<Member> printAll(Connection conn)
	{
		ArrayList<Member> ml = new ArrayList<>();
		String sql = "select * from member";
		
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
	
	public Member printNo(Connection conn, int no)
	{
		Member m = null;
		String sql = "select * from member where member_no = ?";
		
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
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		String sql = "select * from member where activation = 'Y' and member_name like ?";
		
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
		String sql = "insert into member values(?,?,?,?,?,'Y')";
		
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
		String sql = "delete from member where activation = 'Y' and member_no = ?";
		
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
