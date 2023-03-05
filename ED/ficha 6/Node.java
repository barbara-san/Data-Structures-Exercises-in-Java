public class Node<T> {
    private T val;
    private Node<T> next;

    Node(T v, Node<T> n) {
	val = v;
	next = n;
    }

    public T getValue() {
	return val;
    }

    public Node<T> getNext() {
	return next;
    }

    public void setValue(T v) {
	val = v;
    }

    public void setNext(Node<T> n) {
    next = n;
    }

}