package My_AKKA_Practice.funtest.funtestthree;

import java.util.HashSet;
import java.util.Set;

import My_AKKA_Practice.funtest.funtestthree.testbean.Room;
import My_AKKA_Practice.funtest.funtestthree.testbean.Student;

public class test {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		Student stu = new Student();
		stu.setAge(20);
		stu.setName("小明");

		Set<Object> objects = new HashSet<Object>();
		objects.contains(stu);

		Room room1 = new Room();
		room1.setRoomName("房间1");
		room1.setRoomPerson(stu);

		Room room2 = new Room();

		// System.out.println(room1.getClass().equals(stu.getClass()));
		//
		// Integer a = 9;
		// Integer b = 1;
		// BeanUtil.copyProperties(room1, room2);
		BeanUtils.cloneObject(room1, room2);

		room1.getRoomPerson().setName("小明进化");

		System.out.println(room2.getRoomPerson().getName());

	}
}
