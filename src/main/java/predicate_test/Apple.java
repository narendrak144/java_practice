package predicate_test;

import java.io.Serializable;

public class Apple {

	private String color;
	private int weight;
	private boolean isFresh;
	
	public Apple(String color,int weight,Boolean isFresh){
		this.color = color;
		this.weight= weight;
		this.isFresh=isFresh;
	}
	
	public Apple(String color, int weight){
		this.color=color;
		this.weight = weight;
	}
	
	public Apple(int weight){
		this.weight=weight;
	}
	
	public Apple(){};
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFresh() {
		return isFresh;
	}

	public void setFresh(boolean isFresh) {
		this.isFresh = isFresh;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Apple [color=" + color + ", weight=" + weight + ", isFresh=" + isFresh + "]";
	}
	
	
 
}
