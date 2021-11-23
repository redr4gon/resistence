package br.com.resistence.network.util;

import br.com.resistence.network.utils.NumberUtil;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberUtilTest {

    @Test
    public void percentSuccessTest() {
        BigDecimal result = NumberUtil.toPercentage(30, 40);
        assertEquals("75.00", result.toString());

        result = NumberUtil.toPercentage(5, 10);
        assertEquals("50.00", result.toString());

        result = NumberUtil.toPercentage(1, 1000);
        assertEquals("1.00", result.toString());
    }
}
