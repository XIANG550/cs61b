public class ArrayDeque<T> {
	private T[] items;

	private int size;
	private int capacity;
	private int nextFirst;
	private int nextLast;
	public ArrayDeque(){
		capacity  = 8;
		items = (T[]) new Object[capacity];
		nextFirst = 4;
		nextLast = 5;
		size = 0;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public int size() {
		return size;
	}
	private void resize(int capacity) {
		T[] temp = (T[]) new Object[capacity];
		int index = (nextFirst + 1) % this.capacity;

		for (int i = 1; i <= size; ++i) {
			temp[i] = items[index];
			index = (index + 1) % this.capacity;
		}

		this.nextFirst = 0;
		this.nextLast = size + 1;

		this.items = temp;
		this.capacity = capacity;

	}
	public void addFirst(T item) {
		if (size == capacity) {
			resize(2*capacity);
		}
		items[nextFirst] = item;
		nextFirst = ((nextFirst - 1) + capacity) % this.capacity;
		size++;
	}
	public void addLast(T item) {
		if (size == capacity) {
			resize(2*capacity);
		}
		items[nextLast] = item;
		nextLast = (nextLast + 1) % this.capacity;
		size++;
	}
	// Extra: For arrays of length 16 or more, your usage factor should always be at least 25%. For smaller arrays, your usage factor can be arbitrarily low.
	public T removeFirst() {
		if (isEmpty()) return null;

		int first = (nextFirst + 1) % this.capacity;
		T temp = items[first];

		items[first] = null;
		nextFirst = first;
		size--;

		double usageFactor = (double) size / capacity;
		if (capacity >= 16 && usageFactor < 0.25) {
			resize(capacity / 2);
		}

		return temp;
	}
	public T removeLast() {
		if (isEmpty()) return null;
		int last = (nextLast - 1 + this.capacity) % this.capacity;
		T temp = items[last];

		items[last] = null;
		nextLast = last;
		size--;

		double usageFactor = (double) size / capacity;
		if (capacity >= 16 && usageFactor < 0.25) {
			resize(capacity / 2);
		}

		return temp;
	}
	public T get(int index) {
		if (isEmpty() || index < 0 || index > size - 1) return null;

		int firstIndex = (nextFirst + 1 + index) % this.capacity; // index = 0
		return items[firstIndex];

	}
	public void printDeque() {
		if (isEmpty()) {
			return;
		}

		for (int i = 0; i < size; ++i) {
			int index = (nextFirst + 1 + i) % this.capacity;
			System.out.print(items[index] + " ");
		}
		System.out.println();

	}

}