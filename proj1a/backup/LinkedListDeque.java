public class LinkedListDeque<T> {

    private class Node {
        private Node prev;
        private T item;
        private Node next;

        public Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        size = 0;
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }
    public void addFirst(T item) {  
        size++;
        sentinel.next = new Node(item, sentinel, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        
    }
    public void addLast(T item) {
        size++;
        sentinel.prev = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.prev.next = sentinel.prev;   
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node ptr = sentinel.next;
        while (ptr != sentinel) {
            System.out.print(ptr.item + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }


    public T removeFirst() {
        Node res = sentinel.next;
        if (isEmpty()) {
            return null;
        }
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size = size - 1;
        return res.item;
    }

    public T removeLast() {
        Node res = sentinel.prev;
        if (isEmpty()) {
            return null;
        }
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size = size - 1;
        return res.item;
    }

    public T get(int index) {
        Node p = sentinel;
        for (int i = 0; i <= index; ++i) {
            if (p.next != sentinel) {
                p = p.next;
            } else {
                return null;
            }
        }
        return p.item;
    }


    public T get(int index) {
        if (index < 0) return null;
        Node ptr = sentinel.next;
        while (index && ptr.next != null) {
            index--;
            ptr = ptr.next;
        }
        return ptr.item;

    }

    // suppose the index is 1, then next
    public T getRecursive(int index) {
        return getRecursiveHelper(sentinel.next, index);
    }

    private T getRecursiveHelper(Node currentNode, int index) {
        if (index < 0 || index >= size || currentNode == sentinel) {
            return null;
        }

        if (index == 0) {
            return currentNode.item;
        }

        return getRecursiveHelper(currentNode.next, index - 1);
    }
}