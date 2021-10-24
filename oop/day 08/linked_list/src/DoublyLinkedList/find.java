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

    public static <T> void transform(DoublyLinkedList<T> list, Consumer<T> consumer) {

        for (T val : list) {
            consumer.accept(val);
        }
    }

    public static <T> DoublyLinkedList<T> transformTo(DoublyLinkedList<T> list, Function<T, T> function) {
        DoublyLinkedList<T> newLinkdList = new DoublyLinkedList<T>();

        for (T val : list) {
            newLinkdList.addToTail(function.apply(val));
        }

        return newLinkdList;
    }

    public static <T> DoublyLinkedList<T> transformIfTo(DoublyLinkedList<T> list, Function<T, T> function, Predicate<T> predicate) {
        DoublyLinkedList<T> newLinkdList = new DoublyLinkedList<T>();

        for (T val : list) {
            if (predicate.test(val)) {
                newLinkdList.addToTail(function.apply(val));
            }
        }

        return newLinkdList;
    }

    public static <T> DoublyLinkedList<T> flatten(DoublyLinkedList<List<T>> list) {

        DoublyLinkedList<T> newList = new DoublyLinkedList<T>();
        Consumer<List<T>> consumer = x -> {

            for (T e : x) {
                newList.addToTail(e);
            }
        };

        for (List<T> val : list) {
            consumer.accept(val);
        }

        return newList;

    }

}
