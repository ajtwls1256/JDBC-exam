package kh.org.controller;

import java.util.ArrayList;

import kh.org.model.dao.MemberDao;
import kh.org.model.vo.Member;
import kh.org.view.MemberView;

public class MemberController
{
    MemberView mv = new MemberView();
    MemberDao md = new MemberDao();
    
    public void printAll()
    {
        ArrayList<Member> ml = new ArrayList<>();
        ml = md.printAll();
        
        if(ml.isEmpty())
        {
            mv.printStr("존재하는 회원이 없습니다.");
        }
        else
        {
            for(Member m : ml)
            {
                mv.printStr(m.toString());
            }
        }
    }
    
    
    public void printId(String searchId)
    {
        Member m = md.printId(searchId);
        
        if(m == null)
        {
            mv.printStr("존재하는 회원이 없습니다.");
        }
        else
        {
            mv.printStr(m.toString());
        }
        
    }
    
    
    public void printName(String searchName)
    {
        ArrayList<Member> ml = new ArrayList<>();
        ml = md.printName(searchName);
        
        if(ml.isEmpty())
        {
            mv.printStr("존재하는 회원이 없습니다.");
        }
        else
        {
            for(Member m : ml)
            {
                mv.printStr(m.toString());
            }
        }
    }
    
    
    public void insertMember(Member m)
    {

        if(md.printId(m.getMemberId()) != null)
        {
            System.out.println("이미 존재하는 ID입니다.");
            return;
        }
        
        int result = md.insertMember(m);
        
        if(result == -1)
        {
            mv.printStr("회원 가입 실패");
        }
        else
        {
            mv.printStr("회원 가입 성공");
        }
    }
    
    public void updateMember(String searchId)
    {
        if(md.printId(searchId) == null)
        {
            System.out.println("존재하지 않는 ID입니다.");
            return;
        }
        
        Member m = mv.updateMember();
        m.setMemberId(searchId);
        
        int result = md.updateMember(m);
        
        if(result == -1)
        {
            mv.printStr("정보 변경 실패");
        }
        else
        {
            mv.printStr("정보 변경 성공");
        }
    }
    
    public void deleteMember(String searchId)
    {
        if(md.printId(searchId) == null)
        {
            System.out.println("존재하지 않는 ID입니다.");
            return;
        }
        
        int result = md.deleteMember(searchId);
        
        if(result == -1)
        {
            mv.printStr("탈퇴 실패");
        }
        else
        {
            mv.printStr("탈퇴 성공");
        }
    }
    
    
}
