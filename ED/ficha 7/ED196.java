public class ED196 {

    public static void process(MyQueue<String> q, MyQueue<String> a, MyQueue<String> b) {
	while (!q.isEmpty()) {
	    String name = q.dequeue();
	    String letter = q.dequeue();
	    if (letter.equals("A")) {
		a.enqueue(name);
	    }
	    if (letter.equals("B")) {
		b.enqueue(name);
	    }
	    if (letter.equals("X")) {
		if (a.size() > b.size()) {
		    b.enqueue(name);
		}
		if (a.size() < b.size()) {
		    a.enqueue(name);
		}
	    }
	}
    }
}