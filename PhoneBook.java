package ru.geekbrains.j2l3;

import java.util.*;

public class PhoneBook {
    private HashMap<Long, String> subscriber = new HashMap<>();

    public void add(Long phoneNumber, String surname) {
        this.subscriber.put(phoneNumber, surname);
    }

    public void get(String surname) {
        Set<Map.Entry<Long, String>> set = subscriber.entrySet();
        for(Map.Entry<Long, String> o : set) {
            if(o.getValue() == surname) {
                System.out.println(o.getValue() + ": " + o.getKey());
            }
        }
    }
}
