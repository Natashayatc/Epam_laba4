package com.epam.natasha_yatcenya.j04_collection;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import com.epam.natasha_yatcenya.j04_collection.RunnerLogic;
import com.epam.natasha_yatcenya.j04_collection.CSVReader;
public class Runner {

	public static void main(String[] args) {

		String fileName = "/Users/nikitastepanov/IdeaProjects/Rsreu/Epam_laba4/Collection/src/com/epam/natasha_yatcenya/j04_collection/integers.txt";
		try {
			CSVReader fileReader = new CSVReader();
			List<Set<Integer>> sets = fileReader.readListSets(fileName);
			new RunnerLogic().doLogic(sets);
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}
}