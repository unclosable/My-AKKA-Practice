package My_AKKA_Practice.funtest.funtestthree;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class BeanUtil {
	/**
	 * 实体bean数据copy
	 * 
	 * @param source
	 *            源Bean
	 * @param target
	 *            目标Bean
	 */
	public static void copyProperties(Object source, Object target) {
		Class<?> sclass = source.getClass();
		Class<?> tclass = target.getClass();

		// 获取成员变量
		Field[] sfields = getFieldAll(sclass);
		Field[] tfields = getFieldAll(tclass);
		try {
			for (Field tfield : tfields) {
				// 获取成员变量名称
				String tfName = tfield.getName();
				// 获取成员变量域定义
				String tfStr = Modifier.toString(tfield.getModifiers());
				// 获取成员变量类型
				String tfType = tfield.getType().toString();
				// 只copy非静态变量
				if (tfStr.indexOf("final") < 0) {
					// 从源中查找是否有相同类型及名称的成员变量
					for (Field sfield : sfields) {
						// 获取成员变量名称
						String sfName = sfield.getName();
						// 获取成员变量域定义
						// String sfStr =
						// Modifier.toString(sfield.getModifiers());
						// 获取成员变量类型
						String sfType = sfield.getType().toString();
						// 如果定义的成员变量类型和名称完全相同 (不判断作用域)
						// if(tfName.equals(sfName) && tfStr.equals(sfStr) &&
						// tfType.equals(sfType)){
						if (tfName.equals(sfName) && tfType.equals(sfType)) {
							// 放在if条件里边也使 避免出现sfName = private static final的情况
							PropertyDescriptor spd = new PropertyDescriptor(
									sfName, sclass);
							// 通过get方法获取源bean中成员变量的值
							Method smethod = spd.getReadMethod();
							Object so = smethod.invoke(source);
							if (so != null) {
								/* 这种方法获取的 method设置值时会报错 */
								PropertyDescriptor tpd = new PropertyDescriptor(
										tfName, tclass);
								Method tmethod = tpd.getWriteMethod();
								tmethod.invoke(target, so);

								/*
								 * 当为父类中的成员变量时本方法会报错
								 * java.lang.NoSuchMethodException
								 */
								/*
								 * PropertyDescriptor tpd = new
								 * PropertyDescriptor(tfName, tclass); Method
								 * tmethodSet = tpd.getWriteMethod(); String
								 * setMethodName = tmethodSet.getName(); Method
								 * tmethod =
								 * tclass.getDeclaredMethod(setMethodName,
								 * tfield.getType()); tmethod.invoke(target,so);
								 */
							}
						}
					}
				}
			}
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} /*
		 * catch (NoSuchMethodException e) { e.printStackTrace(); }
		 */
	}

	/**
	 * 获取包括继承的类型的成员变量
	 * 
	 * @param clazz
	 * @return
	 */
	private static Field[] getFieldAll(Class<?> clazz) {
		Field[] fds = null;
		Field[] fdsSupper = null;
		Field[] result = null;
		// 获取当前对象的所有成员变量
		fds = clazz.getDeclaredFields();
		// 获取父对象
		Class<?> clazzSuper = clazz.getSuperclass();
		if (clazzSuper != null) {
			fdsSupper = getFieldAll(clazzSuper);
			if (fdsSupper != null) {
				// 合并数组
				result = Arrays
						.copyOf(fdsSupper, fds.length + fdsSupper.length);
				System.arraycopy(fds, 0, result, fdsSupper.length, fds.length);
			} else {
				result = fds;
			}
		} else {
			result = fds;
		}
		return result;
	}
}
