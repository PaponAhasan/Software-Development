package B_03;

public class TestClass implements A,B {
	@Override
	public void show() 
    { 
        // use super keyword to call the show 
        // method of PI1 interface 
        A.super.show(); 
  
        // use super keyword to call the show 
        // method of PI2 interface 
        B.super.show(); 
    }
}
