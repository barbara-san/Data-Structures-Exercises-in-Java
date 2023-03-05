import java.util.Scanner;

public class ED270 {

    static class Student {
	private String name;
	private int doubts;
	private int day;

	Student(String n, int d) {
	    name = n;
	    doubts = d;
	    day = 0;
	}
	public int getDay() {return day;}
	public int getDoubts() {return doubts;}
	public String getName() {return name;}

	public void setDay(int n) {day = n;}
	public void setDoubts(int n) {doubts = n;}
    }
	
    public static void main (String[] args) {
	Scanner s = new Scanner(System.in);
	int T = s.nextInt();
	int X = s.nextInt();
	int N = s.nextInt();

	LinkedListQueue<Student> fila = new LinkedListQueue<Student>();
	for (int i = 0; i < N; i++) {
	    String name = s.next();
	    int doubts = s.nextInt();
	    Student m = new Student(name, doubts);
	    fila.enqueue(m);
	}
	int dia = 1;
	int R = T;
	while (!fila.isEmpty()) {
	    if (R > 0 && fila.first().getDay() < X) {
		R--;
		fila.first().setDoubts(fila.first().getDoubts() - 1);
		fila.first().setDay(fila.first().getDay() + 1);
		if (fila.first().getDoubts() == 0) {
		    Student stu = fila.dequeue();
		    System.out.println(stu.getName() + " " + dia + " " + R);
		}
		else {
		    fila.enqueue(fila.dequeue());
		}
	    }

	    if (!fila.isEmpty() && (R == 0 || fila.first().getDay() == X)) {
		dia++;
		R = T;
		for (int i = 0; i < fila.size(); i++) {
		    fila.first().setDay(0);
		    fila.enqueue(fila.dequeue());
		}
	    }
	}
    }
}