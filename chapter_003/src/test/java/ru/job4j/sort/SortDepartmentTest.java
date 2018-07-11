package ru.job4j.sort;

import org.junit.Before;
import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortDepartmentTest {

    private SortDepartment sort;
    private Set<String> code;

    @Before
    public void start() {
        this.sort = new SortDepartment();
        this.code = new TreeSet<String>();
        this.code.add("K1");
        this.code.add("K1" + '\\' + "SK1");
        this.code.add("K2" + '\\' + "SK1" + '\\' + "SSK1");
        this.code.add("K1" + '\\' + "SK2");
        this.code.add("K1" + '\\' + "SK1" + '\\' + "SSK1");
        this.code.add("K1" + '\\' + "SK1" + '\\' + "SSK2");
        this.code.add("K2");
        this.code.add("K2" + '\\' + "SK1" + '\\' + "SSK2");
    }

    @Test
    public void whenSortAscending() {
        Set<String> set = this.code;
        String[] result = set.toArray(new String[set.size()]);
        String[] expected = new String[8];
        expected[0] = "K1";
        expected[1] = "K1" + '\\' + "SK1";
        expected[2] = "K1" + '\\' + "SK1" + '\\' + "SSK1";
        expected[3] = "K1" + '\\' + "SK1" + '\\' + "SSK2";
        expected[4] = "K1" + '\\' + "SK2";
        expected[5] = "K2";
        expected[6] = "K2" + '\\' + "SK1" + '\\' + "SSK1";
        expected[7] = "K2" + '\\' + "SK1" + '\\' + "SSK2";
        assertThat(expected, is(result));
    }

    @Test
    public void whenDecreasingOrder() {
        Set<String> set = this.sort.sortReverse(this.code);
        String[] result = set.toArray(new String[set.size()]);
        String[] expected = new String[8];
        expected[7] = "K1";
        expected[6] = "K1" + '\\' + "SK1";
        expected[5] = "K1" + '\\' + "SK1" + '\\' + "SSK1";
        expected[4] = "K1" + '\\' + "SK1" + '\\' + "SSK2";
        expected[3] = "K1" + '\\' + "SK2";
        expected[2] = "K2";
        expected[1] = "K2" + '\\' + "SK1" + '\\' + "SSK1";
        expected[0] = "K2" + '\\' + "SK1" + '\\' + "SSK2";
        assertThat(expected, is(result));
    }
}

