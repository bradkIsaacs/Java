package threadBasics;

class MyThread extends Thread {
	public void run(){
		for (int i =0; i<5; i++){
			System.out.println(currentThread().getName()+" "+(i+1));
			try {
				currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class ThreadBasics {
	public static void main(String[] args){
		MyThread thread = new MyThread();
		MyThread thread1 = new MyThread();
		thread.setName("First thread");
		thread1.setName("Second thread");
		thread1.start();
		thread.start();
	}
}