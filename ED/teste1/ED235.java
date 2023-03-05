import java.util.Scanner;

public class ED235 {

    public static void cardinal (int s) {
	int x = s;
	for (int i = 0; i < s; i++) {
	    for (int j = 0; j < x; j++) {
		System.out.print("#");
	    }
	    for (int c = 0; c < i; c++) {
		System.out.print(".");
	    }
	    x--;
	    System.out.println("");
	}
    }

    public static void main(String[] args) {

	Scanner w = new Scanner(System.in);
	int m = w.nextInt();
	for (int i = 0; i < m; i++) {
	    int size = w.nextInt();
	    cardinal(size);
	}

    }

}