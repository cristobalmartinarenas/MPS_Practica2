package DoubleEndedList;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class DoubleLinkedListQueueTest {

    private DequeNode node1;
    private DequeNode node2;
    private DoubleLinkedListQueue list1;
    private DoubleLinkedListQueue list2;

    @BeforeEach
    public void init() {
        node1 = new DequeNode<Integer>(1, null, null);
        node2 = new DequeNode<Integer>(5, null, null);
        list1 = new DoubleLinkedListQueue<Integer>();
        list2 = new DoubleLinkedListQueue<>();

    }


    @Test
    public void ShouldAppendANodeLastPosition() {
        list1.append(node1);
        list1.append(node2);

        assertEquals(list1.peekLast(), node2);
    }

    @Test
    public void ShouldThrowAnExceptionIllegalArgumentWhenAppendNulls() {
        assertThrows(IllegalArgumentException.class, () -> list1.append(null));
        assertThrows(IllegalArgumentException.class, () -> list1.appendLeft(null));
    }


    @Test
    public void ShouldAppendANodeFirstPosition() {
        list1.appendLeft(node1);
        list1.appendLeft(node2);

        assertEquals(list1.peekFirst(), node2);
    }

    @Test
    public void ShouldDeleteNodeFirstPosition() {
        list1.append(node1);
        list1.append(node2);

        list1.deleteFirst();

        assertEquals(list1.peekFirst(), node2);
    }

    @Test
    public void ShouldReturnNullIfTheListIsEmpty() {
        list1.append(node1);
        list1.deleteLast();

        assertEquals(list1, null);
    }


    @Test
    public void ShouldDeleteNodeLastPosition() {
        list1.append(node1);
        list1.append(node2);

        list1.deleteLast();

        assertEquals(list1.peekLast(), node1);
    }

    @Test
    public void ShouldReturnTheSizeOfTheList() {
        list1.append(node1);
        list1.append(node2);

        assertEquals(list1.size(), 2);
    }

    @Test
    public void ShouldReturn0IfTheListIsEmpty() {
        assertEquals(0, list1.size());
    }

    @Test
    public void ShouldReturnTheNodeAtTheGivenPosition() {
        list1.append(node1);
        list1.append(node2);

        assertEquals(list1.getAt(1), node2);
    }

    @Test
    public void ShouldThrownAnIndexOutOfBoundsExceptionIfThePositionIsBiggerThanSize() {
        list1.append(node1);
        list1.append(node2);

        assertThrows(IndexOutOfBoundsException.class, () -> list1.getAt(10));
    }

    @Test
    public void ShouldReturnTheNodeOfTheValue() {
        list1.append(node1);
        list1.append(node2);

        assertEquals(list1.find(5), node2);

    }

    @Test
    public void ShouldThrownAnExceptionIfTheNumberIsNotInTheList() {
        list1.append(node1);
        list1.append(node2);

        assertNull(list1.find(2000));
    }


    @Test
    public void ShouldDeleteTheGivenNode() {
        DequeNode node3 = new DequeNode<Integer>(10, null, null);
        list1.append(node1);
        list1.append(node2);
        list1.append(node3);

        //System.out.println(list1.size());
        list1.delete(node2);
        //System.out.println(list1.size());

        assertEquals(list1.size(), 2);
        assertEquals(list1.peekFirst(), node1);
        assertEquals(list1.peekLast(), node3);


    }

    @Test
    public void ShouldThrownAnExceptionIfTheNodeIsNotInTheList() {
        DequeNode node3 = new DequeNode<Integer>(10, null, null);

        list1.append(node1);
        list1.append(node2);


        assertThrows(IllegalArgumentException.class, () -> list1.delete(node3));

    }
}
