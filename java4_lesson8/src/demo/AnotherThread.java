package demo;

// Threads are in java.lang.Thread so no import is needed
public class AnotherThread {
	public static void main(String args[]) {
		T t = new T();
		t.start();
	}
}

class T extends Thread {
	public void run() {
		while (true) {
			// forever,
			System.out.println("b: ");
			// prompt the user with a b:, waiting for them to do something
			try {
				sleep(300);
				// sleep is in milliseconds
			} catch (InterruptedException e) {
			}
		}
	}
}