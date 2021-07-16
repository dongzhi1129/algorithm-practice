package Practice.algorithm;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PracticeThread {

	private static class PrintThread extends Thread {

		private static final int threadSize = 3;

		private int id;

		private static AtomicInteger printCount = new AtomicInteger(0);

		private char symbol;

		private final ReentrantLock lock;

		private final Condition condition;

		public PrintThread(int id, char symbol, final ReentrantLock lock, final Condition condition) {
			super();
			this.id = id;
			this.symbol = symbol;
			this.lock = lock;
			this.condition = condition;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				lock.lock();
				try {
					if (printCount.get() % threadSize != id) {
						condition.await();
					}
					System.out.println(symbol);
					printCount.incrementAndGet();
					condition.signal();
					Thread.currentThread().sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}

		}

	}

	public static void main(String[] args) throws InterruptedException {
		final ReentrantLock lock = new ReentrantLock();
		final Condition condition = lock.newCondition();
		new PrintThread(0, 'A', lock, condition).start();
		;
		new PrintThread(1, 'B', lock, condition).start();
		new PrintThread(2, 'C', lock, condition).start();
		Thread.currentThread().sleep(100000);
	}

}
