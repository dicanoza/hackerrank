package heaps;

public class MaxIntHeap extends Heap {

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
