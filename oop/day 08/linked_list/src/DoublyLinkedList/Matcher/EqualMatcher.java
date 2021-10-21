package DoublyLinkedList.Matcher;

public class EqualMatcher<T> extends Matcher {
    private T value;

    public EqualMatcher(T value) {
        this.value = value;
    }


    @Override
    protected boolean test(Object obj) {
        try {
            T object=(T) obj;
            return object == value;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
