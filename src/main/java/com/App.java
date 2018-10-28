package com;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.CompareGenerator;

import predicate_test.Apple;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        int port = 8080;
        //Runnable r = ()-> System.out.println("I am running -> "+port);
        //port = 9090;
        //r.run();
       Runnable a = new Runnable(){

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println(port);
		}};
		
		a.run();
		
		Function<String,Integer> stringToInteger = Integer::parseInt;
		
		List<String> list = Arrays.asList("adde","dw","ewwww");
		list.sort(String::compareTo);
		System.out.println(list);
		
		
		List<Apple> applist = Arrays.asList(new Apple("nare", 1),new Apple("na", 1),new Apple("zare", 1));
		applist.sort((a1,a2)->a1.getColor().compareTo(a2.getColor()));
		System.out.println(applist);
		//applist.sort(comparing(Apple::getColor));
		
		//Local variable port defined in an enclosing scope must be final or effectively final
		//port = 9090;
		
		Supplier<Apple> sup = Apple::new;
		Apple app = sup.get();
    }
}
