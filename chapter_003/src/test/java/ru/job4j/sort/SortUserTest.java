package ru.job4j.sort;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SortUserTest {
    private List<User> users = new ArrayList<>();
    private SortUser sort = new SortUser();

    @Before
    public void start() {
        users.add(new User("Сергей", 25));
//        users.add(new User("Иван", 30));
//        users.add(new User("Сергей", 20));
        users.add(new User("Иван", 25));
    }

    @Test
    public void whenUserListSortByAgeThemGetListSortedInAscendingOrder() {
        System.out.println(sort.sort(users));
    }
}