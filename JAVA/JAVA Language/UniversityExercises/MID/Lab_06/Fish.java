package Lab_06;

public class Fish extends Animal {

	@Override
	void breathe() {
		System.out.println("\nCan a fish breathe through its mouth");
		
	}

	@Override
	void eat() {
		System.out.println("Fish eats Insects ,Vegetables and Fruit etc");
		
	}

	@Override
	void move() {
		System.out.println("Fish swim by flexing their bodies and tail back and forth.\n");
		
	}

	@Override
	public int compareTo(Animal o) {
		if(this.size==o.size) return 0;
		else if(this.size<o.size) return -1;
		else return 1;
	}
	
}
