package indi.schoolWork.T1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Test {

    private static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        Q1();
        Q2();
        Q3();
        Q4();
        Q5();
        Q6();
        Q7();
        Q8();
        Q9();
    }

    private static void Q1() {
        int sum = 0;
        int n = 0;
        n = SC.nextInt();
        while (n != 0) {
            sum += n;
            sum /= 2;
            n = SC.nextInt();
        }
        System.out.println(sum);
    }

    private static void Q2() {
        int[] num = new int[11];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 10; i++) {
            num[i] = SC.nextInt();
            min = Integer.min(num[i], min);
            max = Integer.max(num[i], max);
        }
        System.out.println(min);
        System.out.println(max);
    }

    private static void Q3() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + "x" + j + "=" + i * j + " ");
            }
            System.out.println();
        }
    }

    private static void Q4() {
        int[][] num = new int[10][10];
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                num[i][j] = i * j;
            }
        }
        int x = SC.nextInt();
        int y = SC.nextInt();
        System.out.println(num[x][y]);
    }

    private static void Q5() {
        int n = SC.nextInt();
        StringBuilder str = new StringBuilder();
        for (int i = 2; i < Math.sqrt(n); i++) {
            while (true) {
                if (n % i == 0) {
                    str.append(i).append(" ");
                    n /= i;
                } else break;
            }
        }
        System.out.println(str);
    }

    private static void Q6() {
        int out = 0;
        int n = SC.nextInt();
        out = switch (n) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> 28;
            default -> -1;
        };
        System.out.println(out != -1 ? out : "输入错误");
    }

    private static void Q7() {
        for (int i = 0; i < 58; i++) {
            if (i < 26 || i > 31) System.out.println((char) ('A' + i));
        }
    }

    private static void Q8() {
        BigDecimal in = SC.nextBigDecimal();
        int n = 1;
        BigDecimal sum = BigDecimal.valueOf(0);
        while (sum.compareTo(in) < 0) {
            sum = sum.add(Utils.fact(n++));
        }
        System.out.println(--n);
    }

    private static void Q9() {
        final BigDecimal stageOne = BigDecimal.valueOf(0.6);
        final BigDecimal stageTwo = BigDecimal.valueOf(1.1);
        final BigDecimal stageThree = BigDecimal.valueOf(1.7);
        BigDecimal in = SC.nextBigDecimal();
        BigDecimal sum = in.compareTo(BigDecimal.valueOf(90)) >= 0 ? stageOne.multiply(BigDecimal.valueOf(90)).add(
                in.compareTo(BigDecimal.valueOf(150)) >= 0 ? stageTwo.multiply(BigDecimal.valueOf(150 - 90)).add(
                        stageThree.multiply(in.subtract(BigDecimal.valueOf(150)))
                ) : stageTwo.multiply(in.subtract(BigDecimal.valueOf(90)))
        ) : stageOne.multiply(in);
        System.out.println(sum);
    }

}

class Utils {
    public static BigDecimal fact(int n) {
        if (n == 1 || n == 0) {
            return BigDecimal.valueOf(1);
        } else return BigDecimal.valueOf(n).multiply(fact(n - 1));
    }

}
