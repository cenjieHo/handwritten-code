import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Call implements Callable<Integer> {
	public Integer call() {
		return -1;
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Call call = new Call();
		FutureTask<Integer> f = new FutureTask<Integer>(call);
		new Thread(f).start();
		System.out.println(f.get());
	}
}
