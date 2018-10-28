package streamsdemo.exercise;

import java.util.function.Function;
import java.util.stream.LongStream;

public class ParellelStreamTest {
	
	public static void main(String...strings){
		System.out.println("rangedSum sum done in: " +
				measureSumPerf(ParellelStreamTest::rangedSum, 4) + " msecs");
		System.out.println("parallelRangedSum sum done in: " +
				measureSumPerf(ParellelStreamTest::parallelRangedSum, 4) + " msecs");
	System.out.println("sideEffectSum sum don in : "
				+measureSumPerf(ParellelStreamTest::sideEffectSum, 4)+ " mesecs");
	
	System.out.println("sideEffectParallelSum sum don in : "
			+measureSumPerf(ParellelStreamTest::sideEffectParallelSum, 10_000_000)+ " mesecs");
	
	}
	
	//sideEffect of misuse of ParallelStream
	public static long sideEffectSum(long n) {
		Accumulator accumulator = new Accumulator();
		LongStream.rangeClosed(0L, n)
		.forEach(accumulator::add);
		return accumulator.total;
	}
	
	public static long sideEffectParallelSum(long n){
		Accumulator accumulator = new Accumulator();
		LongStream.rangeClosed(0L, n)
		.parallel()
		.forEach(accumulator::add);
		return accumulator.total;
	}
	
	
	

	public static long rangedSum(long n){
		return LongStream.rangeClosed(1, n).reduce(0L, Long::sum);
	}
	
	public static long parallelRangedSum(long n ){
		return LongStream.rangeClosed(1, n)
				.parallel()
				.reduce(0L, Long::sum);
	}

	public static long measureSumPerf(Function<Long, Long> adder, long n) {
		long fastest = Long.MAX_VALUE;
		for (int i = 0; i < 10; i++) {
			long start = System.nanoTime();
			long sum = adder.apply(n);
			long duration = (System.nanoTime() - start) / 1_000_000;
			System.out.println("Result: " + sum);
			if (duration < fastest)
				fastest = duration;
		}
		return fastest;
	}
}
