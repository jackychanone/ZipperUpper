package datastructures.worklists;

import cse332.exceptions.NotYetImplementedException;
import src.interfaces.worklists.PriorityWorkList;

/**
 * See src/interfaces/worklists/PriorityWorkList.java
 * for method specifications.
 */
public class MinFourHeap<E extends Comparable<E>> extends PriorityWorkList<E> {
    /* Do not change the name of this field; the tests rely on it to work correctly. */
    private E[] data;	// array called 'data'
    int size = 0;
     
    public MinFourHeap() {
    	data = (E[]) new Comparable[10]; 
    }

    @Override
    public boolean hasWork() {
        return data[0] != null;
    }

    @Override
    public void add(E work) {
    	// if data.length and this.size() are equal, grow() the array
    	if (size == data.length) {
    		data = grow(data);
    	}
    	
    	// add work at the last index which is null
    	for (int i = 0; i < data.length; i++) {
    		if (data[i] == null) {
    			data[i] = work;
    			size++;
    			break;
    		}
    	}
    	
    	// call percolateUp to fix the array
    	percolateUp(findParent(this.size), this.size);
    
    }
    
    private E[] grow(E[] data) {
    	E[] new_data = (E[]) new Comparable[data.length * 2];
    	for (int i = 0; i < data.length; i++) {
    		new_data[i] = data[i];
    	}
    	return new_data;
    }

    private int findParent(int childIndex) {
    	return (childIndex - 1)/ 4;
    }
    
    private void percolateUp(int parentIndex, int childIndex) {
    	while (data[childIndex].compareTo(data[parentIndex]) < 0) {
    		swap(childIndex, parentIndex);
    		childIndex = parentIndex;
    		parentIndex = findParent(childIndex);
    	}
    }
        
    @Override
    public E peek() {
        return data[0];
    }

    @Override
    public E next() {
        E val = data[0];
        for (int i = 0; i < size - 1; i++) {
        	data[i] = data[i+1];
        }
        data[size] = null;
        size--;
        percolateDown();
        return val;
    }
    
    private void swap(int index1, int index2) {
    	E temp = data[index1];
    	data[index1] = data[index2];
    	data[index2] = temp;
    }
    
    private void percolateDown() {
    	// start at index 0 
    	int parentIndex = 0; 
    	
    	int child1Index = parentIndex * 4 - 2;
    	int child2Index = parentIndex * 4 - 1;
    	int child3Index = parentIndex * 4;
    	int child4Index = parentIndex * 4 + 1;
    	
    	// check if parent is smaller than children
    	while (data[parentIndex].compareTo(data[child1Index]) > 0) {
    		swap(parentIndex, child1Index);
    		child1Index = parentIndex;
    		parentIndex = findParent(child1Index);
    	}
    	
    	while (data[parentIndex].compareTo(data[child2Index]) > 0) {
    		swap(parentIndex, child1Index);
    		child1Index = parentIndex;
    		parentIndex = findParent(child1Index);
    	}
    	
    	while (data[parentIndex].compareTo(data[child3Index]) > 0) {
    		swap(parentIndex, child1Index);
    		child1Index = parentIndex;
    		parentIndex = findParent(child1Index);
    	}
    	
    	while (data[parentIndex].compareTo(data[child4Index]) > 0) {
    		swap(parentIndex, child1Index);
    		child1Index = parentIndex;
    		parentIndex = findParent(child1Index);
    	}
    }	
    			
    @Override
    public int size() {
    	return size;
    }

    @Override
    public void clear() {
        data = (E[]) new Comparable[10];
    }
}
