package map;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class numberPlayList {
	public static void main(String[] args) {
		ArrayList<Integer> myList = new ArrayList<Integer>();
		for(int i=0;i<5;i++) myList.add(i);
		
		//Method 1
		class myConsumer implements Consumer<Integer>{
			@Override
			public void accept(Integer t) {
				// TODO Auto-generated method stub
				System.out.println("Method 2 :"+ t);
			}			
		}
		myConsumer action = new myConsumer();
		myList.forEach(action);
		
		
		
		
		myList.forEach(new Consumer<Integer>() {
			public void accept(Integer t) {
				System.out.println("Mehtod 3 :"+ t);
			}	
		});
		
		
		
		Consumer<Integer> myListAction = n -> {
			System.out.println("Method 4 : "+n);

		};
		myList.forEach(myListAction);
		
		
		
		
		myList.forEach(n->{
			System.out.println("Mehtod 5 : "+n);
		});
		
		Function<Integer,Double> toDoubleFunction = Integer :: doubleValue;
		myList.forEach(n->{
			System.out.println("method 6 :"+ 
					toDoubleFunction.apply(n));
		});
		
		
		Predicate<Integer> isEvenFunction = n -> n%2 ==0;
		myList.forEach(n->{
			System.out.println("Method 7 : "+ n+"check for even : "+ isEvenFunction.test(n));
		});
		
		//Stream processing
		
		myList.stream().forEach(n->{
			System.out.println("For each value in stream : "+n);
			
		});
		
		myList.stream().map(toDoubleFunction).forEach(n -> System.out.println(n));
		
		List<Double> doubleList = myList.stream().map(toDoubleFunction).collect(Collectors.toList());
		
		myList.stream().filter(isEvenFunction).forEach(n -> System.out.println(n));
		
		
		
	}	

}
