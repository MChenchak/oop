import java.io.*;
import java.lang.reflect.Field;

// унаследован от базового класса Object
public class General implements Serializable {

    // копирование объекта (копирование содержимого одного объекта в другой существующий, включая DeepCopy
    // - глубокое рекурсивное дублирование, подразумевающее также копирование содержимого объектов,
    // вложенных в копируемый объект через его поля, атрибуты);
    <T extends Any> void copy(T copyTo) {
        if (!this.isClass(copyTo.getClass())) throw new RuntimeException();
        for (Field field : this.getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                Object value = field.get(this);
                Field copyToField = copyTo.getClass().getDeclaredField(field.getName());
                copyToField.setAccessible(true);
                copyToField.set(copyTo, value);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    // клонирование объекта (создание нового объекта и глубокое копирование в него исходного объекта)
    <T extends Any> T deepClone() {
        byte[] serialized = this.serialize();
        return (T) General.deserialize(serialized).clone();
    }

    // сравнение объектов (включая глубокий вариант)
    // будет использоваться метод базового класса Object - equals()

    // сериализация
    byte[] serialize() {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bos.toByteArray();
    }

    // десериализация
    static <T extends Any> T deserialize(byte[] data) {
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        try (ObjectInputStream ois = new ObjectInputStream(bis)) {
            return (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    // печать (наглядное представление содержимого объекта в текстовом формате)
    void print() {
        System.out.println(this.toString());
    }

    // проверка типа (является ли тип текущего объекта указанным типом)
    boolean isClass(Class<?> clazz) {
        return this.getClass().equals(clazz);
    }

    // получение реального типа объекта (непосредственного класса, экземпляром которого он был создан)
    // будет использоваться метод базового класса Object - getClass()

    public Any add(Any other) {

        return new Any();
    }
}

// реализация интерфейса Cloneable необходима для работы метода clone класса Object
class Any extends General implements Cloneable {

    // т.к класс открыт для модификации, то можем переопределить метод или добавить новые
    @Override
    public Any clone() {
        try {
            return (Any) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

