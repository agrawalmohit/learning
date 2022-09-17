package patterns.creational.objectpool;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class ObjectPool<T> {

	// Threadsafe map to hold objects which are in use
	Map<T, Long> lockedMap = new ConcurrentHashMap<T, Long>();
	// Threadsafe map to hold free objects
	Map<T, Long> unlockedMap = new ConcurrentHashMap<T, Long>();

	// timeout for ideal objects in free map
	protected static final Long idealTimeout = 30l;

	protected synchronized T get() {

		T obj;
		if (unlockedMap.size() > 0) {
			// has some objects available
			// check if object is alive
			Iterator<T> iterator = unlockedMap.keySet().iterator();
			while (iterator.hasNext()) {
				obj = iterator.next();
				if (System.currentTimeMillis() - unlockedMap.get(obj) >= idealTimeout) {
					// Object ideal timeout
					cleanObject(obj);
				} else if (!isValidObject(obj)) {
					cleanObject(obj);
				} else {
					lockedMap.put(obj, System.currentTimeMillis());
					unlockedMap.remove(obj);
					return obj;
				}
			}
		}
		// create new Object
		obj = create();
		lockedMap.put(obj, System.currentTimeMillis());
		return obj;
	}

	protected synchronized void release(T obj) {
		lockedMap.remove(obj);
		unlockedMap.put(obj, System.currentTimeMillis());
	}

	private void cleanObject(T obj) {
		unlockedMap.remove(obj);
		// clean resources held by object
		clean(obj);
	}

	/**
	 * Checks if Object hold any valid state to be reused
	 * @param obj
	 * @return
	 */
	protected abstract boolean isValidObject(T obj);

	/**
	 * creates an Object
	 * @return
	 */
	protected abstract T create();

	/**
	 * clean any state of object or resources held by Object
	 * 
	 * @param obj
	 *
	 */
	protected abstract void clean(T obj);
}
