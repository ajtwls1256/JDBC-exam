package kh.student.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import kh.student.model.dao.StudentDao;
import kh.student.model.vo.Student;
import kh.student.view.StudentView;

public class StudentController
{
    StudentView stv = new StudentView();
    StudentDao sd = new StudentDao();
    
    
    public void printAll()
    {
        Connection conn = null;
        
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jdbc", "1234");
            ArrayList<Student> sl = sd.printAll(conn);
            
            if(sl.isEmpty())
            {
                stv.printStr("존재하는 학생이 없습니다.");
            }
            else
            {
                stv.showColumn();
                
                for(int i = 0; i < sl.size(); i++)
                {
                    if(sl.get(i).getActivation() == 0)
                    {
                        sl.remove(i);
                        i--;
                    }
                }
                
                
                for(Student s : sl)
                {
                    stv.printStr(s.toString());
                }
                
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
                conn.close();
            }
            catch (SQLException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        
    }
    
    
    public void printNo(int searchNo)
    {
        
        Connection conn = null;
        
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "jdbc", "1234");
            
            
            Student s = sd.printNo(conn, searchNo);
            
            if(s == null)
            {
                stv.printStr("존재하는 학생이 없습니다.");
                return;
            }
            else if(s.getActivation() == 0)
            {
                stv.printStr("비활성화된 학생입니다.");
                return;
            }
            else
            {
                stv.showColumn();
                
                stv.printStr(s.toString());
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
                conn.close();
            }
            catch (SQLException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
    
    
    public void printName(String searchName)
    {
        Connection conn = null;
        
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "jdbc", "1234");
            
            ArrayList<Student> sl = new ArrayList<>();
            
            sl = sd.printName(conn, searchName);
            
            if(sl.isEmpty())
            {
                stv.printStr("존재하는 학생이 없습니다.");
                return;
            }
            else
            {
                stv.showColumn();
                
                for(Student s : sl)
                {
                    if(s.getActivation() == 1)
                    {
                        stv.printStr(s.toString());
                    }
                }
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
                conn.close();
            }
            catch (SQLException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
    }
    
    
    public void insertStudent(Student m)
    {
        Connection conn = null;
        
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "jdbc", "1234");
            
            int result = sd.insertStudent(conn, m);
            
            if(result < 0)
            {
                conn.rollback();
                stv.printStr("학생 등록 실패");
            }
            else
            {
                conn.commit();
                stv.printStr("학생 등록 성공");
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
                conn.close();
            }
            catch (SQLException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
    }
    
    public void updateStudent(int searchNo)
    {
        
        Connection conn = null;
        
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "jdbc", "1234");
            
            Student s = sd.printNo(conn, searchNo);
            
            if(s == null)
            {
                stv.printStr("존재하는 학생이 없습니다.");
                return;
            }
            else if(s.getActivation() == 0)
            {
                stv.printStr("비활성화된 학생입니다.");
                return;
            }
            
            s = stv.updateStudent();
            s.setStudentNo(searchNo);
            
            int result = sd.updateStudent(conn, s);
            
            if(result < 0)
            {
                conn.rollback();
                stv.printStr("정보 수정 실패");
            }
            else
            {
                conn.commit();
                stv.printStr("정보 수정 성공");
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
                conn.close();
            }
            catch (SQLException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
    }
    
    
    public void deleteStudent(int searchNo)
    {

        Connection conn = null;
        
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "jdbc", "1234");
            
            
            Student s = sd.printNo(conn,searchNo);
            
            if(s == null)
            {
                stv.printStr("존재하는 학생이 없습니다.");
                return;
            }
            else if(s.getActivation() == 0)
            {
                stv.printStr("비활성화된 학생입니다.");
                return;
            }
            
           
            
            int result = sd.deleteStudent(conn, searchNo);
            int result2 = sd.insertDeleteStudent(conn, s);
            
            if(result > 0 && result2 > 0)
            {
                conn.commit();
                stv.printStr("정보 삭제 성공");
            }
            else
            {
                conn.rollback();
                stv.printStr("정보 삭제 실패");      
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
                conn.close();
            }
            catch (SQLException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
    }
    
    
    
    
}
