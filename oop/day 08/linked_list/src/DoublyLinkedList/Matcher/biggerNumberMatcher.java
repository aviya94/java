package DoublyLinkedList.Matcher;

public class biggerNumberMatcher extends Matcher {
    private double threshold;

    public biggerNumberMatcher(int threshold) {
        this.threshold = threshold;
    }

    @Override
    protected boolean test(Object obj) {

        try {
            return (int) obj >= threshold;
        } catch (IllegalArgumentException e) {
            return false;
        }

    }
}
