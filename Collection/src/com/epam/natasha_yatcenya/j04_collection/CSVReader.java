package com.epam.natasha_yatcenya.j04_collection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CSVReader {

    private static final String CSV_DELIMITER = ",";

    public List<Set<Integer>> readListSets(String filename) throws IOException {

        List<Set<Integer>> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String rawLists[] = line.split(CSV_DELIMITER);
                Set<Integer> current = getSetFromLine(rawLists);
                result.add(current);
            }
        }
        return result;
    }

    private Set<Integer> getSetFromLine(String... rawLine) {
        Set<Integer> result = new TreeSet<>();
        for (String value : rawLine) {
            result.add(Integer.parseInt(value.trim()));
        }
        return result;
    }
}

