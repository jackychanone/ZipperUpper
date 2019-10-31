package datastructures.worklists;

import cse332.exceptions.NotYetImplementedException;
import java.util.NoSuchElementException;
import java.lang.IndexOutOfBoundsException;
import cse332.interfaces.worklists.FixedSizeFIFOWorkList;

/**
 * See cse332/interfaces/worklists/FixedSizeFIFOWorkList.java
 * for method specifications.
 */
public class CircularArrayFIFOQueue<E> extends FixedSizeFIFOWorkList<E> {
	private E[] array;
	private int add_iterator;
	private int next_iterator;
	private int size;
	
    public CircularArrayFIFOQueue(int capacity) {
        super(capacity);
        array = (E[]) new Object[capacity];
        add_iterator = 0;
        next_iterator = 0;     
        size = 0;
    }

    @Override
    public void add(E work) {
    	if (this.isFull()) {
    		throw new IllegalStateException();
    	}
    	array[add_iterator % array.length] = work;
    	add_iterator++;
    	size++;
    }

    @Override
    public E peek() {
    	if (size == 0) {
    		throw new NoSuchElementException();
    	}    	
    	
        return array[next_iterator];
    }
    
    @Override
    public E peek(int i) {
    	if (size == 0) {
    		throw new NoSuchElementException();
    	}
    	if (i < 0 | (next_iterator+ i) >= array.length) {
    		throw new IndexOutOfBoundsException();
    	}
    	if ((next_iterator + i) >= array.length) {
    		return array[next_iterator + 1 - array.length];
    	}
    	return array[next_iterator + i];
    }
    
    @Override
    public E next() {
    	if (size == 0) {
    		throw new NoSuchElementException();
    	}
    	E element = array[next_iterator];
    	next_iterator++;
    	if (next_iterator == array.length) {
    		next_iterator = 0;
    	}
    	size--;
    	return element;
    }
    
    @Override
    public void update(int i, E value) {
    	if (size == 0) {
    		throw new NoSuchElementException();
    	}
    	if (i < 0 | i >= array.length) {
    		throw new IndexOutOfBoundsException();
    	}
    	array[i] = value;
    }
    
    @Override
    public int size() {
    	return size;
    }
    
    @Override
    public void clear() {
    	int size_of_array = array.length;
        array = (E[]) new Object[size_of_array];
        add_iterator = 0;
        next_iterator = 0;
        size = 0;
    }

    @Override
    public int compareTo(FixedSizeFIFOWorkList<E> other) {
        // You will implement this method in p2. Leave this method unchanged for p1.
        throw new NotYetImplementedException();
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        // You will finish implementing this method in p2. Leave this method unchanged for p1.
        if (this == obj) {
            return true;
        }
        else if (!(obj instanceof FixedSizeFIFOWorkList<?>)) {
            return false;
        }
        else {
            FixedSizeFIFOWorkList<E> other = (FixedSizeFIFOWorkList<E>) obj;

            // Your code goes here

            throw new NotYetImplementedException();
        }
    }

    @Override
    public int hashCode() {
        // You will implement this method in p2. Leave this method unchanged for p1.
        throw new NotYetImplementedException();
    }
}
