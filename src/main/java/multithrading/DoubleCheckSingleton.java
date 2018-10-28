package multithrading;

public class DoubleCheckSingleton {

	private static DoubleCheckSingleton instance;
	private DoubleCheckSingleton(){
		
	}
	
	public static DoubleCheckSingleton getInstance(){
		if(instance==null){
			System.out.println("hi .. "+Thread.currentThread().getName());
			synchronized (DoubleCheckSingleton.class) {
				if(instance == null){
					instance = new DoubleCheckSingleton();
				System.out.println("critical - "+Thread.currentThread().getName());
				}
			}
		}
		
		return instance;
	}
	
}
