public class ThreadExample extends Thread {
	private Thread t;
	private String threadDesc;

	public ThreadExample(String desc) {
		threadDesc = desc;
		System.out.println("Creating " + threadDesc);
	}

	public void runThread() {
		System.out.println("Rnnning" + threadDesc);
		try {
			for (int a = 4; a > 0; a--) {
				System.out.println("Rnnning" + threadDesc + " " + a);
				Thread.sleep(50);
			}
		} catch (Exception e) {
			System.out.println("Thraed" + threadDesc + " " + " is interrupted");
		}
	}

	public void start() {
		System.out.println("Starting" + threadDesc);
		if (t == null) {
			t = new Thread(this, threadDesc);
			t.start();
		}
	}
}