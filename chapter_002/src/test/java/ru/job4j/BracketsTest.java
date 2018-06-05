package ru.job4j;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BracketsTest {
    private Brackets brackets;
    @Before
    public void start() {
        brackets = new Brackets();
        brackets.add('(', ')');
        brackets.add('{', '}');
        brackets.add('[', ']');
    }

    @Test
    public void thenOddNumberThemFalse() {
        boolean result = brackets.validation("{[{}]");
        assertThat(result, is(false));
    }

    @Test
    public void thenInvalidThemFalse() {
        boolean result = brackets.validation("{[}]");
        assertThat(result, is(false));
    }

    @Test
    public void thenValidThemTrue() {
        boolean result = brackets.validation("{{{}{}[()()][]}}");
        assertThat(result, is(true));
    }
}