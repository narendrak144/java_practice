package multithrading;

public class EagerInitializationSinglton {

	private static EagerInitializationSinglton instance = new EagerInitializationSinglton();
	
	private EagerInitializationSinglton(){
		
	}
	
	public static EagerInitializationSinglton getInstance(){
		return instance;
	} 
}
