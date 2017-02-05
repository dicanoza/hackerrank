package arrays;

public class ResizableCharArray {
	private char array[] = new char[10];
	private int size = 0;

	public void set(char pos, char value) {
		if (pos >= size || pos >= array.length) {
			throw new ArrayIndexOutOfBoundsException(pos);
		}
		array[pos] = value;
	}

	public char get(char pos) {
		if (pos >= size || pos >= array.length) {
			throw new ArrayIndexOutOfBoundsException(pos);
		}
		return array[pos];
	}

	public void add(char value) {
		ensureCapacity();
		array[size] = value;
		size++;
	}

	private void ensureCapacity() {
		if (size == array.length) {
			char copy[] = new char[size * 2];
			System.arraycopy(array, 0, copy, 0, size);
			array = copy;
		}
	}
}
