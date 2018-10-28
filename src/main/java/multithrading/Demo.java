package multithrading;

public class Demo implements Runnable{

	public void run() {
		// TODO Auto-generated method stub
		 System.out.println("Doing heavy processing - START "+Thread.currentThread().getName());
		 try {
	            Thread.sleep(1000);
	            //Get database connection, delete unused data from DB
	            doDBProcessing();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        System.out.println("Doing heavy processing - END "+Thread.currentThread().getName());
	    }


	private void doDBProcessing() throws InterruptedException {
		System.out.println("I am in doDBProcessing starts -> ");
		Thread.sleep(5000);
		System.out.println("I am in doDBProcessing ends -> ");
	}

}
