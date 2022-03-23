package DoubleEndedList;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class DoubleLinkedListQueueTest {

    private DequeNode node1;
    private DequeNode node2;
    private DequeNode node3;
    private DoubleLinkedListQueue list1;
    private DoubleLinkedListQueue list2;

    @BeforeEach
    public void init() {
        node1 = new DequeNode<Integer>(5, null, null);
        node2 = new DequeNode<Integer>(1, null, null);
        node3 = new DequeNode<Integer>(2, null, null);

        list1 = new DoubleLinkedListQueue<Integer>();
        list1.append(node1);
        list1.append(node2);

        list2 = new DoubleLinkedListQueue<>();
    }


    @Test
    public void ShouldAppendANodeLastPosition() {
        list1.append(node3);
        assertEquals(list1.peekLast(), node3);
    }

    @Test
    public void ShouldAppendANodeFirstPositionEmptyList(){
        list2.appendLeft(node3);
        assertEquals(list2.peekFirst(), node3);
        assertEquals(list2.peekLast(), node3);
    }

    @Test
    public void ShouldThrowAnExceptionIllegalArgumentWhenAppendNulls() {
        assertThrows(IllegalArgumentException.class, () -> list1.append(null));
        assertThrows(IllegalArgumentException.class, () -> list1.appendLeft(null));
    }


    @Test
    public void ShouldAppendANodeFirstPosition() {
        list1.appendLeft(node3);
        assertEquals(list1.peekFirst(), node3);
    }

    @Test
    public void ShouldDeleteNodeFirstPosition() {
        list1.deleteFirst();

        assertEquals(list1.peekFirst(), node2);
    }

    @Test
    public void ShouldBeEmptyIfDeleteAllElements() {
        list1.deleteLast();
        list1.deleteLast();

        assertEquals(0, list1.size());
        assertNull(list1.peekFirst());
        assertNull(list1.peekLast());
    }

    @Test
    public void ShouldBeEmptyIfDeleteAllFirstElements() {
        list1.deleteFirst();
        list1.deleteFirst();

        assertEquals(0, list1.size());
        assertNull(list1.peekFirst());
        assertNull(list1.peekLast());
    }


    @Test
    public void ShouldDeleteNodeLastPosition() {
        list1.deleteLast();

        assertEquals(list1.peekLast(), node1);
    }

    @Test
    public void ShouldReturnTheSizeOfTheList() {
        assertEquals(list1.size(), 2);
    }

    @Test
    public void ShouldReturn0IfTheListIsEmpty() {
        assertEquals(0, list2.size());
    }

    @Test
    public void ShouldReturnTheNodeAtTheGivenPosition() {
        assertEquals(list1.getAt(1), node2);
    }

    @Test
    public void ShouldThrownAnIndexOutOfBoundsExceptionIfThePositionIsBiggerThanSize() {
        assertThrows(IndexOutOfBoundsException.class, () -> list1.getAt(10));
    }

    @Test
    public void ShouldReturnTheNodeOfTheValue() {
        assertEquals(list1.find(1), node2);

    }

    @Test
    public void ShouldReturnNullIfTheNumberIsNotInTheList() {
        assertNull(list1.find(2000));
    }


    @Test
    public void ShouldDeleteTheGivenNode() {
        DequeNode node3 = new DequeNode<Integer>(10, null, null);

        list1.append(node3);
        list1.delete(node2);

        assertEquals(list1.size(), 2);
        assertEquals(list1.peekFirst(), node1);
        assertEquals(list1.peekLast(), node3);
    }

    @Test
    public void ShouldThrownAnExceptionIfTheNodeToDeleteIsNotInTheList() {
        DequeNode node3 = new DequeNode<Integer>(10, null, null);

        assertThrows(IllegalArgumentException.class, () -> list1.delete(node3));
    }

    @Test
    public void ShouldCorrectlySortList(){
        list1.sort();

        assertEquals(node1, list1.peekLast());
    }

    @Test
    public void ShouldCorrectlySortListMoreThan2Elements(){
        list1.append(node3);
        list1.sort();

        assertEquals(node2, list1.peekFirst());
    }
}
