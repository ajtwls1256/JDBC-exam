package kh.member.controller;

import java.sql.Connection;
import java.util.ArrayList;

import kh.member.model.dao.MemberDAO;
import kh.member.model.vo.Member;
import kh.member.view.MemberView;
import kh.template.common.JDBCTemplate;

public class MemberController {

	MemberDAO dao = new MemberDAO();
	MemberView view = new MemberView();
	
	
	public void printAll()
	{
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Member> ml = dao.printAll(conn);
		
		if(ml.isEmpty())
		{
			view.println("존재하는 회원이 없습니다.");
		}
		else
		{
			for(Member m : ml)
			{
				
				if(m.getActivation().equals("Y"))
				{
					view.println(m.toString());
				}
			}
		}
		
		
		JDBCTemplate.close(conn);
	}
	
	
	public void printNo(int no)
	{
		Connection conn = JDBCTemplate.getConnection();
		
		Member m = dao.printNo(conn,no);
		
		if(m == null)
		{
			view.println("존재하는 회원이 없습니다.");
		}
		else if(m.getActivation().equals("N"))
		{
			view.println("비활성화된 회원 입니다.");
		}
		else
		{
			view.println(m.toString());
		}
		
		
		JDBCTemplate.close(conn);
	}
	
	
	public void printName(String name)
	{
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Member> ml = dao.printName(conn, name);
		
		if(ml.isEmpty())
		{
			view.println("존재하는 회원이 없습니다.");
		}
		else
		{
			for(Member m : ml)
			{
				
				if(m.getActivation().equals("Y"))
				{
					view.println(m.toString());
				}
			}
		}
		
		JDBCTemplate.close(conn);
	}
	
	
	public void insertMember(int no)
	{
		Connection conn = JDBCTemplate.getConnection();
		
		Member m = dao.printNo(conn, no);
		
		if(m != null)
		{
			view.println("이미 존재하는 회원 ID입니다.");
		}
		else
		{
			m = view.insertMember();
			m.setMemberNo(no);
			
			int result = dao.insertMember(conn, m);
			
			if(result > 0)
			{
				JDBCTemplate.commit(conn);
				view.println("회원 가입 성공");
			}
			else
			{
				JDBCTemplate.rollback(conn);
				view.println("회원 가입 실패");
			}
		}

		
		JDBCTemplate.close(conn);
	}
	
	
	
	
	
	
	
	
	
	
	
	public void deleteMember(int no)
	{
		Connection conn = JDBCTemplate.getConnection();
		
		Member m = dao.printNo(conn, no);
		if(m == null)
		{
			view.println("존재하는 회원이 없습니다.");
		}
		else
		{
			int result = dao.deleteMember(conn, no);
			
			if(result > 0)
			{
				JDBCTemplate.commit(conn);
				view.println("회원 탈퇴 성공");
			}
			else
			{
				JDBCTemplate.rollback(conn);
				view.println("회원 탈퇴 실패");
			}
		}
		
		
		JDBCTemplate.close(conn);
	}
	
	
	
	
	
}
