package Practice.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

	public static class Consumer implements Runnable {

		private CountDownLatch countDownLatch;

		public Consumer(CountDownLatch countDownLatch) {
			super();
			this.countDownLatch = countDownLatch;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				Thread.currentThread().sleep(3000);
				countDownLatch.countDown();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " finished");
		}

	}
	
	public static void main(String[] args) throws InterruptedException {
		
		CountDownLatch countDownLatch = new CountDownLatch(2);
		
		Consumer consumer1 = new Consumer(countDownLatch);
		Consumer consumer2 = new Consumer(countDownLatch);
		new Thread(()->{
			try {
				countDownLatch.await();
				Thread.currentThread().sleep(3000);
				System.out.println("main");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("fin");
			
		}).start();
		new Thread(consumer1).start();
		new Thread(consumer2).start();
		
		
		Thread.currentThread().join();
		
		
	}

}
