package indi.schoolWork.calc;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class utils {

    public static double add(double a, double b) {
        return BigDecimal.valueOf(a).add(BigDecimal.valueOf(b)).setScale(5, RoundingMode.HALF_DOWN).doubleValue();
    }

    public static double divide(double a, double b) {
        BigDecimal Da = BigDecimal.valueOf(a);
        BigDecimal Db = BigDecimal.valueOf(b);
        if (!Db.equals(new BigDecimal(0))) {
            return Da.divide(Db, 5, RoundingMode.HALF_DOWN).doubleValue();
        } else {
            return 0;
        }
    }

    public static double multiply(double a, double b) {
        return BigDecimal.valueOf(a).multiply(BigDecimal.valueOf(b)).setScale(5, RoundingMode.HALF_DOWN).doubleValue();
    }

    public static double sub(double a, double b) {
        return BigDecimal.valueOf(a).subtract(BigDecimal.valueOf(b)).setScale(5, RoundingMode.HALF_DOWN).doubleValue();
    }

}