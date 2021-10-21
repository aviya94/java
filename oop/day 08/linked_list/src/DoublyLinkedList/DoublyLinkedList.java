package DoublyLinkedList;

import DoublyLinkedList.Matcher.EqualMatcher;
import DoublyLinkedList.Matcher.Matcher;

public class DoublyLinkedList<T> {

    private final Node<T> head;
    private final Node<T> tail;
    private int sizeLinkedList;

    public DoublyLinkedList() {

        head = new Node();
        tail = new Node();
        head.setNext(tail);
        tail.setPrevious(head);
        sizeLinkedList = 0;

    }

    public void addToHead(T dataToAdd) {
        addAfter(head, dataToAdd);
    }

    public void addToTail(T dataToAdd) {
        addAfter(tail.getPrevious(), dataToAdd);
    }

    private void addAfter(Node where, T data) {
        Node<T> node = new Node(data, where.getNext(), where);
        where.getNext().setPrevious(node);
        where.setNext(node);
        ++sizeLinkedList;

    }

    private void remove(Node nodeToRemove) {
        nodeToRemove.getNext().setPrevious(nodeToRemove.getPrevious());
        nodeToRemove.getPrevious().setNext(nodeToRemove.getNext());
        sizeLinkedList--;
    }

    public T removeFromTail() throws LinkedListException {

        if (sizeLinkedList == 0) {
            throw new LinkedListException();
        }

        var obj = tail.getPrevious().value();
        remove(tail.getPrevious());
        return (T) obj;

    }

    public T removeFromHead() throws LinkedListException {

        if (sizeLinkedList == 0) {
            throw new LinkedListException();
        }

        var obj = head.getNext().value();
        remove(head.getNext());
        return (T) obj;
    }

    public T removeObject(T objToRemove) {

        Node node = find(objToRemove);

        if (node != null) {
            remove(node);
            return objToRemove;
        }
        return null;

    }

    public T removeObject(Matcher matc) {

        Node<T> node = find(matc);

        if (node != null) {
            remove(node);
            return (T) matc;
        }
        return null;

    }

    public T isExist(Matcher matc) {
        return isExist(matc);
    }

    public T isExist(T obj) {

        Node<T> value = find(obj);

        if (value != null) {
            return (T) value.value();
        }
        return null;
    }

    private Node find(T obj) {

        return (find(new EqualMatcher(obj)));

    }

    private Node find(Matcher matc) {

        Node<T> LinkedList = head.getNext();

        while (LinkedList.getNext() != tail) {

            if (matc.match(LinkedList.value())) {
                return LinkedList;
            }
            LinkedList = LinkedList.getNext();
        }
        return null;

    }

    public int size() {
        return sizeLinkedList;
    }

    public T head() throws LinkedListException {

        if (sizeLinkedList == 0) {
            throw new LinkedListException();
        }

        return (T) head.getNext().value();
    }

    public T tail() throws LinkedListException {

        if (sizeLinkedList == 0) {
            throw new LinkedListException();
        }

        return (T) tail.getPrevious().value();
    }

    public void reverseFromHead() throws LinkedListException {

        if (sizeLinkedList > 0) {
            reverse(head);
        }

        Node<T> node = new Node(null, tail.getNext(), tail.getPrevious());
        tail.setPrevious(head.getPrevious());
        tail.setNext(head.getNext());
        head.setPrevious(node.getPrevious());
        head.setNext(node.getNext());

    }

    private void reverse(Node obj) throws LinkedListException {

        if (obj == null) {
            throw new LinkedListException();
        }

        if (obj.getNext() == null) {
            obj.setNext(obj.getPrevious());
            obj.setPrevious(tail);
            return;
        }

        reverse(obj.getNext());
        Node<T> Next = obj.getNext();
        obj.setNext(obj.getPrevious());
        obj.setPrevious(Next);

    }

    private static class Node<V> {
        private V item;
        private Node<V> previous;
        private Node<V> next;

        private Node() {

        }

        private Node(V obj, Node nextNode, Node prevNode) {
            item = obj;
            previous = prevNode;
            next = nextNode;
        }

        private void setNext(Node nextIndex) {
            next = nextIndex;
        }

        private void setPrevious(Node prev) {
            previous = prev;
        }

        private Node<V> getPrevious() {
            return previous;
        }

        private Node<V> getNext() {
            return next;
        }

        private V value() {
            return item;
        }
    }
}
