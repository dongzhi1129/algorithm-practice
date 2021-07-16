package Practice.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentranLockTest {

	public static class Consumer extends Thread {

		private final int[] storage;

		private final Lock lock;

		private final Condition condition;

		private int id;

		private AtomicInteger index;

		public Consumer(int[] storage, Lock lock, Condition condition, int id, AtomicInteger index) {
			super();
			this.storage = storage;
			this.lock = lock;
			this.condition = condition;
			this.id = id;
			this.index = index;
		}

		@Override
		public void run() {
			while (index.get() < storage.length) {
				if(!lock.tryLock()) {
					continue;
				}
				try {
					if (index.get() % 2 != id) {
						condition.await();
					}
					System.out.println("id:" + id + "-->" + storage[index.get()]);
					index.incrementAndGet();
					condition.signal();
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
		final int[] storage = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		final ReentrantLock lock = new ReentrantLock();
		Condition con = lock.newCondition();
		AtomicInteger index = new AtomicInteger(0);
//		new Thread(new Consumer(storage, lock, con, 0,index)).start();
//		new Thread(new Consumer(storage, lock,  con, 1,index)).start();
		new Consumer(storage, lock, con, 0,index).start();
		new Consumer(storage, lock,  con, 1,index).start();
		
		Thread.currentThread().join();
	}
}