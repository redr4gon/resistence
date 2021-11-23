package br.com.resistence.network.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberUtil {

    public static BigDecimal toPercentage(double number, double totalNumber){
        BigDecimal value1 = BigDecimal.valueOf(number);
        BigDecimal value2 = BigDecimal.valueOf(totalNumber);

        if (value2.equals(BigDecimal.ZERO)) {
            return BigDecimal.ZERO.setScale(2);
        }

        return value1.divide(value2, 2, RoundingMode.UP).multiply(BigDecimal.valueOf(100)).setScale(2);
    }
}
