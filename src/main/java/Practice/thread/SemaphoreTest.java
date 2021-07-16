package Practice.thread;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
	
	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(2);
		
		for(int i =0;i<10;i++) {
			new Thread(()->{
				try {
					semaphore.acquire();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Thread:"+ Thread.currentThread().getName() + "Get licence success");
				try {
					Thread.currentThread().sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				semaphore.release();
				System.out.println("Thread:"+ Thread.currentThread().getName() + "releas licence success");
			}).start();
		}
		try {
			Thread.currentThread().join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
