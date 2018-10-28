package singletonPractice;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;


public class ReflectionSingletonDemo {

	public static void main(String ...strings){
		ReflectionSingleton instanceone = ReflectionSingleton.getInstance();
		ReflectionSingleton instancetwo = null;
		
		try {
			
			Field instance = ReflectionSingleton.class.getDeclaredField("INSTANCE");
			instance.setAccessible(true);
			instance.set(instance, null);

			Constructor constructor = ReflectionSingleton.class.getDeclaredConstructor();
			constructor.setAccessible(true);
			instancetwo= (ReflectionSingleton)constructor.newInstance();
			System.out.println(" instanceone -> "+instanceone);
			System.out.println(" instancetwo -> "+instancetwo);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" instanceone -> "+instanceone.hashCode());
		System.out.println(" instancetwo -> "+instancetwo.hashCode());
	}
}
