package DoubleEndedList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DequeNodeTest {

    private DequeNode node;
    private DequeNode node2;
    private DequeNode node3;

    @BeforeEach
    public void init() {
        node = new DequeNode<Integer>(1, null, null);
    }

    @AfterEach
    public void finish() {
        node = null;
    }

    @Test
    public void ShouldGetCorrectElementAfterInitialized() {
        int expectedValue = 1;
        int obtainedValue = (Integer) node.getItem();
        assertEquals(expectedValue, obtainedValue);
    }


    @Test
    public void ShouldNotHavePreviousAfterInitialized() {
        assertNull(node.getPrevious());
    }

    @Test
    public void ShouldNotHaveNextAfterInitialized() {
        assertNull(node.getNext());
    }

    @Test
    public void ShouldBeFirstNodeAfterInitialized() {
        assertTrue(node.isFirstNode());
    }

    @Test
    public void ShouldBeLastNodeAfterInitialized() {
        assertTrue(node.isLastNode());
    }

    @Test
    public void ShouldBeTerminalNodeAfterInitialized() {
        assertFalse(node.isNotATerminalNode());
    }

    //-------------------------------------------------
    @Test
    public void ShouldAddNextElement() {
        DequeNode expectedValue = node3;
        node2 = new DequeNode<Integer>(1, node3, node);
        DequeNode obtainedValue = node2.getNext();
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void ShouldAddPreviousElement() {
        DequeNode expectedValue = node3;
        node2 = new DequeNode<Integer>(1, null, node3);
        DequeNode obtainedValue = node2.getPrevious();
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void ShouldNotBeTerminalNodeIfHavePreviousAndNext() {
        node3 = new DequeNode<Integer>(1, node2, null);
        node2 = new DequeNode<Integer>(1, node, node3);
        assertTrue(node2.isNotATerminalNode());
    }


}
