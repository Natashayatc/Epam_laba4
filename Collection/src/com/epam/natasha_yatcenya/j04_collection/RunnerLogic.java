package com.epam.natasha_yatcenya.j04_collection;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RunnerLogic {

	public void doLogic(List<Set<Integer>> sets) {

		System.out.println("Все наборы множеств:");
		for (Set<Integer> set : sets) {
			System.out.println(set);
		}
		Set<Integer> firstSet = sets.get(0);
		Set<Integer> secondSet = sets.get(1);

		System.out.println("Пересечение первых двух множеств:");
		System.out.println(crossing(firstSet, secondSet));

		System.out.println("Объединение первых двух наборов:");
		System.out.println(unite(firstSet, secondSet));
	}

	private Set<Integer> crossing(Set<Integer> firstSet, Set<Integer> secondSet) {
		Set<Integer> result = new TreeSet<>(firstSet);
		result.retainAll(secondSet);
		return result;
	}

	private Set<Integer> unite(Set<Integer> firstSet, Set<Integer> secondSet) {
		return Stream.of(firstSet, secondSet)
				.flatMap(Set::stream)
				.collect(Collectors.toSet());
	}
}
