import java.util.Scanner;

public class ED006 {
    public static void main(String[] args) {

	CircularLinkedList<String> list = new CircularLinkedList<String>();
	
        Scanner stdin = new Scanner(System.in);
	int m = stdin.nextInt();
	stdin.nextLine();

	for (int j = 0; j < m; j++) {
	    String meow = stdin.nextLine();
	    String[] a = meow.split(" ");

	    int w = stdin.nextInt();
	    for (int q = 0; q < w; q++) {
                list.addLast(stdin.next());
	    }
	    if (stdin.hasNextLine()) stdin.nextLine();

	    while (list.size() > 1){
		for (int i = 0; i < a.length - 1; i++) {
                	list.rotate();
		}
		list.removeFirst();
		
            }
	    
	    String nameX = list.getFirst();
	    list.removeFirst();
	    if (nameX.equals("Carlos")) {
		System.out.println("O Carlos nao se livrou");
	    }
	    else {
		System.out.println("O Carlos livrou-se (coitado do " + nameX + "!)");
	    }
	}

    }
}