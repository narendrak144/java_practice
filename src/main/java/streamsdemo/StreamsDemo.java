package streamsdemo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import collectordemo.ToListCollector;
import streamsdemo.Dish.CaloricLevel;

import static java.util.stream.Collectors.*;
import static java.lang.System.out;

public class StreamsDemo {

	public static void main(String... strings) {
		List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("beef", false, 700, Dish.Type.MEAT),
				new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER),
				new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER), 
				new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH), 
				new Dish("salmon", false, 450, Dish.Type.FISH));
		
		
		List<Dish> vegetarial = menu.stream().filter(Dish::isVegetarian).collect(toList());
		vegetarial.forEach(a-> out.println(a));
		
		vegetarial = menu.stream().filter(d -> d.getCalories()>400).skip(2).collect(toList());
		vegetarial.forEach(a-> out.println(a));
		
		vegetarial = menu.stream().filter(d -> d.getCalories()>400).limit(2).collect(toList());
		vegetarial.forEach(a-> out.println(a));
		
		vegetarial = menu.stream().filter(d -> d.getType()== Dish.Type.MEAT).collect(toList());
		vegetarial.forEach(a-> out.print("Dish.Type.MEAT -> "+a+" , "));
		
		List<String> names = menu.stream().map(Dish::getName).collect(toList());
		names.forEach(s-> System.out.println(s));
		
		List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
		List<Integer> wordsLength = words.stream().map(String::length).collect(toList());
		
		List<String> wordsC = words.stream()
				.map(s -> s.split(""))
				.flatMap(Arrays::stream)
				.distinct()
				.collect(toList());
		wordsC.forEach(s-> System.out.println(s));
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		 numbers.stream()
		 .map(a -> a*a).findFirst().ifPresent(d-> System.out.println("find first -> "+d));
		 //.collect(toList()).forEach(a-> System.out.println(a));
		 
		 System.out.println(numbers.stream().reduce(1, (a,b)-> a*b));
		 
		 System.out.println(numbers.stream().reduce(0, Integer::sum));
		 
		 List<Integer> numbers1 = Arrays.asList(1, 2, 3);
		 List<Integer> numbers2 = Arrays.asList(3, 4);
		 
		 numbers1.stream().flatMap(i -> numbers2.stream()
				 //.filter(j-> (i+j)%3==0)
				 .map(j->new int[]{i,j}))
		 .collect(toList())
		 .forEach(a -> {
			 for(int x=0 ; x < a.length-1;x++){
				 System.out.format("{%d,%d}",a[x],a[x+1]);
			 }
		 });
		 
		 boolean isthat = numbers2.stream().noneMatch(a -> a%2==0);
		 System.out.println(isthat);
		 
		 
		menu.stream().filter(Dish::isVegetarian)
		.findAny().ifPresent(d-> System.out.println(d.getName()));
		
		
		int caloriesSum = menu.stream()
		.mapToInt(Dish::getCalories)
		.sum();
		System.out.println("sum -> "+caloriesSum);
		
		int max=menu.stream()
		.mapToInt(Dish::getCalories)
		.max().orElse(1);
		System.out.println("max -> "+max);
		
		System.out.println(menu.stream().collect(counting()));
		System.out.println(menu.stream().count());
		int sum = menu.stream().collect(summingInt(Dish::getCalories));
		System.out.println(sum);
		
		System.out.println(menu.stream().collect(summarizingInt(Dish::getCalories)));
		String dishes = menu.stream().map(Dish::getName).collect(joining(","));
		System.out.println(dishes);
		
		Map<CaloricLevel, List<Dish>> dishesByColorilevel = 
				menu.stream().collect(groupingBy(dish -> {
					if (dish.getCalories() <= 400)
						return CaloricLevel.DIET;
					else if (dish.getCalories() <= 700)
						return CaloricLevel.NORMAL;
					else
						return CaloricLevel.FAT;
		}));
		
		System.out.println(dishesByColorilevel);
		
		
		Map<Dish.Type , Map<Dish.CaloricLevel,List<Dish>>> dishesByTypeCaloriLevel =
				menu.stream()
				.collect(groupingBy(Dish::getType, 
						groupingBy(dish ->{
							if(dish.getCalories()<=400)
								return CaloricLevel.DIET;
							else if(dish.getCalories()<=700)
								return CaloricLevel.NORMAL;
							else
								return CaloricLevel.FAT;
						})));
				System.out.println(dishesByTypeCaloriLevel);
				
				Map<Dish.Type, Long> countByType = menu.stream()
						.collect(groupingBy(Dish::getType,counting()));
				System.out.println(countByType);
				
				Map<Dish.Type,Integer> totalCaloriesByType = menu.stream()
						.collect(groupingBy(Dish::getType,summingInt(Dish::getCalories)));
				System.out.println(totalCaloriesByType);
				
				Map<Boolean, List<Dish>> isVegatarian=menu.stream().collect(partitioningBy(Dish::isVegetarian));
				System.out.println(isVegatarian);
				
		//partitioning multilevel-		
		Map<Boolean, Map<Dish.Type, List<Dish>>> partitioningValue = menu.stream()
				.collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));
		System.out.println(partitioningValue);
		
	Map<Boolean , Map<Boolean,List<Dish>>>	 a = menu.stream().collect(partitioningBy(Dish::isVegetarian, partitioningBy(dish -> dish.getCalories() > 500)));
		System.out.println(a);
		
		
	List<Dish> dishList =	menu.stream().collect(new ToListCollector<Dish>());
	dishList.forEach(s -> System.out.println(s));
	
	int nThreads = Runtime.getRuntime().availableProcessors();
	System.out.println("nThreads -> "+nThreads);
		
				
				
				
				
	
	}
}
