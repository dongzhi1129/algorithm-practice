package Practice.thread;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTaskTest {

	public static class ExhaustTask extends TimerTask {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("ExhaustTask");
			try {
				Thread.sleep(3000);
				System.out.println("ExhaustTask finished");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	
	public static class ExhaustTaskException extends TimerTask {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("ExhaustTaskException");
			throw new RuntimeException();

		}

	}
	
	
	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new ExhaustTask(), 1000);
		timer.schedule(new ExhaustTaskException(), 300);
	}

}
