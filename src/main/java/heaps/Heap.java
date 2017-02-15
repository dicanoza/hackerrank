package heaps;

import java.util.Arrays;

public abstract class Heap {
	protected int capacity;
	protected int size = 0;

	protected int[] items = new int[capacity];

	protected int getLeftChildIndex(int index) {
		return 2 * index + 1;
	}

	protected int getRightChildIndex(int index) {
		return 2 * index + 2;
	}

	protected int getParentIndex(int index) {
		return (index - 1) / 2;
	}

	protected boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < size;
	}

	protected boolean hasRightChild(int index) {
		return getRightChildIndex(index) < size;
	}

	protected boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}

	protected int leftChild(int index) {
		return items[getLeftChildIndex(index)];
	}

	protected int rightChild(int index) {
		return items[getRightChildIndex(index)];
	}

	protected int parent(int index) {
		return items[getParentIndex(index)];
	}

	protected void swap(int indexOne, int indexTwo) {
		int tmp = items[indexOne];
		items[indexOne] = items[indexTwo];
		items[indexTwo] = tmp;
	}

	protected void ensureExtraCapacity() {
		if (size == capacity) {
			items = Arrays.copyOf(items, capacity * 2);
			capacity *= 2;
		}
	}

	/**
	 * gets the first element of the heap
	 * 
	 * @return the first element of the heap
	 */
	public int peek() {
		if (size == 0) {
			throw new IllegalStateException();
		}
		return items[0];
	}

	/**
	 * Remove the first element of the heap
	 * 
	 * @return the first element of the heap
	 */
	public int poll() {
		if (size == 0) {
			throw new IllegalStateException();
		}
		int tmp = items[0];
		items[0] = items[size - 1];
		size--;
		heapfyDown();
		return tmp;
	}

	/**
	 * adds a new element to the heap
	 * 
	 * @param item
	 */
	public void add(int item) {
		ensureExtraCapacity();
		items[size] = item;
		size++;
		heapfyUp();
	}

	protected abstract void heapfyUp();

	protected abstract void heapfyDown();
}
