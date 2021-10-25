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

    public static <T> DoublyLinkedList<Object> flatten(DoublyLinkedList<T> list) {

        DoublyLinkedList<Object> newList = new DoublyLinkedList<Object>();
        Consumer<List<Object>> consumer = x -> {

            for (Object e : x) {
                newList.addToTail(e);
            }
        };

        Consumer<List<Object>> cons2 = x -> {

            for (Object e : x) {
                newList.addAfter(e);
            }
        };

        for (Object val : list) {
            if (isArray(val)) {
                consumer.accept((List<Object>) val);
            }
        }
        {
            for (Object val : newList) {

                while (isArray(val))
                    cons2.accept((List<Object>) val);
            }

        }

        return newList;
    }


}
