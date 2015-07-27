package My_AKKA_Practice.funtest.funtestthree;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import net.sf.cglib.beans.BeanMap;

public class BeanUtils {
	private static final Set<Class<?>> classSet = new HashSet<Class<?>>();
	static {
		classSet.add(Integer.class);
		classSet.add(Double.class);
		classSet.add(Byte.class);
		classSet.add(Long.class);
		classSet.add(Float.class);
		classSet.add(Short.class);
		classSet.add(Character.class);
		classSet.add(Boolean.class);
		classSet.add(String.class);
	}

	@SuppressWarnings("unchecked")
	public static void copyProperties(Object source, Object target) {
		BeanMap sourceMap = BeanMap.create(source);
		BeanMap targetMap = BeanMap.create(target);
		Set<Object> targetKeySet = targetMap.keySet();
		for (Object key : targetKeySet) {
			Object sourceObj = sourceMap.getOrDefault(key, null);
			if (sourceObj == null)
				continue;
			// sourceMap.getPropertyType((String) key).equals(obj)
			// 判断类型是否一样，是否有bug待检验
			if (sourceMap.getPropertyType((String) key).equals(targetMap.getPropertyType((String) key))) {
				targetMap.put(key, sourceObj);
			}
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T, E, K, V> void cloneObject(Object source, Object target) throws InstantiationException, IllegalAccessException {
		if (isPrimitive(source.getClass()) || isPrimitive(target.getClass())) {
			throw new RuntimeException();
		}
		BeanMap sourceMap = BeanMap.create(source);
		BeanMap targetMap = BeanMap.create(target);
		Set<Object> targetKeySet = targetMap.keySet();
		for (Object key : targetKeySet) {
			Object sourceObj = sourceMap.getOrDefault(key, null);
			if (sourceObj == null)
				continue;
			Class sourceClazz = sourceMap.getPropertyType((String) key);
			Class targetClazz = targetMap.getPropertyType((String) key);
			// 判断类型是否一样，是否有bug待检验
			if (sourceClazz.equals(targetClazz)) {
				if (sourceClazz.isPrimitive() || isPrimitive(sourceClazz)) {// 是基本类型的话直接赋值
					targetMap.put(key, sourceObj);
				} else if (sourceClazz.isArray()) {// 数组的话就复制一个数组
					T[] sourceList = (T[]) sourceObj;
					T[] targetList = Arrays.copyOf(sourceList, sourceList.length);
					Class<? extends Object> clazz = sourceList[0].getClass();
					if (!clazz.isPrimitive() && !isPrimitive(clazz))
						for (int i = 0; i < sourceList.length; i++) {
							T sourceT = sourceList[i];
							T targetT = (T) sourceT.getClass().newInstance();
							cloneObject(sourceT, targetT);
							targetList[i] = targetT;
						}
					targetMap.put(key, targetList);
				} else if (sourceObj instanceof Collection) {
					Collection<E> sourceCollection = (Collection<E>) sourceObj;
					Collection<E> targetCollection = (Collection<E>) sourceObj.getClass().newInstance();
					for (E e : sourceCollection) {
						Class tClazz = e.getClass();
						E targetE = (E) tClazz.newInstance();
						cloneObject(e, targetE);
						targetCollection.add(targetE);
					}
					targetMap.put(key, targetCollection);
				} else if (sourceObj instanceof Map) {
					Map<K, V> sourceObjMap = (Map<K, V>) sourceObj;
					Map<K, V> targetObjMap = (Map<K, V>) sourceObj.getClass().newInstance();
					Set<K> keySet = sourceObjMap.keySet();
					for (K keyObj : keySet) {
						K targetKeyObj = (K) keyObj.getClass().newInstance();
						if (isPrimitive(keyObj.getClass()))
							targetKeyObj = keyObj;
						else
							cloneObject(keyObj, targetKeyObj);

						V valueObj = sourceObjMap.get(keyObj);
						V targetValueObj = (V) valueObj.getClass().newInstance();
						if (isPrimitive(valueObj.getClass()))
							targetValueObj = valueObj;
						else
							cloneObject(valueObj, targetValueObj);

						targetObjMap.put(targetKeyObj, targetValueObj);

					}
					targetMap.put(key, targetObjMap);
				} else {
					Object targetObj = sourceObj.getClass().newInstance();
					cloneObject(sourceObj, targetObj);
					targetMap.put(key, targetObj);
				}
			}
		}
	}

	private static boolean isPrimitive(Class<?> clazz) {
		return classSet.contains(clazz);
	}
}
