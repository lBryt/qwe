package ru.job4j.chess;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.white.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LogicTest {
    private Logic logic;
    @Before
    public void start() {
        this.logic = new Logic();
        logic.add(new PawnWhite(Cell.A2));
        logic.add(new PawnWhite(Cell.B2));
        logic.add(new PawnWhite(Cell.C2));
        logic.add(new PawnWhite(Cell.D2));
        logic.add(new RookWhite(Cell.A1));
        logic.add(new KnightWhite(Cell.B1));
        logic.add(new BishopWhite(Cell.C1));
        logic.add(new QeenWhite(Cell.D1));
        logic.add(new KingWhite(Cell.E1));
        logic.add(new BishopWhite(Cell.F1));
        logic.add(new KnightWhite(Cell.G1));
        logic.add(new RookWhite(Cell.H1));
    }

    @Test
    public void thenStepPawnD2D4ThemMoveTrue() {
        boolean move = logic.move(Cell.D2, Cell.D4);
        assertThat(true, is(move));
    }

    @Test
    public void thenStepPawnD2B4ThemMoveFalse() {
        boolean move = logic.move(Cell.D2, Cell.B4);
        assertThat(false, is(move));
    }

    @Test
    public void thenStepKnightD2B4ThemMoveFalse() {
        boolean move = logic.move(Cell.B1, Cell.D2);
        assertThat(false, is(move));
    }

    @Test
    public void thenStepKnightB1C3ThemMoveTrue() {
        boolean move = logic.move(Cell.B1, Cell.C3);
        assertThat(true, is(move));
    }

    @Test
    public void thenStepQeenD1D4ThemMoveFalse() {
        boolean move = logic.move(Cell.D1, Cell.D4);
        assertThat(false, is(move));
    }

    @Test
    public void thenStepQeenD1H5ThemMoveTrue() {
        boolean move = logic.move(Cell.D1, Cell.H5);
        assertThat(true, is(move));
    }

    @Test
    public void thenStepRookH1H5ThemMoveTrue() {
        boolean move = logic.move(Cell.H1, Cell.H5);
        assertThat(true, is(move));
    }

    @Test
    public void thenStepRookA1A5ThemMoveFalse() {
        boolean move = logic.move(Cell.A1, Cell.A5);
        assertThat(false, is(move));
    }

    @Test
    public void thenStepBishopC1G5ThemMoveFalse() {
        boolean move = logic.move(Cell.C1, Cell.G5);
        assertThat(false, is(move));
    }

    @Test
    public void thenStepBishopF1G5ThemMoveTrue() {
        boolean move = logic.move(Cell.F1, Cell.B5);
        assertThat(true, is(move));
    }

    @Test
    public void thenStepKingE1G3ThemMoveFalse() {
        boolean move = logic.move(Cell.E1, Cell.G3);
        assertThat(false, is(move));
    }

    @Test
    public void thenStepKingE1F2ThemMoveTrue() {
        boolean move = logic.move(Cell.E1, Cell.F2);
        assertThat(true, is(move));
    }
}