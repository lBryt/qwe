package ru.job4j;

import java.util.Arrays;

/**
 * Class for cash of cash to the client.
 *
 * @author Ihor Bryt  (ihorbryt@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public final class Overpayment {
    private final int price;
    private final int payment;
    /**
     * array cash for to return overpayment.
     * The array must be sorted in descending order.
     * The quantity of cash is unlimited.
     */
    private final int[] cash;

    public Overpayment(int price, int payment, int[] cash) {
        this.price = price;
        this.payment = payment;
        this.cash = cash;
    }

    /**
     * @return array of cash for refund.
     */
    public final int[] returnOverpay()  {
        int[] result = new int[0];
        int repayment = 0;
        while (this.payment > this.price + repayment) {
            for (int value : this.cash) {
                if (value <= this.payment - (this.price + repayment)) {
                    repayment += value;
                    result = this.add(result, value);
                    break;
                }
            }
        }
        return result;
    }

    private int[] add(int[] result, final int coin) {
        result = Arrays.copyOf(result, result.length + 1);
        result[result.length - 1] = coin;
        return result;
    }
}
