package com.epam.natasha_yatcenya.j04_collection;

public class Line {

    private Point point1;
    private Point point2;

    public Line(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    public boolean contains(Point point) {
        float vectorX = getPoint2().getX() - getPoint1().getX();
        float vectorY = getPoint2().getY() - getPoint1().getY();

        Point linePoint1 = getPoint1();
        Point linePoint2 = getPoint2();

        return ((point.getX() - linePoint1.getX()) / vectorX == (point.getY() - linePoint1.getY()) / vectorY);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        if (!point1.equals(line.point1)) return false;
        return point2.equals(line.point2);

    }

    @Override
    public int hashCode() {
        int result = point1.hashCode();
        result = 31 * result + point2.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Line(" + point1 + "; " + point2 + ')';
    }
}

