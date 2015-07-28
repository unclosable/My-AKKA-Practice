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

	/**
	 * TODO 此方法不会保留引用关系 上午10:49:52
	 * 
	 * @param source
	 * @param target
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T> void cloneObjectWithOutReferenceRelationship(Object source, Object target) throws InstantiationException, IllegalAccessException {
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
				if (sourceClazz.isPrimitive() || isPrimitive(sourceClazz)) {
					targetMap.put(key, sourceObj);
				} else if (sourceClazz.isArray()) {
					T[] sourceList = (T[]) sourceObj;
					T[] targetList = copyArray(sourceList);
					targetMap.put(key, targetList);
				} else if (sourceObj instanceof Collection) {
					Collection sourceCollection = (Collection) sourceObj;
					Collection targetCollection = copyCollection(sourceCollection);
					targetMap.put(key, targetCollection);
				} else if (sourceObj instanceof Map) {
					Map sourceObjMap = (Map) sourceObj;
					Map targetObjMap = copyMap(sourceObjMap);
					targetMap.put(key, targetObjMap);
				} else {
					Object targetObj = sourceObj.getClass().newInstance();
					cloneObjectWithOutReferenceRelationship(sourceObj, targetObj);
					targetMap.put(key, targetObj);
				}
			}
		}
	}

	/* 复制数组类型 */
	@SuppressWarnings("unchecked")
	public static <T> T[] copyArray(T[] tArray) throws InstantiationException, IllegalAccessException {
		T[] reList = Arrays.copyOf(tArray, tArray.length);
		if (tArray.length == 0)
			return reList;
		Class<? extends Object> clazz = reList[0].getClass();
		if (!clazz.isPrimitive() && !isPrimitive(clazz))
			for (int i = 0; i < tArray.length; i++) {
				T sourceT = tArray[i];
				T targetT = (T) sourceT.getClass().newInstance();
				cloneObjectWithOutReferenceRelationship(sourceT, targetT);
				reList[i] = targetT;
			}
		return reList;
	}

	/* 复制Collection接口的结构体 */
	@SuppressWarnings("unchecked")
	public static <T extends Collection<E>, E> T copyCollection(T collection) throws InstantiationException, IllegalAccessException {
		T reCollection = (T) collection.getClass().newInstance();
		if (collection.isEmpty())
			return reCollection;
		E sample = collection.iterator().next();
		Class<?> tClazz = sample.getClass();
		if (tClazz.isPrimitive() || isPrimitive(tClazz))
			for (E e : collection) {
				E targetE = e;
				reCollection.add(targetE);
			}
		else
			for (E e : collection) {
				E targetE = (E) tClazz.newInstance();
				cloneObjectWithOutReferenceRelationship(e, targetE);
				reCollection.add(targetE);
			}
		return reCollection;
	}

	/* 复制Map接口的结构体 */
	@SuppressWarnings("unchecked")
	public static <M extends Map<K, V>, K, V> M copyMap(M map) throws InstantiationException, IllegalAccessException {
		M reMap = (M) map.getClass().newInstance();
		if (map.isEmpty())
			return reMap;
		Set<K> keySet = map.keySet();
		K keySample = keySet.iterator().next();
		V valueSample = map.get(keySample);
		boolean keyIsPrimitive = (keySample.getClass().isPrimitive() || isPrimitive(keySample.getClass()));
		boolean valueIsPrimitive = (valueSample.getClass().isPrimitive() || isPrimitive(valueSample.getClass()));
		for (K keyObj : keySet) {
			K targetKeyObj;
			if (keyIsPrimitive) {
				targetKeyObj = keyObj;
			} else {
				targetKeyObj = (K) keyObj.getClass().newInstance();
				cloneObjectWithOutReferenceRelationship(keyObj, targetKeyObj);
			}
			V valueObj = map.get(keyObj);
			V targetValueObj;
			if (valueIsPrimitive)
				targetValueObj = valueObj;
			else {
				targetValueObj = (V) valueObj.getClass().newInstance();
				cloneObjectWithOutReferenceRelationship(valueObj, targetValueObj);
			}
			reMap.put(targetKeyObj, targetValueObj);
		}
		return reMap;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T> void cloneObjectWithReferenceRelationship(Object source, Object target) throws InstantiationException, IllegalAccessException {
		if (isPrimitive(source.getClass()) || isPrimitive(target.getClass())) {
			throw new RuntimeException();
		}
		BeanMap sourceMap = BeanMap.create(source);
		BeanMap targetMap = BeanMap.create(target);
		Set<Object> targetKeySet = targetMap.keySet();
		ObjectPool objectPool = new ObjectPool();
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
					T[] targetList = copyArray(sourceList, objectPool);
					targetMap.put(key, targetList);
				} else if (sourceObj instanceof Collection) {
					Collection sourceCollection = (Collection) sourceObj;
					Collection targetCollection = copyCollection(sourceCollection, objectPool);
					targetMap.put(key, targetCollection);
				} else if (sourceObj instanceof Map) {
					Map sourceObjMap = (Map) sourceObj;
					Map targetObjMap = copyMap(sourceObjMap, objectPool);
					targetMap.put(key, targetObjMap);
				} else {
					Object midTargetObj = objectPool.getObj(sourceObj);
					Object targetObj;
					if (midTargetObj == null) {
						targetObj = sourceObj.getClass().newInstance();
						cloneObjectWithReferenceRelationship(sourceObj, targetObj);
						objectPool.put(sourceObj, targetObj);
					} else {
						targetObj = midTargetObj;
					}
					targetMap.put(key, targetObj);
				}
			}
		}
	}

	/* 复制数组类型 */
	@SuppressWarnings("unchecked")
	public static <T> T[] copyArray(T[] tArray, ObjectPool objectPool) throws InstantiationException, IllegalAccessException {
		Object midList = objectPool.getObj(tArray);
		if (midList != null) {
			return (T[]) midList;
		}
		T[] reList = Arrays.copyOf(tArray, tArray.length);
		if (tArray.length == 0) {
			objectPool.put(tArray, reList);
			return reList;
		}
		Class<?> clazz = reList[0].getClass();
		if (!clazz.isPrimitive() && !isPrimitive(clazz))
			for (int i = 0; i < tArray.length; i++) {
				T sourceT = tArray[i];
				T targetT;
				Object midT = objectPool.getObj(sourceT);
				if (midT == null) {
					targetT = (T) sourceT.getClass().newInstance();
					cloneObjectWithReferenceRelationship(sourceT, targetT);
					objectPool.put(sourceT, targetT);
				} else {
					targetT = (T) midT;
				}
				reList[i] = targetT;
			}
		objectPool.put(tArray, reList);
		return reList;
	}

	/* 复制Collection接口的结构体 */
	@SuppressWarnings("unchecked")
	public static <T extends Collection<E>, E> T copyCollection(T collection, ObjectPool objectPool) throws InstantiationException, IllegalAccessException {
		Object midCollection = objectPool.getObj(collection);
		if (midCollection != null) {
			return (T) midCollection;
		}
		T reCollection = (T) collection.getClass().newInstance();
		if (collection.isEmpty()) {
			objectPool.put(collection, reCollection);
			return reCollection;
		}
		E sample = collection.iterator().next();
		Class<?> tClazz = sample.getClass();
		if (tClazz.isPrimitive() || isPrimitive(tClazz))
			for (E e : collection) {
				E targetE = e;
				reCollection.add(targetE);
			}
		else
			for (E e : collection) {
				E targetE;
				Object midE = objectPool.getObj(e);
				if (midE == null) {
					targetE = (E) tClazz.newInstance();
					cloneObjectWithReferenceRelationship(e, targetE);
					objectPool.put(e, targetE);
				} else {
					targetE = (E) midE;
				}
				reCollection.add(targetE);
			}
		objectPool.put(collection, reCollection);
		return reCollection;
	}

	/* 复制Map接口的结构体 */
	@SuppressWarnings("unchecked")
	public static <M extends Map<K, V>, K, V> M copyMap(M map, ObjectPool objectPool) throws InstantiationException, IllegalAccessException {
		Object midMap = objectPool.getObj(map);
		if (midMap != null) {
			return (M) midMap;
		}
		M reMap = (M) map.getClass().newInstance();
		if (map.isEmpty()) {
			objectPool.put(map, reMap);
			return reMap;
		}
		Set<K> keySet = map.keySet();
		K keySample = keySet.iterator().next();
		V valueSample = map.get(keySample);
		boolean keyIsPrimitive = (keySample.getClass().isPrimitive() || isPrimitive(keySample.getClass()));
		boolean valueIsPrimitive = (valueSample.getClass().isPrimitive() || isPrimitive(valueSample.getClass()));
		for (K keyObj : keySet) {
			K targetKeyObj;
			if (keyIsPrimitive) {
				targetKeyObj = keyObj;
			} else {
				Object midKey = objectPool.getObj(keyObj);
				if (midKey == null) {
					targetKeyObj = (K) keyObj.getClass().newInstance();
					cloneObjectWithReferenceRelationship(keyObj, targetKeyObj);
					objectPool.put(keyObj, targetKeyObj);
				} else {
					targetKeyObj = (K) midKey;
				}
			}
			V valueObj = map.get(keyObj);
			V targetValueObj;
			if (valueIsPrimitive)
				targetValueObj = valueObj;
			else {
				Object midValue = objectPool.getObj(valueObj);
				if (midValue == null) {
					targetValueObj = (V) valueObj.getClass().newInstance();
					cloneObjectWithReferenceRelationship(valueObj, targetValueObj);
					objectPool.put(valueObj, targetValueObj);
				} else {
					targetValueObj = (V) midValue;
				}
			}
			reMap.put(targetKeyObj, targetValueObj);
		}
		objectPool.put(map, reMap);
		return reMap;
	}

	private static boolean isPrimitive(Class<?> clazz) {
		return classSet.contains(clazz);
	}
}
