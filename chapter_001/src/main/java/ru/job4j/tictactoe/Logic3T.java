package ru.job4j.tictactoe;

public class Logic3T {
    private final Figure3T[][] table;
    private enum ExpectedMark { X, O };
    private ExpectedMark mark = ExpectedMark.X;
    private static int[][][] combinations = {
            {{0, 0}, {1, 0}, {2, 0}},
            {{0, 1}, {1, 1}, {2, 1}},
            {{0, 2}, {1, 2}, {2, 2}},
            {{0, 0}, {0, 1}, {0, 2}},
            {{1, 0}, {1, 1}, {1, 2}},
            {{2, 0}, {2, 1}, {2, 2}},
            {{2, 0}, {1, 1}, {0, 2}},
            {{0, 0}, {1, 1}, {2, 2}}
    };

    public boolean expectedMarkX() {
        boolean result = false;
        if (this.mark == ExpectedMark.X) {
            result = true;
        }
        return result;
    }

    public void changeExpectedMark() {
        if (this.mark == ExpectedMark.X) {
            this.mark = ExpectedMark.O;
        } else {
            this.mark = ExpectedMark.X;
        }
    }

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean isWinnerX() {
        return combinations(ExpectedMark.X);
    }

    public boolean isWinnerO() {
        return combinations(ExpectedMark.O);
    }

    private boolean combinations(ExpectedMark marks) {
        boolean result = false;
        for (int[][] out : combinations) {
            Figure3T firstField = this.table[out[0][0]][out[0][1]];
            Figure3T secondField = this.table[out[1][0]][out[1][1]];
            Figure3T thirdField = this.table[out[2][0]][out[2][1]];
            if (ExpectedMark.X == marks) {
                if (firstField.hasMarkX() && secondField.hasMarkX() && thirdField.hasMarkX()) {
                    result = true;
                    break;
                }
            } else if (ExpectedMark.O == marks) {
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