import java.util.Scanner;
import java.util.Comparator;

class Person implements Comparable<Person>{
    private String name;
    private int price;

    Person(String n, int p) {
	name = n;
	price = p;
    }

    public String getName(){return name;}
    public int getPrice(){return price;} 

    public int compareTo(Person p){
        return -1*Integer.compare(price, p.price);
    }

}

public class ED215 {
    public static void main(String[] args) {

	Scanner s = new Scanner(System.in);
	int N = s.nextInt();

        MinHeap<Person> h = new MinHeap<>(N);
	Person[] v = new Person[N];
        for (int i = 0; i < N; i++) {
	    String ss = s.next();
	    if (ss.equals("OFERTA")) {
		String n = s.next();
		int pr = s.nextInt();
		Person p = new Person(n, pr);
		v[i] = p;
		h.insert(v[i]);
	    }
	    if (ss.equals("VENDA")) {
		Person a = h.removeMin();
		System.out.println(a.getPrice() + " " + a.getName());
	    }
	}
    }
}