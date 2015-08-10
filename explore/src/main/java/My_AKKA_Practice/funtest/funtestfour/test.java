package My_AKKA_Practice.funtest.funtestfour;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import net.sf.cglib.proxy.Enhancer;

public class test {

	public static void main(String[] args) {
		// Enhancer enhancer = new Enhancer();
		// enhancer.setSuperclass(Phone.class);
		// enhancer.setCallbackType(NoOp.class);
		List<Method> list = new ArrayList<Method>();
		// Enhancer.getMethods(PhoneIn.class, new Class[] { PhoneInterface.class
		// }, list);
		Enhancer.getMethods(PhoneIn.class, null, list);
		for (Method o : list) {
			System.out.println(o);
			// System.out.println("getModifiers" + "：" + o.getModifiers());
			System.out.println("isPublic" + "：" + Modifier.isPublic(o.getModifiers()));
			System.out.println("isAbstract" + "：" + Modifier.isAbstract(o.getModifiers()));
			System.out.println("isFinal" + "：" + Modifier.isFinal(o.getModifiers()));
			System.out.println("isStatic" + "：" + Modifier.isStatic(o.getModifiers()));
			// System.out.println("isPublic" + "：" +
			// Modifier.isPublic(o.getModifiers()));
			// System.out.println("isPublic" + "：" +
			// Modifier.isPublic(o.getModifiers()));
			// System.out.println("isPublic" + "：" +
			// Modifier.isPublic(o.getModifiers()));
			System.out.println("getParameterCount" + "：" + o.getParameterCount());
			System.out.println("toGenericString" + "：" + o.toGenericString());
			System.out.println("getDefaultValue" + "：" + o.getDefaultValue());
			// System.out.println("getModifiers" + "：" + o.getModifiers());
			// System.out.println("getModifiers" + "：" + o.getModifiers());
			// System.out.println("getModifiers" + "：" + o.getModifiers());
			// System.out.println("getModifiers" + "：" + o.getModifiers());
			// System.out.println("getModifiers" + "：" + o.getModifiers());
			// System.out.println("getModifiers" + "：" + o.getModifiers());
			System.out.println("---");
		}
		// Class class1 = enhancer.createClass();
		// System.out.println(class1.getName());
		// System.out.println(class1 == Phone.class);
		// Enhancer enhancer2 = new Enhancer();
		// enhancer2.setSuperclass(Phone.class);
		// enhancer2.setCallback(NoOp.INSTANCE);
		// Object object = enhancer2.create(new Class[] { int.class,
		// String.class }, new Object[] { 22, "qwe" });
		// Phone phone = (Phone) object;
		// System.out.println(phone.getPhoneName());
		// System.out.println(class1 == object.getClass());
	}

}
