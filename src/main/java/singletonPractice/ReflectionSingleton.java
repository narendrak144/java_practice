package singletonPractice;

public class ReflectionSingleton {

	private static ReflectionSingleton INSTANCE = new ReflectionSingleton();

	private ReflectionSingleton() {
		System.out.println("INSTANCE -> "+INSTANCE);
		if(INSTANCE!= null){
			throw new IllegalStateException("instance is allready created..");
		}
		System.out.println("Singleton instance is being created.");
	}

	public static ReflectionSingleton getInstance() {
		return INSTANCE;
	}
}
