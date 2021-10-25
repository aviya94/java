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


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TransformTest {
    private DoublyLinkedList linkedListInt;
    private DoublyLinkedList linkedListStudent;

    public class student {

        public int grade;
        int id = ++ID;
        static int ID = 0;

        public student(int grade) {
            this.grade = grade;
        }
    }

    @BeforeEach
    void setup() {

        linkedListStudent = new DoublyLinkedList<student>();
        linkedListInt=new DoublyLinkedList<Integer>();

        for (int i = 0; i < 5; i++) {
            linkedListInt.addToTail(i);
        }

    }

    @Test
    @Order(1)
    void transform_int() {

        Function<Integer,Integer> add5point = x -> {return x+= 5;};
        Transform.transform(linkedListInt, add5point);
        int i=5;
        for (Object e:linkedListInt) {
            assertEquals(i, (int) e);
            i++;
        }

    }

    @Test
    @Order(2)
    void transform_student() {

        student student1 = new student(50);
        student student2 = new student(60);
        student student3 = new student(70);
        student student4 = new student(80);
        linkedListStudent.addToTail(student1);
        linkedListStudent.addToTail(student2);
        linkedListStudent.addToTail(student3);
        linkedListStudent.addToTail(student4);

        Function<student,student> add5point = x -> { x.grade += 5;
        return x;};
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

    @Test
    @Order(4)
    void flatten_mat() {

        DoublyLinkedList<List<List<Integer>>> list = new DoublyLinkedList<List<List<Integer>>>();
        List<Integer> a = new ArrayList<Integer>();
        List<Integer> b = new ArrayList<Integer>();
        List<Integer> c = new ArrayList<Integer>();

        List<List<Integer>> d = new ArrayList<List<Integer>>();
        List<List<Integer>> e = new ArrayList<List<Integer>>();
        List<List<Integer>> f = new ArrayList<List<Integer>>();
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
        d.add(c);
        e.add(a);
        f.add(b);
        list.addToTail(d);
        list.addToTail(e);
        list.addToTail(f);

        DoublyLinkedList<Integer> res = Transform.flatten(list);
        i = 0;

        for (int val : res) {
            assertEquals(i, val);
            i++;
        }
    }

}
