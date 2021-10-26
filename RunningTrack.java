package ru.geekbrains.j2l1;

public class RunningTrack implements Obstacles {
    private String object;
    private int difficult;

    public RunningTrack(String object, int difficult) {
        this.object = object;
        this.difficult = difficult;
    }

    public void action(Objects objects) {
        if(objects.getPower() >= difficult) {
            objects.run();
            System.out.println(objects.getName() + " ran the " + object);
        }
        else {
            objects.run();
            System.out.println(objects.getName() + " didn't run the " + object);
        }
    }
}
