package DoubleEndedList;

public class DoubleLinkedListQueue<T extends Comparable> implements DoubleEndedQueue<T>{

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
        if(firstNode.getNext() != null) {
            firstNode.getNext().setPrevious(null);
            firstNode = firstNode.getNext();
        }else{
            firstNode = null;
            lastNode = null;
        }
    }

    @Override
    public void deleteLast() {
        if(lastNode.getPrevious() != null) {
            lastNode.getPrevious().setNext(null);
            lastNode = lastNode.getPrevious();
        }else{
            firstNode = null;
            lastNode = null;
        }
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

        if(current==null){
            size=0;
        }else {

            while (current.getNext() != null) {
                current = current.getNext();
                size++;
            }
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

    public void delete(DequeNode<T> node){
        if(node == firstNode){ deleteFirst(); return;}
        if(node == lastNode){ deleteLast(); return;}

        DequeNode currentNode = firstNode;

        while(node.getNext() != null) {
            if (currentNode != node) {
                currentNode = currentNode.getNext();
                continue;
            }

            currentNode.getPrevious().setNext(currentNode.getNext());
            currentNode.getNext().setPrevious(currentNode.getPrevious());

            currentNode = null;

            return;
        }

        throw new IllegalArgumentException("Node is not in the list: " + node);
    }

    public void sort(){
        boolean isSorted = false;

        while(!isSorted){
            isSorted = true;

            DequeNode prevNode = firstNode;
            DequeNode currNode = firstNode.getNext();

            while(currNode != null){
                if(prevNode.getItem().compareTo(currNode.getItem()) > 0){
                    isSorted = false;

                    //Switch the nodes
                    DequeNode auxPrev = prevNode.getPrevious();
                    DequeNode auxNext = currNode.getNext();

                    prevNode.setPrevious(currNode);
                    prevNode.setNext(auxNext);

                    currNode.setPrevious(auxPrev);
                    currNode.setNext(prevNode);


                    if(prevNode == firstNode){
                        firstNode = currNode;
                    }else{
                        auxPrev.setNext(currNode);
                    }

                    if(currNode == lastNode){
                        lastNode = prevNode;
                    }else{
                        auxNext.setPrevious(prevNode);
                    }

                    currNode = prevNode.getNext();
                }else{
                    prevNode = currNode;
                    currNode = currNode.getNext();
                }
            }
        }
    }
}
