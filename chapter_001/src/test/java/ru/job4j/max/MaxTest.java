package ru.job4j.max;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxTest {
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, Is.is(2));
    }
}