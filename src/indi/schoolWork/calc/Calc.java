package indi.schoolWork.calc;

import java.util.Scanner;

public class Calc {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        int n = scanner.nextInt();
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i*i;
        }
        System.out.println(utils.add(a, b));
        System.out.println(utils.divide(a, b));
        System.out.println(utils.sub(a, b));
        System.out.println(utils.multiply(a, b));
        System.out.println(sum);
    }
}

