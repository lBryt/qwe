package ru.job4j.sort;

import java.util.*;


public class SortUser {
    public Set<User> sort(List<User> users) {
        return new TreeSet<>(users);
    }
}
