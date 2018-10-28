package cloning;

import java.util.HashMap;
import java.util.Map;

public class Employ extends BaseEmploy{

	private int id;
	private String name;
	
	Map<String, String > hmp = new HashMap<>();
	
	public Employ(){}
	
	public Employ(int id , String name){
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, String> getHmp() {
		return hmp;
	}

	public void setHmp(Map<String, String> hmp) {
		this.hmp = hmp;
	}

	@Override
	public String toString() {
		return "Employ [id=" + id + ", name=" + name + ", hmp=" + hmp + "]";
	}
	
	
	
	
}
