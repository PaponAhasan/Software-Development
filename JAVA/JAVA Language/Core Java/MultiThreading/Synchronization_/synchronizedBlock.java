package Synchronization_;

public class synchronizedBlock {
	void printTable(int n) {
		synchronized (this) {// synchronized block
			for (int i = 1; i <= 5; i++) {
				System.out.println(n * i);
				try {
					Thread.sleep(400);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
	}// end of the method
}

class MyThread5 extends Thread {
	synchronizedBlock t;

	MyThread5(synchronizedBlock t) {
		this.t = t;
	}

	public void run() {
		t.printTable(5);
	}

}

class MyThread6 extends Thread {
	synchronizedBlock t;

	MyThread6(synchronizedBlock t) {
		this.t = t;
	}

	public void run() {
		t.printTable(100);
	}
}

class TestSynchronizedBlock1 {
	public static void main(String args[]) {
		synchronizedBlock obj = new synchronizedBlock();// only one object
		MyThread5 t1 = new MyThread5(obj);
		MyThread6 t2 = new MyThread6(obj);
		t1.start();
		t2.start();
	}
}