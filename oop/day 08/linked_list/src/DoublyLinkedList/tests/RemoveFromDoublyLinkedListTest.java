package DoublyLinkedList.tests;

import org.junit.jupiter.api.*;
import DoublyLinkedList.DoublyLinkedList;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("RemoveFromDoublyLinkedListTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RemoveFromDoublyLinkedListTest {
    private DoublyLinkedList linkedList;

    @BeforeEach
    void setup() {
        linkedList = new DoublyLinkedList();
    }

    @Test
    @Order(1)
    void remove_from_tail() {

        int size = 10;
        for (int i = 0; i < size; i++) {
            linkedList.addToHead(i);
        }

        int value = (int) linkedList.tail();
        linkedList.removeFromTail();
        assertNotEquals(value, linkedList.tail());

    }

    @Test
    @Order(2)
    void remove_from_empty_tail() {

        try {
            linkedList.removeFromTail();
            fail();

        } catch (NullPointerException e) {
        }
    }

    @Test
    @Order(3)
    void remove_From_Head() {

        int size = 10;

        for (int i = 0; i < size; i++) {
            linkedList.addToHead(i);

        }

        int value = (int) linkedList.head();
        linkedList.removeFromHead();
        assertNotEquals(value, linkedList.head());

    }

    @Test
    @Order(4)
    void remove_from_empty_head() {

        try {
            linkedList.removeFromHead();
            fail();

        } catch (NullPointerException e) {
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
        //assertEquals(null, linkedList.find(size / 2));
        assertEquals(size - 1, linkedList.size());
    }

    @Test
    @Order(5)
    void remove_not_found() {

        int size = 10;
        int value = 11;

        for (int i = 0; i < size; i++) {
            linkedList.addToHead(i);
        }

        linkedList.removeObject(value);
        assertEquals(size, linkedList.size());

    }

    @Test
    @Order(5)
    void remove_empty_list() {

        int value = 5;
        try {
            linkedList.removeObject(value);
            fail();
        } catch (NullPointerException e) {

        }
    }
}