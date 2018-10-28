package predicate_test.typefree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import predicate_test.Apple;

public class TypePredicatDemo {

	public static void main(String... strings) {
		
		List<Apple> list1= new ArrayList<>();
		List<Apple> list = Arrays.asList(
				new Apple("red", 1,true), 
				new Apple("green", 2,true), 
				new Apple("red", 3),
				new Apple("red", 4,true));
		
		/*System.out.println(list);
		list1 = filter(list, new TypePredicate<Apple>() {
			@Override
			public boolean test(Apple t) {
				// TODO Auto-generated method stub
				return "red".equals(t.getColor());
			}

		});*/
		//list.forEach(a -> System.out.println(a));
		Predicate<Apple> p = a -> "green".equals(a.getColor());
		
		list1=list.stream().filter(p.negate().and(a-> a.getWeight()>1 && a.getWeight() < 4)).collect(Collectors.toList());
		
		List<String> colors = list.stream().map(Apple::getColor).collect(Collectors.toList());
		
		Set<String> colorSet = list.stream().map(Apple::getColor).collect(Collectors.toCollection(TreeSet::new));
		
		String commaSeperated  = list.stream().map(Apple::getColor).collect(Collectors.joining(","));
		
		int sum =list.stream().collect(Collectors.summingInt(Apple::getWeight));
		
		Map<String, List<Apple>> collectByColor = list.stream().collect(Collectors.groupingBy(Apple::getColor));
		
		Map<Boolean, Integer> summingColor = list.stream().collect(Collectors.groupingBy(Apple::isFresh,Collectors.summingInt(Apple::getWeight)));
		
		Map<Boolean , List<Apple>> collectByfresh = list.stream().collect(Collectors.partitioningBy(Apple::isFresh));
		
		System.out.println("collectByfresh -> "+collectByfresh);
		System.out.println("summingColor -> "+summingColor);
		
		System.out.println("collectByColor -> "+collectByColor);
		
		System.out.println(sum);
		System.out.println("commaSeperated -> "+commaSeperated);
		colorSet.forEach(a-> System.out.println(a));
		//list1.forEach(a -> System.out.println(a));
	}

	public static <T> List<T> filter(List<T> list, TypePredicate<T> t) {
		List<T> result = new ArrayList<T>();
		for (T t1 : list) {
			if (t.test(t1))
				result.add(t1);
		}

		return result;
	}
}
