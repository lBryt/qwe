package ru.job4j;

import java.util.Arrays;

/**
 * The class stores combinations of opening and closing brackets and checks them for validity.
 *
 * @author Ihor Bryt  (ihorbryt@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Brackets {
    private int position = 0;
    private Item[] items = new Item[0];

    /**
     * @param value to check valid brackets.
     * @return true if brackets valid closes.
     */
    public boolean validation(String value) {
        boolean result = true;
        for (int i = 0; i != value.length(); i++) {
            char symbol = value.charAt(i);
            int current = findIndexItem(symbol);
            if (current != -1) {
                int counter = 0;
                for (int j = i - 1; j >= 0; j--) {
                    int find = findIndexItem(value.charAt(j));
                    if (find != -1) {
                        if (find == current) {
                            if (counter != 0) {
                                result = false;
                                break;
                            }
                        } else {
                            if (items[find].open == value.charAt(j)) {
                                counter++;
                            } else {
                                counter--;
                            }
                        }
                    }
                }
            }
            if (!result) {
                break;
            }
        }
        return result;
    }

    private int findIndexItem(char symbol) {
        int result = -1;
        for (int index = 0; index != this.items.length; index++) {
            if (symbol == items[index].open || symbol == items[index].close) {
                result = index;
                break;
            }
        }
        return result;
    }

    public void add(char open, char close) {
        Item item = new Item(open, close);
        this.items = Arrays.copyOf(items, items.length + 1);
        items[position++] = item;
    }

    private class Item {
        private char open;
        private char close;

        Item(char open, char close) {
            this.open = open;
            this.close = close;
        }
    }
}