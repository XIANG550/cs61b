
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

	public void resize(int capacity) {
		T[] a = (T[]) new Object[capacity];
		System.arraycopy(items, 0, a, 0, size);
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
		return result;
	}

	public T removeLast() {
		if (isEmpty()) {
			return null;
		}
		nextLast = (nextLast - 1 + capacity) % capacity; 
		size--;
		T result = items[nextLast];
		return result;
	}

	public T get(int index) {
		if (index < 0 || index > size - 1) {
			return null;
		}

		int frontIndex = (nextFirst + 1) % capacity;
		int backIndex = (nextLast - 1 + capacity) % capacity;

		int transformedIndex = (index + frontIndex) % capacity;
		return items[transformedIndex];	
	}

}
