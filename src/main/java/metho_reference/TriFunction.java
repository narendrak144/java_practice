package metho_reference;

@FunctionalInterface
public interface TriFunction<T, A,B, R> {
	R apply(T t,A a, B b);
}
