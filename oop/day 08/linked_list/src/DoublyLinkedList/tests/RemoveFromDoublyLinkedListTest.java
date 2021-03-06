package DoublyLinkedList.tests;

import DoublyLinkedList.Matcher.biggerNumberMatcher;
import org.junit.jupiter.api.*;
import DoublyLinkedList.DoublyLinkedList;
import DoublyLinkedList.LinkedListException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("RemoveFromDoublyLinkedListTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RemoveFromDoublyLinkedListTest {
    private DoublyLinkedList linkedList;

    @BeforeEach
    void setup() {
        linkedList = new DoublyLinkedList<Integer>();
    }

    @Test
    @Order(1)
    void remove_from_tail() throws LinkedListException {

        int size = 10;
        for (int i = 0; i < size; i++) {
            linkedList.addToHead(i);
        }

        int value = (int) linkedList.tail();
        linkedList.removeFromTail();
        assertNotEquals(value, linkedList.tail());
        assertEquals(null, linkedList.isExist(value));

    }

    @Test
    @Order(2)
    void remove_from_empty_tail() {

        try {
            linkedList.removeFromTail();
            fail();

        } catch (LinkedListException e) {
        }
    }

    @Test
    @Order(3)
    void remove_From_Head() throws LinkedListException {

        int size = 10;

        for (int i = 0; i < size; i++) {
            linkedList.addToHead(i);

        }

        int value = (int) linkedList.head();
        linkedList.removeFromHead();
        assertNotEquals(value, linkedList.head());
        assertEquals(null, linkedList.isExist(value));

    }

    @Test
    @Order(4)
    void remove_from_empty_head() {

        try {
            linkedList.removeFromHead();
            fail();

        } catch (LinkedListException e) {
        }
    }

    @Test
    @Order(5)
    void remove() {

        int size = 10;

        for (int i = 0; i < size; i++) {
            linkedList.addToHead(i);
        }

        linkedList.removeObject(size / 2);
        assertEquals(null, linkedList.isExist(size / 2));
        assertEquals(size - 1, linkedList.size());
    }

    @Test
    @Order(5)
    void remove_not_found() {

        int size = 10;
        int value = size + 1;

        for (int i = 0; i < size; i++) {
            linkedList.addToHead(i);
        }

        linkedList.removeObject(value);
        assertEquals(size, linkedList.size());
        assertEquals(null, linkedList.isExist(value));

    }

    @Test
    @Order(6)
    void remove_empty_list() {

        int value = 5;
        var val =  linkedList.removeObject(value);
        assertNull(val);

    }

    @Test
    @Order(7)
    void remove_matcher() {

        int size = 10;

        for (int i = 0; i < size; i++) {
            linkedList.addToHead(i);
        }

        linkedList.removeObject(new biggerNumberMatcher(size / 2));
        assertEquals(null, linkedList.isExist(size - 1));
        assertEquals(size - 1, linkedList.size());
    }
}