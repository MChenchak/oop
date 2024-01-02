import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("string01");


        // ковариантный вызовов метода
        // Метод get() возвращает тип, который в данном случае является паараметром метода, т.е String (потомок Object).
        // Переменная string ссылается на объект типа String
        Object string = list.get(0);

        // полиморфный вызовов метода
        // будет вызвана реализация метода toString(), определенная для класса String
        string.toString();
    }
}
