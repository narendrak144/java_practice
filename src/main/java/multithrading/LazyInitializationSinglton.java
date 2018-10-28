package multithrading;

public class LazyInitializationSinglton {

	private static LazyInitializationSinglton instance ;
	
	private LazyInitializationSinglton(){
		
	}
	
	public static LazyInitializationSinglton getInstance(){
		//System.out.println( "just going to take instance , Thread name  "+Thread.currentThread().getName());
		if(instance==null){
			//System.out.println( "getting null , Thread name  "+Thread.currentThread().getName());
			instance = new LazyInitializationSinglton();
			//System.out.println("inside if block instance value ->  "+instance);
		}
		return instance;
	}
}
