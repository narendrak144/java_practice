package multithrading;

public class SingletonNaive {

	private static SingletonNaive instance;
	private SingletonNaive(){
		
	}
	
	public static synchronized SingletonNaive getInstance(){
		if(instance == null){
			instance = new SingletonNaive();
		}
		return instance;
	}
}
