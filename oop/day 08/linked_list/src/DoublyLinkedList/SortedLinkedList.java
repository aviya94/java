package DoublyLinkedList;

import java.util.Comparator;
import java.util.Iterator;

public class SortedLinkedList<T> implements Iterable<T> {
    public DoublyLinkedList<T> linkedList;

    public SortedLinkedList() {
        linkedList = new DoublyLinkedList<T>();
    }

    public void add(T obj, Comparator<T> comp) {

        boolean bool = false;
        for (T e : linkedList) {
            if (comp.compare(obj, e) > 0 || comp.compare(obj, e) == 0) {
                linkedList.addApter(e);
                bool=true;
            }

        }
        if(bool==false)
        {
            linkedList.addToTail(obj);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return linkedList.iterator();
    }
}