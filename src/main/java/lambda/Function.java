package lambda;

public interface Function<T, R> {
	R apply(T t);
}
