package DoublyLinkedList.Matcher;

public class EqualMatcher extends Matcher {
    private Object number;

    public EqualMatcher(Object number) {
        this.number = number;
    }

    @Override
    protected boolean test(Object obj) {

        try {
            return (int) obj == (int)number;
        } catch (IllegalArgumentException e) {
            return false;
        }

    }
}
