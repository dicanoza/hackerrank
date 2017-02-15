package heaps;

import java.util.Arrays;

public class MinIntHeap {
	private int capacity;
	private int size = 0;

	private int[] items = new int[capacity];

	private int getLeftChildIndex(int index) {
		return 2 * index + 1;
	}

	private int getRightChildIndex(int index) {
		return 2 * index + 2;
	}

	private int getParentIndex(int index) {
		return (index - 1) / 2;
	}

	private boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < size;
	}

	private boolean hasRightChild(int index) {
		return getRightChildIndex(index) < size;
	}

	private boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}

	private int leftChild(int index) {
		return items[getLeftChildIndex(index)];
	}

	private int rightChild(int index) {
		return items[getRightChildIndex(index)];
	}

	private int parent(int index) {
		return items[getParentIndex(index)];
	}

	private void swap(int indexOne, int indexTwo) {
		int tmp = items[indexOne];
		items[indexOne] = items[indexTwo];
		items[indexTwo] = tmp;
	}

	private void ensureExtraCapacity() {
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

	/**
	 * fix the heap order looking from the last to the first element
	 */
	private void heapfyUp() {
		int index = size - 1;
		while (hasParent(index) && parent(index) > items[index]) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}

	}

	/**
	 * fix the heap order looking from first to the last element
	 */
	private void heapfyDown() {
		int index = 0;
		while (hasLeftChild(index)) {
			int smallerIndex = getLeftChildIndex(index);
			if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
				smallerIndex = getRightChildIndex(index);
			}
			if (items[index] < items[smallerIndex]) {
				break;
			} else {
				swap(index, smallerIndex);
			}
			index = smallerIndex;
		}

	}
}
