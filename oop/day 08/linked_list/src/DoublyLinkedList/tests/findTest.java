package DoublyLinkedList.tests;

import DoublyLinkedList.DoublyLinkedList;
import DoublyLinkedList.find;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import DoublyLinkedList.LinkedListException;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("AddToDoublyLinkedListTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class findTest {

    private DoublyLinkedList linkedList;
    int size;
    private DoublyLinkedList linkedListString;


    @BeforeEach
    void setup() {

        linkedList = new DoublyLinkedList<Integer>();
        linkedListString = new DoublyLinkedList<String>();
        size = 100;

        for (int i = 0; i < size; i++) {
            linkedList.addToTail(i);
        }

        linkedListString.addToTail("sunday");
        linkedListString.addToTail("monday");
        linkedListString.addToTail("tuesday");
        linkedListString.addToTail("wednesday");

    }

    @Test
    @Order(1)
    void find_first() throws LinkedListException {

        Predicate<Integer> even = x -> (x % 2 == 0);
        Predicate<Integer> biggerThen = x -> (x > 10);
        Predicate<Integer> equal = x -> (x == size);

        assertEquals(0, find.findFirst(linkedList, even));
        assertEquals(11, find.findFirst(linkedList, biggerThen));
        assertNull(find.findFirst(linkedList, equal));
    }

    @Test
    @Order(2)
    void find_not_first() throws LinkedListException {

        Predicate<Integer> even = x -> (x % 2 == 0);
        Predicate<Integer> biggerThen = x -> (x > 10);
        Predicate<Integer> equal = x -> (x == size);
        Predicate<Integer> smallerThen = x -> (x < size);

        assertEquals(1, find.findFirstNot(linkedList, even));
        assertEquals(0, find.findFirstNot(linkedList, biggerThen));
        assertEquals(0, find.findFirstNot(linkedList, equal));
        assertNull(find.findFirstNot(linkedList, smallerThen));
    }

    @Test
    @Order(3)
    void sum_if_integer() throws LinkedListException {

        Predicate<Integer> even = x -> (x % 2 == 0);
        Predicate<Integer> biggerAndSmallerThen = x -> (x > 0 && x < 10);
        Predicate<Integer> equal = x -> (x == 99);
        Predicate<Integer> biggerThen = x -> (x > 100);
        BiFunction<Integer, Integer, Integer> add = (x, y) -> (x + y);

        assertEquals(45, find.SumIf(linkedList, biggerAndSmallerThen, add, 0));
        assertEquals(99, find.SumIf(linkedList, equal, add, 0));
        assertEquals(0, find.SumIf(linkedList, biggerThen, add, 0));

    }

    @Test
    @Order(4)
    void sum_if_string() throws LinkedListException {

        Predicate<String> equal = x -> (x.equals("sunday"));
        Predicate<String> startWithaa = x -> (x.startsWith("aa"));
        Predicate<String> startWithmon = x -> (x.startsWith("mon"));

        BiFunction<String, String, String> add = (x, y) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(x);
            sb.append(y);
            return String.valueOf(sb);
        };

        assertEquals("sunday", find.SumIf(linkedListString, equal, add, ""));
        assertEquals("", find.SumIf(linkedListString, startWithaa, add, ""));
        assertEquals("monday", find.SumIf(linkedListString, startWithmon, add, ""));

    }

}
