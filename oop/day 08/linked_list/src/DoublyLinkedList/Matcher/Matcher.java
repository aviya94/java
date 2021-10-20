package DoublyLinkedList.Matcher;

public abstract class Matcher {

    public boolean match(Object obj) {
        return test(obj);
    }

    abstract protected boolean test(Object obj);
}

