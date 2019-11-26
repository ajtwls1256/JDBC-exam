package kh.member.model.vo;

public class Member {
	
		private int memberNo;
	    private String memberName;
	    private int age;
	    private String email;
	    private String phone;
	    private String activation;
	    
		

	    public Member() {
			super();
			// TODO Auto-generated constructor stub
		}



		public Member(int memberNo, String memberName, int age, String email, String phone, String activation) {
			super();
			this.memberNo = memberNo;
			this.memberName = memberName;
			this.age = age;
			this.email = email;
			this.phone = phone;
			this.activation = activation;
		}



		public int getMemberNo() {
			return memberNo;
		}



		public void setMemberNo(int memberNo) {
			this.memberNo = memberNo;
		}



		public String getMemberName() {
			return memberName;
		}



		public void setMemberName(String memberName) {
			this.memberName = memberName;
		}



		public int getAge() {
			return age;
		}



		public void setAge(int age) {
			this.age = age;
		}



		public String getEmail() {
			return email;
		}



		public void setEmail(String email) {
			this.email = email;
		}



		public String getPhone() {
			return phone;
		}



		public void setPhone(String phone) {
			this.phone = phone;
		}



		public String getActivation() {
			return activation;
		}



		public void setActivation(String activation) {
			this.activation = activation;
		}



		@Override
	    public String toString()
	    {
	    	return memberNo + "\t" + memberName + "\t" + age + "\t" + email + "\t" + phone + "\t" + activation;
	    }
	    
}
