package ru.geekbrains.j2l3;

public class HomeWorkApp {
    public static void main(String[] args) {
        Words.printWords();

        PhoneBook phonebook = new PhoneBook();

        phonebook.add(61575l, "Wachowski");
        phonebook.add(88005553535l,"Obama");
        phonebook.add(21235l,"Vulovic");
        phonebook.add(75839461873l,"Wachowski");
        phonebook.add(9845752l,"Jagger");

        phonebook.get("Wachowski");
        phonebook.get("Obama");
        phonebook.get("Vulovic");
        phonebook.get("Jagger");
    }
}
