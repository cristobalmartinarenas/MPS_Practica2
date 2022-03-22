package DoubleEndedList;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class DoubleLinkedListQueueTest {

    @Test
    public void ShouldAppendANodeLastPosition() {
        DoubleLinkedListQueue list1 = new DoubleLinkedListQueue<Integer>();
        DequeNode node1 = new DequeNode<Integer>(1, null, null);
        DequeNode node2 = new DequeNode<Integer>(1, null, null);
        list1.append(node1);
        list1.append(node2);

        assertEquals(list1.peekLast(), node2);

    }


}
