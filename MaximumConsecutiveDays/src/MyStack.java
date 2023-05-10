//-----------------------------------------------------
// Title: MyStack class
// Author: Mustafa Baran Ercan
// ID: 28810555206
// Section: 6
// Assignment: 1
// Description: This class represents as a standart Java Stack class
//-----------------------------------------------------
import java.util.Iterator;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class MyStack<Item> implements Iterable<Item>{                           
    private int size = 0;                                                       
    private Node first = null;
    
    private class Node {                                                        // Node of a Stack.
        Item item;                                                              // Item stored by a node.
        Node next;                                                              // Pointer to next node.
    }
    
    public boolean isEmpty() {                                                  // Returns a boolean value of true if the Stack is empty, and false if the Stack is not Empty.
        return first == null;
    }
    
    public void push(Item item) {                                               // push() method to add Item to the Stack.
        Node oldfirst = first;                                                  // also increases the Stack.size by 1.
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        size++;
    }
    
    public Item pop() {                                                         // pop() method to remove and return the last Item from the Stack.
        Item item = first.item;                                                 // also decreases the Stack.size by 1.
        first = first.next;
        size--;
        return item;
    }
    public Item peek() {                                                        // peek method to only return the last Item from the Stack, and not remove it from the Stack.
        if (!isEmpty()) {                                                       // does not change the Stack.size
            Item item = first.item;                                             // Unlike pop(), checks if the method is empty or not
            return item;                                                        // If empty, throws exception.
        }else {                                                                 
            System.out.println("Empty Stack Exception");
            throw new EmptyStackException();
        }
    }

    public int getSize() {                                                      // Getter method for Stack.size
        return size;                                                            // We use this method in Main.maxConsecutiveDaysCalculator method.
    }

    public void setSize(int size) {                                             // Setter method for Stack.size
        this.size = size;                                                       // We do not use call this method actually.
    }
    
    @Override
    public Iterator<Item> iterator() {                                          // Since we wanted to iterate over Stack elements, we called Iterator interface
        return new StackIterator();                                             // and the rest is the overriding of this interface's methods.
    }

    private class StackIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {                                              
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
