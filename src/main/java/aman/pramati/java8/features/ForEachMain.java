package aman.pramati.java8.features;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

// First Java Features to explore
public class ForEachMain {

	public static void main(String[] args) {
		
		List<Integer> l;
		l=new LinkedList<Integer>();
		
		for(int i=0; i<10; i++) {
			l.add(i);
		}
		
		//Anonymous implementation
		System.out.println("Anonymous Impl");
		l.forEach(new Consumer<Integer>(){

			public void accept(Integer arg0) {
				System.out.println("Consumed value "+arg0);
				
			}
			
		});
		
		//Anonymous implementation using Lambda expression
				System.out.println("--------------------------------------------\nLambda Anonymous Implementation");
				l.forEach(
						(Integer arg0) -> {
						System.out.println("Value "+arg0+", square="+arg0*arg0);					
					}
					);
		
		//Consumer Implemented
		System.out.println("-------------------------------------\nConsumer Implementation");
		Consumer<Integer> action;
		action = new IntConsumer();
		
		l.forEach(action);
		
	}

}
