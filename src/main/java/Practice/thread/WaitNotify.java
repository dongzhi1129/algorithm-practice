package Practice.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WaitNotify {

	public static class Producer extends Thread {

		private List<Object> storage;

		private int capacity;

		private Object lock;

		public Producer(final List<Object> storage, final int capacity, final Object lock) {
			super();
			this.storage = storage;
			this.capacity = capacity;
			this.lock = lock;
		}

		public void run() {
			while (true) {
				synchronized (lock) {
					if (storage.size() >= capacity) {
						System.out.println("Storage is full,wait consume.");
						try {
							lock.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					String product = new Random().nextInt() + "";
					System.out.println("Produce produce:" + product + ",Time:" + System.currentTimeMillis());
					storage.add(product);
					lock.notifyAll();
				}
			}

		}
	}

	public static class Consumer extends Thread {

		private List<Object> storage;

		private int capacity;

		private Object lock;

		public Consumer(final List<Object> storage, final int capacity, final Object lock) {
			super();
			this.storage = storage;
			this.capacity = capacity;
			this.lock = lock;
		}

		public void run() {
			while (true) {
				synchronized (lock) {
					if (storage.size() <= 0) {
						System.out.println("Storage is empty,wait consume.");
						try {
							lock.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println("Consume consume:" + storage.remove(storage.size() - 1) + ",Time:"
							+ System.currentTimeMillis());
					lock.notifyAll();
				}

			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		final Object lock = new Object();
		List<Object> storage = new ArrayList<>(4);
		int capacity = 4;
		Producer prod1 = new Producer(storage, capacity, lock);
		Consumer consumer1 = new Consumer(storage, capacity, lock);
		prod1.start();
		consumer1.start();
		Thread.currentThread().sleep(200000);;
	}

}
