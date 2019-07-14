
import java.util.LinkedHashMap;
import java.util.Map;

public class LRU {
	private int capacity;
	private Map<Object, Object> cache;
	
	public LRU(int capacity) {
		this.capacity = capacity;
		this.cache = new LinkedHashMap<Object, Object>(capacity, 0.75f, true){
			protected boolean removeEldestEntry(Map.Entry<Object, Object> eldest) {
				return size() > capacity;
			}
		};
	}
	
	public void put(Object key, Object val) {
		cache.put(key, val);
	}
	
	public Object get(Object key) {
		return cache.get(key);
	}
	
	public static void main(String[] args) {
		LRU lru = new LRU(9);
		for(int i = 0; i < 10; i++) {
			lru.put(i, i);
		}
		System.out.println(lru.get(1));
		System.out.println(lru.get(0));
	}
}
