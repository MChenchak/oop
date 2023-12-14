```java
class Animal {
    void makeSound() {
        System.out.println("Some sound");
    }
}

class Dog extends Animal {
    void makeSound() {
        System.out.println("Bark");
    }
}

class Cat extends Animal {
    void makeSound() {
        System.out.println("Meow");
    }
}

public class DynamicBindingExample {
    public static void main(String[] args) {
        Animal animal1 = new Dog(); // Создаем объект Dog, но ссылка типа Animal
        Animal animal2 = new Cat(); // Создаем объект Cat, но ссылка типа Animal
        
        animal1.makeSound(); // Вызывается метод makeSound() класса Dog
        animal2.makeSound(); // Вызывается метод makeSound() класса Cat
    }
}
```

В этом примере у нас есть класс `Animal` с методом `makeSound()`, который переопределен в классах-наследниках `Dog` и `Cat`. 
В методе `main` создаются объекты типа `Dog` и `Cat` (оба типа являются типом Animal), но ссылки на них имеют тип `Animal`. 
Затем вызывается метод `makeSound()` для каждого объекта.

Динамическое связывание происходит во время выполнения программы, когда метод `makeSound()` 
вызывается для объектов `animal1` и `animal2`. Несмотря на то, что ссылки имеют тип `Animal`, вызываются соответствующие методы, 
определенные в классах `Dog` и `Cat`, благодаря динамическому связыванию.