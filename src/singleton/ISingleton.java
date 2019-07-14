package singleton;

public class ISingleton {
	private static class Inner{
		private static ISingleton instance = new ISingleton();
	}
	
	private ISingleton() {
		
	}
	
	public static ISingleton getInstance() {
		return Inner.instance;
	}
}
