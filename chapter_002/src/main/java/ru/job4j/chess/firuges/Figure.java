package ru.job4j.chess.firuges;

import java.util.Arrays;

public interface Figure {
    Cell position();

    Cell[] way(Cell source, Cell dest);

    default String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );

    }

    default Cell[] tracer(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        boolean moveX = source.x != dest.x;
        boolean moveY = source.y != dest.y;
        int x = source.x;
        int y = source.y;
        while (dest.y != y || dest.x != x) {
            if (moveX) {
                x += (source.x - dest.x < 0 ? 1 : -1);
            }
            if (moveY) {
                y += (source.y - dest.y < 0 ? 1 : -1);
            }
            steps = Arrays.copyOf(steps, steps.length + 1);
            steps[steps.length - 1] =  Cell.findCell(x, y)[0];
        }
        return steps;
    }

    Figure copy(Cell dest);

}
