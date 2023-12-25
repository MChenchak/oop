public class Animal {

    //метод публичен в родительском классе А
    //и публичен в его потомке B;
    public void walk() {}

    // метод публичен в родительском классе и публичен в его потомке
    protected void run() {}

    public void foo() {}

    //метод скрыт в родительском классе А
    //и скрыт в его потомке B.
    protected void bar() {}


}

class Dog extends Animal {

    @Override
    public void walk() {
        super.walk();
    }

    @Override
    public void run() {}

    //метод публичен в родительском классе А
    //и скрыт в его потомке B - так сделать невозможно. видимость метода в потомке должна быть
    // такой же или более "публичной"
    // private void foo()

    @Override
    protected void bar() {
    }
}

