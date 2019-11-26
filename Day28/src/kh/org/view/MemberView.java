package kh.org.view;

import java.util.Scanner;

import kh.org.controller.MemberController;
import kh.org.model.vo.Member;

public class MemberView
{
    Scanner sc = new Scanner(System.in);
    
    public void mainView()
    {
        
        MemberController mc = new MemberController();
     
        while(true)
        {
            System.out.println("\n==== 회원 관리 프로그램 ====");
            System.out.println("1. 회원 전체 조회");
            System.out.println("2. 회원 아이디 조회");
            System.out.println("3. 회원 이름 조회");
            System.out.println("4. 회원 가입");
            System.out.println("5. 회원 정보 변경");
            System.out.println("6. 회원 탈퇴");
            System.out.println("0. 종료");
            System.out.print("선택 > ");
            int sel = sc.nextInt();
            
            switch(sel)
            {
                case 1: mc.printAll();
                    break;
                case 2: mc.printId(insertId("조회"));
                    break;
                case 3: mc.printName(insertName());
                    break;
                case 4: mc.insertMember(insertMember());
                    break;
                case 5: mc.updateMember(insertId("변경"));
                    break;
                case 6: mc.deleteMember(insertId("탈퇴"));
                    break;
                case 0: System.out.println("프로그램을 종료합니다");
                return;
            }
        }
        
    }
    
    public void printStr(String s)
    {
        System.out.println(s);
    }
    
    public String insertId(String s)
    {
        System.out.print(s + "할 아이디를 입력하세요 : ");
        String searchId = sc.next();
        return searchId;
    }
    
    public String insertName()
    {
        System.out.print("조회할 이름을 입력하세요 : ");
        String searchName = sc.next();
        return searchName;
    }
    
    public Member insertMember()
    {
        System.out.print("아이디 입력 : ");
        String memberId = sc.next();
        System.out.print("비밀번호 입력 : ");
        String memberPw = sc.next();
        System.out.print("이름 입력 : ");
        String memberName = sc.next();
        System.out.print("이메일 입력 : ");
        String email = sc.next();
        System.out.print("나이 입력 : ");
        int age = sc.nextInt();
        System.out.print("주소 입력 : ");
        String addr = sc.next();
        System.out.print("성별 입력 : ");
        String gender = sc.next();
        
        return new Member(memberId, memberPw, memberName, email, age, addr, gender, null);
    }
    
    public Member updateMember()
    {
        System.out.print("변경할 이름 입력 : ");
        String memberName = sc.next();
        System.out.print("변경할 이메일 입력 : ");
        String email = sc.next();
        System.out.print("변경할 주소 입력 : ");
        String addr = sc.next();
        System.out.print("변경할 성별 입력 : ");
        String gender = sc.next();
        
        return new Member(null, null, memberName, email, 0, addr, gender, null);
    }
    
    
   
    
    
}
