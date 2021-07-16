package Practice.thread;

import java.util.concurrent.TimeUnit;

public class ThreadInterrupt {

	public static class WaitThread extends Thread {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				TimeUnit.SECONDS.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	public static void main(String[] args) throws InterruptedException {
		ThreadInterrupt.WaitThread thread = new WaitThread();
		thread.start();
		TimeUnit.SECONDS.sleep(2);
		thread.interrupt();
		System.out.println("isInterrupt -->" +  thread.isInterrupted());
		
	}

}
