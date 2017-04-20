package hu.gaborbalazs.concurrency;

import java.text.MessageFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BufferedReaderTestApp {
	
	private static Object lock1 = new Object();
	private static Object lock2 = new Object();
	private static Object lock3 = new Object();

	public static void main(String[] args) {

		System.out.println(MessageFormat.format("Thread: {0}, Message: {1}", Thread.currentThread().getName(), "Beginning of the Game"));
		long time = System.currentTimeMillis();
		
		ExecutorService service = Executors.newCachedThreadPool();
		for(int i = 0; i < 20; i++) {
			service.submit(() -> {
				method1();
				long l = Integer.MAX_VALUE;
				for(int j = 0; j < 10; j++) {
					l *= l;
				}
				method2();
				System.out.println(MessageFormat.format("Thread: {0}, Message: {1}", Thread.currentThread().getName(), "I am a Gamer"));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println(MessageFormat.format("Thread: {0}, Message: {1}", Thread.currentThread().getName(), "Gamer Interrupted"));
				}
				method3();
			});
		}
		service.shutdown();
//		System.out.println(MessageFormat.format("Thread: {0}, Gamers Awaiting Execution: {1}", Thread.currentThread().getName(), service.shutdownNow().size()));
		System.out.println(MessageFormat.format("Thread: {0}, isShutdown: {1}", Thread.currentThread().getName(), service.isShutdown()));
		System.out.println(MessageFormat.format("Thread: {0}, isTerminated: {1}", Thread.currentThread().getName(), service.isTerminated()));
		try {
			service.awaitTermination(10, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			System.out.println(MessageFormat.format("Thread: {0}, Message: {1}", Thread.currentThread().getName(), "Game Master Interrupted"));
		}
		System.out.println(MessageFormat.format("Thread: {0}, isTerminated: {1}", Thread.currentThread().getName(), service.isTerminated()));
		
		System.out.println(MessageFormat.format("Thread: {0}, Message: {1}, Time: {2}", Thread.currentThread().getName(), "End of the Game", System.currentTimeMillis()-time));
	}
	
	public static void method1() {
		synchronized (lock1) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(MessageFormat.format("Thread: {0}, Message: {1}", Thread.currentThread().getName(), "Gamer Interrupted in method1()"));
			}
			System.out.println(MessageFormat.format("Thread: {0}, Message: {1}", Thread.currentThread().getName(), "I am a Gamer in the method1()"));
		}
	}
	
	public static void method2() {
		synchronized (lock2) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(MessageFormat.format("Thread: {0}, Message: {1}", Thread.currentThread().getName(), "Gamer Interrupted in method2()"));
			}
			System.out.println(MessageFormat.format("Thread: {0}, Message: {1}", Thread.currentThread().getName(), "I am a Gamer in the method2()"));
		}
	}
	
	public static void method3() {
		synchronized (lock3) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(MessageFormat.format("Thread: {0}, Message: {1}", Thread.currentThread().getName(), "Gamer Interrupted in method3()"));
			}
			System.out.println(MessageFormat.format("Thread: {0}, Message: {1}", Thread.currentThread().getName(), "I am a Gamer in the method3()"));
		}
	}
	
}