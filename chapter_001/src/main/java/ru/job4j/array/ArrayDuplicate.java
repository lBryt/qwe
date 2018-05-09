package ru.job4j.array;

import java.util.Arrays;

public class ArrayDuplicate {
    public String[] removeDuplicates(String[] array) {
        int lastIndex = array.length;
        for (int out = 0; out != lastIndex; out++) {
                for (int in = out + 1; in != lastIndex; in++) {
                if (array[out].equals(array[in])) {
                    array[in] = array[--lastIndex];
                    in--;
                }
            }
        }
        return Arrays.copyOf(array, lastIndex);
    }
}
