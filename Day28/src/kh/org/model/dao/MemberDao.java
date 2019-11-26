package kh.org.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kh.org.model.vo.Member;

public class MemberDao
{
    public ArrayList<Member> printAll()
    {
        ArrayList<Member> ml = new ArrayList<>();
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;
        String query = "select * from member";
        
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "jdbc", "1234");
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
            
          
            
            while(rset.next())
            {
                String memberId = rset.getString("member_id");
                String memberPw = rset.getString("member_pw");
                String memberName = rset.getString("member_name");
                String email = rset.getString("email");
                int age = rset.getInt("age");
                String addr = rset.getString("addr");
                String gender = rset.getString("gender");
                Date enrollDate = rset.getDate("enroll_date");
                
                Member m = new Member(memberId, memberPw, memberName, email, age, addr, gender, enrollDate);
                ml.add(m);
            }
        }
        catch (ClassNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally
        {
            try
            {
                rset.close();
                stmt.close();
                conn.close();
            }
            catch (SQLException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        
        return ml;
    }

    
    
    public Member printId(String searchId)
    {
        Connection conn = null;
        //Statement stmt = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        //String query = "select * from member where member_id = '" + searchId + "'";
        String query = "select * from member where member_id = ?";
        
        Member m = null;
        
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "jdbc", "1234");
            //stmt = conn.createStatement();
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, searchId);
            //rset = stmt.executeQuery(query);
            rset = pstmt.executeQuery();

            if(rset.next())
            {
                String memberId = rset.getString("member_id");
                String memberPw = rset.getString("member_pw");
                String memberName = rset.getString("member_name");
                String email = rset.getString("email");
                int age = rset.getInt("age");
                String addr = rset.getString("addr");
                String gender = rset.getString("gender");
                Date enrollDate = rset.getDate("enroll_date");
                
                m = new Member(memberId, memberPw, memberName, email, age, addr, gender, enrollDate);
            }
        }
        catch (ClassNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally
        {
            try
            {
                rset.close();
                //stmt.close();
                pstmt.close();
                conn.close();
            }
            catch (SQLException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        return m;
    }
    
    public ArrayList<Member> printName(String searchName)
    {
        ArrayList<Member> ml = new ArrayList<>();
        
        Connection conn = null;
        //Statement stmt = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        //String query = "select * from member where member_name like '%" + searchName + "%'";
        String query = "select * from member where member_name like ?";
        
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "jdbc", "1234");
            //stmt = conn.createStatement();
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "%" + searchName + "%");
            //rset = stmt.executeQuery(query);
            rset = pstmt.executeQuery();
          
            
            while(rset.next())
            {
                String memberId = rset.getString("member_id");
                String memberPw = rset.getString("member_pw");
                String memberName = rset.getString("member_name");
                String email = rset.getString("email");
                int age = rset.getInt("age");
                String addr = rset.getString("addr");
                String gender = rset.getString("gender");
                Date enrollDate = rset.getDate("enroll_date");
                
                Member m = new Member(memberId, memberPw, memberName, email, age, addr, gender, enrollDate);
                ml.add(m);
            }
        }
        catch (ClassNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally
        {
            try
            {
                rset.close();
                //stmt.close();
                pstmt.close();
                conn.close();
            }
            catch (SQLException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        
        return ml;
    }
    
    
    
    
    public int insertMember(Member m)
    {
        Connection conn = null;
        //Statement stmt = null;
        PreparedStatement pstmt = null;
        int result = -1;
        
//        String query = "insert into member values('" + 
//                        m.getMemberId() + "' , '" +
//                        m.getMemberPw() + "' , '" +
//                        m.getMemberName() + "' , '" +
//                        m.getEmail() + "' , " +
//                        m.getAge() + " , '" +
//                        m.getAddr() + "' , '" +
//                        m.getGender() + "' , " +
//                        "sysdate)";
        
        String preparedQuery = "insert into member values(?,?,?,?,?,?,?,sysdate)";
        
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "jdbc", "1234");
            
            //stmt = conn.createStatement();
            pstmt = conn.prepareStatement(preparedQuery);
            pstmt.setString(1, m.getMemberId());
            pstmt.setString(2, m.getMemberPw());
            pstmt.setString(3, m.getMemberName());
            pstmt.setString(4, m.getEmail());
            pstmt.setInt(5, m.getAge());
            pstmt.setString(6, m.getAddr());
            pstmt.setString(7, m.getGender());
     
            
            
            //result = stmt.executeUpdate(query);
            result = pstmt.executeUpdate();
            
            if(result > 0)
            {
                conn.commit();
            }
            else
            {
                conn.rollback();
            }
            
        }
        catch (ClassNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //stmt.close();
                pstmt.close();
                conn.close();
            }
            catch (SQLException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        return result;
    }
    
    

    public int updateMember(Member m)
    {
        Connection conn = null;
        //Statement stmt = null;
        PreparedStatement pstmt = null;
        int result = -1;
        
//        String query = "update member set " + 
//                        "member_name = '" + m.getMemberName() + "' , " +
//                        "email = '" + m.getEmail() + "' , " +
//                        "addr = '" + m.getAddr() + "' , " +
//                        "gender = '" + m.getGender() + "' " +
//                        "where member_id = '" + m.getMemberId() + "'";
        String query = "update member set " + 
              "member_name = ? , " +
              "email = ? , " +
              "addr = ? , " +
              "gender = ? " +
              "where member_id = ?";
        
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "jdbc", "1234");
            //stmt = conn.createStatement();
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, m.getMemberName());
            pstmt.setString(2, m.getEmail());
            pstmt.setString(3, m.getAddr());
            pstmt.setString(4, m.getGender());
            pstmt.setString(5, m.getMemberId());
            
            //result = stmt.executeUpdate(query);
            result = pstmt.executeUpdate();
            
            if(result > 0)
            {
                conn.commit();
            }
            else
            {
                conn.rollback();
            }
            
        }
        catch (ClassNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //stmt.close();
                pstmt.close();
                conn.close();
            }
            catch (SQLException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        return result;
    }
    
    
    public int deleteMember(String searchId)
    {
        Connection conn = null;
        //Statement stmt = null;
        PreparedStatement pstmt = null;
        int result = -1;
        
        //String query = "delete from member where member_id = '" + searchId + "'" ;
        String query = "delete from member where member_id = ?" ;
        
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "jdbc", "1234");
            //stmt = conn.createStatement();
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, searchId);
            
            //result = stmt.executeUpdate(query);
            result = pstmt.executeUpdate();
            
            if(result > 0)
            {
                conn.commit();
            }
            else
            {
                conn.rollback();
            }
            
        }
        catch (ClassNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //stmt.close();
                pstmt.close();
                conn.close();
            }
            catch (SQLException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        return result;
    }
    
}
