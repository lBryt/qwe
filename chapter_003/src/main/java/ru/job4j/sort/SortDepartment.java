package ru.job4j.sort;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class SortDepartment {

    public Set sortReverse(Set source) {
        Set<String> reverse = new TreeSet<String>(Comparator.reverseOrder());
        reverse.addAll(source);
        return reverse;
    }
}
