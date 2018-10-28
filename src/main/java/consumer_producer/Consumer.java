package consumer_producer;

import java.util.Queue;

public class Consumer implements Runnable {
	
	private final Queue<Integer> sQueue ;
	private int maxsize;
	public Consumer(Queue<Integer> sQueue, int maxsize){
		this.sQueue = sQueue;
		this.maxsize = maxsize;
	}

	public void run() {
		// TODO Auto-generated method stub
		while(true){
			synchronized (sQueue) {
				System.out.println("this Consumer -> "+this);
	    		   System.out.println("sQueue Consumer -> "+sQueue);
				while(sQueue.isEmpty()){
					try {
						System.out.println("sQueue is empty :");
						sQueue.wait(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				Integer number = (Integer)sQueue.poll();
				System.out.println("removing elements -> "+number);
				sQueue.notify();
			}
			
		}
		
	}

}
