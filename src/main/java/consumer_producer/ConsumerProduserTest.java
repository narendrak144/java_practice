package consumer_producer;

import java.util.LinkedList;
import java.util.Queue;

public class ConsumerProduserTest {

	public static void main(String... strings){
		final Queue sQueue = new LinkedList<Integer>();
		Thread consumerThread = new Thread(new Consumer(sQueue, 4),"CONSUMER");
		Thread producerThread = new Thread(new Producer(sQueue, 4),"PRODUCER");
		
		producerThread.start();
		consumerThread.start();
	}
}
