package kh.student.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kh.student.model.vo.Student;
import kh.template.common.JDBCTemplate;

public class StudentDao
{
    
    public ArrayList<Student> printAll(Connection conn)
    {
        ArrayList<Student> sl = new ArrayList<>();

        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String query = "select * from student";
        
        try
        {
            pstmt = conn.prepareStatement(query);
            rset = pstmt.executeQuery();
            
            while(rset.next())
            {
                int studentNo = rset.getInt("student_no");
                String studentName = rset.getString("student_name");
                int studentGrade = rset.getInt("student_grade");
                int age = rset.getInt("age");
                String email = rset.getString("Email");
                String phone = rset.getString("phone");
                int activation = rset.getInt("activation");
                
                Student s = new Student(studentNo, studentName, studentGrade, age, email, phone, activation);
                sl.add(s);
            }
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
                pstmt.close();
            }
            catch (SQLException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        

        return sl;
    }
    
    
    public Student printNo(Connection conn, int searchNo)
    {

        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String query = "select * from student where student_no = ?";
        
        Student s = null;
        
        try
        {

            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, searchNo);
            rset = pstmt.executeQuery();
            
            if(rset.next())
            {
                int studentNo = rset.getInt("student_no");
                String studentName = rset.getString("student_name");
                int studentGrade = rset.getInt("student_grade");
                int age = rset.getInt("age");
                String email = rset.getString("Email");
                String phone = rset.getString("phone");
                int activation = rset.getInt("activation");
                
                s = new Student(studentNo, studentName, studentGrade, age, email, phone, activation);
                return s;
            }
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
                pstmt.close();
            }
            catch (SQLException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        return s;
    }
    
    
    public ArrayList<Student> printName(Connection conn, String searchName)
    {

        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String query = "select * from student where student_name like ?";
        
        ArrayList<Student> sl = new ArrayList<>();
        
        try
        {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "%" + searchName + "%");
            rset = pstmt.executeQuery();
            
            while(rset.next())
            {
                int studentNo = rset.getInt("student_no");
                String studentName = rset.getString("student_name");
                int studentGrade = rset.getInt("student_grade");
                int age = rset.getInt("age");
                String email = rset.getString("Email");
                String phone = rset.getString("phone");
                int activation = rset.getInt("activation");
                
                Student s = new Student(studentNo, studentName, studentGrade, age, email, phone, activation);
                sl.add(s);
            }
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
                pstmt.close();
            }
            catch (SQLException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        return sl;
    }
    
    
    public int insertStudent(Connection conn, Student m)
    {

        PreparedStatement pstmt = null;
        String query = "insert into student values(?,?,?,?,?,?,?)";

        int result = -1;
        
        try
        {
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, m.getStudentNo());
            pstmt.setString(2, m.getStudentName());
            pstmt.setInt(3, m.getStudentGrade());
            pstmt.setInt(4, m.getAge());
            pstmt.setString(5, m.getEmail());
            pstmt.setString(6, m.getPhone());
            pstmt.setInt(7, m.getActivation());
            
            result = pstmt.executeUpdate();

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
                pstmt.close();
            }
            catch (SQLException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        return result;
    }
    
    
    
    public int updateStudent(Connection conn, Student m)
    {

        PreparedStatement pstmt = null;
        String query = "update student set email = ?, phone = ?, activation = ? where student_no = ?";

        int result = -1;
        
        try
        {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, m.getEmail());
            pstmt.setString(2, m.getPhone());
            pstmt.setInt(3, m.getActivation());
            pstmt.setInt(4, m.getStudentNo());
            
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
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally
        {
            try
            {
                pstmt.close();
            }
            catch (SQLException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
        
        return result;
    }
    
    
    
    public int deleteStudent(Connection conn, int searchNo)
    {

        //Connection conn = null;
        PreparedStatement pstmt = null;
        String query = "update student set activation = 0 where student_no = ?";

        int result = -1;
        
        try
        {
            //Class.forName("oracle.jdbc.driver.OracleDriver");
            //conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "jdbc", "1234");
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, searchNo);
            
            result = pstmt.executeUpdate();
            
//            if(result > 0)
//            {
//                conn.commit();
//            }
//            else
//            {
//                conn.rollback();
//            }
           
        }
//        catch (ClassNotFoundException e)
//        {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally
        {
            try
            {
                pstmt.close();
                //con.close();
            }
            catch (SQLException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        return result;
    }
    
    
    
    
    public int insertDeleteStudent(Connection conn, Student m)
    {

        //Connection conn = null;
        PreparedStatement pstmt = null;
        String query = "insert into delete_student values(?,?,sysdate)";

        int result = -1;
        
        try
        {
            //Class.forName("oracle.jdbc.driver.OracleDriver");
            //conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "jdbc", "1234");
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, m.getStudentNo());
            pstmt.setString(2, m.getStudentName());
   
            result = pstmt.executeUpdate();
            
//            if(result > 0)
//            {
//                conn.commit();
//            }
//            else
//            {
//                conn.rollback();
//            }
           
        }
//        catch (ClassNotFoundException e)
//        {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally
        {
            try
            {
                pstmt.close();
                //conn.close();
            }
            catch (SQLException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        return result;
    }
    
    
    public int deleteStu(Connection conn, int inputStuNo)
    {
    	PreparedStatement pstmt = null;
    	int result = 0;
    	String query = "update student set activition = 0 where student_no = ?";
    	
    	try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, inputStuNo);
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
