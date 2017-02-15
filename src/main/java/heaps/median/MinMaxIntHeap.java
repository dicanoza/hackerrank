package heaps.median;

import java.util.Arrays;
import java.util.Scanner;

public class MinMaxIntHeap {
	MaxIntHeap maxHeap = new MaxIntHeap();
	MinIntHeap minHeap = new MinIntHeap();

	public void add(int item) {
		if (maxHeap.size > minHeap.size) {
			minHeap.add(item);
		} else {
			maxHeap.add(item);
		}
		if (minHeap.size != 0 && maxHeap.peek() > minHeap.peek()) {
			int min = minHeap.poll();
			int max = maxHeap.poll();
			minHeap.add(max);
			maxHeap.add(min);
		}
	}

	public float median() {
		if (maxHeap.size > minHeap.size) {
			return maxHeap.peek();
		} else {
			return (float) (maxHeap.peek() + minHeap.peek()) / 2;
		}
	}

}

abstract class Heap {
	protected int capacity = 10;
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

class MaxIntHeap extends Heap {

	/**
	 * fix the heap order looking from the last to the first element
	 */
	@Override
	protected void heapfyUp() {
		int index = size - 1;
		while (hasParent(index) && parent(index) < items[index]) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}

	}

	/**
	 * fix the heap order looking from first to the last element
	 */
	@Override
	protected void heapfyDown() {
		int index = 0;
		while (hasLeftChild(index)) {
			int biggestIndex = getLeftChildIndex(index);
			if (hasRightChild(index) && rightChild(index) > leftChild(index)) {
				biggestIndex = getRightChildIndex(index);
			}
			if (items[index] > items[biggestIndex]) {
				break;
			} else {
				swap(index, biggestIndex);
			}
			index = biggestIndex;
		}

	}
}

class MinIntHeap extends Heap {

	/**
	 * fix the heap order looking from the last to the first element
	 */
	@Override
	protected void heapfyUp() {
		int index = size - 1;
		while (hasParent(index) && parent(index) > items[index]) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}

	}

	/**
	 * fix the heap order looking from first to the last element
	 */
	@Override
	protected void heapfyDown() {
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

class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		MinMaxIntHeap heap = new MinMaxIntHeap();
		for (int a_i = 0; a_i < n; a_i++) {
			heap.add(in.nextInt());
			System.out.println(String.format("%.1f", heap.median()));
		}
	}
}