package multithrading;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import cloning.SingletonCloneable;

public class LazySingltonDemo {
	
	public static void main(String...strings ){
	
	Runnable T1 = new Runnable(){

		public void run() {
			System.out.println("instance start - " + new Date());
			// TODO Auto-generated method stub
			//LazyInitializationSinglton instance = LazyInitializationSinglton.getInstance();
			//EagerInitializationSinglton instance = EagerInitializationSinglton.getInstance();
			//SingletonNaive instance  = SingletonNaive.getInstance();
			//DoubleCheckSingleton instance = DoubleCheckSingleton.getInstance();
			//SingleTonBillPugh instance = SingleTonBillPugh.getInstance();
			SingletonCloneable instance = SingletonCloneable.getInstance();
			System.out.println("instance 1 - "+instance+" end time -> "+ new Date().toString());
		}
		
	};
	
	Runnable T2 = new Runnable(){

		public void run() {
			System.out.println("instance start - " + new Date());
			// TODO Auto-generated method stub
			//LazyInitializationSinglton instance = LazyInitializationSinglton.getInstance();
			//EagerInitializationSinglton instance = EagerInitializationSinglton.getInstance();
			//SingletonNaive instance  = SingletonNaive.getInstance();
			//DoubleCheckSingleton instance = DoubleCheckSingleton.getInstance();
			//SingleTonBillPugh instance = SingleTonBillPugh.getInstance();
			SingletonCloneable instance = SingletonCloneable.getInstance();
			System.out.println("instance 2 - "+instance+" end time -> "+ new Date());
		}
		
	};
	
	Thread t1 = new Thread(T1);
	Thread t2 = new Thread(T2);
	
	t1.start();
	t2.start();
		
	
	}
	
	
}
