package com.epam.natasha_yatcenya.j04_collection;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import com.epam.natasha_yatcenya.j04_collection.RunnerLogic;
import com.epam.natasha_yatcenya.j04_collection.CSVReader;
public class Runner {

	public static void main(String[] args) {

		String fileName = "пам.txt";
		try {
			CSVReader fileReader = new CSVReader(fileName);
			List<Set<Integer>> sets = fileReader.readListSets();
			new RunnerLogic().doLogic(sets);
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}
}