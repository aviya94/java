package DoublyLinkedList.tests;

import org.junit.jupiter.api.*;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import DoublyLinkedList.SortedLinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

import DoublyLinkedList.LinkedListException;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SortedLonkedListTest {

    private SortedLinkedList linkedListInt;
    int size;
    private SortedLinkedList linkedListString;


    @BeforeEach
    void setup() {

        linkedListInt = new SortedLinkedList<Integer>();
        linkedListString = new SortedLinkedList<String>();

    }

    @Test
    @Order(1)
    void add_int() throws LinkedListException {
        Comparator<Integer> intComparator = (x, y) -> {

            if (x > y) {
                return 1;
            } else if (x == y) {
                return 0;
            } else {
                return -1;
            }
        };
        linkedListInt.add(5, intComparator);
        linkedListInt.add(1, intComparator);
        linkedListInt.add(2, intComparator);
        linkedListInt.add(4, intComparator);
        linkedListInt.add(3, intComparator);
        int i=1;

        for (var e: linkedListInt) {
            assertEquals(i,e);
            i++;

        }
    }

    @Test
    @Order(1)
    void add_string() throws LinkedListException {
        Comparator<String> stringComparator = (x, y) -> {

            if (x.compareTo(y)>0) {
                return 1;
            } else if (x.compareTo(y)==0) {
                return 0;
            } else {
                return -1;
            }
        };
        linkedListString.add("cscs",stringComparator);
        linkedListString.add("fvf",stringComparator);
        linkedListString.add("aaa",stringComparator);
        linkedListString.add("dadc",stringComparator);
        linkedListString.add("a",stringComparator);
        String[]a={"a","aaa","cscs","dadc","fvf"};

        char i=0;
        for (var e: linkedListInt) {
            assertEquals(a[i],e);
            i++;

        }
    }


}
