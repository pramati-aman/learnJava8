package aman.pramati.java8.features;

import java.util.function.Consumer;

public class IntConsumer implements Consumer<Integer> {

	public void accept(Integer t) {
		System.out.println("Value="+t+", factorial="+factorial(t));
		
	}

	private long factorial(Integer t) {
		if(t==0)
			return 1;
		else
			return t*factorial(t-1);

	}

}
