package DoublyLinkedList.Matcher;

public class firstCharStringMatcher extends Matcher {
    char firstChar;

    public firstCharStringMatcher(char firstChar) {
        this.firstChar = firstChar;
    }

    @Override
    protected boolean test(Object obj) {

        try {
            String string = (String) obj;
            return firstChar == string.charAt(0);
        } catch (IllegalArgumentException e) {
            return false;
        }

    }
}
