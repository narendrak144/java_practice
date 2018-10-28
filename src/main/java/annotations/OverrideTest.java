package annotations;

public class OverrideTest {

	public static void main(String...strings){
		BaseClass bs = new ChildClass();
		bs.doSomething("Overriding...");
	}
}
