package kh.member.view;

import java.util.Scanner;

import kh.member.controller.MemberController;
import kh.member.model.vo.Member;

public class MemberView {

	Scanner sc = new Scanner(System.in);
	
	public void main()
	{
		MemberController ctrl = new MemberController();
		
		while(true)
		{
			
			System.out.println("\n==== 회원 관리 프로그램 ====");
			System.out.println("1. 회원 정보 전체 조회");
			System.out.println("2. 회원 아이디 조회");
			System.out.println("3. 회원 이름으로 검색");
			System.out.println("4. 회원 가입");
			System.out.println("5. 회원 정보 변경");
			System.out.println("6. 회원 탈퇴");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 > ");
			int sel = sc.nextInt();
			
			switch(sel)
			{
			
			case 1: ctrl.printAll();
				break;
			case 2: ctrl.printNo(insertNo("조회"));
				break;
			case 3: ctrl.printName(insertName());
				break;
			case 4: ctrl.insertMember(insertNo("가입"));
				break;
			case 5: 
				break;
			case 6: ctrl.deleteMember(insertNo("탈퇴"));
				break;
			case 0: System.out.println("프로그램을 종료합니다.");
				return;
				
			}

		}
		
	}
	
	
	public void println(String s)
	{
		System.out.println(s);
	}
	
	public int insertNo(String s)
	{
		System.out.print(s + "할 아이디를 입력하세요 : ");
		int no = sc.nextInt();
		return no;
	}
	
	public String insertName()
	{
		System.out.print("조회할 이름을 입력하세요 : ");
		String name = sc.next();
		return name;
	}
	
	public Member insertMember()
	{

		System.out.print("이름을 입력하세요 : ");
		String memberName = sc.next();
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		System.out.print("이메일을 입력하세요 : ");
		String email = sc.next();
		System.out.print("번호를 입력하세요 : ");
		String phone = sc.next();

		Member m = new Member();
		m.setMemberName(memberName);
		m.setAge(age);
		m.setEmail(email);
		m.setPhone(phone);
		
		return m;
	}
	
	
	
}
