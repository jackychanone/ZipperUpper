package datastructures.worklists;

import java.util.NoSuchElementException;

import src.interfaces.worklists.LIFOWorkList;

/**
 * See src/interfaces/worklists/LIFOWorkList.java
 * for method specifications.
 */
public class ArrayStack<E> extends LIFOWorkList<E> {
	private E[] array;
	private int size;
	
    public ArrayStack() {
    	array = (E[]) new Object[10];
    	size = -1; // uses 0 based indexing
    }

    @Override
    public void add(E work) {
    	size++;
    	if (array.length == size) {
    		E[] newArray = (E[]) new Object[array.length * 2];
    		for (int i = 0; i < array.length; i++) {
    			newArray[i] = array[i];
    		}
    		array = newArray;
    	}
    	array[size] = work;
    }

    @Override
    public E peek() {
    	if (size == -1) {
    		throw new NoSuchElementException();
    	}
    	return array[size];
    }

    @Override
    public E next() {
    	if (size == -1) {
    		throw new NoSuchElementException();
    	}
    	E ret = array[size];
    	array[size] = null;
    	size--;
        return ret;
    }

    @Override
    public int size() {
        return size + 1;
    }

    @Override
    public void clear() {
    	array = (E[]) new Object[10];
    	size = -1;
    }
}