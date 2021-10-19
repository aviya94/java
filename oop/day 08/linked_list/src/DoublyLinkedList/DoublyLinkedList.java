package DoublyLinkedList;

public class DoublyLinkedList {

    private Node head = null;
    private Node tail = null;
    private int sizeLinkedList = 0;

    public void addToTail(Object obj) {

        if (head == null && tail == null) {
            addFirstValue(obj);

        } else {
            Node newNode = new Node(obj);
            newNode.setNext(null);
            newNode.setPrevious(tail);
            tail.setNext(newNode);
            tail = newNode;
            sizeLinkedList++;
        }

    }

    public void addToHead(Object obj) {

        if (head == null && tail == null) {
            addFirstValue(obj);

        } else {
            Node newNode = createNewNode(obj);
            newNode.setNext(head);
            newNode.setPrevious(null);
            head.setPrevious(newNode);
            head = newNode;
            sizeLinkedList++;
        }

    }

    private void addFirstValue(Object obj) {

        Node newNode = new Node(obj);
        newNode.setNext(null);
        newNode.setPrevious(null);
        tail = newNode;
        head = newNode;
        sizeLinkedList++;

    }


    private Node createNewNode(Object obj) {

        Node newNode = new Node(obj);
        return newNode;

    }

    public void removeFromTail() {

        if (tail == null) {
            throw new NullPointerException();
        }

        tail = tail.getPrevious();
        tail.setNext(null);
        sizeLinkedList--;

    }

    public void removeFromHead() {

        if (head == null) {
            throw new NullPointerException();
        }

        head = head.getNext();
        head.setPrevious(null);
        sizeLinkedList--;

    }

    public Node find(Object obj) {

        Node LinkedList = head;

        while (LinkedList.getNext() != null) {

            if (LinkedList.value() == obj) {
                return LinkedList;
            }
            LinkedList = LinkedList.getNext();
        }
        return null;

    }

    public void remove(Object obj) {

        if (head != null) {

            Node nodeToRemove = find(obj);
            if (nodeToRemove != null) {

                if (nodeToRemove.getNext() != null) {
                    nodeToRemove.getNext().setPrevious(nodeToRemove.getPrevious());

                } else {
                    tail = nodeToRemove.getPrevious();
                }

                if (nodeToRemove.getPrevious() != null) {
                    nodeToRemove.getPrevious().setNext(nodeToRemove.getNext());

                } else {
                    head = nodeToRemove.getNext();
                }

                sizeLinkedList--;
            }
        }
    }

    public int size() {
        return sizeLinkedList;
    }

    public Node head() {
        return head;
    }

    public Node tail() {
        return tail;
    }

    public void reverse(Node obj) {

        if(obj==null)
        {
            throw new  NullPointerException();
        }

        if (obj.getNext() == null) {
            obj.setNext(obj.getPrevious());
            obj.setPrevious(null);
            head = obj;
            return;
        }

        reverse(obj.getNext());
        Node Next = obj.getNext();
        obj.setNext(obj.getPrevious());
        obj.setPrevious(Next);
        tail = obj;

    }
}
