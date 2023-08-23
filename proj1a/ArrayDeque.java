
public class ArrayDeque<T> 
{
	private T[] items;
	private int size;
	private int nextFirst;
	private int nextLast;
	private int capacity;

	public ArrayDeque() {
		capacity = 8;
		nextFirst = 0;
		nextLast = nextFirst + 1;
		items = (T[]) new Object[capacity];
		size = 0;
	}
	/*
	public ArrayDeque(ArrayDeque<T> other) {
		items = (T[]) new Object[other.capacity];
		System.arraycopy(other.items, 0, items, 0, other.capacity);
		nextFirst = other.nextFirst;
		nextLast = other.nextLast;
		size = other.size;
	}
	*/

	private void resize(int capacity) {
		T[] a = (T[]) new Object[capacity];
		// System.arraycopy() will not work because the array is circular
		for (int i = 1; i <= size; ++i) {
			a[i] = items[(++nextFirst) % capacity];
		}
		this.capacity = capacity;
		nextFirst = 0;
		nextLast = size + 1;
		items = a;

	}
	
	public void addFirst(T item) {
		if (size == capacity) {
			int factor = 2;
			capacity *= 2;
			resize(capacity);
		}
		items[nextFirst] = item;
		nextFirst = (nextFirst - 1 + capacity) % capacity; 
		size++;
	}

	public void addLast(T item) {
		if(size == capacity) {
			int factor = 2;
			capacity *= 2;
			resize(capacity);
		}
		items[nextLast] = item;
		nextLast = (nextLast + 1) % capacity; 
		size++;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void printDeque() {
		if (isEmpty()) {
			return;
		}
		int frontIndex = (nextFirst + 1) % capacity;
		int backIndex = (nextLast - 1 + capacity) % capacity;

		for (int i = 0; i < size; ++i) {
			int transformedIndex = (i + frontIndex) % capacity;
			System.out.print(items[transformedIndex] + " ");
		}
		System.out.println();
	}

	public T removeFirst() {
		if (isEmpty()) {
			return null;
		}
		// the one you removed is the one to be added
		nextFirst = (nextFirst + 1) % capacity; 
		size--;
		T result = items[nextFirst];
		if (capacity >= 16 && size < capacity / 4) {
			resize(capacity / 2);
		}
		return result;


	}

	public T removeLast() {
		if (isEmpty()) {
			return null;
		}
		nextLast = (nextLast - 1 + capacity) % capacity; 
		size--;
		T result = items[nextLast];

		if (capacity >= 16 && size < capacity / 4) {
			resize(capacity / 2);
		}
		return result;
	}

	public T get(int index) {
		if (index < 0 || index > size - 1) {
			return null;
		}
		return items[(nextFirst + 1 + index) % capacity];
	}

}
