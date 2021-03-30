package individualPresentation;

public class Inhertance_02 {
	public static void main(String[] args) {
		R objA = new R();
		A objB = new A(); 
//		objA.run();
//		objB.run();
		objA.start(); //static method
		objB.start();
	}
}
class R extends Thread {
	@Override
	public void run() {  //abstract method
		for (int i = 0; i <= 10; i++) {
			try {
				Thread.sleep(1000); 
				// must try-catch block rakte hove.
				//Exception throw korbe
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("R");
		}
	}
}

class A extends Thread {
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