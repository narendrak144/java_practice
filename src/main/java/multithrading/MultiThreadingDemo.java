package multithrading;

public class MultiThreadingDemo implements Runnable{

	public static void main(String...strings ){
		Runnable job1 = new MultiThreadingDemo();
		Runnable job2 = new MultiThreadingDemo();
		Runnable job3 = new MultiThreadingDemo();
		Thread worker1 = new Thread(job1);
		Thread worker2 = new Thread(job2);
		Thread worker3 = new Thread(job3);
		worker1.start();
		System.out.println(" worker1.isInterrupted() "+worker1.isInterrupted());
		worker1.interrupt();		
		System.out.println(" worker11.isInterrupted() "+worker1.isInterrupted());
	}

	public void run() {
		// TODO Auto-generated method stub
		while(true){
			if (Thread.interrupted()) 
	        {
				System.out.println("I am intrupted "+ Thread.interrupted());
	           break;
				
	        }
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				Thread.currentThread().interrupt();
			}
			for(int i=0; i<10; i++){
				System.out.println("thread name : "+Thread.currentThread().getName()+ "count "+i);
			}
		}
	}
}
