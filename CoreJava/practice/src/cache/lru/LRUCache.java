package cache.lru;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LRUCache<T> {

	// capacity
	private final int CAPACITY;
	private int hitCount = 0;
	private int missCount = 0;
	private int thrashed = 0;

	public LRUCache(int capacity) {
		this.CAPACITY = capacity;
		cache = new LinkedHashSet<T>();
	}

	// data structure to store elements
	private Set<T> cache;

	// refer an element in cache
	public synchronized void refer(T element) {
		System.out.println("element referred --> " + element);
		// check element already exists
		boolean hit = false;
		if (cache.contains(element)) {
			cache.remove(element);
			++hitCount;
			hit = true;
		} else if (cache.size() == CAPACITY) {
			// remove first element
			T firstElement = (T) cache.iterator().next();
			cache.remove(firstElement);
			++thrashed;
		}
		cache.add(element);
		if (!hit) {
			++missCount;
		}
		displayCache();
	}

	public void displayCache() {
		List<T> tempList = new LinkedList<T>(cache);
		Collections.reverse(tempList);
		tempList.forEach(e -> System.out.print(e + ","));
		System.out.println();
	}

	public int getHitCount() {
		return hitCount;
	}

	public int getMissCount() {
		return missCount;
	}

	public int getThrashed() {
		return thrashed;
	}

	public void resetCache() {
		cache.clear();
		hitCount = 0;
		missCount = 0;
		thrashed = 0;
	}

	public static void main(String[] args) throws InterruptedException {
		LRUCache<Integer> cache = new LRUCache<Integer>(25);
		Thread user1 = new Thread(new CacheUser(cache, false));
		Thread user2 = new Thread(new CacheUser(cache, true));
		user1.start();
		user2.start();
		user1.join();
		user2.join();
		System.out.println("--------------------result--------------------");
		cache.displayCache();
		System.out.println(cache.hitCount + ":" + cache.missCount + ":" + cache.thrashed);
	}

}
