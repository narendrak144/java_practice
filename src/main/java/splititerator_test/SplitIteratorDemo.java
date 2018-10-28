package splititerator_test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SplitIteratorDemo {

	public static void main(String...strings){
		String s = " Narendra Kumar ";
		System.out.format("Found %d words in iterative manner ",getCount(s));
		
		Stream<Character> stream = IntStream.range(0, s.length())
				.mapToObj(s::charAt);
		System.out.println();		
		System.out.format("Found %d words in stram manner ",countWord(stream));
	}
	
	
	public static int countWord(Stream<Character> stream){
		WordCounter wordCounter = stream.reduce(new WordCounter(0, true), WordCounter::accumulate, 
				WordCounter::combine);
		return wordCounter.getCounter();
	}
	
	
	public static int getCount(String s){
		//String s = " Narendra Kumar ";
		int count=0;
		boolean lastspace = true;
		System.out.println(s.toCharArray().length);
		for(char c : s.toCharArray()){
			System.out.format("Whitespace - %s and count - %d : ",Character.isWhitespace(c), count);
			System.out.println();
			if(Character.isWhitespace(c)){
				lastspace = true;
			}else{
				if(lastspace){
					count++;
					lastspace=false;
				}
		}
		}
		return count;
	}

}

