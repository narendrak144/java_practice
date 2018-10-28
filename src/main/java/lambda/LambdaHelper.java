package lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LambdaHelper {

	public static String processFile(BufferedReaderProcessor p) throws IOException {
		try(BufferedReader br = new BufferedReader(new FileReader("E:\\workspace_home_base\\JavaPractic\\src\\main\\java\\com\\data.txt"))){
			return p.process(br);
		}
	}
	
	public static<T> List<T> filter(List<T> l,Predicate<T> t){
		List<T> list = new ArrayList<>();
		 /*for(T a:l){
			 if(t.test(a))
				 list.add(a);
		 }*/
		l.forEach(a-> {
			if(t.test(a))
				list.add(a);
		});
		
		return list;
	}
	
	public static<T> void foreach(List<T> l, Consumer<T> c){
		for(T t:l)
			c.accept(t);
	}
	
	public static <T,R> List<R> map(List<T> input,Function<T,R> f){
		List<R> result = new ArrayList<>();
		for(T t:input)
			result.add(f.apply(t));
		
		return result;
		
	}
}
