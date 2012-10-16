package experiment.innerclassandconcurrency;

import java.util.ArrayList;
import java.util.List;

/*
 ***************************************************
 #                                                 #
 #    Concurrency And Inner Class Example File     #
 #             Made by Farajallah                  #
 #                                                 #
 ***************************************************
 */

public class ConcurrencyAndInnerClass {

	private class MyRunnable implements Runnable {
		private final long count;

		MyRunnable(long count) {
			this.count = count;
		}

		@Override
		public void run() {
			System.out.println("Thread: " + count + " is waiting");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Thread: " + count + " has been waited");
		}
	}

	public void startThreads() {
		// We will store the threads so that we can check if they are done
		List<Thread> threads = new ArrayList<Thread>();
		// We will create 500 threads
		for (int i = 0; i < 500; i++) {
			Runnable task = this.new MyRunnable(i);
			Thread worker = new Thread(task);
			// We can set the name of the thread
			worker.setName(String.valueOf(i));
			// Start the thread, never call method run() direct
			worker.start();
			// Remember the thread for later usage
			threads.add(worker);
		}
		int running = 0;
		do {
			running = 0;
			for (Thread thread : threads) {
				if (thread.isAlive()) {
					running++;
				}
			}
			System.out.println("We have " + running + " running threads. ");
		} while (running > 0);

	}

	public static void main(String[] args) {
		ConcurrencyAndInnerClass test = new ConcurrencyAndInnerClass();
		test.startThreads();

	}

}