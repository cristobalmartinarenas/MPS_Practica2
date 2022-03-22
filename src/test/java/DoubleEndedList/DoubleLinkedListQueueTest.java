package DoubleEndedList;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class DoubleLinkedListQueueTest {

    private DequeNode node1;
    private DequeNode node2;

    @BeforeEach
    public void init1() {
        node1 = new DequeNode<Integer>(1, null, null);
        node2 = new DequeNode<Integer>(1, null, null);
    }


    @Test
    public void ShouldAppendANodeLastPosition() {
        DoubleLinkedListQueue list1 = new DoubleLinkedListQueue<Integer>();
        list1.append(node1);
        list1.append(node2);

        assertEquals(list1.peekLast(), node2);

    }

    @Test
    public void ShouldAppendANodeFirstPosition() {
        DoubleLinkedListQueue list1 = new DoubleLinkedListQueue<Integer>();
        list1.appendLeft(node1);
        list1.appendLeft(node2);

        assertEquals(list1.peekFirst(), node2);

    }


}
