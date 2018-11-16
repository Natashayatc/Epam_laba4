package com.epam.natasha_yatcenya.j04_collection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Surface {
    private Set<Point> points = new HashSet<>();
    private Set<Line> lines = new HashSet<>();

    public Surface() {
    }

    public void addPoint(Point point) {
        points.add(point);
    }

    public void addPoints(List<Point> points) {
        this.points.addAll(points);
    }

    public void addLine(Line line) {
        lines.add(line);
    }

    @Override
    public String toString() {
        return "Surface{" +
                "points=" + points +
                ", lines=" + lines +
                '}';
    }

    public Set<Line> getLines() {
        return lines;
    }

    public Set<Point> getPoints() {
        return points;
    }

    public void addLines(List<Line> lines) {
        this.lines.addAll(lines);
    }
}
