package taxonomy_conflict;

public class Character {
    private String name;
    private int level;
    private int health;
    private Race race;
}

class Race {
    protected String name;

    public void printRace() {
        System.out.println("I`m "  + name);
    }
}

class Human extends Race {

    Human() {
        this.name = "Human";
    }

    public static void main(String[] args) {
        Human h = new Human();
        h.printRace();
    }

    @Override
    public void printRace() {
        System.out.println("Happy new year");
    }
}

// В данном примере добавление новой расы (предроложим, что пишем компьютерную игру) осуществляется с помощью наследования.
// Достаточно добавить новый класс, расширяющий класс Race. При необходимости можно переопределить метод printRace(), и
// для каждой расы будет вызываться нужная реализация метода, без if-else...
// Добавление нового класса, наследника Race, можно аргументировать изменением постусловия метода printRace()



