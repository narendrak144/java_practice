package multithrading;

public class SingleTonBillPugh {

	private SingleTonBillPugh(){
		
	}
	
	private static class SingleTonHelper {
		private static final SingleTonBillPugh INSTANCE = new SingleTonBillPugh();
	}
	
	public static SingleTonBillPugh getInstance(){
		return SingleTonHelper.INSTANCE;
	}
}
