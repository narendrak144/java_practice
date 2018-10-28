package forkjoin_test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class ForkJoinSumCalculator extends RecursiveTask<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final long[] numbers;
	private final int start;
	private final int end;

	public static final long THRESHOLD = 10_000;

	public ForkJoinSumCalculator(long[] numbers) {
		this(numbers, 0, numbers.length);
	}

	public ForkJoinSumCalculator(long[] numbers, int start, int end) {
		// TODO Auto-generated constructor stub
		this.numbers = numbers;
		this.start = start;
		this.end = end;
	}
	
	

	@Override
	protected Long compute() {
		// TODO Auto-generated method stub
		int length = end - start;
		if (length <= THRESHOLD) {
			return computeSequentially();
		}
		ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length / 2);
		leftTask.fork();

		ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length / 2, end);

		long rightResult = rightTask.compute();
		long leftResult = leftTask.join();
		return leftResult + rightResult;
	}

	private Long computeSequentially() {
		// TODO Auto-generated method stub
		long sum = 0;
		for(int i=start;i<end;i++){
			sum += numbers[i];
		}
		return sum;
	}
	
	
	public static long forkJoinSum(long n){
		long[] numbers = LongStream.rangeClosed(0, n).toArray();
		ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
		int availableProcessors = Runtime.getRuntime().availableProcessors();
		return new ForkJoinPool(availableProcessors).invoke(task);
	}

}
