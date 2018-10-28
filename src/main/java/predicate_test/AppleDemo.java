package predicate_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppleDemo {

	public static void main(String...strings){
		List<Apple> list = Arrays.asList(new Apple("red",1),new Apple("green",2),new Apple("red",3),new Apple("red",4));
		System.out.println(list);
	    list=filteredApple(list, new FilteredColorApple());
	    list.forEach(a -> System.out.println(a));
	}
	
	public static List<Apple>  filteredApple(List<Apple> enventory , ApplePredicate p){
		   List<Apple> list = new ArrayList<>();
		   for(Apple app:enventory)
			   if(p.test(app))
				   list.add(app);
		return list;
	}
}
