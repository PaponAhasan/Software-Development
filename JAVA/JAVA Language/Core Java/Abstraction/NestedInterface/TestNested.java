package NestedInterface;

public class TestNested implements Nested.Message {

	@Override
	public void msg() {
		System.out.println("Hello nested interface");
	}
	
	public static void main(String[] args) {
		Nested.Message message = new TestNested();//upcasting here  
		message.msg();  
	}
}
