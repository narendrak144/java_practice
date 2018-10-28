package streamsdemo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import streamsdemo.Dish.CaloricLevel;

import static java.util.stream.Collectors.*;


public class GroupingDemo {

	public static void main(String...strings){
		List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("beef", false, 700, Dish.Type.MEAT),
				new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER),
				new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER), 
				new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH), 
				new Dish("salmon", false, 450, Dish.Type.FISH));
		
		System.out.println("narendra");
		Map<Dish.Type, Optional<Dish>> maxByType = menu.stream()
								.collect(groupingBy(Dish::getType,
										maxBy(Comparator.comparingInt(Dish::getCalories))));
		System.out.println(maxByType);
		
		Map<Dish.Type,Dish> maxBy = menu.stream()
				.collect(groupingBy(Dish::getType,
						collectingAndThen(
								maxBy(Comparator.comparingInt(Dish::getCalories)), 
								Optional::get)));
							System.out.println(maxBy);
							
		Map<Dish.Type, Set<CaloricLevel>> findByCaloreLevel = menu.stream()
				.collect(groupingBy(Dish::getType, mapping(dish -> {
					if (dish.getCalories() <= 400) {
						return CaloricLevel.DIET;
					} else if (dish.getCalories() <= 700)
						return CaloricLevel.NORMAL;
					else
						return CaloricLevel.FAT;
				}, toCollection(HashSet::new))));

		 
		
	}
}
