package DoublyLinkedList.tests;

import org.junit.jupiter.api.*;
import DoublyLinkedList.DoublyLinkedList;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("GetObjectFromeDoublyLinkedListTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GetObjectFromeDoublyLinkedListTest {
    private DoublyLinkedList linkedList;

    @BeforeEach
    void setup() {
        linkedList = new DoublyLinkedList();
    }

    @Test
    @Order(1)
    void get_tail_not_empty_list() {
        int size = 10;

        for (int i = 0; i < size; i++) {
            linkedList.addToHead(i);
        }

        assertEquals(0, linkedList.tail().value());
        assertNotEquals(0, linkedList.head().value());

    }

    @Test
    @Order(2)
    void get_tail_empty_list() {

        try {
            linkedList.tail().value();
            fail();

        } catch (NullPointerException e) {

        }
    }

    @Test
    @Order(3)
    void get_head_not_empty_list() {

        int size = 10;

        for (int i = 0; i < size; i++) {
            linkedList.addToHead(i);
        }

        assertNotEquals(size - 1, linkedList.tail().value());
        assertEquals(size - 1, linkedList.head().value());
    }

    @Test
    @Order(3)
    void get_size() {

        assertEquals(0, linkedList.size());
        int size = 10;

        for (int i = 0; i < size; i++) {

            linkedList.addToHead(i);
        }

        assertEquals(size, linkedList.size());

    }

    @Test
    @Order(4)
    void find() {

        int size = 10;

        for (int i = 0; i < size; i++) {
            linkedList.addToHead(i);
        }

        assertEquals(size / 2, linkedList.find(size / 2).value());

    }

    @Test
    @Order(4)
    void Not_find() {

        int size = 10;

        for (int i = 0; i < size; i++) {
            linkedList.addToHead(i);
        }

        try {
            linkedList.find(size + 1).value();
            fail();

        } catch (NullPointerException e) {
        }
    }

    @Test
    @Order(5)
    void find_from_empty_list() {

        int value = 1;
        try {
            linkedList.find(value).value();
            fail();

        } catch (NullPointerException e) {
        }

    }

    @Test
    @Order(5)
    void reverse() {
        int size = 10;
        for (int i = 0; i < size; i++) {
            linkedList.addToHead(i);
        }
        linkedList.reverse(linkedList.head());
        assertEquals(size - 1, linkedList.tail().value());
        assertEquals(0, linkedList.head().value());

    }

    @Test
    @Order(6)
    void reverse_empty() {

        try {
            linkedList.reverse(linkedList.head());
            fail();
        }

        catch (NullPointerException e) {
        }

    }

}

