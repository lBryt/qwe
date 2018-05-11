package ru.job4j.array;

import java.util.Arrays;

public class ArrayDuplicate {
    public String[] removeDuplicates(String[] array) {
        int size = array.length;
        for (int out = 0; out != size; out++) {
                for (int in = out + 1; in != size; in++) {
                if (array[out].equals(array[in])) {
                    array[in] = array[--size];
                    in--;
                }
            }
        }
        return Arrays.copyOf(array, size);
    }
}
