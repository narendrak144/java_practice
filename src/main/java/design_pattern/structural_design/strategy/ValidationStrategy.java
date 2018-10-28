package design_pattern.structural_design.strategy;

@FunctionalInterface
public interface ValidationStrategy {

	boolean execute(String s);
}
