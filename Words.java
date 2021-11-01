package ru.geekbrains.j2l3;

import java.util.*;

public class Words {
    public static void printWords() {
        ArrayList<String> allWords = new ArrayList<>(Arrays.asList(
                "Here", "Come", "Old", "Flat", "Top",
                "He", "Come", "Grooving", "Up", "Slowly",
                "He", "Got", "Joo", "Joo", "Eyeball",
                "He", "One", "Holy", "Roller", "He", "Got"
        ));

        LinkedHashSet<String> set = new LinkedHashSet<>(allWords);

        System.out.println("Список уникальных слов: " + set);
        System.out.println("Количество всех слов: [" + allWords.size() + "]");
        System.out.println("Количество уникальных слов: [" + set.size() + "]");
    }
}
