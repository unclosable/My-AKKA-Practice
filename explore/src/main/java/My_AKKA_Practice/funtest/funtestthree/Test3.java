package My_AKKA_Practice.funtest.funtestthree;

import java.util.HashMap;
import java.util.Map;

import My_AKKA_Practice.funtest.funtestthree.testbean.Student;

public class Test3 {
	public static void main(String[] args) {
		Student stu1 = new Student();
		stu1.setAge(1);
		stu1.setName("1");
		Student stu11 = new Student();
		stu1.setAge(1);
		stu1.setName("1");
		Student stu2 = new Student();
		stu1.setAge(2);
		stu1.setName("2");
		Student stu21 = new Student();
		stu1.setAge(21);
		stu1.setName("21");

		Map<Student, Student> map = new HashMap<Student, Student>();
		map.put(stu1, stu11);
		map.put(stu2, stu21);
		boolean a = map.get(stu1) == stu11;
		boolean b = map.get(stu2) == stu21;
		System.out.println(stu1.hashCode());
		System.out.println(stu1.hashCode());
		System.out.println(stu11.hashCode());
		System.out.println(a);
		System.out.println(b);

	}
}
