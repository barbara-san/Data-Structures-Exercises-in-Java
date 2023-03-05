import java.util.Scanner;

public class ED268 {

    public static void lambda(int n) {
	int line = 0;
	for (int j = 0; j < n/2; j++) {
	    for (int i = 0; i < j; i++) {
	        System.out.print(".");
	    }
	    System.out.print("#");
	    for (int i = n - 1; i > j; i--) {
	        System.out.print(".");
	    }
	    line += 1;
	    System.out.println("");
	}



	for (int i = 0; i < n/2; i++) {
	    System.out.print(".");
	}
	System.out.print("#");
	for (int i = n - 1; i > n/2; i--) {
	    System.out.print(".");
	}
	System.out.println("");
	line = 1;

	for (int j = 0; j < n/2; j++) {
	    for (int i = n/2 - 1; i > j; i--) {
	        System.out.print(".");
	    }
	    System.out.print("#");
	    for (int i = 0; i < line*2 -1; i++) {
	        System.out.print(".");
		
	    }
	    System.out.print("#");
	    for (int i = n/2 - 1; i > j; i--) {
	        System.out.print(".");
	    }
	    System.out.println("");
	    line += 1;
	}

    }
	
    public static void main (String[] args) {
	Scanner s = new Scanner(System.in);
	int n = s.nextInt();

	for (int i = 0; i < n ; i++) {
	    int t = s.nextInt();
	    lambda(t);
	}
    }
}