package DoublyLinkedList;

public class DoublyLinkedList {

    private final  Node head;
    private final Node tail;
    private int sizeLinkedList;

    public DoublyLinkedList() {

        head = new Node();
        tail = new Node();
        head.setNext(tail);
        tail.setPrevious(head);
        sizeLinkedList = 0;

    }

    public void addToHead(Object dataToAdd) {
        addAfter(head, dataToAdd);
    }

    public void addToTail(Object dataToAdd) {
        addAfter(tail.getPrevious(), dataToAdd);
    }

    private void addAfter(Node where, Object data) {
        Node node = new Node(data, where.getNext(), where);
        where.getNext().setPrevious(node);
        where.setNext(node);
        ++sizeLinkedList;

    }

    private void remove(Node nodeToRemove) {
        nodeToRemove.getNext().setPrevious(nodeToRemove.getPrevious());
        nodeToRemove.getPrevious().setNext(nodeToRemove.getNext());
        sizeLinkedList--;
    }

    public void removeFromTail() {

        if (sizeLinkedList == 0) {
            throw new NullPointerException();
        }
        remove(tail.getPrevious());

    }

    public void removeFromHead() {

        if (sizeLinkedList == 0) {
            throw new NullPointerException();
        }

        remove(head.getNext());
    }

    private Node find(Object obj) {

        Node LinkedList = head.getNext();

        while (LinkedList.getNext() != tail) {

            if (LinkedList.value() == obj) {
                return LinkedList;
            }
            LinkedList = LinkedList.getNext();
        }
        return null;

    }

    public Object removeObject(Object objToRemove) {

        Node node = find(objToRemove);

        if (node != null) {
            remove(node);
            return objToRemove;
        }

        return null;

    }

    public int size() {
        return sizeLinkedList;
    }

    public Object head() {

        if (sizeLinkedList == 0) {
            throw new NullPointerException();
        }

        return head.getNext().value();
    }

    public Object tail() {

        if (sizeLinkedList == 0) {
            throw new NullPointerException();
        }

        return tail.getPrevious().value();
    }

    public void reverseFromHead() {

        if (sizeLinkedList > 0) {
            reverse(head);
        }

        Node node =new Node(null,tail.getNext(),tail.getPrevious());
        tail.setPrevious(head.getPrevious());
        tail.setNext(head.getNext());
        head.setPrevious(node.getPrevious());
        head.setNext(node.getNext());

    }

    private void reverse(Node obj) {

        if (obj == null) {
            throw new NullPointerException();
        }

        if (obj.getNext() == null) {
            obj.setNext(obj.getPrevious());
            obj.setPrevious(tail);
            return;
        }

        reverse(obj.getNext());
        Node Next = obj.getNext();
        obj.setNext(obj.getPrevious());
        obj.setPrevious(Next);

    }

    private static class Node {
        private Object item;
        private Node previous;
        private Node next;

        private Node() {

        }

        private Node(Object obj, Node nextNode, Node prevNode) {
            item = obj;
            previous=prevNode;
            next=nextNode;
        }

        private void setNext(Node nextIndex) {
            next = nextIndex;
        }

        private void setPrevious(Node prev) {
            previous = prev;
        }

        private Node getPrevious() {
            return previous;
        }

        private Node getNext() {
            return next;
        }

        private Object value() {
            return item;
        }
    }
}
