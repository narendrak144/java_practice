package cloning;

public class SingletonCloneable extends ClonableParent {

	private static SingletonCloneable instance = new SingletonCloneable();

	private SingletonCloneable() {
	}

	public static SingletonCloneable getInstance() {
		return instance;
	}
	
	protected Object clone() throws CloneNotSupportedException{
		 throw new RuntimeException();
	}
}
