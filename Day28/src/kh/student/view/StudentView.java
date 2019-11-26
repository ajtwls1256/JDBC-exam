package kh.student.view;

import java.util.Scanner;

import kh.student.controller.StudentController;
import kh.student.model.vo.Student;

public class StudentView
{
    Scanner sc = new Scanner(System.in);
    
    public void main()
    {
        
        StudentController sct = new StudentController();
        
        while(true)
        {
            System.out.println("\n==== 학생 관리 프로그램 ====");
            System.out.println("1. 학생 전체 정보 보기");
            System.out.println("2. 학번으로 조회");
            System.out.println("3. 이름으로 조회");
            System.out.println("4. 학생 정보 등록");
            System.out.println("5. 학생 정보 수정");
            System.out.println("6. 학생 정보 삭제");
            System.out.println("0. 종료");
            System.out.print("선택 > ");
            int sel = sc.nextInt();
            
            switch(sel)
            {
                case 1: sct.printAll();
                    break;
                case 2: sct.printNo(insertNo("조회"));
                    break;
                case 3: sct.printName(insertName());
                    break;
                case 4: sct.insertStudent(insertStudent());
                    break;
                case 5: sct.updateStudent(insertNo("수정"));
                    break;
                case 6: sct.deleteStudent(insertNo("삭제"));
                    break;
                case 0: System.out.println("프로그램을 종료합니다.");
                    return;
            }
        }
    }
    
    
    public void printStr(String str)
    {
        System.out.println(str);
    }
    
    public int insertNo(String s)
    {
        System.out.print(s + "할 학번을 입력하세요 : ");
        int searchNo = sc.nextInt();
        return searchNo;
    }
    
    public String insertName()
    {
        System.out.print("조회할 이름을 입력하세요 : ");
        String searchName = sc.next();
        return searchName;
    }
    
    public Student insertStudent()
    {
        System.out.print("학번 입력 : ");
        int studentNo = sc.nextInt();
        System.out.print("이름 입력 : ");
        String studentName = sc.next();
        System.out.print("학년 입력 : ");
        int studentGrade = sc.nextInt();
        System.out.print("나이 입력 : ");
        int age = sc.nextInt();
        System.out.print("이메일 입력 : ");
        String email = sc.next();
        System.out.print("연락처 입력 : ");
        String phone = sc.next();
        System.out.print("활성화 여부 입력 : ");
        int activation = sc.nextInt();
        
        return new Student(studentNo, studentName, studentGrade, age, email, phone, activation);
    }
    
    public Student updateStudent()
    {
        System.out.print("이메일 입력 : ");
        String email = sc.next();
        System.out.print("연락처 입력 : ");
        String phone = sc.next();
        System.out.print("활성화 여부 입력 : ");
        int activation = sc.nextInt();
        
        Student s = new Student();
        s.setEmail(email);
        s.setPhone(phone);
        s.setActivation(activation);
        
        return s;
    }
    
    public void showColumn()
    {
        System.out.println("\n학번\t이름\t학년\t나이\tEmail\t\t전화번호\t활성화여부");
    }
    
    
    
    
}
