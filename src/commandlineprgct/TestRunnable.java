package commandlineprgct;

import java.io.*;
import java.lang.management.ManagementFactory;

public class TestRunnable {

	static BufferedReader lineRead = null;

	private volatile static boolean stop = false;

	public synchronized static void stopProgram() {
		stop = true;
	}
	
	//get free memory with hidden java api
	static long getFreeMemory() {
		
		/*
		 * 
		 * Using native JAVA hidden feature
		 * Suppress warnings..
		 * Preferences - Errors/Warning >> Forbidden reference change to Warning.
		 */		
		
		@SuppressWarnings("restriction")
		com.sun.management.OperatingSystemMXBean os = (com.sun.management.OperatingSystemMXBean) 
		ManagementFactory.getOperatingSystemMXBean();
		
		@SuppressWarnings("restriction")
		long freeMem = os.getFreePhysicalMemorySize();
		
		return freeMem;
		
	}

	// call method in library...
	public static void getMemoryUtilization() {

		long freeMem;
		int mb = 1024 * 1024;

		freeMem = getFreeMemory();

		System.out.println("Free Memory(MB) = " + freeMem / mb);

	}

	// wait for keystroke
	public static void waitForKey() throws IOException {
		String key = null;

		// this will be run in separate thread
		while (true) {
			try {
				key = lineRead.readLine();

			} catch (IOException e) {
				// IO error
				e.printStackTrace();
			}

			if (key.equals("t")) {
				stopProgram();
				break;
			}
		}
	}

	public static void mainRunnable() {
		lineRead = new BufferedReader(new InputStreamReader(System.in));

		// create a new thread
		Thread T = new Thread(new Runnable() {

			@Override
			public void run() {
				// run waitForKey() in separate thread.
				try {
					waitForKey();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		});
		T.start();

		System.out.println("\n--Press t then ENTER to terminate.--");
		System.out.println("*Refreshes every 5 seconds in loop...**\n");

		while (true) {

			// continue loop until true
			if (stop == true) {
				System.out.println("Exiting Memory Program....\n");
				break;
			} else {
				// run memory test before pause
				getMemoryUtilization();

				try {
					// sleep 5 seconds.
					Thread.sleep(5000);

				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

		}
	}

	public static void main(String[] args) {
	}

}
