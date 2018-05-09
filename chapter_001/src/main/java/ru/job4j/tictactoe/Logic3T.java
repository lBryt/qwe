package ru.job4j.tictactoe;

import javafx.scene.input.MouseButton;

import java.util.Arrays;

public class Logic3T {
    private final Figure3T[][] table;
    private enum Marks { X, O };
    private static int[][][]  combinations = {
            {{0, 0}, {1, 0}, {2, 0}},
            {{0, 1}, {1, 1}, {2, 1}},
            {{0, 2}, {1, 2}, {2, 2}},

            {{0, 0}, {0, 1}, {0, 2}},
            {{1, 0}, {1, 1}, {1, 2}},
            {{2, 0}, {2, 1}, {2, 2}},

            {{2, 0}, {2, 1}, {0, 2}},
            {{0, 0}, {1, 1}, {2, 2}}
    };

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean isWinnerX() {
        return combinations(Marks.X);
    }

    public boolean isWinnerO() {
        return combinations(Marks.O);
    }

    private boolean combinations(Marks marks) {
        boolean result = false;
        for (int[][] out : combinations) {
            Figure3T firstField = this.table[out[0][0]][out[0][1]];
            Figure3T secondField = this.table[out[1][0]][out[1][1]];
            Figure3T thirdField = this.table[out[2][0]][out[2][1]];
            if (Marks.X == marks) {
                if (firstField.hasMarkX() && secondField.hasMarkX() && thirdField.hasMarkX()) {
                    result = true;
                    break;
                }
            } else if (Marks.O == marks) {
                if (firstField.hasMarkO() && secondField.hasMarkO() && thirdField.hasMarkO()) {
                    result = true;
                    break;
                }
            }

        }
        return result;
    }

    public boolean hasGap() {
        boolean result = false;
        exitLoops:
        for (Figure3T[] row : this.table) {
            for (Figure3T fild : row) {
                if (!fild.hasMarks()) {
                    result = true;
                    break exitLoops;
                }
            }
        }

        return result;
    }
}