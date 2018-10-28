package forkjoin_test;

public class ForkJoinTest {

	public static void main(String...strings){
		System.out.println("demonstration of Forkjoin now start");
		long number = 10_000_000;
		long sum = ForkJoinSumCalculator.forkJoinSum(number);
		System.out.println(sum);
		
		
		System.out.println(1 << 13 );
	}
}
