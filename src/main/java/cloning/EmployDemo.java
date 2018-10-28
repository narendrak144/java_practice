package cloning;

import java.util.HashMap;
import java.util.Map;

public class EmployDemo {

	public static void main(String...strings) throws CloneNotSupportedException{
		
		Employ emp = new Employ(1,"narendra");
		Map<String,String> mp = new HashMap<>();
		mp.put("man", "narendra");
		mp.put("ma", "narendra11");
		emp.setHmp(mp);
		System.out.println(emp);
		System.out.println(emp.clone());
		
		
		Employ emp1 = (Employ)emp.clone();
		
		System.out.println(emp == emp1);
		
		emp.getHmp().put("name", "kumar");
		emp.getHmp().put("name11", "kumar111");
		
		
		System.out.println(emp.getHmp());
		System.out.println(emp1.getHmp());
		
		
	}
}
