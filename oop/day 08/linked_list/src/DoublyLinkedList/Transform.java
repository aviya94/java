package DoublyLinkedList;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.platform.commons.util.ReflectionUtils.isArray;

public abstract class Transform {

    public static <T> void transform(DoublyLinkedList<T> list, Function<T, T> func) {

        for (T val : list) {
            list.setValue(val, func.apply(val));

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

    public static <T, R> DoublyLinkedList<R> flatmap(DoublyLinkedList linkedList, Function<T, R> trans) {
        final var newList = new DoublyLinkedList<R>();
        return flatmapRecursive(linkedList, newList, trans);
    }

    public static <T, R> DoublyLinkedList<R> flatmapRecursive(DoublyLinkedList linkedList, DoublyLinkedList<R> newList, Function<T, R> trans) {

        for (Object obj : linkedList) {
            if (obj instanceof DoublyLinkedList) {
                var list = obj;
                flatmapRecursive((DoublyLinkedList) list, newList, trans);
            } else {
                T value = (T) obj;
                newList.addToTail(trans.apply(value));
            }

        }
        return newList;
    }
}
