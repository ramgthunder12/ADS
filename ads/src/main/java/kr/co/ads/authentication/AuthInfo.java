package kr.co.ads.authentication;

public class AuthInfo {
	String id;
	String phoneNumber;
	int no;

	public AuthInfo(String id, String phoneNumber, int no) {
		this.id = id;
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	@Override
	public String toString() {
		return "RentalInfo [id=" + id + ", no=" + no + "]";
	}
}
