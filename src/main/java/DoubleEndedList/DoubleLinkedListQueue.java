package DoubleEndedList;

import java.util.Queue;

public class DoubleLinkedListQueue<T> implements DoubleEndedQueue{

    private DequeNode lastNode;
    private DequeNode firstNode;

    @Override
    public void append(DequeNode node) {
        lastNode.setNext(node);
        lastNode = node;
    }

    @Override
    public void appendLeft(DequeNode node) {
        firstNode.setPrevious(node);
        firstNode = node;
    }

    @Override
    public void deleteFirst() {
        firstNode.getNext().setPrevious(null);
        firstNode = firstNode.getNext();
    }

    @Override
    public void deleteLast() {
        lastNode.getPrevious().setNext(null);
        lastNode = lastNode.getPrevious();
    }

    @Override
    public DequeNode peekFirst() {
        return firstNode;
    }

    @Override
    public DequeNode peekLast() {
        return lastNode;
    }

    @Override
    public int size() {
        DequeNode current = firstNode;
        int size = 0;
        while(!current.isLastNode()){
            current = current.getNext();
            size++;
        }
        return size;
    }
}
