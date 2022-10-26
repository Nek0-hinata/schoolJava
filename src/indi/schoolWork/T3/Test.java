package indi.schoolWork.T3;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    private static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {

//        T1();
//        T2();
//        T3();
//        T4();
//        T5();
//        T6();
//        T7();
        System.out.println("输出枪毙号码");
        T8(SC.nextInt());

    }

    private static void T1() {
        System.out.println("hello world".toUpperCase());
        System.out.println("MAYBE".toLowerCase());
        System.out.println("concat one".concat(" + concat two"));
    }

    private static void T2() {
        System.out.println("today is 2022/10/19".charAt(0));
        System.out.println("this is string".charAt(13));
    }

    private static void T3() {
        System.out.println("字符串数字剔除");
        String str = SC.next();
        System.out.println(str.replaceAll("\\d+", "*"));
    }

    private static void T4() {
        System.out.println(Math.max(0, 2));
        System.out.println(Math.min(10, 1));
        System.out.println(Math.abs(-11111));
    }

    private static void T5() {
        System.out.println("日期计算：");
        LocalDate startDate = LocalDate.of(SC.nextInt(), SC.nextInt(), SC.nextInt());
        LocalDate endDate = LocalDate.of(SC.nextInt(), SC.nextInt(), SC.nextInt());
        Utils.calculateDate(startDate, endDate);
    }

    private static void T6() {
        System.out.println("给定年月，输出日历:");
        LocalDate startDate = LocalDate.of(1900, 1, 1);
        LocalDate endDate = LocalDate.of(SC.nextInt(), SC.nextInt(), 1);
        long weekDay = Utils.calculateDate(startDate, endDate);
        if (weekDay <= 0) {
            System.out.println("无法计算咯");
        } else {
            long delta = weekDay % 7;
            weekDay %= 7;
            while (weekDay-- > 0) {
                System.out.printf("%-2d", 0);
                System.out.print(" ");
            }
            int days = 1;
            while (days <= Utils.DaysOfMonth(endDate.getMonthValue())) {
                System.out.printf("%-2d", days);
                System.out.print(" ");
                if ((days++ + delta) % 7 == 0) {
                    System.out.println();
                }
            }
        }
    }

    private static void T7() {
        Scanner SC = new Scanner(System.in);
        SC.useDelimiter("[^0-9]");
        double sum = 0;
        int times = 0;
        while(!SC.hasNext("#$")) {
//            sum += Double.parseDouble(SC.next());
            System.out.println(SC.next());
            times++;
        }
        System.out.println("总分：" + sum);
        System.out.println("平均分为：" + times);
    }

    private static void T8(int n) {
        System.out.println("输入待求解人数");
        int nums = SC.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> fin = new ArrayList<>();
        for (int i = 1; i <= nums; i++) {
            list.add(i);
        }
        int t = 0;
        final int interval = n - 1;
        while (list.size() > 0) {
            t += interval;
            t = t > list.size() - 1 ? t % list.size() : t;
            System.out.println(list.get(t));
            fin.add(list.get(t));
            list.remove(t);
        }
        System.out.println(fin.get(fin.size() - 1));
    }

}

class Utils {

    public static long calculateDate(LocalDate startDate, LocalDate endDate) {
        Period period = Period.between(startDate, endDate);
        Duration duration = Duration.between(LocalDateTime.of(startDate.getYear(), startDate.getMonth(), startDate.getDayOfMonth(), 0, 0, 0),
                LocalDateTime.of(endDate.getYear(), endDate.getMonth(), endDate.getDayOfMonth(), 0, 0, 0));
        System.out.println("相差" + period.getYears() + "年" + period.getMonths() + "月" + period.getDays() + "日" + "，共计" + duration.toDays() + "天");
        return duration.toDays();
    }

    public static int DaysOfMonth(int month) {
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> 28;
            default -> -1;
        };
    }

}