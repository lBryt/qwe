package ru.job4j.pseudo;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SquareTest {
    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        assertThat(
                square.pic(),
                is(
                        new StringBuilder()
                                .append("***" + System.lineSeparator())
                                .append("***" + System.lineSeparator())
                                .append("***")
                                .toString()
                )
        );
    }
}