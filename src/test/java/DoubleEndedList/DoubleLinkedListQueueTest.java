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
        node2 = new DequeNode<Integer>(1, null, null);
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


}
