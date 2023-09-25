package com.aurionpro.model;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionCounsumer {
	public static void main(String[] args)
	{
		Consumer<String> nameAddition=(name)->System.out.println(name);
		nameAddition.accept("aashish");
	
		BiConsumer<Integer, Integer> consumerMultiplication=(number1,number2)->
		{
			int answer=number1*number2;
			System.out.println(answer);
		};
		consumerMultiplication.accept(5, 4);
	
		
		Function<String, Integer> lengthFunction=(name)->{
			int nameLength=name.length();
			return nameLength;
		};
		System.out.println(lengthFunction.apply("Aashish"));
		
		BiFunction<Integer, Integer, Integer> addingNumber=(number1,number2)->{
			int answer=number1+number2;
			return answer;
		};
		System.out.println(addingNumber.apply(4, 6));
	
		Predicate<String> lengthCheck=(input)->{
			int length=input.length();
			return length>5;
		};
		System.out.println(lengthCheck.test("Aashish"));
	
	}
	
}
