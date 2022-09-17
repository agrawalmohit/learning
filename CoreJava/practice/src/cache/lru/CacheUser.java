package cache.lru;

public class CacheUser implements Runnable {

	private LRUCache<Integer> cache;
	private boolean reverse;

	public CacheUser(LRUCache<Integer> cache, boolean reverse) {
		this.cache = cache;
		this.reverse = reverse;
	}

	@Override
	public void run() {
		if (reverse) {
			for (int i = 49; i > -1; i--) {
				cache.refer(i);
			}
		} else {
			for (int i = 0; i < 50; i++) {
				cache.refer(i);
			}
		}

	}

}
