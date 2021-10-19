package DoublyLinkedList.tests;

import org.junit.jupiter.api.*;
import DoublyLinkedList.DoublyLinkedList;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("AddToDoublyLinkedListTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AddToDoublyLinkedListTest {
    private DoublyLinkedList linkedList;

    @BeforeEach
    void setup() {
        linkedList = new DoublyLinkedList();
    }

    @Test
    @Order(1)
    void add_to_tail_empty_list() {

        int value = 1;
        int size = 1;
        linkedList.addToTail(value);
        assertEquals(value, linkedList.tail().value());
        assertEquals(value, linkedList.head().value());
        assertEquals(size, linkedList.size());

    }

    @Test
    @Order(2)
    void add_to_head_empty_list() {

        int value = 1;
        int size = 1;
        linkedList.addToHead(value);
        assertEquals(value, linkedList.tail().value());
        assertEquals(value, linkedList.head().value());
        assertEquals(size, linkedList.size());

    }

    @Test
    @Order(3)
    void add_to_tail_not_empty_list() {

        int size = 5;
        int value = 6;

        for (int i = 0; i < size; i++) {
            linkedList.addToHead(i);
        }

        linkedList.addToTail(value);
        assertEquals(value, linkedList.tail().value());
        assertNotEquals(value, linkedList.head().value());
        assertEquals(size + 1, linkedList.size());

    }

    @Test
    @Order(4)
    void add_to_head_not_empty_list() {

        int size = 5;
        int value = 6;

        for (int i = 0; i < size; i++) {
            linkedList.addToHead(i);
        }

        linkedList.addToHead(value);
        assertNotEquals(value, linkedList.tail().value());
        assertEquals(value, linkedList.head().value());
        assertEquals(size + 1, linkedList.size());

    }
}
