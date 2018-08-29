package com.fj.nitin;

import static java.util.stream.Collector.Characteristics.CONCURRENT;
import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class StreamApi {

	public static void main(String[] args) {
		List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		for (Integer i : values) {
			System.out.println(i);
		}
		// Internal loop

		for (int s = 0; s < values.size(); s++) {
			System.out.println(s);
		}

		for (Iterator iterator = values.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			System.out.println(integer);

		}
		// Exterm looping

		 values.forEach(i ->System.out.println(i));
		// Method Reference
		 values.forEach(System.out::println);
		 
		 Supplier<Integer> supplier=new Supplier<Integer>() {

			@Override
			public Integer get() {
			return values.size();
			}
		};

		Consumer<Integer> consumer = new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				System.out.println(t);

			}

		};
		values.forEach(consumer);
		// values.forEach(StreamApi::addvalue3times);
		// 1*3+2*3+3*3+1*3+4*3+5*3+6*3+7=84
		// 3+6+9+12+15+18+21=
		Stream<Integer> integerStream=values.stream().map(i -> i * 3);
		System.out.println(values.stream().map(i -> i * 3).reduce(0, (c, e) -> c + e));
		Stream<Integer> stream1 = values.stream();
		
		Function<Integer, Integer> function = new Function<Integer, Integer>() {
			@Override
			public Integer apply(Integer t) {
				return t * 3;
			}

		};
		Stream<Integer> stream2 = stream1.map(function);

		BinaryOperator<Integer> binaryOperator = new BinaryOperator<Integer>() {

			@Override
			public Integer apply(Integer t, Integer u) {
				return t + u;
			}

		};
		Integer result = stream2.reduce(0, binaryOperator);
		System.out.println(result);
		System.out.println("************************");
		System.out.println(values.stream().map(i -> i * 3).collect(toList()));

		Collector<Integer, List<Integer>, List<Integer>> listInt = new Collector<Integer, List<Integer>, List<Integer>>() {

			@Override
			public Supplier<List<Integer>> supplier() {
				return () -> new ArrayList<Integer>();
			}

			@Override
			public Function<List<Integer>, List<Integer>> finisher() {
				return i -> i;
			}

			@Override
			public BinaryOperator<List<Integer>> combiner() {
				return (list1, list2) -> {
					list1.addAll(list2);
					return list1;
				};
			}

			@Override
			public Set<Characteristics> characteristics() {
				return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH, CONCURRENT));
			}

			@Override
			public BiConsumer<List<Integer>, Integer> accumulator() {
				return (list, item) -> list.add(item);
			}
		};

		System.out.println(values.stream().map(i -> i * 3).collect(toList()));

	}

	public static void addvalue3times(Integer i) {
		System.out.println(1 * 3);
	}

}
