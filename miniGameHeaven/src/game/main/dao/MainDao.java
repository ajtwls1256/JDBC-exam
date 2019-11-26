package game.main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import game.main.model.Member;

public class MainDao {

	public MainDao() {
		JDBCTemplate.getConnection();
	}
	public Member selId(Connection conn, String selId) {
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from Member where member_id = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, selId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				m = new Member();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return m;
	}
	
	public int newMem(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into Member values(?,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getID());
			pstmt.setString(2, m.getPWD());
			pstmt.setString(3, m.getNickName());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	public Member checkId(Connection conn, Member m) {
		Member mm = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from Member where member_id = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getID());
			rset = pstmt.executeQuery();
			if(rset.next()) {
				mm = new Member();
				if(rset.getString("member_pwd").equals(m.getPWD())){
					mm.setID(rset.getString("member_id"));
					mm.setPWD(rset.getString("member_pwd"));
					mm.setNickName(rset.getString("nickname"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return mm;
	}
	public int setMazeRank(Connection conn, Member m, float timeCost) {
		PreparedStatement pstmt = null;
		int result =0;
		
		String query = "insert into maze values (?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getID());
			pstmt.setFloat(2, timeCost);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int setRank(Connection conn, Member m, float timeCost, String game) {
		PreparedStatement pstmt = null;
		int result =0;
		
		String query = "insert into "+ game +" values (?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getID());
			pstmt.setFloat(2, timeCost);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
}
