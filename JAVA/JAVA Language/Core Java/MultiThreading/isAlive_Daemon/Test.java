package isAlive_Daemon;

public class Test {
	public static void main(String[] args) {
		A o = new A();
		
		o.setDaemon(true);
		
		System.out.println(o.isAlive());
		o.start();
		System.out.println(o.isAlive());
		
		System.out.println("Main Class: "+o.x);
	}
}
