import java.util.Observable;
import java.util.Observer;

public class DObserver {
	public static void main(String[] args) {
		O1 o1 = new O1("Question");
		O2 o2 = new O2();
		O2 o3 = new O2();
		o1.addObserver(o2);
		o1.addObserver(o3);
		o1.change();
	}
}

class O1 extends Observable{
	private String name;
	
	public O1(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void change() {
		setChanged();
		notifyObservers("Changed!");
	}
}

class O2 implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		O1 o1 = (O1) o;
		System.out.println(o1.getName() + " have been " + arg);
	}
	
}