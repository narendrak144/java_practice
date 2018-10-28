package cloning;
public class ClonableParent implements Cloneable{
	
	protected Object clone() throws CloneNotSupportedException {
		
		return super.clone();
	}
	
}