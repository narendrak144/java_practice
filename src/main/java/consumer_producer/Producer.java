package consumer_producer;

import java.util.Queue;
import java.util.Random;

public class Producer implements Runnable{
	
	private final Queue<Integer> sQueue ;
	private int maxsize;
	
	public Producer(Queue<Integer> sQueue, int maxsize){
		this.sQueue = sQueue;
		this.maxsize=maxsize;
	}

	public void run() {
		// TODO Auto-generated method stub
	       while(true){
	    	   synchronized (sQueue) {
	    		   System.out.println("this Producer -> "+this);
	    		   System.out.println("sQueue Producer -> "+sQueue);
				while(sQueue.size()== maxsize){
					try {
						System.out.println("Queue is full -> "+maxsize);
						sQueue.wait(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				Random random = new Random();
				int number = random.nextInt(100);
				sQueue.add(number);
				System.out.println("adding no in Queue -> "+number);
				sQueue.notify();
			 }
	       }	
	}

}
