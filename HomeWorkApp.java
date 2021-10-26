package ru.geekbrains.j2l1;

public class HomeWorkApp {
    public static void main(String[] args) {
        Objects[] objects = {
                new Human("Boris", 50),
                new Cat("Murzik", 30),
                new Robot("HUMANOID-2000", 800)
        };

        Obstacles[] obstacles = {
                new RunningTrack("Stadium track", 40),
                new Wall("Brick wall", 30)
        };

        for(int i = 0; i < obstacles.length; i++) {
            for(int j = 0; j < objects.length; j++) {
                obstacles[i].action(objects[j]);
            }
        }
    }
}
