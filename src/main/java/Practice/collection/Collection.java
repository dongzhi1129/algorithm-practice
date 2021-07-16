package Practice.collection;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Collection {

	public static class ArrayBlockingQueue {

		private final ReentrantLock lock;

		private final Object[] objects;

		private int count;

		private Condition notFull;

		private Condition notEmpty;

		private int putIndex;

		private int takeIndex;

		public ArrayBlockingQueue(int size) {
			if (size <= 0) {
				throw new IllegalArgumentException();
			}
			objects = new Object[size];
			lock = new ReentrantLock(false);
			notFull = lock.newCondition();
			notEmpty = lock.newCondition();
		}

		public void put(Object elem) throws InterruptedException {
			lock.lock();
			try {
				if (count == objects.length) {
					lock.wait();
				}
				objects[putIndex++] = elem;
				notEmpty.signal();
			} finally {
				lock.unlock();
			}
		}

		public void take() throws InterruptedException {
			lock.lock();
			try {
				if (count <= 0) {
					lock.wait();
				}
				objects[takeIndex++] = null;
				notEmpty.signal();
			} finally {
				lock.unlock();
			}
		}

	}

	public static void main(String[] args) {
		final ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(10);
		
		 Integer a = new Integer(50);
		 int b =50;
		 System.out.println(a == b);
		 
	}

}
