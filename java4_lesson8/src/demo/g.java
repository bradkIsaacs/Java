package demo;

class SimpleThread extends Thread {
	public SimpleThread(String str) {
		super(str);
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i + " " + getName());
			try {
				sleep((int) (Math.random() * 1000));
			}// end try
			catch (InterruptedException e) {
			}// end catch
		}// end for loop
		System.out.println("DONE! " + getName());
	}// end run method
	public static void main(String[] args) {
		SimpleThread st = new SimpleThread("myGuy");
		st.start();
	}
}