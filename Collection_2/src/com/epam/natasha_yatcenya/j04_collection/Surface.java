package com.epam.natasha_yatcenya.j04_collection;

import java.util.HashSet;
import java.util.Set;

public class Surface {

    private Set<Point> pointList = new HashSet<>();
    private Set<Line> lineList = new HashSet<>();

    public Surface() {
    }

    public void addPoint(Point point) {


        if (point == null) {
            throw new IllegalArgumentException("point can't be null");
        }

        pointList.add(point);
    }

    public void addLine(Line line) {

        if (line == null) {
            throw new IllegalArgumentException("point can't be null");
        }

        lineList.add(line);
    }

    @Override
    public String toString() {
        return "Surface{" +
                "pointList=" + pointList +
                ", lineList=" + lineList +
                '}';
    }

    public Set<Line> getLineList() {
        return lineList;
    }

    public Set<Point> getPointList() {
        return pointList;
    }
}
