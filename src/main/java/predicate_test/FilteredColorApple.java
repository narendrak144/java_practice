package predicate_test;

public class FilteredColorApple implements ApplePredicate {

	@Override
	public boolean test(Apple o) {
		// TODO Auto-generated method stub
		 return	"red".equals(o.getColor());
		
	}

}
