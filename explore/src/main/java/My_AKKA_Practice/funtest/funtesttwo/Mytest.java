package My_AKKA_Practice.funtest.funtesttwo;

import java.util.Set;

import net.sf.cglib.beans.BeanMap;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import My_AKKA_Practice.funtest.funtestone.MyCglibProxy;

public class Mytest {

	public static class Student {
		private Integer age;
		private String name;

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

	public static void main(String[] args) {
		Student student = new Student();
		BeanMap beanMap = BeanMap.create(student);
		@SuppressWarnings("unchecked")
		Set<String> keySet = beanMap.keySet();
		for (String key : keySet) {
			System.out.println("属性名：" + key);
			System.out
					.println("属性类型：" + beanMap.getPropertyType(key).getName());
			// beanMap.getOrDefault(key, null);
			// beanMap.put("name", "dsacds");
		}
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(Student.class);
		enhancer.setCallbacks(new Callback[] { new MyCglibProxy("123"),
				new MyCglibProxy("456"), NoOp.INSTANCE });// NoOp.INSTANCE是不执行任何操作
		Student student1 = (Student) enhancer.create();
		student1.setAge(123);// 报错，需要设置CallbackFilter
		// System.out.println(student.name);

	}

}
