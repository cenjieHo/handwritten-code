package singleton;

public class VSingleton {
	private volatile static VSingleton instance;
	
	private VSingleton() {
	}
	
	public static VSingleton getInstance() {
		if(instance == null) {
			synchronized(VSingleton.class) {
				if(instance == null) {
					instance = new VSingleton();
				}
			}
		}
		return instance;
	}
}
