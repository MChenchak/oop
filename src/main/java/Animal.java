// Для запрета переопределеения методов в классах-потомках в Java шспользуется модификатор final

public class Animal {

    final void run() {
        System.out.println("Животное бежит");
    }
}

class Dog extends Animal{

    // переопределение run() невозможно, т.к это "финальный" меетод в классе-родителе
    void run() {

    }
}
