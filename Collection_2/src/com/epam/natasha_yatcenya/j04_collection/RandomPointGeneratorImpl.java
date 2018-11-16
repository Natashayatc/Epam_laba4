package com.epam.natasha_yatcenya.j04_collection;

import java.util.Random;

public class RandomPointGeneratorImpl implements PointGenerator {

    private Random random = new Random();
    private int min = 10;
    private int max = 10;

    public RandomPointGeneratorImpl() {
    }

    public RandomPointGeneratorImpl(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public Point generate() {
        int x = random.nextInt(max - min + 1) + min;
        int y = random.nextInt(max - min + 1) + min;

        return new Point(x, y);
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
