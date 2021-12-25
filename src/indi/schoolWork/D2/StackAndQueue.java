package indi.schoolWork.D2;

import indi.structures.queue.LinkedQueue;
import indi.structures.stack.SeqStack;

import java.util.Objects;
import java.util.Scanner;

public class StackAndQueue {
    public static void main(String[] args) {
        LinkedQueue<Cars> LQ = new LinkedQueue<>();
        SeqStack<Cars> Park = new SeqStack<>();
        Scanner scanner = new Scanner(System.in);
        int maxCars = scanner.nextInt();
        double fees = scanner.nextDouble();
        int status = scanner.nextInt();
        int num = scanner.nextInt();
        int times = scanner.nextInt();
        while (status != 0 || num != 0 || times != 0) {
            // 汽车离开
            if (status == 1) {
                if (LQ.find(new Cars(num))) {
                    int size = LQ.size() - 1;
                    while (size != 0) {
                        if (!LQ.peek().equals(new Cars(num))) {
                            LQ.push(LQ.pop());
                            size--;
                        } else {
                            LQ.pop();
                        }
                    }
                } else if (Park.find(new Cars(num))) {
                    var tmp = new SeqStack<Cars>();
                    while (!Park.peek().equals(new Cars(num))) {
                        tmp.push(Park.pop());
                    }
                    var t = Park.pop();
                    System.out.println(t.getNum() + " " + fees * (times - t.getTime()));
                    while (!tmp.isEmpty()) {
                        Park.push(tmp.pop());
                    }
                    if (!LQ.isEmpty()) {
                        Cars temp = LQ.pop();
                        temp.setTime(times);
                        Park.push(temp);
                    }
                }
            } else {  //汽车进入
                if (Park.size() >= maxCars) {
                    LQ.push(new Cars(num, times));
                } else {
                    Park.push(new Cars(num, times));
                }
            }
            status = scanner.nextInt();
            num = scanner.nextInt();
            times = scanner.nextInt();
        }
        while (!Park.isEmpty()) {
            System.out.print(Park.pop().getNum() + " ");
        }
        System.out.println();
        while (!LQ.isEmpty()) {
            System.out.print(LQ.pop().getNum() + " ");
        }
    }
}

class Cars {
    private final int num;
    private int time;

    Cars(int num, int times) {
        this(num);
        this.time = times;
    }

    Cars(int num) {
        this.num = num;
    }

    Cars() {
        this.num = -1;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public int getNum() {
        return num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars = (Cars) o;
        return getNum() == cars.getNum();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNum());
    }
}