package cloning;

public class CloningDemo {

	public static void main(String...strings ) throws CloneNotSupportedException{
		SingletonCloneable instance = SingletonCloneable.getInstance();
		System.out.println(instance);
		System.out.println(instance.clone());
		//Employ emp = Employ.getInstance();
		
		
		//System.out.println(emp);
		//Employ emp1 = (Employ)emp.clone();
		
		//System.out.println(emp.clone());
	}
}
