package DoublyLinkedList;

public class IntLinkedList {
    private DoublyLinkedList linkedList = new DoublyLinkedList();

    public void addToHead(int dataToAdd) {

        linkedList.addToHead(dataToAdd);
    }

    public void addToTail(int dataToAdd) {

        linkedList.addToTail(dataToAdd);
    }

    public void removeFromTail() {

        linkedList.removeFromTail();
    }

    public void removeFromHead() {

        linkedList.removeFromHead();
    }


    public int removeObject(int objToRemove) {

        return (int) linkedList.removeObject(objToRemove);
    }

    public int size() {

        return linkedList.size();
    }

    public int head() {

        return (int) linkedList.head();
    }

    public Object tail() {

        return (int) linkedList.tail();
    }

    public void reverseFromHead() {

        linkedList.reverseFromHead();
    }
}