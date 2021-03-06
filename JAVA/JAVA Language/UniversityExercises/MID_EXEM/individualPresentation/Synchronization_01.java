package individualPresentation;

public class Synchronization_01 extends Thread {
	public static void main(String[] args) {
		Synchronization_01 sc1 = new Synchronization_01();
		Synchronization_01 sc2 = new Synchronization_01();
		sc1.start();
		sc2.start();
	}
	
	static synchronized void Print() {
		try {
			for(int i=0;i<10;i++) {
				System.out.println(i);
				Thread.sleep(200);
			}
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
		}
	}
	
	@Override
	public void run() {
		synchronized (this) { //current object
			Print();
		}
	}
}
