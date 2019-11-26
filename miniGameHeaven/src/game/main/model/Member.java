package game.main.model;

public class Member {
	private String ID;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPWD() {
		return PWD;
	}
	public void setPWD(String pWD) {
		PWD = pWD;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Member(String iD, String pWD, String nickName) {
		super();
		ID = iD;
		PWD = pWD;
		this.nickName = nickName;
	}
	private String PWD;
	private String nickName;
	public Member() {
		super();
	}
	
}
