public class SinglyLinkedList<T> {
    private Node<T> first;
    private int size;

    SinglyLinkedList() {
	first = null;
	size = 0;
    }

    public int size() {
	return size;
    }

    public boolean isEmpty() {
	return (size == 0);
    }

    public void addFirst(T value) {
	Node<T> b = new Node<T>(value, first);
	first = b;
	size++;
    }

    public void addLast(T value) {
	Node<T> b = new Node<T>(value, null);
	if (isEmpty()) {
	    first = b;
	} else {
	    Node<T> cur = first;
	    while (cur.getNext() != null) {
		cur = cur.getNext();
	    }
	    cur.setNext(b);
	}
	size++;	
    }

    public T getFirst() {
	if (isEmpty()) return null;
	return first.getValue();
    }

    public T getLast() {
	if (isEmpty()) return null;
	Node<T> cur = first;
	while (cur.getNext() != null) {
	    cur = cur.getNext();
	}
	return cur.getValue();
    }

    public void removeFirst() {
	if (isEmpty()) return;
	first = first.getNext();
	size--;
    }

    public void removeLast() {
	if (isEmpty()) return;
	if (size == 1) {
	    first = null;
	}
	else {
	    Node <T> cur = first;
	    for (int i = 0; i < size-2; i++) {
		cur = cur.getNext ();
	    }
	    cur.setNext(null);
	}
	size--;
    }

    public String toString()  {
	String str = "{";
	Node <T> cur = first;
	while (cur != null) {
	    str += cur.getValue ();
	    cur = cur.getNext ();
	    if (cur != null) str += ",";
	}
	str += "}";
	return str;
    }

    public T get(int pos) {
	if (isEmpty() || pos >= size || pos < 0) return null;
	else {
	    Node <T> cur = first;
	    for (int i = 0; i < pos; i++) {
		cur = cur.getNext ();
	    }
	    return cur.getValue();
	}
    }


    public T remove(int pos) {
	if (isEmpty() || pos >= size || pos < 0) return null;
	else {
	    if (pos == 0) {T a = get(0); removeFirst(); return a;}
	    else {
		Node <T> cur = first;
		for (int i = 0; i < pos - 1; i++) {
		    cur = cur.getNext();
		}
		T a = cur.getNext().getValue();
		cur.setNext(cur.getNext().getNext());
		size--;
		return a;
	    }
	}
    }

    public SinglyLinkedList<T> copy() {
	SinglyLinkedList<T> b = new SinglyLinkedList<T>();
	Node<T> cur = first;
	for (int i = 0; i < size; i++) {
	    b.addLast(cur.getValue());
	    cur = cur.getNext();
	}
	return b;
    }

    public void duplicate() {
	if (isEmpty()) return;
	Node<T> cur = first;
	while (cur.getNext() != null) {
	    Node<T> n = new Node<T>(cur.getValue(), cur.getNext());
	    cur.setNext(n);
	    cur = cur.getNext().getNext();
	}
	size *=2;
	addLast(cur.getValue());
	size--;
    }

    public int count(T value) {
	int count = 0;
	for (int i = 0; i < size; i++) {
	    if (get(i).equals(value))
		count++;
	}
	return count;
    }

    public void removeAll(T value) {
	for (int i = 0; i < size; i++) {
	    if (get(i).equals(value)) {
		remove(i);
		i--;
	    }
	}
    }

}