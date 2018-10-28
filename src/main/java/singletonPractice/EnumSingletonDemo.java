package singletonPractice;

public class EnumSingletonDemo {

	public static void main(String ...strings){
		System.out.println("instance -> "+Singleton.INSTANCE);
		
		Thread t1 = new Thread(() -> System.out.println("running thread 1 -> "+Singleton.INSTANCE));
		Thread t2 = new Thread(() -> System.out.println("running thread 1 -> "+Singleton.INSTANCE));
		Thread t3 = new Thread(() -> System.out.println("running thread 1 -> "+Singleton.INSTANCE));
		
		t1.start();
		t2.start();
		t3.start();
	}
	
}


enum Singleton {
	INSTANCE ;
}
