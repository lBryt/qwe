package ru.job4j.pseudo;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TriagleTest {
    @Test
    public void whenDrawSquare() {
        Triagle triagle = new Triagle();
        assertThat(
                triagle.pic(),
                is(
                        new StringBuilder()
                        .append("  *  " + System.lineSeparator())
                        .append(" *** " + System.lineSeparator())
                        .append("*****")
                        .toString()
                )
        );
    }
}