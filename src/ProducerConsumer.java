import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerConsumer {
	
	private static AtomicInteger no = new AtomicInteger(0);
	private static BlockingQueue<Task> queue = new ArrayBlockingQueue<>(5);
	
	static class Producer implements Runnable {
		@Override
		public void run() {
			Task task = new Task(no.getAndIncrement());
			try {
				queue.put(task);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	static class Consumer implements Runnable{
		@Override
		public void run() {
			try {
				Task task = queue.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	static class Task{
		int taskNo;
		public Task(int taskNo) {
			this.taskNo = taskNo;
		}
	}
	
	public static void main(String[] args) {
		ProducerConsumer model = new ProducerConsumer();
		for(int i = 0; i < 5; i++) {
			new Thread(new Producer()).start();
		}
		for(int i = 0; i < 6; i++) {
			new Thread(new Consumer()).start();
		}
	}
}
