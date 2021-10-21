package DoublyLinkedList.Matcher;

public abstract class Matcher<T> {

    public boolean match(T obj) {
        return test(obj);
    }

    abstract protected boolean test(T obj);
}

