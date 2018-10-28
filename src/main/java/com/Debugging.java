package com;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;


public class Debugging {

	public static void main(String...strings){
		//List<Point> points = Arrays.asList(new Point(1,4),null);
		//points.stream().mapToInt(Point::getX).forEach(s -> System.out.println(s));
		
		List<Integer> list = Arrays.asList(1,2,4,6,7,3);
		List<Integer> list1 =list.stream()
		.peek(x-> System.out.println("from stream : "+x))
		.map(x-> x+10)
		.peek(x -> System.out.println("from map : "+x))
		.filter(x-> x%2==0)
		.peek(x -> System.out.println("from filter : "+x))
		.collect(toList());
		
		
	}
}
