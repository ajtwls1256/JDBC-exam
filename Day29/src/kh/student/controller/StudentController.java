package kh.student.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import kh.student.model.dao.StudentDao;
import kh.student.model.vo.Student;
import kh.student.view.StudentView;
import kh.template.common.JDBCTemplate;

public class StudentController
{
    StudentView stv = new StudentView();
    StudentDao sd = new StudentDao();
    
    
    public void printAll()
    {
        Connection conn = JDBCTemplate.getConnection();

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
   

        JDBCTemplate.close(conn);
        
        
    }
    
    
    public void printNo(int searchNo)
    {
    	JDBCTemplate jd = new JDBCTemplate();
        Connection conn = jd.getConnection();
        


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
            
        jd.close(conn);

    }
    
    
    public void printName(String searchName)
    {
    	JDBCTemplate jd = new JDBCTemplate();
        Connection conn = jd.getConnection();
        

            
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
       
        jd.close(conn);
    }
    
    
    public void insertStudent(Student m)
    {
    	JDBCTemplate jd = new JDBCTemplate();
        Connection conn = jd.getConnection();
        
       
        int result = sd.insertStudent(conn, m);
        
        if(result < 0)
        {
            jd.commit(conn);
            stv.printStr("학생 등록 실패");
        }
        else
        {
            jd.rollback(conn);
            stv.printStr("학생 등록 성공");
        }
  
        jd.close(conn);
        
    }
    
    public void updateStudent(int searchNo)
    {
    	JDBCTemplate jd = new JDBCTemplate();
        Connection conn = jd.getConnection();
        
  

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
            jd.commit(conn);
            stv.printStr("정보 수정 실패");
        }
        else
        {
            jd.rollback(conn);
            stv.printStr("정보 수정 성공");
        }
        
            
        jd.close(conn);
        
    }
    
    
    public void deleteStudent(int searchNo)
    {

    	JDBCTemplate jd = new JDBCTemplate();
        Connection conn = jd.getConnection();
        

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
            jd.commit(conn);
            stv.printStr("정보 삭제 성공");
        }
        else
        {
            jd.rollback(conn);
            stv.printStr("정보 삭제 실패");      
        }
        
        jd.close(conn);
        
    }
    
    public void deleteStu(int inptStuNo)
    {
    	Connection conn = JDBCTemplate.getConnection();
    	int result = sd.deleteStu(conn, inptStuNo);
    	
    	if(result > 0)
    	{
    		JDBCTemplate.commit(conn);
    		stv.printStr("삭제 성공");
    	}
    	else
    	{
    		JDBCTemplate.rollback(conn);
    		stv.printStr("삭제 실패");
    	}
    	
    	JDBCTemplate.close(conn);
    }
    
    
    
    
}
