package com.epam.natasha_yatcenya.j04_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Ќа плоскости задано N точек. ¬ывести в файл описани€ всех пр€мых, которые
 * проход€т более чем через одну точку из заданных. ƒл€ каждой пр€мой
 * указать, через сколько точек она проходит. »спользовать класс HashMap.
 */
public class Runner {

    public static void main(String[] args) {
        Surface surface = new Surface();
        PointGenerator pointGenerator = new RandomPointGeneratorImpl(0, 100);

        List<Point> points = initPoints(pointGenerator, 5);
        surface.addPoints(points);

        List<Line> lines = initLines(pointGenerator, 5);
        surface.addLines(lines);

        Map<Line, Long> map = neighbourLines(surface);

        System.out.println();
        for (Map.Entry<Line, Long> item : map.entrySet()) {
            System.out.println(item.getKey() + ": " + item.getValue());
        }
        System.out.println();
    }

    private static Map<Line, Long> neighbourLines(Surface surface) {
        HashMap<Line, Long> map = new HashMap<>();

        Map<Line, Long> collect = surface.getLines().stream()
                .collect(Collectors.toMap(Function.identity(), line ->
                        surface.getPoints().stream()
                                .filter(line::contains)
                                .count())
                );

        for (Line line : surface.getLines()) {
            long i = 0;

            for (Point point : surface.getPoints()) {
                boolean isBelong = line.contains(point);

                if (isBelong) {
                    i++;
                }
            }
            map.put(line, i);
        }
        System.out.println(map.equals(collect));

        return map;
    }

    private static List<Point> initPoints(PointGenerator pointGenerator, int count) {
        List<Point> points = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            points.add(pointGenerator.generate());
        }

        List<Point> somePoints = Arrays.asList(
                new Point(0, 0),
                new Point(1, 0),
                new Point(0, 1),
                new Point(5, 5),
                new Point(0, 5),
                new Point(5, 0),
                new Point(2, 2),
                new Point(6, 7),
                new Point(1, 5),
                new Point(5, 1),
                new Point(1, 1)
        );

        points.addAll(somePoints);
        return points;
    }

    private static List<Line> initLines(PointGenerator pointGenerator, int count) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Point p1 = pointGenerator.generate();
            Point p2 = pointGenerator.generate();
            Line line = new Line(p1, p2);
            lines.add(line);
        }

        List<Line> someLines = Arrays.asList(
                new Line(new Point(0, 0), new Point(10, 10)),
                new Line(new Point(0, 0), new Point(10, 0)),
                new Line(new Point(0, 0), new Point(0, 10)),
                new Line(new Point(1, 1), new Point(1, 10)),
                new Line(new Point(1, 1), new Point(10, 1)),
                new Line(new Point(2, 1), new Point(10, 2)),
                new Line(new Point(2, 1), new Point(2, 10)),
                new Line(new Point(7, 7), new Point(1, 4)),
                new Line(new Point(3, 4), new Point(8, 8)),
                new Line(new Point(1, 1), new Point(5, 7))
        );

        lines.addAll(someLines);
        return lines;
    }
}



