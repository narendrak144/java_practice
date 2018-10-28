package metho_reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import predicate_test.Apple;

public class MethodReferenceDemo {

	public static void main(String...strings){
		Supplier<Apple> c = Apple::new;
		Apple a = c.get();
		System.out.println(a);
		
		Function<Integer, Apple> f = Apple::new;
		System.out.println("function -> "+f);
		Apple a1 = f.apply(100);
		System.out.println(a1);
		
		BiFunction<String,Integer,Apple> f1 = Apple::new;
		Apple a2 = f1.apply("white", 100);
		System.out.println(a2);
		List<Integer> intlist = Arrays.asList(12,13,23,45,45,67);
		List<Apple> alist = map(intlist, Apple::new);
		System.out.println(alist);
		
	}
	
	
	public static<T,R> List<R> map(List<T> list, Function<T,R> f ){
		List<R> result = new ArrayList<>();
		for(T e:list ){
			result.add(f.apply(e));
		}
		return result;
		
	}
	
	
}
