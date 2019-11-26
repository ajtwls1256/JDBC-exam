package kh.student.model.vo;

public class Student
{
    private int studentNo;
    private String studentName;
    private int studentGrade;
    private int age;
    private String email;
    private String phone;
    private int activation;
    
    public Student()
    {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public Student(int studentNo, String studentName, int studentGrade, int age,
            String email, String phone, int activation)
    {
        super();
        this.studentNo = studentNo;
        this.studentName = studentName;
        this.studentGrade = studentGrade;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.activation = activation;
    }
    
    public int getStudentNo()
    {
        return studentNo;
    }
    public void setStudentNo(int studentNo)
    {
        this.studentNo = studentNo;
    }
    public String getStudentName()
    {
        return studentName;
    }
    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }
    public int getStudentGrade()
    {
        return studentGrade;
    }
    public void setStudentGrade(int studentGrade)
    {
        this.studentGrade = studentGrade;
    }
    public int getAge()
    {
        return age;
    }
    public void setAge(int age)
    {
        this.age = age;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getPhone()
    {
        return phone;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }
    public int getActivation()
    {
        return activation;
    }
    public void setActivation(int activation)
    {
        this.activation = activation;
    }
    
    @Override
    public String toString()
    {
        return studentNo + "\t" + studentName + "\t" + studentGrade + "\t" + age + "\t" + email + "\t" + phone + "\t" + activation;
    }
}
