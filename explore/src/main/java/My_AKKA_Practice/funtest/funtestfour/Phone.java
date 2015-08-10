package My_AKKA_Practice.funtest.funtestfour;

public class Phone {
	private int phoneNumber;
	private String phoneName;

	public Phone(int phoneNumber, String phoneName) {
		this.phoneName = phoneName;
		this.phoneNumber = phoneNumber;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneName() {
		return phoneName;
	}

	public void setPhoneName(String phoneName) {
		this.phoneName = phoneName;
	}

}
