package DoublyLinkedList;

import DoublyLinkedList.Matcher.EqualMatcher;
import DoublyLinkedList.Matcher.Matcher;

import java.util.Iterator;
import java.util.concurrent.locks.Condition;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class DoublyLinkedList<T>implements Iterable<T>  {

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

        if (isZeroSize()) {
            throw new LinkedListException();
        }

        var obj = tail.getPrevious().value();
        remove(tail.getPrevious());
        return (T) obj;

    }

    public T removeFromHead() throws LinkedListException {

        if (isZeroSize()) {
            throw new LinkedListException();
        }

        var obj = head.getNext().value();
        remove(head.getNext());
        return (T) obj;
    }

    private boolean isZeroSize() {
        return sizeLinkedList == 0 ? true : false;
    }

    public T removeObject(T objToRemove) {
        return (T) removeObject(new EqualMatcher(objToRemove));

    }

    public T removeObject(Matcher<T> matc) {

        Node<T> node = find(matc);

        if (!isNullNode(node)) {
            remove(node);
            return (T) node.value();
        }
        return null;

    }

    public T isExist(Matcher<T> matc) {

        Node<T> value = find(matc);

        if (!isNullNode(value)) {
            return (T) value.value();
        }
        return null;
    }

    public T isExist(T obj) {
        return (T) isExist(new EqualMatcher(obj));
    }

    private boolean isNullNode(Node<T> node) {
        return node == null ? true : false;
    }

    private Node<T> find(Matcher<T> matc) {

        Node<T> LinkedList = head.getNext();

        while (LinkedList != tail) {

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

        if (isZeroSize()) {
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

        if (isNullNode(obj)) {
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


    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {

        private Node<T> node;

        public ListIterator(){
            node= head;
        }

        @Override
        public boolean hasNext() {

            if (node.next.value() == null) {
                return false;
            }
            return true;
        }

        public boolean hasPrev() {

            if (node.previous.value() == null) {
                return false;
            }
            return true;
        }

        @Override
        public T next() {
            node=node.getNext();
            return node.value();
        }

        public T prev() {
            return node.getNext().value();
        }


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
