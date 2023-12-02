Рефлексия по решению курсанта

```java
public class Animal { // животное

    public void voice(){ // голос
        System.out.println("I am animal!");
    }
}

public class Head { // голова

}

public class Cat extends Animal { // наследование

    private Head head; // композиция: у кота всегда имеется голова

    //полиморфизм 
    @Override
    public void voice(){ // голос
        System.out.println("I am the cat!");
    }

    // При вызове voice() у подтипов типа Animal 
    // не обязательно знать конкретный тип объекта,
    // главное, что его подтип -- потомок класса Animal.

}
```

С формальной точки зрения все ок. Наглядности ради head я бы переместил в класс Animal,
т.к у всех животных есть голова. И в класс Cat для демонстрации расширения добвил бы какое-то
другое поле или метод, характерный только для кошек.