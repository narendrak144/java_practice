package decision;

public class Sub1 extends SubBase {
	
	@Override
	public String getSeasons(String a){
		System.out.println("a sub class -> "+a);
		
		return a;
	}
	public static void main(String...strings){
		SubBase base = new Sub1();
		System.out.println(base.getSeasons("narednra"));
	}
	

}
