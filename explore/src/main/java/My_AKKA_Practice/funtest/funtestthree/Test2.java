package My_AKKA_Practice.funtest.funtestthree;

import java.util.ArrayList;

import My_AKKA_Practice.funtest.funtestthree.testbean.BigRoom2;
import My_AKKA_Practice.funtest.funtestthree.testbean.Student;

public class Test2 {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		Student stu = new Student();
		stu.setAge(20);
		stu.setName("小明");

		BigRoom2 room1 = new BigRoom2();
		room1.setRoomName("房间1");
		room1.setRoomPersons(new ArrayList<Student>());
		room1.getRoomPersons().add(stu);

		BigRoom2 room2 = new BigRoom2();
		// System.out.println(room1.getClass().equals(stu.getClass()));
		//
		// Integer a = 9;
		// Integer b = 1;
		// BeanUtil.copyProperties(room1, room2);
		BeanUtils.cloneObject(room1, room2);

		room1.getRoomPersons().get(0).setName("小明进化");

		System.out.println(room2.getRoomPersons().get(0).getName());

	}

}
