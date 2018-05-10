package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class JoinTest {
    @Test
    public void whenArray14AndArray32ThenArray1234() {
        int[] input1 = {1, 4};
        int[] input2 = {3, 2};
        int[] expected = {1, 2, 3, 4};
        int[] result = Join.join(input1, input2);
        assertThat(result, is(expected));
    }

}