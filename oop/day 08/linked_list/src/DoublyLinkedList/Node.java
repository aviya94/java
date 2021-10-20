package DoublyLinkedList;

public class Node {
    private Object item;
    private Node previous;
    private Node next;

    public Node() {

    }

    public Node(Object obj,Node nextNode,Node prevNode) {
        item = obj;
        previous=prevNode;
        next=nextNode;
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
