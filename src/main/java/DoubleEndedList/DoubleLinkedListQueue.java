package DoubleEndedList;

import java.util.Queue;

public class DoubleLinkedListQueue<T extends Comparable> implements DoubleEndedQueue{

    private DequeNode lastNode;
    private DequeNode firstNode;

    @Override
    public void append(DequeNode node) {
        if(lastNode != null){
            lastNode.setNext(node);
        }else{
            firstNode = node;
        }

        node.setPrevious(lastNode);
        lastNode = node;
    }

    @Override
    public void appendLeft(DequeNode node){
        if(firstNode != null){
            firstNode.setPrevious(node);
        }else{
            lastNode = node;
        }

        node.setNext(firstNode);
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
        int size = 1;

        while(current.getNext() != null){
            current = current.getNext();
            size++;
        }

        return size;
    }

    public DequeNode getAt(int position){
        DequeNode sol = firstNode;

        for(int i = 1; i < position; i++){
            sol = firstNode.getNext();

            if(sol == null){
                throw(new IllegalArgumentException("Index out of bounds: " + position));
            }
        }

        return sol;
    }

    public DequeNode find(T item){
        DequeNode node = firstNode;

        while(node.getNext() != null){
            if(node.getItem() == item) { break;}

            node = node.getNext();
        }

        if(node == lastNode && node.getItem() != item){
            //No node has been found
            node = null;
        }

        return node;
    }
}
