
import java.util.EmptyStackException;
import java.util.Iterator;

public class DoubleLinkedStackOfIntegers implements Iterable<Integer>{
    private Node first = null;
    private int size = 0;

    
        
    private class Node {
        int item;
        Node next;
    }
    
    public boolean isEmpty() {
        return first == null;
    }
    
    public void push(int item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        size++;
    }
    
    public int pop() {
        int item = first.item;
        first = first.next;
        size--;
        return item;
    }
    
    public int peek() {
        if (!isEmpty()) {
            int item = first.item;
            return item;
        }else {
            System.out.println("EmptyStackException");
            throw new EmptyStackException();
        }
    }
    

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public Iterator<Integer> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }
    
}
