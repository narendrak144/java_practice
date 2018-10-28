package com;

import java.util.function.Function;

public class Letter {
	
	
	public static void main(String...strings){
		Function<String,String> h = Letter::addHeader;
		Function<String,String> f = Letter::addFooter;
		Function<String,String> c = Letter:: checkSpelling;
		
		Function<String,String> pipeLine = h.andThen(c).andThen(f);
		
		Function<String,String> pipeLine1 = h.compose(c).compose(f);
		System.out.println(pipeLine.apply("Narendra"));
		System.out.println(pipeLine1.apply("Narendra"));
		
		Function<Integer,Integer> g = x -> x+1;
		Function<Integer,Integer> n = x -> x*2;
		
		Function<Integer,Integer> andThen = g.andThen(n);
		Function<Integer,Integer> compose = g.compose(n);
		
		System.out.println(andThen.apply(1));
		System.out.println(compose.apply(1));
		
		
	}

	public static String addHeader(String text){
		return "From Raoul, Mario and Alan: " + text;
	}
	
	public static String addFooter(String text){
		return text + " Kind regards";
	}
	
	public static String checkSpelling(String text){
		return text.replaceAll("labda", "lambda");
	}
}
