package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class JoinTest {
    @Test
    public void whenArray14AndArray23ThenArray1234() {
        int[] input1 = {1, 4};
        int[] input2 = {2, 3};
        int[] expected = {1, 2, 3, 4};
        int[] result = new Join().join(input1, input2);
        assertThat(result, is(expected));
    }

}