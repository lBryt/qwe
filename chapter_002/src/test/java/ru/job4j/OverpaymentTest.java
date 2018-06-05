package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class OverpaymentTest {

    @Test
    public void thenPrice35AndPayment52ThemSurrenderTenFiveTwo() {
        Overpayment overpayment = new Overpayment(35, 52, new int[]{10, 5, 2, 1});
        int[] result = overpayment.returnOverpay();
        int[] expected = new int[]{10, 5, 2};
        assertThat(result, is(expected));
    }
}