package Practice.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {

	private final Lock lock = new ReentrantLock();

	private final Condition zeroCondtn = lock.newCondition();

	private final Condition eventCondtn = lock.newCondition();

	private final Condition oddCondtn = lock.newCondition();

	private int index;

	private int n;

	public ZeroEvenOdd(int n) {
		this.n = n;
	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	public void zero(IntConsumer printNumber) throws InterruptedException {
		for (;;) {
			lock.lock();
			try {
				if (index > n) {
					break;
				}
				if (index % 2 != 0) {
					zeroCondtn.await();
				}
				printNumber.accept(0);
				index++;
				int eventIndex = index / 2 + 1;
				if (eventIndex % 2 == 0) {
					eventCondtn.signal();
				} else {
					oddCondtn.signal();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				lock.unlock();
			}

		}

	}

	public void even(IntConsumer printNumber) throws InterruptedException {
		for (;;) {
			lock.lock();
			try {
				if (index > n) {
					break;
				}
				int eventIndex = index / 2 + 1;
				if (eventIndex % 2 != 0) {
					eventCondtn.await();
				}
				printNumber.accept(eventIndex);
				index++;
				zeroCondtn.signal();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				lock.unlock();
			}

		}
	}

	public void odd(IntConsumer printNumber) throws InterruptedException {
		for (;;) {
			lock.lock();
			try {
				if (index > n) {
					break;
				}
				int eventIndex = index / 2 + 1;
				if (eventIndex % 2 == 0) {
					eventCondtn.await();
				}
				printNumber.accept(eventIndex);
				index++;
				zeroCondtn.signal();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				lock.unlock();
			}

		}
	}
}