package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactorialTest {
    @Test
    public void whenFactorialWith5Then120() {
        Factorial factorial = new Factorial();
        int expected = factorial.calc(5);
        assertThat(120, is(expected));
    }
}