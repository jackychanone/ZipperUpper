package datastructures.worklists;

import java.util.NoSuchElementException;
import src.exceptions.NotYetImplementedException;
import src.interfaces.worklists.FIFOWorkList;

/**
 * See src/interfaces/worklists/FIFOWorkList.java
 * for method specifications.
 */
public class ListFIFOQueue<E> extends FIFOWorkList<E> {
    private Node front; 
    private int size;
    
    
	public class Node {
		E data;
		Node next;
		
		public Node(E data) {
			this.data = data;
			this.next = null;
		}
	}
	
    public ListFIFOQueue() {
    	size = 0;
    }

    @Override
    public void add(E work) {
    	if (!hasWork()) {
    		front = new Node(work);
    	}
    	else {
        	Node temp = front;
        	while (temp.next != null) {
        		temp = temp.next;
        	}
        	temp.next = new Node(work);
    	}
    	size++;
    }

    @Override
    public E peek() {
    	if (!hasWork()) {
    		throw new NoSuchElementException(); 
    	}
    
    	return front.data;
    }

    @Override
    public E next() {
    	if (!hasWork()) {
    		throw new NoSuchElementException(); 
    	}
    	
    	E ret = front.data;
    	// front.next = null; 		// Garbage disposal but not necessary, bc 		
    	front = front.next;    		// there is no means to access the previous
    	size--;						// front.
    	return ret;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
    	front.next = null;
    	size = 0;
    }
}
