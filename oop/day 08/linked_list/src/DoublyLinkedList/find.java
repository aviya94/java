package DoublyLinkedList;

import java.util.List;
import java.util.function.*;

public class find {

    public static <T> T findFirst(DoublyLinkedList<T> list, Predicate<T> predicate) {

        for (T val : list) {
            if (predicate.test(val)) {
                return val;
            }
        }
        return null;

    }

    public static <T> T findFirstNot(DoublyLinkedList<T> list, Predicate<T> predicate) {

        for (T val : list) {
            if (!predicate.test(val)) {
                return val;
            }
        }
        return null;
    }

    public static <T> T SumIf(DoublyLinkedList<T> list, Predicate<T> predicate, BiFunction<T, T, T> add, T initial) {
        T s = initial;

        for (T val : list) {
            if (predicate.test(val)) {
                s = add.apply(s, val);
            }
        }

        return s;
    }



}
