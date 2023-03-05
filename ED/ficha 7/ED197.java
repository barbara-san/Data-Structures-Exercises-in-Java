public class ED197 {

    public static MyQueue<Integer> merge(MyQueue<Integer> a, MyQueue<Integer> b) {

	MyQueue<Integer> q = new LinkedListQueue<Integer>();
	
	while(!a.isEmpty() && !b.isEmpty()) {
	    if (a.first() < b.first()) {
		q.enqueue(a.dequeue());
	    }
	    else if (a.first() > b.first()) {
		q.enqueue(b.dequeue());
	    }
	    else if (a.first() == b.first()) {
		q.enqueue(b.dequeue());
		q.enqueue(a.dequeue());
	    }
	}
	if (a.isEmpty() && b.isEmpty()) return q;
	if(!a.isEmpty()) {
	    while (!a.isEmpty()) {
		q.enqueue(a.dequeue());
	    }
	    return q;
	}

	if(!b.isEmpty()) {
	    while (!b.isEmpty()) {
		q.enqueue(b.dequeue());
	    }
	    return q;
	}
	return q;
    }

}