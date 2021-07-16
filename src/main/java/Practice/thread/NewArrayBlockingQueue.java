package Practice.thread;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class NewArrayBlockingQueue {

	private Object lock;

	private List<Object> repository;
	
	private Condition notFull;
	
	private Condition notEmpty;
	
	private int length;

	public NewArrayBlockingQueue(final Object lock, List<Object> repository,int length) {
		super();
		this.lock = lock;
		this.repository = repository;
		this.length = length;
		this.notFull = lock.newCondition();
		this.notEmpty = lock.newCondition();
	}

	public void addElement(Object element) {
		synchronized (lock) {
			if(repository.size() == length) {
				try {
					notFull.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				repository.add(element);
				notEmpty.signalAll();
				
			}
		}

	}
	
	public void removeElem(Object element) {
		synchronized (lock) {
			if(repository.isEmpty()) {
				try {
					notEmpty.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				repository.remove(element);
				notFull.signal();
			}
			
		}
		
	}

}
