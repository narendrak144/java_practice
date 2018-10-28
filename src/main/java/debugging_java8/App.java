package debugging_java8;

public class App {

	public static void main(String... strings) {
		final int a = 10;
		Runnable b = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				int a = 19;
				System.out.println("ananymus class a -> " + a);

			}
		};
		b.run();
		System.out.println(" class a -> " + a);
		
		Runnable r1 = ()-> {
			// we cant redeclare 
			System.out.println(a); 
		};
		r1.run();
	}
}
