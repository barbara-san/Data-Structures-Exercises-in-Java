import java.util.Scanner;

class Process {
    String name;
    int time;

    Process(String na, int ti) {
	name = na;
	time = ti;
    }

    public void setTime(int n) {
	time = n;
    }

    public int getTime() {
	return time;
    }

    public String getName() {
	return name;
    }

}

public class ED237 {
    public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	int t = s.nextInt();
	int n = s.nextInt();
	LinkedListQueue<Process> q = new LinkedListQueue<Process>();
	for (int i = 0; i < n; i++) {
	    String name = s.next();
	    int time = s.nextInt();
	    Process cur = new Process(name, time);
	    q.enqueue(cur);
	    if (s.hasNextLine()) {
		s.nextLine();
	    }
	}
	int curtime = 0;
	int num = 1;
	int i = 0;
	while (!q.isEmpty()) {
	    if (q.first().getTime() - t > 0) {
		q.first().setTime(q.first().getTime() - t);
		q.enqueue(q.dequeue());
		curtime += t;
		num += 1;
	    }
	    if (q.first().getTime() - t <= 0) {
		curtime += q.first().getTime();	
		q.first().setTime(0);
		System.out.println(q.first().getName() + " " + curtime + " " + num);
		num += 1;
		q.dequeue();
	    }
	}
    }
}