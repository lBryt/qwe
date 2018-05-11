package ru.job4j.array;

public class Join {

    /**
     * Метод получает два отсортированых массива и возвращае объдененный отсортированный массив.
     */
    public int[] join(int[] array, int[] array2) {
        int size = array.length + array2.length;
        int[] result = new int[size];
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i != size; i++) {
            if (array.length == count1) {
                result[i] = array2[count2++];
            } else if (array2.length == count2) {
                result[i] = array[count1++];
            } else if (array[count1] > array2[count2]) {
                result[i] = array2[count2++];
            } else {
                result[i] = array[count1++];
            }
        }
        return result;
    }
}
