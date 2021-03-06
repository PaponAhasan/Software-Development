package individualPresentation;

public class Interface_02 {
	public static void main(String[] args) {

		// Anonymous_Class

		/* First Way */
		Runnable obj = new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<5;i++) {
					System.out.println("Rakibul Ahasan");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		Thread t1 = new Thread(obj);
		t1.start();

		
		
		/* Second Way */
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<5;i++) {
					System.out.println("ID : 022");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		t2.start();
	}
}
