package design_pattern.structural_design.strategy;

public class ValidatorDemo {

	public static void main(String...strings){
		String str = "naredrakumar";
		
		System.out.println(str.matches("[a-z]+"));
		
		Validator isLowerCase = new Validator((String s)-> s.matches("[a-z]+"));
		System.out.printf("Is String in lower case -> %b",isLowerCase.validate(str));
		System.out.println();
		Validator isNumeric = new Validator((String s)-> s.matches("[0-9]+"));
		System.out.printf("Is String in Numeric case -> %b",isNumeric.validate("3"));
	}
}
