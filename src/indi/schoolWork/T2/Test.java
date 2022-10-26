package indi.schoolWork.T2;

import java.util.Scanner;

public class Test {

    private static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {

        Counter counter = new Counter();
        System.out.println(counter.getCounterValue());
        counter.increment();
        System.out.println(counter.getCounterValue());
        counter.reset();
        System.out.println(counter.getCounterValue());
        counter.decrement();
        System.out.println(counter.getCounterValue());

        Rectangle rectangle = new Rectangle(10, 20);
        System.out.println(rectangle.S());
        System.out.println(rectangle.C());

        Student student = new Student("20101020313", "叶孟琦", "男", 203, 20);
        System.out.println(student);
        student.setAge(21);
        System.out.println(student);

        Cat cat = new Cat("大黑", "3");
        cat.sleep();
        System.out.println(cat.showProfile());

        Dog dog = new Dog("小白", "5");
        cat.sleep();
        dog.run();
        System.out.println(dog.showProfile());

        System.out.println(cat.speak());
        System.out.println(dog.speak());

    }

}

class Counter {

    private int counterValue = 0;

    public void increment() {
        counterValue++;
    }

    public void decrement() {
        counterValue--;
    }

    public void reset() {
        counterValue = 0;
    }

    public int getCounterValue() {
        return counterValue;
    }
}

class Rectangle {

    private final double a;

    private final double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double C () {
        return a + b;
    }

    public double S() {
        return a * b;
    }

}

class Student {

    private final String id;

    private final String name;

    private final String gender;

    private final int classId;

    private int age;

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getClassId() {
        return classId;
    }

    public int getAge() {
        return age;
    }

    public Student(String id, String name, String gender, int classId, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.classId = classId;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", classId=" + classId +
                ", age=" + age +
                '}';
    }
}

abstract class Animal implements IAnimal {

    protected String name;

    protected String age;

    public String showProfile() {
        return name + age;
    }

    public String speak() {
        return "my name is " + name + "i'm " + age + "years old.";
    }

}

class Cat extends Animal implements ICat {

    public Cat(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public void sleep() {
        System.out.println("sleep");
    }

    @Override
    public String speak() {
        return "I'm cat";
    }
}

class Dog extends Animal implements IDog {

    public Dog(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public void run() {
        System.out.println("run");
    }

    @Override
    public String speak() {
        return "I'm dog";
    }
}