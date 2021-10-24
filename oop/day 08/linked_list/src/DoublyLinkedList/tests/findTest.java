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

    public class student {

        public int grade;
        int id = ++ID;
        static int ID = 0;

        public student(int grade) {
            this.grade = grade;
        }
    }

    private DoublyLinkedList linkedListStudent;

    @BeforeEach
    void setup() {

        linkedList = new DoublyLinkedList<Integer>();
        linkedListString = new DoublyLinkedList<String>();
        linkedListStudent = new DoublyLinkedList<student>();
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

    @Test
    @Order(5)
    void transform_student() {

        student student1 = new student(50);
        student student2 = new student(60);
        student student3 = new student(70);
        student student4 = new student(80);
        linkedListStudent.addToTail(student1);
        linkedListStudent.addToTail(student2);
        linkedListStudent.addToTail(student3);
        linkedListStudent.addToTail(student4);

        Consumer<student> add5point = x -> x.grade += 5;
        find.transform(linkedListStudent, add5point);
        assertEquals(55, student1.grade);
        assertEquals(65, student2.grade);
        assertEquals(75, student3.grade);
        assertEquals(85, student4.grade);

    }

    @Test
    @Order(6)
    void transformTo_student() {

        student student1 = new student(50);
        student student2 = new student(60);
        student student3 = new student(70);
        student student4 = new student(80);
        linkedListStudent.addToTail(student1);
        linkedListStudent.addToTail(student2);
        linkedListStudent.addToTail(student3);
        linkedListStudent.addToTail(student4);

        Function<student, student> add5pointfunc = x -> {
            x.grade += 5;
            return x;
        };

        DoublyLinkedList<student> res = find.transformTo(linkedListStudent, add5pointfunc);
        int i = 55;
        for (student e : res) {

            assertEquals(i, e.grade);
            i += 10;
        }

    }

    @Test
    @Order(7)
    void transformIfTo() {

        student student1 = new student(50);
        student student2 = new student(60);
        student student3 = new student(70);
        student student4 = new student(80);
        linkedListStudent.addToTail(student1);
        linkedListStudent.addToTail(student2);
        linkedListStudent.addToTail(student3);
        linkedListStudent.addToTail(student4);

        Function<student, student> add5pointfunc = x -> {
            x.grade += 5;
            return x;
        };
        Predicate<student> biggerThen = x -> (x.grade > 60);
        find.transformIfTo(linkedListStudent, add5pointfunc, biggerThen);

        assertEquals(50, student1.grade);
        assertEquals(60, student2.grade);
        assertEquals(75, student3.grade);
        assertEquals(85, student4.grade);

    }

    @Test
    @Order(8)
    void flatten() {

        DoublyLinkedList<List<Integer>> list = new DoublyLinkedList<List<Integer>>();
        List<Integer> a = new ArrayList<Integer>();
        List<Integer> b = new ArrayList<Integer>();
        List<Integer> c = new ArrayList<Integer>();
        int i;

        for (i = 0; i < 5; i++) {
            a.add(i);
        }

        for (i = 5; i < 10; i++) {
            b.add(i);
        }

        for (i = 10; i < 15; i++) {
            c.add(i);
        }

        list.addToTail(a);
        list.addToTail(b);
        list.addToTail(c);

        DoublyLinkedList<Integer> res = find.flatten(list);
        i = 0;

        for (int e : res) {
            assertEquals(i, e);
            i++;
        }
    }
}
