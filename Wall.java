package ru.geekbrains.j2l1;

public class Wall implements Obstacles {
    private String object;
    private int difficult;

    public Wall(String object, int difficult) {
        this.object = object;
        this.difficult = difficult;
    }

    public void action(Objects objects) {
        if(objects.getPower() >= difficult) {
            objects.jump();
            System.out.println(objects.getName() + " jumped over the " + object);
        }
        else {
            objects.jump();
            System.out.println(objects.getName() + " didn't jump the " + object);
            return;
        }
    }
}
