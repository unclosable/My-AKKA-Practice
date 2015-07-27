package My_AKKA_Practice.funtest.funtestthree.testbean;

import java.util.List;
import java.util.Map;

public class BigRoom2 {
	private String roomName;
	private List<Student> roomPersons;
	private Student[] roomPersonss;
	private Map<String, Student> stuMap;

	public Student[] getRoomPersonss() {
		return roomPersonss;
	}

	public void setRoomPersonss(Student[] roomPersonss) {
		this.roomPersonss = roomPersonss;
	}

	public Map<String, Student> getStuMap() {
		return stuMap;
	}

	public void setStuMap(Map<String, Student> stuMap) {
		this.stuMap = stuMap;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public List<Student> getRoomPersons() {
		return roomPersons;
	}

	public void setRoomPersons(List<Student> roomPersons) {
		this.roomPersons = roomPersons;
	}

}
