package ru.job4j.array;

public class Join {

    /**
     * Метод объединяет и сортирует два массив.
     */
    public static int[] join(int[] array1, int[] array2) {
        int size = array1.length + array2.length;
        int[] array = new int[size];
        array1 = sort(array1);
        array2 = sort(array2);
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i != size; i++) {
            if (array1.length == count1) {
                array[i] = array2[count2++];
            } else if (array2.length == count2) {
                array[i] = array1[count1++];
            } else if (array1[count1] > array2[count2]) {
                array[i] = array2[count2++];
            } else {
                array[i] = array1[count1++];
            }
        }
        return array;
    }

    private static int[] sort(int[] array) {
        for (int i = 0; i != array.length - 1; i++) {
            if (array[i + 1] < array[i]) {
                array = new BubbleSort().sort(array);
                break;
            }
        }
        return array;
    }
}
