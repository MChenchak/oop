import java.util.Arrays;

public class Vector<T extends Any> extends General {
    T[] arr;
    int size;

    public Vector(T[] arr) {
        this.arr = arr;
    }

    public Vector<T> add(Vector<T> other) {
        if (arr.length != other.arr.length) return null;

        T[] result = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i <= arr.length; i++) {
            result[i] = (T) arr[i].add(other.arr[i]);
        }
        return new Vector<>(result);
    }
}


