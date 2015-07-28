package My_AKKA_Practice.funtest.funtestthree;

import java.util.HashMap;
import java.util.Map;

public class ObjectPool {
	private Map<Object, Object> objectMap;

	public ObjectPool() {
		this.objectMap = new HashMap<Object, Object>();
	}

	Object getObj(Object object) {
		return this.objectMap.get(object);
	}

	void put(Object keyObject, Object valueObject) {
		this.objectMap.put(keyObject, valueObject);
	}

}
