package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

public class PointTest {

    @Test
    public void whemPointx1y4AndPointx5y1Then5() {
        Point a = new Point(1, 4);
        Point b = new Point(5, 1);
        double distance = a.distanceTo(b);
        assertThat(distance, closeTo(5, 0.1));
    }
}