package DoublyLinkedList.tests;

import DoublyLinkedList.DoublyLinkedList;
import DoublyLinkedList.Transform;
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
class TransformTest {

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

        linkedListStudent = new DoublyLinkedList<student>();

    }

    @Test
    @Order(1)
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
        Transform.transform(linkedListStudent, add5point);
        assertEquals(55, student1.grade);
        assertEquals(65, student2.grade);
        assertEquals(75, student3.grade);
        assertEquals(85, student4.grade);

    }

    @Test
    @Order(2)
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

        DoublyLinkedList<student> res = Transform.transformTo(linkedListStudent, add5pointfunc);
        int i = 55;
        for (student e : res) {

            assertEquals(i, e.grade);
            i += 10;
        }

    }

    @Test
    @Order(3)
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
        Transform.transformIfTo(linkedListStudent, add5pointfunc, biggerThen);

        assertEquals(50, student1.grade);
        assertEquals(60, student2.grade);
        assertEquals(75, student3.grade);
        assertEquals(85, student4.grade);

    }

    @Test
    @Order(4)
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

        DoublyLinkedList<Integer> res = Transform.flatten(list);
        i = 0;

        for (int e : res) {
            assertEquals(i, e);
            i++;
        }
    }
}
