package HOA_02;

import org.w3c.dom.Node;

public class HOA_02 {

    public static int sum=0;
    
    public class Node {
        private int element;
        private Node next;
        
        public Node (int s, Node n) {
            element = s;
            next = n;
        }
        public int getElement() { return element; }
        public Node getNext() { return next; }
        public void setElement(int newElem) { element = newElem; }
        public void setNext(Node newNext) { next = newNext; }
    }
    
    public class SlinkedList {
        public Node head;
        public long size;

        public SlinkedList() {
            head = null;
            size = 0;
            }            
        
        void swapFirstTwoNodes(SlinkedList list) {
            Node node = head;
            if (head != null) {
                Node node2 = head.getNext();
                node.setNext(node2.getNext());
                node2.setNext(node);
                head = node2;       
            }  
        }
       int getSum(SlinkedList list) {
            Node node = list.head;
            int sum = 0;
            while (node != null) {
                sum += node.element;
                node = node.next;
                }
            return sum;
       }
    }
    
    public class DNode {
        protected int element;
        protected DNode next, prev;
        
        
        public DNode(int e, DNode p, DNode n) {
            element = e;
            prev = p;
            next = n;
        }
        public int getElement() { return element; }
        public DNode getPrev() { return prev; }
        public DNode getNext() { return next; }
        public void setElement(int newElem) { element = newElem; }
        public void setPrev(DNode newPrev) { prev = newPrev; }
        public void setNext(DNode newNext) { next = newNext; }   
    }
    
    public class DList {
        protected int size;
        protected DNode head, tail;
        
        void remove(DNode n) {
            while (n != null) {
                 n.prev.setNext(n.getNext());
                 n.setNext(null);
            }
        }
        
        DNode search(int i) {
            DNode temp = head;
            boolean nullFound = false;
            while (!nullFound) {
                if (temp == null) {
                    nullFound = true;
                }else if (temp.element == i) {
                    return temp;
                }else
                    temp = temp.getNext();
            }
            return null;
        }
        
        void removeLast() {
            if(head != null) {
                if (head.next == null) {
                    head = null;
                } else {
                    DNode temp = head;
                    while (temp.next.next != null)
                        temp = temp.next;
                    DNode lastNode = temp.next;
                    temp.next = null;
                    lastNode = null;
                }
            }
        }
        
    }

}
