package My_AKKA_Practice.funtest.funtestthree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import My_AKKA_Practice.funtest.funtestthree.testbean.BigRoom2;
import My_AKKA_Practice.funtest.funtestthree.testbean.Student;

public class Test2 {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		Random random = new Random();
		List<Student> students = new ArrayList<Student>();
		Map<String, Student> stuMap = new HashMap<String, Student>();
		Student[] sss = new Student[100000];
		for (int i = 0; i < 100000; i++) {
			Student stu = new Student();
			stu.setAge(random.nextInt());
			stu.setName(UUID.randomUUID().toString());
			students.add(stu);
			stuMap.put(stu.getName(), stu);
			sss[i] = stu;
		}

		BigRoom2 room1 = new BigRoom2();
		room1.setRoomName("房间1");
		room1.setRoomPersons(students);
		room1.setStuMap(stuMap);
		room1.setRoomPersonss(sss);

		BigRoom2 room2 = new BigRoom2();
		BigRoom2 room3 = new BigRoom2();

		long a = System.currentTimeMillis();
		BeanUtils.cloneObjectWithOutReferenceRelationship(room1, room2);
		long b = System.currentTimeMillis();

		long c = System.currentTimeMillis();
		BeanUtils.cloneObjectWithReferenceRelationship(room1, room3);
		long d = System.currentTimeMillis();

		System.out.println("未校验运行时间：" + (b - a));
		System.out.println("校验运行时间：" + (d - c));

		System.out.println("＝＝＝＝＝＝＝复制前＝＝＝＝＝＝＝");
		System.out.println(room1.getRoomPersons().get(0).getName());
		System.out.println(room1.getRoomPersonss()[0].getName());

		room1.getRoomPersons().get(0).setName("小明进化");

		System.out.println(room1.getRoomPersons().get(0).getName());
		System.out.println(room1.getRoomPersonss()[0].getName());
		/**
		 * 复制后原本的引用关系就没有了，相当于原有10w个对象，每个对象被引用了三遍，复制后就成为了30w个对象，所以慎用
		 */
		System.out.println("＝＝＝＝＝＝＝未校验复制后＝＝＝＝＝＝＝");
		System.out.println(room2.getRoomPersons().get(0).getName());
		System.out.println(room2.getRoomPersonss()[0].getName());

		room2.getRoomPersons().get(0).setName("xiaomingggggg");

		System.out.println(room2.getRoomPersons().get(0).getName());
		System.out.println(room2.getRoomPersonss()[0].getName());

		System.out.println("＝＝＝＝＝＝＝校验复制后＝＝＝＝＝＝＝");
		System.out.println(room3.getRoomPersons().get(0).getName());
		System.out.println(room3.getRoomPersonss()[0].getName());

		room3.getRoomPersons().get(0).setName("xiaomingggggg");

		System.out.println(room3.getRoomPersons().get(0).getName());
		System.out.println(room3.getRoomPersonss()[0].getName());

	}
}
