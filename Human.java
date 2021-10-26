package ru.geekbrains.j2l1;

public class Human implements Objects {
    private String name;
    private int power;

    public Human(String name, int power) {
        this.name = name;
        this.power = power;
    }

    public void run() {
        System.out.println(name + " is running");
    }

    public void jump() {
        System.out.println(name + " is jumping");
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }
}
