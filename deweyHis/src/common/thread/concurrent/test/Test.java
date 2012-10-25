package common.thread.concurrent.test;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

public class Test {

	// private int number = 0;

	public static void main(String[] args) {
		// Test test = new Test();
		// ScheduledExecutor schedule = new ScheduledExecutor(10);
		// schedule.scheduleAtFixedRate(test.new Worker(), 0, 1,
		// TimeUnit.SECONDS);

		BeeperControl test = new BeeperControl();
		test.beepForAnHour();

		try {
			NetworkService test1 = new NetworkService(8000, 12);
			test1.serve();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// private class Worker implements Runnable {
	// public void run() {
	// number = number + 1;
	// System.out.println(number);
	// }
	// }
}

class BeeperControl {
	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

	public void beepForAnHour() {
		final Runnable beeper = new Runnable() {
			public void run() {
				System.out.println("beep");
			}
		};
		// 间隔10秒种
		final ScheduledFuture<?> beeperHandle = scheduler.scheduleAtFixedRate(beeper, 10, 10, SECONDS);
		// 间隔一小时 取消
		scheduler.schedule(new Runnable() {
			public void run() {
				beeperHandle.cancel(true);
			}
		}, 60 * 60, SECONDS);
	}
}

class NetworkService {
	private final ServerSocket serverSocket;
	private final ExecutorService pool;

	public NetworkService(int port, int poolSize) throws IOException {
		serverSocket = new ServerSocket(port);
		pool = Executors.newFixedThreadPool(poolSize);
	}

	public void serve() {
		try {
			for (;;) {
				pool.execute(new Handler(serverSocket.accept()));
			}
		} catch (IOException ex) {
			pool.shutdown();
		}
	}
}

class Handler implements Runnable {
	
	private final Socket socket;

	Handler(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		// read and service request
	}
}