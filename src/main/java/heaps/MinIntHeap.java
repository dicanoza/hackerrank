package heaps;

public class MinIntHeap extends Heap {

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
