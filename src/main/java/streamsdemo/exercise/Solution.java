package streamsdemo.exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

	public static void main(String...strings){
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario","Milan");
		Trader alan = new Trader("Alan","Cambridge");
		Trader brian = new Trader("Brian","Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950)
				);
		
		//Find all transactions in the year 2011 and sort them by value (small to high).
		
		transactions.stream()
		.filter(d -> d.getYear() == 2011)
		.sorted(Comparator.comparing(Transaction::getValue))
		.collect(Collectors.toList())
		.forEach(a-> System.out.println("transactions -> "+a));
		
		//What are all the unique cities where the traders work?
		
				transactions.stream()
				.map(transaction -> transaction.getTrader().getCity())
				//.map(Transaction::getTrader)
				//.map(Trader::getCity)
				//.distinct()
				.collect(Collectors.toSet())
		        .forEach(a -> System.out.println("transactions - Trader' city -> "+a));
		
		//Find all traders from Cambridge and sort them by name.
		
		transactions.stream().map(Transaction::getTrader)
		.filter(trader -> trader.getCity().equals("Cambridge"))
		.sorted(Comparator.comparing(Trader::getName))
		//.collect(Collectors.toList())
		.forEach(System.out::println);
		
		//Return a string of all traders’ names sorted alphabetically.
		/*transactions.stream().map(Transaction::getTrader).map(Trader::getName)
		.distinct()
		//.map(s-> s.split("")).flatMap(Arrays::stream)
		.sorted(Comparator.comparing(String::toString))
		.map(String::toUpperCase)
		//.distinct()
		.collect(Collectors.toList())
		.forEach(s -> System.out.print(s+" "));*/
		
		String name = transactions.stream()
		.map(transaction -> transaction.getTrader().getName())
		.sorted()
		.collect(Collectors.joining());
		//.reduce("", (str1, str2)-> str1+str2);
		System.out.println("name -> "+name);
		
		//Are any traders based in Milan?
		
		/*transactions.stream().map(Transaction::getTrader)
		.filter(d -> d.getCity().equals("Milan"))
		.collect(Collectors.toList())
		.forEach(s -> System.out.println(s));*/
		
		boolean isInMilan = transactions.stream()
		.anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
		System.out.println("isInMilan -> "+isInMilan);
		
		//Print all transactions’ values from the traders living in Cambridge.
		transactions.stream()
		.filter( d -> "Cambridge".equals(d.getTrader().getCity()))
		.map(Transaction::getValue)
		//.collect(Collectors.toList())
		//.forEach(s -> System.out.println(s));
		.forEach(System.out::println);
		
		//What’s the highest value of all the transactions
		int value = transactions.stream()
				.map(Transaction::getValue)
				//.max(Comparator.comparing(Integer::intValue))
				.reduce(Integer::max)
				.get();
		System.out.println("highest value -> "+value);
		
		//Find the transaction with the smallest value.
		int minValue =	transactions.stream()
				.map(Transaction::getValue)
				.reduce(Integer::min)
				.get();
				//.min(Comparator.comparing(Integer::intValue)).get();
		System.out.println("minValue -> "+minValue);
		
		//fibonaci series 
		Stream.iterate(new int[]{0,1}, t-> new int[]{t[1], t[0]+t[1]})
		.limit(20)
		.forEach(t-> System.out.println("("+t[0]+","+t[1]+")"));
		
		
		Stream.iterate(new int[]{0,1},t-> new int[]{t[1],t[0]+t[1]})
		.limit(20)
		.map(t-> t[0])
		.forEach(System.out::println);
		
		
		
		
		
	}
}
