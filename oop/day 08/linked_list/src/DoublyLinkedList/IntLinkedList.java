package DoublyLinkedList;

public class IntLinkedList {
    private DoublyLinkedList linkedList = new DoublyLinkedList();

    public void addToHead(int dataToAdd) {

        linkedList.addToHead(dataToAdd);
    }

    public void addToTail(int dataToAdd) {

        linkedList.addToTail(dataToAdd);
    }

    public void removeFromTail() throws LinkedListException {

        linkedList.removeFromTail();
    }

    public void removeFromHead() throws LinkedListException {

        linkedList.removeFromHead();
    }


    public int removeObject(int objToRemove) {

        return (int) linkedList.removeObject(objToRemove);
    }

    public int size() {

        return linkedList.size();
    }

    public int head() throws LinkedListException {

        return (int) linkedList.head();
    }

    public Object tail() throws LinkedListException {

        return (int) linkedList.tail();
    }

    public void reverseFromHead() throws LinkedListException {

        linkedList.reverseFromHead();
    }
}