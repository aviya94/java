package DoublyLinkedList;

public class Node {
    private Object item;
    private Node previous;
    private Node next;

    public Node(Object obj) {
        item = obj;
    }

    public void setNext(Node nextIndex) {
        next = nextIndex;
    }

    public void setPrevious(Node prev) {
        previous = prev;
    }

    public Node getPrevious() {
        return previous;
    }

    public Node getNext() {
        return next;
    }

    public Object value() {
        return item;
    }
}
