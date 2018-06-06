package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    private UserConvert convert;

    @Before
    public void start() {
        convert = new UserConvert();
    }

    @Test
    public void whenConvertListThenGetHashMapWithKeyIdValueUser() {
        User user = new User(1, "name", "city");
        List<User> list = new ArrayList<>(Arrays.asList(user));
        Map<Integer, User> result = convert.process(list);
        Map<Integer, User> expect = new HashMap<Integer, User>();
        expect.put(user.getId(), user);
        assertThat(result, is(expect));
    }
}