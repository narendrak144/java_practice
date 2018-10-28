package metho_reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import static java.util.Comparator.comparing;
import java.util.function.BiFunction;
import java.util.function.Function;

import predicate_test.Apple;

public class Demo1 {

	public static void main(String...strings){
		List<Integer> list = Arrays.asList(1,10,5,6,7);
		
		//List<Apple> appList = map(list, (weight)-> new Apple(weight));
		List<Apple> appList = map(list, Apple::new);
		System.out.println("before -> "+appList);
		/*Comparator<Apple> c = new Comparator<Apple>() {

			@Override
			public int compare(Apple o1, Apple o2) {
				// TODO Auto-generated method stub
				return o1.getWeight()-o2.getWeight();
			}
			
		};*/
		
		Comparator<Apple> c = (o1,o2)-> o1.getWeight().compareTo(o2.getWeight());
		appList.sort(comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));
		
		System.out.println("after -> "+appList);
		BiFunction<String,Integer,Apple> bi = (String a, Integer b) -> new Apple(a,b);
		
		TriFunction<String,Integer,Boolean, Apple> tri = Apple::new;
		Apple a = tri.apply("white", 1,true);
		System.out.println("apple -> "+a);
	}
	
	
	public static  	List<Apple> map(List<Integer> intlist , Function<Integer,Apple> f){
		List<Apple> list = new ArrayList<>();
		for(Integer t:intlist)
			list.add(f.apply(t));
		
		return list;
	}
	
	public static<T,R> List<R>  getR(List<T> t,Function<T,R> f){
		List<R> result = new ArrayList<>();
		for(T i:t)
			result.add(f.apply(i));
		
		return result;
	}
	
}
