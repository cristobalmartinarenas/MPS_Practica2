package DoubleEndedList;

public class DoubleLinkedListQueue<T> implements DoubleEndedQueue<T>{

    private DequeNode lastNode;
    private DequeNode firstNode;

    @Override
    public void append(DequeNode<T> node) {
        if(node == null){ throw new IllegalArgumentException("Appended node cannot be null"); }

        if(lastNode != null){
            lastNode.setNext(node);
        }else{
            firstNode = node;
        }

        node.setPrevious(lastNode);
        lastNode = node;
    }

    @Override
    public void appendLeft(DequeNode<T> node){
        if(node == null){ throw new IllegalArgumentException("Appended node cannot be null"); }

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

    public DequeNode<T> getAt(int position){
        if(position < 0) { throw new IllegalArgumentException("Position cannot be negative");}

        DequeNode<T> sol = firstNode;

        for(int i = 0; i < position; i++){
            sol = sol.getNext();

            if(sol == null){
                throw(new IndexOutOfBoundsException("Index out of bounds: " + position));
            }
        }

        return sol;
    }

    public DequeNode<T> find(T item){
        DequeNode<T> node = firstNode;

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
