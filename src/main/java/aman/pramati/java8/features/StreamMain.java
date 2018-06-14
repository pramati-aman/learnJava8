package aman.pramati.java8.features;

import java.util.LinkedList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamMain {

	public static void main(String[] args) {
		List<Integer> l;
		l=new LinkedList<>();
		
		for(int i=0; i<100; i++) {
			l.add(i);
		}
		
		streamProcessing(l);
		supplierAssistedStreamProcessing(l);
	}

	private static void supplierAssistedStreamProcessing(List<Integer> l) {
		
		System.out.println("----------------------------------------------");
		System.out.println("Supplier Facilitated Stream Procesing");
		Supplier<Stream<Integer>> pStream = () -> l.parallelStream().filter(a -> a < 35);
		Supplier<Stream<Integer>> sStream = () -> l.stream().filter(b -> b > 90);
		
		pStream.get().forEach( num -> System.out.println("Parallel Value= "+num));
		sStream.get().forEach( num -> System.out.println("Sequential value= "+num));
		
//Following statement do not gives exception as the supplier will provide the freshly created stream upon invoking of each get() on it
		int pSum= pStream.get().filter(a-> a%2==0).mapToInt(a-> a).sum();
		OptionalDouble sSum= sStream.get().filter(a-> a%2==0).mapToInt(a-> a).average();
		
		
		System.out.println("Parallel sum of even numbers"+pSum);
		System.out.println("Sequential avg of even numbers"+sSum);
	}

	private static void streamProcessing(List<Integer> l) {
		
		System.out.println("Normal Stream Processing");
		Stream<Integer> pStream = l.parallelStream().filter(a -> a < 35);
		Stream<Integer> sStream = l.stream().filter(b -> b > 90);
		
		pStream.forEach( (num) -> System.out.println("Parallel Value= "+num));
		sStream.forEach((num) -> System.out.println("Sequential value= "+num));
		
		//Following statement gives exception as the stream has been already closed prior to it
//		int pSum= pStream.filter(a-> a%2==0).mapToInt(a-> a).sum();
//		OptionalDouble sSum= sStream.filter(a-> a%2==0).mapToInt(a-> a).average();
		
		//Need to create stream again for accessing the stream again
		int pSum= l.parallelStream().filter(a -> a < 35).filter(a-> a%2==0).mapToInt(a-> a).sum();
		OptionalDouble sSum= l.stream().filter(b -> b > 90).filter(a-> a%2==0).mapToInt(a-> a).average();
		
		System.out.println("Parallel sum of even numbers"+pSum);
		System.out.println("Sequential avg of even numbers"+sSum);
	}

}
