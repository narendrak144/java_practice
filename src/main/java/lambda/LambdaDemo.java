package lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

public class LambdaDemo {

	public static void main(String... strings) throws IOException {
		// just showing behavior is the passing to method
		/*
		 * BufferedReaderProcessor p = new BufferedReaderProcessor() {
		 * 
		 * @Override public String process(BufferedReader br) throws IOException
		 * { // TODO Auto-generated method stub return br.readLine(); } };
		 * 
		 * BufferedReaderProcessor p1 = (BufferedReader r) -> r.readLine();
		 * 
		 * String s1 = LambdaHelper.processFile(p1);
		 * 
		 * System.out.println("s1 -> "+s1);
		 */

		System.out.println(LambdaHelper.processFile((BufferedReader br) -> br.readLine() + br.readLine()));
//custom use
		List<String> list = Arrays.asList("narendra", "kumar", "");
		list = LambdaHelper.filter(list, (String s) -> !s.isEmpty());
		System.out.println(list);
		LambdaHelper.foreach(list, (String s) -> System.out.println(s));
		List<Integer> intlist = LambdaHelper.map(list, String::length);
		System.out.println(intlist);
//real time use
		List<Integer> listInt = list.stream().map(String::length).collect(Collectors.toList());
		System.out.println("listInt -> " + listInt);
		list.forEach(s -> System.out.println(s.length()));
		System.out.println(list.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList()));
		
		System.out.println(list.stream().sorted((s1, s2)-> s1.compareTo(s2)).collect(Collectors.toList()));
		
		IntPredicate evenNumbers = (int i )-> i%2==0;
		System.out.println();
	}

}
