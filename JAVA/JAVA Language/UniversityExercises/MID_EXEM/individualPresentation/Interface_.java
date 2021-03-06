package individualPresentation;
/*
  t1.start();  
  t1.start(); 
  Can not we start a thread twice.
  An IllegalThreadStateException is thrown.
  Thread will run once but for second time,
  it will throw exception.
*/
public class Interface_ {
	public static void main(String[] args) {
		X objA = new X();
		Y objB = new Y();

		//objA.start();
		//objB.start();
		
		Thread thread1 = new Thread(objA,"My Thread1");
		Thread thread2 = new Thread(objB);
		
		try {
			thread1.start();
			thread2.start();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

class X implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i <= 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("R");
		}
	}

}
//java multiple inheritance does not support
class Y extends X implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i <= 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("A");
		}
	}
}
